package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AgentService {
   @Autowired
   private AgentRepository agentRepository;
   @Autowired
   private CongeRepository congeRepository;
   @Autowired
   private GradeRepository gradeRepository;
   @Autowired
   private AffectationRepository affectationRepository;
   @Autowired
   private PosteRepository posteRepository;
   @Autowired
   private QualificationRepository qualificationRepository;


    public Agent getAgent(long id) {
       return agentRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Agent n'existe pas"));
   }


   public List<Agent> getAllAgents() {
       return agentRepository.findAll();
   }

   public void addAgent(Agent agent) {
       agentRepository.save(agent);
   }


   public void updateAgent(Long id , Agent agent) {
       Agent oldAgent = agentRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Agent n'existe pas"));

       oldAgent.setFirstname(agent.getFirstname());
       oldAgent.setLastname(agent.getLastname());
       oldAgent.setPhone(agent.getPhone());
       oldAgent.setEmail(agent.getEmail());
       oldAgent.setAffectationHistories(agent.getAffectationHistories());
       oldAgent.setAvisPriseFonction(agent.getAvisPriseFonction());

       agentRepository.save(oldAgent);

   }


    public void deleteAgent(long id) {
        if(!agentRepository.existsById(id)) {
            throw new RuntimeException("Agent n'existe pas");
        }
        agentRepository.deleteById(id);
   }

   public Agent saveAgent(Agent agent) {
       return agentRepository.save(agent);
   }


    public Agent ajouterConge(Long agentId, Conge conge) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));

        conge.setAgent(agent);
        agent.getConges().add(conge);

        congeRepository.save(conge);
        return agentRepository.save(agent);
    }

    public Agent assignGradeToAgent(Long agentId, Long gradeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with ID: " + agentId));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found with ID: " + gradeId));

        agent.setGrade(grade);

        return agentRepository.save(agent);
    }

    // Ajouter une qualification à un agent
    public Agent ajouterQualification(Long agentId, Qualification qualification) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));

        qualification.setAgent(agent);
        qualificationRepository.save(qualification);

        return agent;
    }

    // Récupérer les qualifications d'un agent
    public List<Qualification> getQualificationsByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));
        return qualificationRepository.findByAgent(agent);
    }

    // Assigner un poste à un agent
    public Agent assignPosteToAgent(Long agentId, Long posteId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new EntityNotFoundException("Poste introuvable"));

        agent.setPoste(poste);
        return agentRepository.save(agent);
    }

    // Récupérer le poste d'un agent
    public Poste getPosteByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));
        return agent.getPoste();
    }

    // Ajouter une affectation à un agent
    public Agent ajouterAffectation(Long agentId, Affectation affectation) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));

        affectation.setAgent(agent);
        affectationRepository.save(affectation);

        return agent;
    }

    // Récupérer les affectations d'un agent
    public List<Affectation> getAffectationsByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));
        return affectationRepository.findByAgent(agent);
    }



}

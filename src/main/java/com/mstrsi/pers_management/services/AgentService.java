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


   public void updateAgent(Agent agent) {
       Agent oldAgent = agentRepository.findById(agent.getId()).get();

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

    // Ajouter Conges a l'agent
    public Agent ajouterConge(Long agentId, Conge conge) {
        // Récupérez l'agent depuis la base de données
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent introuvable"));

        // Ajoutez le congé à la liste des congés de l'agent
        conge.setAgent(agent); // Associez l'agent au congé
        agent.getConges().add(conge);

        // Sauvegardez les deux entités
        congeRepository.save(conge); // Sauvegarde indépendante du congé
        return agentRepository.save(agent); // Sauvegarde de l'agent avec sa liste mise à jour
    }


}

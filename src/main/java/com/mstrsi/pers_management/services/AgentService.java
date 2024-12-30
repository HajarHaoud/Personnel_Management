package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private DecisionRecrutementRepository decisionRecrutementRepository;
    @Autowired
    private AvisPriseFonctionRepository avisRepository;
    @Autowired
    private GradeHistoryRepository gradeHistoryRepository;
    @Autowired
    private AffectationHistoryRepository affectationHistoryRepository;


    // Recrutement
    public Agent recruterAgent(Agent agent , DecisionRecrutement decision ){
        decision.setAgent(agent);
        decision.setDecision_date(LocalDate.now());
        agent.setDecision(decision);
        decisionRecrutementRepository.save(decision);
        return agentRepository.save(agent);
    }

    public List<Agent> getNouveauxAgents() {
        return agentRepository.findByDecision_Decision_dateBetween(
                LocalDate.now().minusWeeks(1),
                LocalDate.now()
        );
    }

    public void saisirPriseFonction(Long agentId , AvisPriseFonction avis) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow((() -> new RuntimeException("Le agent " + agentId + " n'existe pas")));
        avis.setAgent(agent);
        avis.setAfp_date(LocalDate.now());
        avisRepository.save(avis);
    }


    //Gestion des dossiers
    public Agent updateDossierAgent(Long agentId , Agent updatedAgent) {
        Agent existingAgent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));


        // Mise a jour des champs modifiables
        existingAgent.setAddress(updatedAgent.getAddress());
        existingAgent.setEmail(updatedAgent.getEmail());
        existingAgent.setPhone(updatedAgent.getPhone());

        return agentRepository.save(existingAgent);
    }

    public void ajouterDiplome(Long agentId , Diplome diplome) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));
        diplome.setAgent(agent);
        agent.getDiplomes().add(diplome);
        agentRepository.save(agent);
    }

    public void ajouterConge(Long agentId , Conge conge) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));
        conge.setAgent(agent);
        agent.getConges().add(conge);
        agentRepository.save(agent);
    }

    public void updateGrade(Long agentId , Grade newGrade) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));

        GradeHistory gh = new GradeHistory();
        gh.setAgent(agent);
        gh.setGrade_history_name(newGrade.getGrade_name());
        gh.setGrade_history_start_date(LocalDate.now());
        gh.setGrade_history_description(newGrade.getGrade_description());

        gradeHistoryRepository.save(gh);
    }

    public void updateAffectation(Long agentId , Affectation newAffectation) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));
        AffectationHistory affecthistory = new AffectationHistory();
        affecthistory.setAgent(agent);
        affecthistory.setAffectation(newAffectation);
        affecthistory.setAffectation_history_start_date(LocalDate.now());
        affecthistory.setAffectation_history_name(newAffectation.getAffectation_name());

        affectationHistoryRepository.save(affecthistory);
    }


    // Consultations
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le agent " + id + " n'existe pas"));
    }

    public List<Conge> getCongesAgent(Long agentId) {
        Agent agent = getAgentById(agentId);
        return agent.getConges();
    }

    public List<GradeHistory> getHistoriquesGrades(Long agentId) {
        Agent agent = getAgentById(agentId);
        return agent.getGradeHistory();
    }

    public List<AffectationHistory> getHistoriqueAffectation(Long agentId) {
        Agent agent = getAgentById(agentId);
        return agent.getAffectationHistories();
    }

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}

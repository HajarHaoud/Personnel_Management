package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Affectation;
import com.mstrsi.pers_management.entities.Rapport;
import com.mstrsi.pers_management.repositories.AffectationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class AffectationService {
    @Autowired
    private AffectationRepository affectationRepository;
    private final Map<Long, List<Affectation>> agentAffectations = new HashMap<>();
    private final Map<String, List<Affectation>> uniteAffectations = new HashMap<>();


    public Affectation addAffectation(Affectation newAffectation) {
        if (newAffectation.getAgent() == null || newAffectation.getUniteAffectation() == null || newAffectation.getPoste() == null) {
            throw new IllegalArgumentException("L'agent, l'unité d'affectation et le poste sont requis.");
        }
        return affectationRepository.save(newAffectation);
    }

    public Affectation updateAffectation(Long affectId, Affectation newAffectation) {
        Affectation existingAffectation = affectationRepository.findById(affectId)
                .orElseThrow(() -> new NoSuchElementException("Affectation non trouvée"));
        existingAffectation.setAffectationName(newAffectation.getAffectationName());
        existingAffectation.setAffectationDate(newAffectation.getAffectationDate());
        existingAffectation.setEndDate(newAffectation.getEndDate());
        existingAffectation.setAgent(newAffectation.getAgent());
        existingAffectation.setUniteAffectation(newAffectation.getUniteAffectation());
        existingAffectation.setPoste(newAffectation.getPoste());
        return affectationRepository.save(existingAffectation);
    }

    public List<Affectation> listerAffectationsParAgent(Long agentId) {
        return affectationRepository.findByAgentId(agentId);
    }



    public void deleteAffectation(Long idAffectation) {
        if (!affectationRepository.existsById(idAffectation)) {
            throw new NoSuchElementException("Affectation non trouvée");
        }
        affectationRepository.deleteById(idAffectation);
    }

    public Affectation getAgentAffectation(Long agentId) {
        List<Affectation> affectationsAgent = agentAffectations.get(agentId);
        if (affectationsAgent == null || affectationsAgent.isEmpty()) {
            return null;
        }
        return affectationsAgent.stream()
                .max(Comparator.comparing(Affectation::getAffectationDate))
                .orElse(null);
    }

    public List<Affectation> getAllAffectationByUnit(String codeUnite) {
        return uniteAffectations.getOrDefault(codeUnite, new ArrayList<>());
    }

    public Map<Long, List<Affectation>> suivreEvolutionAffectations() {
        return new HashMap<>(agentAffectations);
    }




    // Generate a report of affectations
    /*public Rapport editerRapportAffectations(CritereRapport criteres) {
        // Mock implementation for reporting
        return new Rapport("Rapport affectations", new Date(), new ArrayList<>(affectations.values()));
    }*/

    // Notify units of new affectations
    /*public void notifierUnitesDesAffectations(List<Affectation> nouvellesAffectations) {
        for (Affectation affectation : nouvellesAffectations) {
            System.out.println("Notification envoyée à l'unité: " + affectation.getCodeUnite());
        }
    }*/
}

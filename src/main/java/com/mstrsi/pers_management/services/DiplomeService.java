package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Diplome;
import com.mstrsi.pers_management.repositories.AgentRepository;
import com.mstrsi.pers_management.repositories.DiplomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DiplomeService {
    @Autowired
    private DiplomeRepository diplomeRespository ;
    @Autowired
    private AgentService agentService ;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private DiplomeRepository diplomeRepository ;

    public Diplome ajouterDiplome(Long agentId , Diplome diplome){
        Agent agent = agentService.getAgent(agentId) ;
        diplome.setAgent(agent);
        return diplomeRespository.save(diplome);
    }

    public List<Diplome> getDiplomeByAgent(Long agentId){
        Agent agent = agentService.getAgent(agentId);
        return diplomeRespository.findByAgent(agent);
    }

    public Diplome getDiplomeById(Long diplomeId) {
        return diplomeRepository.findById(diplomeId)
                .orElseThrow(() -> new RuntimeException("Diplôme introuvable avec l'ID : " + diplomeId));
    }

    public Diplome updateDiplome(Long diplomeId, Diplome updatedDiplome) {
        Diplome existingDiplome = getDiplomeById(diplomeId);

        existingDiplome.setDiplomeName(updatedDiplome.getDiplomeName());
        existingDiplome.setDiplomeDate(updatedDiplome.getDiplomeDate());

        return diplomeRepository.save(existingDiplome);
    }

    public void deleteDiplome(Long diplomeId){
        diplomeRespository.deleteById(diplomeId);
    }

    public void saveDiplome(Diplome diplome){
        diplomeRespository.save(diplome);
    }
}

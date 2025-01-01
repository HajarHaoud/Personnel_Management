package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Diplome;
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




    public Diplome ajouterDiplome(Long agentId , Diplome diplome){
        Agent agent = agentService.getAgent(agentId) ;
        diplome.setAgent(agent);
        return diplomeRespository.save(diplome);
    }

    public List<Diplome> getDiplomeByAgent(Agent agentId){
        return diplomeRespository.findByAgent(agentId);
    }

    public void deleteDiplome(Diplome diplome){
        diplomeRespository.delete(diplome);
    }

    public void saveDiplome(Diplome diplome){
        diplomeRespository.save(diplome);
    }
}

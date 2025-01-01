package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Conge;
import com.mstrsi.pers_management.repositories.AgentRepository;
import com.mstrsi.pers_management.repositories.CongeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CongeService {
    @Autowired
    private CongeRepository congeRepository;
    @Autowired
    private AgentRepository agentRepository;


    public List<Conge> getAllConges(Long agentId) {
        Agent agent = agentRepository.getAgentById(agentId);
        return agent.getConges();
    }

    public Conge getCongeById(Long congeId) {
        return congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found"));
    }

    public List<Conge> getCongesByAgentId(Long agentId) {
        return congeRepository.findByAgentId(agentId);
    }



    public void addConge(Long id , Conge conge) {
        Agent agent =  agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        conge.setAgent(agent);
        agent.getConges().add(conge);
        congeRepository.save(conge);
    }

    public void updateConge(Long congeId, Conge updatedConge) {
        Conge existingConge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found"));

        existingConge.setCongeDateDebut(updatedConge.getCongeDateDebut());
        existingConge.setCongeDateFin(updatedConge.getCongeDateFin());
        existingConge.setCongeType(updatedConge.getCongeType());
        existingConge.setCongeStatus(updatedConge.getCongeStatus());

        congeRepository.save(existingConge);
    }

    public void removeConge(Long congeId) {
        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found"));
        conge.getAgent().getConges().remove(conge);
        congeRepository.deleteById(congeId);
    }

    public List<Conge> findCongesByStatus(String status) {
        return congeRepository.findByCongeStatus(status);
    }

    public List<Conge> findCongesByType(String type) {
        return congeRepository.findByCongeStatus(type);
    }

}

package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Affectation;
import com.mstrsi.pers_management.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findByAgentId(Long agentId);

    List<Affectation> findByAgent(Agent agent);
}

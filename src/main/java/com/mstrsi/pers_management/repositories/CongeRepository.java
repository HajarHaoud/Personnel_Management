package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {
    List<Conge> findByCongeStatus(String congeStatus);
    List<Conge> findByAgentId(Long agentId);
}

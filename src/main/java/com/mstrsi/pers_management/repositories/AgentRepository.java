package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query("SELECT a FROM Agent a WHERE a.decision.decision_date BETWEEN ?1 AND ?2")
    List<Agent> findByDecision_Decision_dateBetween(LocalDate startDate, LocalDate endDate);


}
package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByAgent(Agent agent);
}

package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
    List<Diplome> findByAgent(Agent agent);
}

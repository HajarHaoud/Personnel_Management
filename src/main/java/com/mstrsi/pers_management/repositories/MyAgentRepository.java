package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyAgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByUsername(String username);
}

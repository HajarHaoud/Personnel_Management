package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Optional<Agent> findByMatricule(String matricule);

    Optional<Agent> findByUsername(String username);

    //boolean existsByUsername(@NotBlank @Size(min = 2, max = 50) String username);

    //boolean existsByEmail(@NotBlank @Size(min = 2, max = 50) String email);
    //Optional<Agent> findByEmail(String username);
}

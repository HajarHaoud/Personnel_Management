package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.DecisionRecrutement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRecrutementRepository extends JpaRepository<DecisionRecrutement, Long> {
}

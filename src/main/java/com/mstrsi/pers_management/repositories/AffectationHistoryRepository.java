package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.AffectationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationHistoryRepository extends JpaRepository<AffectationHistory, Long> {
}

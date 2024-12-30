package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.GradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeHistoryRepository extends JpaRepository<GradeHistory, Long> {
}

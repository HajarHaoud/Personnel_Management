package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.UniteAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteAffectationRepository extends JpaRepository<UniteAffectation, Long> {

}

package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.AvisPriseFonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisPriseFonctionRepository extends JpaRepository<AvisPriseFonction, Long> {
}

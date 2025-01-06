package com.mstrsi.pers_management.repositories;

import com.mstrsi.pers_management.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
    List<Poste> findByPosteName(String posteName);
}

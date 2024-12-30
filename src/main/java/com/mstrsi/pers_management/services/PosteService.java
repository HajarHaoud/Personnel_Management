package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.repositories.PosteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PosteService {
    @Autowired
    private PosteRepository posteRepository;


    public Poste createPoste(Poste poste) {
        return posteRepository.save(poste);
    }


    public void assignerGradeAuPoste(Long posteId , Grade grade) {
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouve"));
        poste.getGrade_requested().add(grade);
        posteRepository.save(poste);
    }
}

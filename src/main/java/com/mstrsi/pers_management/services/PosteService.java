package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.repositories.PosteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PosteService {
    @Autowired
    private PosteRepository posteRepository;


    public Poste addPoste(Poste poste) {
        if(poste == null) {
            throw new IllegalArgumentException("Le poste ne peut pas etre null");
        }
        return posteRepository.save(poste);
    }

    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    public boolean existsById(Long posteId) {
        return posteRepository.existsById(posteId);
    }

    public List<Poste> findPostesByNom(String posteName) {
        return posteRepository.findByPosteName(posteName);
    }

    public long countPostes() {
        return posteRepository.count();
    }


    public Poste updatePoste(Long posteId, Poste posteDetails) {
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + posteId));

        poste.setPosteName(posteDetails.getPosteName());
        poste.setPosteDescription(posteDetails.getPosteDescription());
        return posteRepository.save(poste);
    }


    public void assignerGradeAuPoste(Long posteId, Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException("Le grade ne peut pas être null");
        }

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + posteId));

        poste.getGradeRequested().add(grade);
        posteRepository.save(poste);
    }




    public void deletePoste(Long posteId) {
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé avec l'ID : " + posteId));
        posteRepository.delete(poste);
    }



}

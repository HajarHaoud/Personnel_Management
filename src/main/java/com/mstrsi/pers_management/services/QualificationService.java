package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Qualification;
import com.mstrsi.pers_management.repositories.QualificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    public Qualification addQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    public List<Qualification> getAllQualifications() {
        return qualificationRepository.findAll();
    }

    public Optional<Qualification> getQualificationById(Long id) {
        return qualificationRepository.findById(id);
    }

    public Qualification saveQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    public void deleteQualification(Long id) {
        qualificationRepository.deleteById(id);
    }
}

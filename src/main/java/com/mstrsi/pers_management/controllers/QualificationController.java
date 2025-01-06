package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Qualification;
import com.mstrsi.pers_management.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/qualification")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    @GetMapping
    public List<Qualification> getAllQualifications() {
        return qualificationService.getAllQualifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Qualification> getQualificationById(@PathVariable Long id) {
        Optional<Qualification> qualification = qualificationService.getQualificationById(id);
        return qualification.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Qualification createQualification(@RequestBody Qualification qualification) {
        return qualificationService.saveQualification(qualification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Qualification> updateQualification(@PathVariable Long id, @RequestBody Qualification qualificationDetails) {
        Optional<Qualification> existingQualification = qualificationService.getQualificationById(id);
        if (existingQualification.isPresent()) {
            Qualification updatedQualification = existingQualification.get();
            updatedQualification.setQualificationName(qualificationDetails.getQualificationName());
            updatedQualification.setQualificationDescription(qualificationDetails.getQualificationDescription());
            updatedQualification.setQualificationDate(qualificationDetails.getQualificationDate());
            updatedQualification.setQualificationType(qualificationDetails.getQualificationType());
            updatedQualification.setAgent(qualificationDetails.getAgent());
            return ResponseEntity.ok(qualificationService.saveQualification(updatedQualification));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualification(@PathVariable Long id) {
        qualificationService.deleteQualification(id);
        return ResponseEntity.noContent().build();
    }
}

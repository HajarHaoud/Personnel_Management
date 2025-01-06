package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Affectation;
import com.mstrsi.pers_management.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/affectation")
public class AffectationController {
    @Autowired
    private AffectationService affectationService;

    // Ajouter une nouvelle affectation
    @PostMapping
    public ResponseEntity<Affectation> addAffectation(@RequestBody Affectation affectation) {
        Affectation newAffectation = affectationService.addAffectation(affectation);
        return new ResponseEntity<>(newAffectation, HttpStatus.CREATED);
    }

    // Mettre à jour une affectation existante
    @PutMapping("/{id}")
    public ResponseEntity<Affectation> updateAffectation(
            @PathVariable Long id,
            @RequestBody Affectation updatedAffectation
    ) {
        Affectation affectation = affectationService.updateAffectation(id, updatedAffectation);
        return new ResponseEntity<>(affectation, HttpStatus.OK);
    }

    // Supprimer une affectation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectation(@PathVariable Long id) {
        affectationService.deleteAffectation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Lister les affectations d'un agent
    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Affectation>> getAffectationsByAgent(@PathVariable Long agentId) {
        List<Affectation> affectations = affectationService.listerAffectationsParAgent(agentId);
        return new ResponseEntity<>(affectations, HttpStatus.OK);
    }

    // Obtenir l'affectation actuelle d'un agent
    @GetMapping("/agent/{agentId}/current")
    public ResponseEntity<Affectation> getCurrentAffectationByAgent(@PathVariable Long agentId) {
        Affectation affectation = affectationService.getAgentAffectation(agentId);
        if (affectation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(affectation, HttpStatus.OK);
    }

    // Lister toutes les affectations d'une unité
    @GetMapping("/unite/{codeUnite}")
    public ResponseEntity<List<Affectation>> getAffectationsByUnit(@PathVariable String codeUnite) {
        List<Affectation> affectations = affectationService.getAllAffectationByUnit(codeUnite);
        return new ResponseEntity<>(affectations, HttpStatus.OK);
    }


    // Suivre l'évolution des affectations par agent
    @GetMapping("/suivi")
    public ResponseEntity<Map<Long, List<Affectation>>> suivreEvolutionAffectations() {
        Map<Long, List<Affectation>> suivi = affectationService.suivreEvolutionAffectations();
        return new ResponseEntity<>(suivi, HttpStatus.OK);
    }
}

package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Conge;
import com.mstrsi.pers_management.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conge")
@CrossOrigin("*")
public class CongeController {
    @Autowired
    private CongeService congeService;


    // Récupérer tous les congés pour un agent spécifique
    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Conge>> getAllConges(@PathVariable Long agentId) {
        List<Conge> conges = congeService.getAllConges(agentId);
        return ResponseEntity.ok(conges);
    }

    // Récupérer un congé par son ID
    @GetMapping("/{congeId}")
    public ResponseEntity<Conge> getCongeById(@PathVariable Long congeId) {
        Conge conge = congeService.getCongeById(congeId);
        return ResponseEntity.ok(conge);
    }

    // Ajouter un nouveau congé pour un agent
    @PostMapping("/agent/{agentId}")
    public ResponseEntity<Void> addConge(@PathVariable Long agentId, @RequestBody Conge conge) {
        congeService.addConge(agentId, conge);
        return ResponseEntity.ok().build();
    }

    // Mettre à jour un congé existant
    @PutMapping("/{congeId}")
    public ResponseEntity<Void> updateConge(@PathVariable Long congeId, @RequestBody Conge updatedConge) {
        congeService.updateConge(congeId, updatedConge);
        return ResponseEntity.ok().build();
    }

    // Supprimer un congé
    @DeleteMapping("/{congeId}")
    public ResponseEntity<Void> removeConge(@PathVariable Long congeId) {
        congeService.removeConge(congeId);
        return ResponseEntity.ok().build();
    }

    // Trouver les congés par statut
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Conge>> findCongesByStatus(@PathVariable String status) {
        List<Conge> conges = congeService.findCongesByStatus(status);
        return ResponseEntity.ok(conges);
    }

    // Trouver les congés par type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Conge>> findCongesByType(@PathVariable String type) {
        List<Conge> conges = congeService.findCongesByType(type);
        return ResponseEntity.ok(conges);
    }

    @GetMapping("/{agentId}")
    public ResponseEntity<List<Conge>> getCongesByAgentId(@PathVariable Long agentId) {
        List<Conge> conges = congeService.getAllConges(agentId);
        return ResponseEntity.ok(conges);
    }

}


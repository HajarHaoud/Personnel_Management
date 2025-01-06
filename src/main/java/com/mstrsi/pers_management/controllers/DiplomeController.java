package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Diplome;
import com.mstrsi.pers_management.repositories.DiplomeRepository;
import com.mstrsi.pers_management.services.AgentService;
import com.mstrsi.pers_management.services.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diplome")
public class DiplomeController {
    @Autowired
    private DiplomeService diplomeService;


    @PostMapping("/agent/{agentId}")
    public ResponseEntity<Diplome> addDiplome(@PathVariable Long agentId , @RequestBody Diplome diplome) {
        Diplome newDiplome = diplomeService.ajouterDiplome(agentId, diplome);
        return ResponseEntity.ok(newDiplome);
    }

    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Diplome>> getDiplomesByAgent(@PathVariable Long agentId) {
        List<Diplome> diplomes = diplomeService.getDiplomeByAgent(agentId);
        return ResponseEntity.ok(diplomes);
    }

    @GetMapping("/{diplomeId}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable Long diplomeId) {
        Diplome diplome = diplomeService.getDiplomeById(diplomeId);
        return ResponseEntity.ok(diplome);
    }

    @PutMapping("/{diplomeId}")
    public ResponseEntity<Diplome> updateDiplome(@PathVariable Long diplomeId, @RequestBody Diplome diplome) {
        Diplome updated = diplomeService.updateDiplome(diplomeId, diplome);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{diplomeId}")
    public ResponseEntity<Void> deleteDiplome(@PathVariable Long diplomeId) {
        diplomeService.deleteDiplome(diplomeId);
        return ResponseEntity.noContent().build();
    }



}

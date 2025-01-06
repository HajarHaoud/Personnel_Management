package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.services.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postes")
public class PosteController {
    @Autowired
    private PosteService posteService;


    @PostMapping
    public ResponseEntity<Poste> addPoste(@RequestBody Poste poste) {
        Poste createdPoste = posteService.addPoste(poste);
        return ResponseEntity.ok(createdPoste);
    }

    @GetMapping
    public ResponseEntity<List<Poste>> getAllPostes() {
        List<Poste> postes = posteService.getAllPostes();
        return ResponseEntity.ok(postes);
    }

    @GetMapping("/exists/{posteId}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long posteId) {
        boolean exists = posteService.existsById(posteId);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Poste>> findPostesByNom(@RequestParam String posteName) {
        List<Poste> postes = posteService.findPostesByNom(posteName);
        return ResponseEntity.ok(postes);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countPostes() {
        long count = posteService.countPostes();
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{posteId}")
    public ResponseEntity<Poste> updatePoste(@PathVariable Long posteId, @RequestBody Poste posteDetails) {
        Poste updatedPoste = posteService.updatePoste(posteId, posteDetails);
        return ResponseEntity.ok(updatedPoste);
    }

    @PostMapping("/{posteId}/grades")
    public ResponseEntity<Void> assignerGradeAuPoste(@PathVariable Long posteId, @RequestBody Grade grade) {
        posteService.assignerGradeAuPoste(posteId, grade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{posteId}")
    public ResponseEntity<Void> deletePoste(@PathVariable Long posteId) {
        posteService.deletePoste(posteId);
        return ResponseEntity.noContent().build();
    }

}

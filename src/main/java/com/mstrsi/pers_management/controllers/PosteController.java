package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.services.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postes")
public class PosteController {
    @Autowired
    private PosteService posteService;

    @PostMapping
    public ResponseEntity<Poste> createPoste(@RequestBody Poste poste) {
        return ResponseEntity.ok(posteService.createPoste(poste));
    }

    @PostMapping("/{id}/grades")
    public ResponseEntity<Void> assignerGrade(@PathVariable Long id , @RequestBody Grade grade) {
        posteService.assignerGradeAuPoste(id , grade);
        return ResponseEntity.ok().build();
    }
}

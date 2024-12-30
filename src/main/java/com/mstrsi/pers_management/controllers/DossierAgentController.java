package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Diplome;
import com.mstrsi.pers_management.entities.Qualification;
import com.mstrsi.pers_management.services.DiplomeService;
import com.mstrsi.pers_management.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dossier-agent")
public class DossierAgentController {
    @Autowired
    private QualificationService qualificationService;
    @Autowired
    private DiplomeService diplomeService;


    @PostMapping("/{agentId}/diplomes")
    public ResponseEntity<Diplome> ajouterDiplome(@PathVariable Long agentId, @RequestBody Diplome diplome) {
        return ResponseEntity.ok(diplomeService.ajouterDiplome(agentId, diplome));
    }

    @PostMapping("/{agentId}/qualifications")
    public ResponseEntity<Qualification> ajouterQualification(@RequestBody Qualification qualification) {
        return ResponseEntity.ok(qualificationService.addQualification(qualification));
    }
}

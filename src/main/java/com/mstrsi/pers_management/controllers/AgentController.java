package com.mstrsi.pers_management.controllers;


import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.repositories.AgentRepository;
import com.mstrsi.pers_management.repositories.CongeRepository;
import com.mstrsi.pers_management.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin("*")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @Autowired
    private CongeRepository congeRepository;
    @Autowired
    private AgentRepository agentRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgent(@PathVariable long id) {
        return ResponseEntity.ok(agentService.getAgent(id));
    }


    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @PostMapping
    public ResponseEntity<Agent> saveAgent(@RequestBody Agent agent) {
        return ResponseEntity.ok(agentService.saveAgent(agent));
    }

    @PutMapping
    public ResponseEntity<Void> updateAgent(@PathVariable Long id , @RequestBody Agent agent) {
        agentService.updateAgent(id , agent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{agentId}/conges")
    public ResponseEntity<Agent> ajouterConge(@PathVariable Long agentId, @RequestBody Conge conge) {
        Agent agentMisAJour = agentService.ajouterConge(agentId, conge);
        return ResponseEntity.ok(agentMisAJour);
    }

    @PutMapping("/{agentId}/assign-grade/{gradeId}")
    public ResponseEntity<Agent> assignGrade(@PathVariable Long agentId, @PathVariable Long gradeId) {
        Agent updatedAgent = agentService.assignGradeToAgent(agentId, gradeId);
        return ResponseEntity.ok(updatedAgent);
    }

    // Ajouter une qualification à un agent
    @PostMapping("/{id}/qualifications")
    public ResponseEntity<Agent> ajouterQualification(@PathVariable Long id, @RequestBody Qualification qualification) {
        Agent agent = agentService.ajouterQualification(id, qualification);
        return ResponseEntity.ok(agent);
    }

    // Récupérer les qualifications d'un agent
    @GetMapping("/{id}/qualifications")
    public ResponseEntity<List<Qualification>> getQualificationsByAgent(@PathVariable Long id) {
        List<Qualification> qualifications = agentService.getQualificationsByAgent(id);
        return ResponseEntity.ok(qualifications);
    }

    // Assigner un poste à un agent
    @PutMapping("/{id}/poste/{posteId}")
    public ResponseEntity<Agent> assignPosteToAgent(@PathVariable Long id, @PathVariable Long posteId) {
        Agent agent = agentService.assignPosteToAgent(id, posteId);
        return ResponseEntity.ok(agent);
    }

    // Récupérer le poste d'un agent
    @GetMapping("/{id}/poste")
    public ResponseEntity<Poste> getPosteByAgent(@PathVariable Long id) {
        Poste poste = agentService.getPosteByAgent(id);
        return ResponseEntity.ok(poste);
    }

    // Ajouter une affectation à un agent
    @PostMapping("/{id}/affectations")
    public ResponseEntity<Agent> ajouterAffectation(@PathVariable Long id, @RequestBody Affectation affectation) {
        Agent agent = agentService.ajouterAffectation(id, affectation);
        return ResponseEntity.ok(agent);
    }

    // Récupérer les affectations d'un agent
    @GetMapping("/{id}/affectations")
    public ResponseEntity<List<Affectation>> getAffectationsByAgent(@PathVariable Long id) {
        List<Affectation> affectations = agentService.getAffectationsByAgent(id);
        return ResponseEntity.ok(affectations);
    }
}

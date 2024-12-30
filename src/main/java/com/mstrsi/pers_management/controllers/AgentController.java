package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.dtos.RecrutementRequest;
import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/recrutement")
    public ResponseEntity<Agent> recruterAgent(@RequestBody RecrutementRequest request) {
        Agent  agent = request.getAgent();
        DecisionRecrutement decision = request.getDecision();
        return ResponseEntity.ok(agentService.recruterAgent(agent, decision));
    }

    @GetMapping("nouveaux")
    public ResponseEntity<List<Agent>> getNouveauxAgents() {
        return ResponseEntity.ok(agentService.getNouveauxAgents());
    }

    @PostMapping("/{id}/prise-fonction")
    public ResponseEntity<Void> saisirPriseFonction(@PathVariable Long id ,@RequestBody AvisPriseFonction avis) {
        agentService.saisirPriseFonction(id, avis);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id,@RequestBody Agent agent) {
        return ResponseEntity.ok(agentService.updateDossierAgent(id, agent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgent(@PathVariable Long id) {
        return ResponseEntity.ok(agentService.getAgentById(id));
    }

    @PostMapping("/{id}/diplomes")
    public ResponseEntity<Agent> ajouterDiplome(@PathVariable Long id ,@RequestBody Diplome diplome) {
        agentService.ajouterDiplome(id, diplome);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/conges")
    public ResponseEntity<Void> ajouterConge(@PathVariable Long id ,@RequestBody Conge conge) {
        agentService.ajouterConge(id, conge);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/conges")
    public ResponseEntity<List<Conge>> getConges(@PathVariable Long id){
        return ResponseEntity.ok(agentService.getCongesAgent(id));
    }

    @GetMapping("/{id}/grades")
    public ResponseEntity<List<GradeHistory>> getGradeHistory(@PathVariable Long id){
        return ResponseEntity.ok(agentService.getHistoriquesGrades(id));
    }


    public ResponseEntity<List<AffectationHistory>> getAffectationHistory(@PathVariable Long id){
        return ResponseEntity.ok(agentService.getHistoriqueAffectation(id));
    }
}

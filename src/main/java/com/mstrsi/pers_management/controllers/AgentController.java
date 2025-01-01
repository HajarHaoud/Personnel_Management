package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.dtos.RecrutementRequest;
import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.repositories.AgentRepository;
import com.mstrsi.pers_management.repositories.CongeRepository;
import com.mstrsi.pers_management.services.AgentService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<Void> updateAgent(@RequestBody Agent agent) {
        agentService.updateAgent(agent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{agentId}/conges")
    public ResponseEntity<Agent> ajouterConge(@PathVariable Long agentId, @RequestBody Conge conge) {
        // Appeler la méthode du service
        Agent agentMisAJour = agentService.ajouterConge(agentId, conge);

        // Retourner la réponse
        return ResponseEntity.ok(agentMisAJour);
    }



}

package com.mstrsi.pers_management.controller;

import com.mstrsi.pers_management.dtos.AgentDto;
import com.mstrsi.pers_management.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthTestController {

    private final AgentService agentService;

    @PostMapping("/register")
    public ResponseEntity<Map<String , String>> registerAgent(@RequestBody AgentDto agentDto) {
        try {
            AgentDto createdAgent = agentService.createAgent(agentDto);
            return ResponseEntity.ok(Map.of("message", "Agent created" , "matricule" , createdAgent.getMatricule()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("erreur", e.getMessage()));
        }
    }

    @GetMapping("/test-auth")
    @PreAuthorize("hasRole('AGENT')")
    public ResponseEntity<String> testAuth() {
        return ResponseEntity.ok("Authentification reussie ! ");
    }
}

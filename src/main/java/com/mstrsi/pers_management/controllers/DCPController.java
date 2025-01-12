package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.dtos.PosteDto;
import com.mstrsi.pers_management.services.DCPService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dcp")
public class DCPController {

    private DCPService dcpService;

    @GetMapping("/postes/{id}/verify")
    public ResponseEntity<Boolean> verifierPoste(@PathVariable Long posteId){
        return ResponseEntity.ok(dcpService.verifierExistencePoste(posteId));
    }

    @GetMapping("/postes/{id}")
    public ResponseEntity<PosteDto> getPoste(@PathVariable Long posteId){
        return ResponseEntity.ok(dcpService.getPosteDetails(posteId));
    }
}

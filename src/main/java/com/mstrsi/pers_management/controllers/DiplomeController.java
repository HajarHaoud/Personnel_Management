package com.mstrsi.pers_management.controllers;


import com.mstrsi.pers_management.dtos.DiplomeDto;
import com.mstrsi.pers_management.services.DiplomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diplomes")
public class DiplomeController {
    private DiplomeService diplomeService;
    public DiplomeController(DiplomeService diplomeService) {
        this.diplomeService = diplomeService;
    }
    @PostMapping
    public ResponseEntity<DiplomeDto> addDiplome(@RequestBody DiplomeDto diplomeDto) {
        return new ResponseEntity<>(diplomeService.createDiplome(diplomeDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DiplomeDto> modifyDiplome( @PathVariable Long id, @RequestBody DiplomeDto diplomeDto) {
        return new ResponseEntity<>(diplomeService.updateDiplome(id, diplomeDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiplomeDto> getDiplome(@PathVariable Long id) {
        return new ResponseEntity<>(diplomeService.getDiplomeById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DiplomeDto>> getAllDiplomes() {
        return new ResponseEntity<>(diplomeService.getAllDiplomes(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiplome(@PathVariable Long id) {
        diplomeService.deleteDiplome(id);
        return  ResponseEntity.ok("Diplome deleted Successfully");
    }
}

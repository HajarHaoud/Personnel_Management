package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.services.AgentService;
import com.mstrsi.pers_management.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private AgentService agentService;


    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Grade grade = gradeService.getGradeById(id);
        return ResponseEntity.ok(grade);
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade newGrade = gradeService.addGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGrade);
    }

    @PutMapping
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id , @RequestBody Grade grade) {
        Grade updatedGrade = gradeService.updateGrade(id, grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{gradeId}/assign-to-grade/{agentId}")
    public ResponseEntity<Agent> assignGradeToAgent(@PathVariable Long gardeId,@RequestBody Long agentId) {
        Agent agent = agentService.assignGradeToAgent(gardeId, agentId);
        return ResponseEntity.ok(agent);
    }


}

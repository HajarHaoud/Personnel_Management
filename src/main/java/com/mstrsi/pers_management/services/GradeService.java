package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Grade;
import com.mstrsi.pers_management.repositories.AgentRepository;
import com.mstrsi.pers_management.repositories.GradeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private AgentRepository agentRepository;


    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade n'existe pas"));
    }

    public Grade addGrade(Grade grade) {
        grade.setGradeDate(LocalDate.now());
        return gradeRepository.save(grade);
    }

/*
Cette méthode est utilisée pour créer une trace historique des grades d'un agent.
Elle ne met pas à jour directement un grade ou un agent, mais enregistre un historique
de changement (dans une table GradeHistory).

    public void updateGrade(Long agentId , Grade newGrade) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Le agent " + agentId + " n'existe pas"));

        GradeHistory gh = new GradeHistory();
        gh.setAgent(agent);
        gh.setGradeHistoryName(newGrade.getGradeName());
        gh.setGradeHistoryDate(LocalDate.now());
        gh.setGradeHistoryDescription(newGrade.getGradeDescription());

        gradeHistoryRepository.save(gh);
    }
*/

    //mettre à jour les informations d'un grade existant
    public Grade updateGrade(Long id , Grade updatedGrade) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade pas trouve"));
        grade.setGradeName(grade.getGradeName());
        grade.setGradeDescription(grade.getGradeDescription());

        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade n'existe pas"));
        gradeRepository.deleteById(id);
    }

    public Agent assignGradeToAgent(Long gradeId, Long agentId) {
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade n'existe pas"));
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent n'existe pas"));

        agent.setGrade(grade);

        return agentRepository.save(agent);
    }

    /*
    public List<Agent>  setAgentGrade(List<Agent> agent, Long id) {
        List<Grade> grade = getAllGrades();
        for(int i = 0 ; i < agent.size() ; i++) {
            for(int j = 0 ; j < grade.size() ; j++) {
                if (grade.get(j).getGradeId() == agent.get(i).getId()) {
                    agent.get(i).setGrade(agent.getLast().getGrade());
                }
            }
        }
        return agent;
    }*/


}


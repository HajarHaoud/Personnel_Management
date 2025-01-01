package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade_history")
public class GradeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gradeHistoryId;

    private LocalDate gradeHistoryDate;
    private String gradeHistoryDescription;
    private String gradeHistoryName;
    private LocalDate gradeHistoryEndDate;
    private LocalDate gradeHistoryStartDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;


    public long getGradeHistoryId() {
        return gradeHistoryId;
    }

    public void setGradeHistoryId(long gradeHistoryId) {
        this.gradeHistoryId = gradeHistoryId;
    }

    public LocalDate getGradeHistoryDate() {
        return gradeHistoryDate;
    }

    public void setGradeHistoryDate(LocalDate gradeHistoryDate) {
        this.gradeHistoryDate = gradeHistoryDate;
    }

    public String getGradeHistoryDescription() {
        return gradeHistoryDescription;
    }

    public void setGradeHistoryDescription(String gradeHistoryDescription) {
        this.gradeHistoryDescription = gradeHistoryDescription;
    }

    public String getGradeHistoryName() {
        return gradeHistoryName;
    }

    public void setGradeHistoryName(String gradeHistoryName) {
        this.gradeHistoryName = gradeHistoryName;
    }

    public LocalDate getGradeHistoryEndDate() {
        return gradeHistoryEndDate;
    }

    public void setGradeHistoryEndDate(LocalDate gradeHistoryEndDate) {
        this.gradeHistoryEndDate = gradeHistoryEndDate;
    }

    public LocalDate getGradeHistoryStartDate() {
        return gradeHistoryStartDate;
    }

    public void setGradeHistoryStartDate(LocalDate gradeHistoryStartDate) {
        this.gradeHistoryStartDate = gradeHistoryStartDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

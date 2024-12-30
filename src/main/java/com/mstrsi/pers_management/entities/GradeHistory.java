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
    private long grade_history_id;

    private LocalDate grade_history_date;
    private String grade_history_description;
    private String grade_history_name;
    private LocalDate grade_history_end_date;
    private LocalDate grade_history_start_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;


    public long getGrade_history_id() {
        return grade_history_id;
    }

    public void setGrade_history_id(long grade_history_id) {
        this.grade_history_id = grade_history_id;
    }

    public LocalDate getGrade_history_date() {
        return grade_history_date;
    }

    public void setGrade_history_date(LocalDate grade_history_date) {
        this.grade_history_date = grade_history_date;
    }

    public String getGrade_history_description() {
        return grade_history_description;
    }

    public void setGrade_history_description(String grade_history_description) {
        this.grade_history_description = grade_history_description;
    }

    public String getGrade_history_name() {
        return grade_history_name;
    }

    public void setGrade_history_name(String grade_history_name) {
        this.grade_history_name = grade_history_name;
    }

    public LocalDate getGrade_history_end_date() {
        return grade_history_end_date;
    }

    public void setGrade_history_end_date(LocalDate grade_history_end_date) {
        this.grade_history_end_date = grade_history_end_date;
    }

    public LocalDate getGrade_history_start_date() {
        return grade_history_start_date;
    }

    public void setGrade_history_start_date(LocalDate grade_history_start_date) {
        this.grade_history_start_date = grade_history_start_date;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

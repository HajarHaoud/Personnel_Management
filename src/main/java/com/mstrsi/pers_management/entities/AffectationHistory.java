package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "affectation_history")
public class AffectationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long affectation_history_id;

    private String affectation_history_name;
    private LocalDate affectation_history_start_date;
    private LocalDate affectation_history_end_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affectation_id", nullable = false)
    private Affectation affectation;


    public long getAffectation_history_id() {
        return affectation_history_id;
    }

    public void setAffectation_history_id(long affectation_history_id) {
        this.affectation_history_id = affectation_history_id;
    }

    public String getAffectation_history_name() {
        return affectation_history_name;
    }

    public void setAffectation_history_name(String affectation_history_name) {
        this.affectation_history_name = affectation_history_name;
    }

    public LocalDate getAffectation_history_start_date() {
        return affectation_history_start_date;
    }

    public void setAffectation_history_start_date(LocalDate affectation_history_start_date) {
        this.affectation_history_start_date = affectation_history_start_date;
    }

    public LocalDate getAffectation_history_end_date() {
        return affectation_history_end_date;
    }

    public void setAffectation_history_end_date(LocalDate affectation_history_end_date) {
        this.affectation_history_end_date = affectation_history_end_date;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }
}

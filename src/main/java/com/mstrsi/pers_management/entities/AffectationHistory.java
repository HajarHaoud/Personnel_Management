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
    private long affectationHistoryId;

    private String affectationHistoryName;
    private LocalDate affectationHistoryStartDate;
    private LocalDate affectationHistoryEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affectation_id", nullable = false)
    private Affectation affectation;


    public long getAffectationHistoryId() {
        return affectationHistoryId;
    }

    public void setAffectationHistoryId(long affectationHistoryId) {
        this.affectationHistoryId = affectationHistoryId;
    }

    public String getAffectationHistoryName() {
        return affectationHistoryName;
    }

    public void setAffectationHistoryName(String affectationHistoryName) {
        this.affectationHistoryName = affectationHistoryName;
    }

    public LocalDate getAffectationHistoryStartDate() {
        return affectationHistoryStartDate;
    }

    public void setAffectationHistoryStartDate(LocalDate affectationHistoryStartDate) {
        this.affectationHistoryStartDate = affectationHistoryStartDate;
    }

    public LocalDate getAffectationHistoryEndDate() {
        return affectationHistoryEndDate;
    }

    public void setAffectationHistoryEndDate(LocalDate affectationHistoryEndDate) {
        this.affectationHistoryEndDate = affectationHistoryEndDate;
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

package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "affectation")
public class Affectation {
    @Id
    @GeneratedValue
    private long affectationId;

    private String affectationName;
    private LocalDate affectationDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "affectation" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<AffectationHistory> affectationHistories;


    public long getAffectationId() {
        return affectationId;
    }

    public void setAffectationId(long affectationId) {
        this.affectationId = affectationId;
    }

    public String getAffectationName() {
        return affectationName;
    }

    public void setAffectationName(String affectationName) {
        this.affectationName = affectationName;
    }

    public LocalDate getAffectationDate() {
        return affectationDate;
    }

    public void setAffectationDate(LocalDate affectationDate) {
        this.affectationDate = affectationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<AffectationHistory> getAffectationHistories() {
        return affectationHistories;
    }

    public void setAffectationHistories(List<AffectationHistory> affectationHistories) {
        this.affectationHistories = affectationHistories;
    }
}

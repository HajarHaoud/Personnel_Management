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
    private long affectation_id;

    private String affectation_name;
    private LocalDate affectation_date;
    private LocalDate end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "affectation" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<AffectationHistory> affectationHistories;


    public long getAffectation_id() {
        return affectation_id;
    }

    public void setAffectation_id(long affectation_id) {
        this.affectation_id = affectation_id;
    }

    public String getAffectation_name() {
        return affectation_name;
    }

    public void setAffectation_name(String affectation_name) {
        this.affectation_name = affectation_name;
    }

    public LocalDate getAffectation_date() {
        return affectation_date;
    }

    public void setAffectation_date(LocalDate affectation_date) {
        this.affectation_date = affectation_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
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

package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avis_prise_fonction")
public class AvisPriseFonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long afpId;

    @OneToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "unite_affectation_id")
    private UniteAffectation uniteAffectation;
    private LocalDate afpDate;

    @Column(name = "responsable_name")
    private String afpResponsableName;


    public Long getAfpId() {
        return afpId;
    }

    public void setAfpId(Long afpId) {
        this.afpId = afpId;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public UniteAffectation getUniteAffectation() {
        return uniteAffectation;
    }

    public void setUniteAffectation(UniteAffectation uniteAffectation) {
        this.uniteAffectation = uniteAffectation;
    }

    public LocalDate getAfpDate() {
        return afpDate;
    }

    public void setAfpDate(LocalDate afpDate) {
        this.afpDate = afpDate;
    }

    public String getAfpResponsableName() {
        return afpResponsableName;
    }

    public void setAfpResponsableName(String afpResponsableName) {
        this.afpResponsableName = afpResponsableName;
    }
}

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
    private Long afp_id;

    @OneToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "unite_affectation_id")
    private UniteAffectation uniteAffectation;
    private LocalDate afp_date;

    @Column(name = "responsable_name")
    private String afp_responsable_name;


    public Long getAfp_id() {
        return afp_id;
    }

    public void setAfp_id(Long afp_id) {
        this.afp_id = afp_id;
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

    public LocalDate getAfp_date() {
        return afp_date;
    }

    public void setAfp_date(LocalDate afp_date) {
        this.afp_date = afp_date;
    }

    public String getAfp_responsable_name() {
        return afp_responsable_name;
    }

    public void setAfp_responsable_name(String afp_responsable_name) {
        this.afp_responsable_name = afp_responsable_name;
    }
}

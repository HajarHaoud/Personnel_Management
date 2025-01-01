package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long congeId;;
    private String congeType;
    private LocalDate congeDateDebut;
    private LocalDate congeDateFin;
    private String congeDescription;
    private int congeNbJours;
    private String congeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public String getCongeStatus() {
        return congeStatus;
    }

    public void setCongeStatus(String congeStatus) {
        this.congeStatus = congeStatus;
    }

    public long getCongeId() {
        return congeId;
    }

    public void setCongeId(long congeId) {
        this.congeId = congeId;
    }

    public String getCongeType() {
        return congeType;
    }

    public void setCongeType(String congeType) {
        this.congeType = congeType;
    }

    public LocalDate getCongeDateDebut() {
        return congeDateDebut;
    }

    public void setCongeDateDebut(LocalDate congeDateDebut) {
        this.congeDateDebut = congeDateDebut;
    }

    public LocalDate getCongeDateFin() {
        return congeDateFin;
    }

    public void setCongeDateFin(LocalDate congeDateFin) {
        this.congeDateFin = congeDateFin;
    }

    public String getCongeDescription() {
        return congeDescription;
    }

    public void setCongeDescription(String congeDescription) {
        this.congeDescription = congeDescription;
    }

    public int getCongeNbJours() {
        return congeNbJours;
    }

    public void setCongeNbJours(int congeNbJours) {
        this.congeNbJours = congeNbJours;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

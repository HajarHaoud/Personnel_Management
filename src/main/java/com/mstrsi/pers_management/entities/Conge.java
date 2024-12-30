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
    private long conge_id;;
    private String conge_type;
    private LocalDate conge_date_debut;
    private LocalDate conge_date_fin;
    private String conge_description;
    private int conge_nb_jours;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;


    public long getConge_id() {
        return conge_id;
    }

    public void setConge_id(long conge_id) {
        this.conge_id = conge_id;
    }

    public String getConge_type() {
        return conge_type;
    }

    public void setConge_type(String conge_type) {
        this.conge_type = conge_type;
    }

    public LocalDate getConge_date_debut() {
        return conge_date_debut;
    }

    public void setConge_date_debut(LocalDate conge_date_debut) {
        this.conge_date_debut = conge_date_debut;
    }

    public LocalDate getConge_date_fin() {
        return conge_date_fin;
    }

    public void setConge_date_fin(LocalDate conge_date_fin) {
        this.conge_date_fin = conge_date_fin;
    }

    public String getConge_description() {
        return conge_description;
    }

    public void setConge_description(String conge_description) {
        this.conge_description = conge_description;
    }

    public int getConge_nb_jours() {
        return conge_nb_jours;
    }

    public void setConge_nb_jours(int conge_nb_jours) {
        this.conge_nb_jours = conge_nb_jours;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

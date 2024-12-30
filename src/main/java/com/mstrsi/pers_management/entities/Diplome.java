package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diplome")
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long diplome_id;
    private String diplome_name;
    private LocalDate diplome_date;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;


    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public LocalDate getDiplome_date() {
        return diplome_date;
    }

    public void setDiplome_date(LocalDate diplome_date) {
        this.diplome_date = diplome_date;
    }

    public String getDiplome_name() {
        return diplome_name;
    }

    public void setDiplome_name(String diplome_name) {
        this.diplome_name = diplome_name;
    }

    public long getDiplome_id() {
        return diplome_id;
    }

    public void setDiplome_id(long diplome_id) {
        this.diplome_id = diplome_id;
    }
}

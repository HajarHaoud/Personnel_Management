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
    private long diplomeId;
    private String diplomeName;
    private LocalDate diplomeDate;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;


    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public long getDiplomeId() {
        return diplomeId;
    }

    public void setDiplomeId(long diplomeId) {
        this.diplomeId = diplomeId;
    }

    public String getDiplomeName() {
        return diplomeName;
    }

    public void setDiplomeName(String diplomeName) {
        this.diplomeName = diplomeName;
    }

    public LocalDate getDiplomeDate() {
        return diplomeDate;
    }

    public void setDiplomeDate(LocalDate diplomeDate) {
        this.diplomeDate = diplomeDate;
    }
}

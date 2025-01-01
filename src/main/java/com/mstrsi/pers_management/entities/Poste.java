package com.mstrsi.pers_management.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long posteId;
    private String posteName;
    private String posteDescription;
    private int posteSalary;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Grade> gradeRequested;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY)
    private List<Agent> agentsAssigned;


    public long getPosteId() {
        return posteId;
    }

    public void setPosteId(long posteId) {
        this.posteId = posteId;
    }

    public String getPosteName() {
        return posteName;
    }

    public void setPosteName(String posteName) {
        this.posteName = posteName;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public int getPosteSalary() {
        return posteSalary;
    }

    public void setPosteSalary(int posteSalary) {
        this.posteSalary = posteSalary;
    }

    public List<Grade> getGradeRequested() {
        return gradeRequested;
    }

    public void setGradeRequested(List<Grade> gradeRequested) {
        this.gradeRequested = gradeRequested;
    }

    public List<Agent> getAgentsAssigned() {
        return agentsAssigned;
    }

    public void setAgentsAssigned(List<Agent> agentsAssigned) {
        this.agentsAssigned = agentsAssigned;
    }
}

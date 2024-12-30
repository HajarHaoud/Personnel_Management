package com.mstrsi.pers_management.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long poste_id;
    private String poste_name;
    private String poste_description;
    private int poste_salary;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Grade> grade_requested;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY)
    private List<Agent> agents_assigned;


    public long getPoste_id() {
        return poste_id;
    }

    public void setPoste_id(long poste_id) {
        this.poste_id = poste_id;
    }

    public String getPoste_name() {
        return poste_name;
    }

    public void setPoste_name(String poste_name) {
        this.poste_name = poste_name;
    }

    public String getPoste_description() {
        return poste_description;
    }

    public void setPoste_description(String poste_description) {
        this.poste_description = poste_description;
    }

    public int getPoste_salary() {
        return poste_salary;
    }

    public void setPoste_salary(int poste_salary) {
        this.poste_salary = poste_salary;
    }

    public List<Grade> getGrade_requested() {
        return grade_requested;
    }

    public void setGrade_requested(List<Grade> grade_requested) {
        this.grade_requested = grade_requested;
    }

    public List<Agent> getAgents_assigned() {
        return agents_assigned;
    }

    public void setAgents_assigned(List<Agent> agents_assigned) {
        this.agents_assigned = agents_assigned;
    }
}

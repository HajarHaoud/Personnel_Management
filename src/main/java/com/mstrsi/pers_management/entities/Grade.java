package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private long grade_id;
    private String grade_name;
    private String grade_description;
    private LocalDate grade_date;



    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste poste;


    public long getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(long grade_id) {
        this.grade_id = grade_id;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public String getGrade_description() {
        return grade_description;
    }

    public void setGrade_description(String grade_description) {
        this.grade_description = grade_description;
    }

    public LocalDate getGrade_date() {
        return grade_date;
    }

    public void setGrade_date(LocalDate grade_date) {
        this.grade_date = grade_date;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
}

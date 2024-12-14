package com.mstrsi.pers_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthdate;
    private String birthplace;
    private String city;
    private String country;
    private LocalDate joinDate;
    private double salary;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private List<GradeHistory> gradeHistory;


    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private List<AffectationHistory> affectationHistories;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Diplome> diplomes;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Conge> conges;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id")
    private DecisionRecrutement decision;





}

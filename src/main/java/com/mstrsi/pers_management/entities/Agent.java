package com.mstrsi.pers_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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



    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Conge> conges = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id")
    private DecisionRecrutement decision;

    @OneToOne(mappedBy = "agent")
    private AvisPriseFonction avisPriseFonction;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<GradeHistory> getGradeHistory() {
        return gradeHistory;
    }

    public void setGradeHistory(List<GradeHistory> gradeHistory) {
        this.gradeHistory = gradeHistory;
    }

    public List<AffectationHistory> getAffectationHistories() {
        return affectationHistories;
    }

    public void setAffectationHistories(List<AffectationHistory> affectationHistories) {
        this.affectationHistories = affectationHistories;
    }

    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    public List<Conge> getConges() {
        return conges;
    }

    public void setConges(List<Conge> conges) {
        this.conges = conges;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public DecisionRecrutement getDecision() {
        return decision;
    }

    public void setDecision(DecisionRecrutement decision) {
        this.decision = decision;
    }

    public AvisPriseFonction getAvisPriseFonction() {
        return avisPriseFonction;
    }

    public void setAvisPriseFonction(AvisPriseFonction avisPriseFonction) {
        this.avisPriseFonction = avisPriseFonction;
    }
}

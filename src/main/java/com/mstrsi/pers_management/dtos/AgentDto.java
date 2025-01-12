package com.mstrsi.pers_management.dtos;

import com.mstrsi.pers_management.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class AgentDto {
    private Long id;
    private String username ;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String gender ;
    private String birthDate ;
    private String birthPlace ;
    private String city ;
    private String country ;
    private LocalDate joinDate ;
    private double salary ;
    private String matricule;
    private String password;
    private String decisionRecrutement;
    private Role role;
    private List<DiplomeDto> diplomes;
    private List<GradeDto> grades;
    private List<CongeDto> conges;
    private List<QualificationDto> qualifications;
    private List<PosteDto> postes;
    private List<AffectationDto> affectations;

    public AgentDto() {}

    public AgentDto(Long id, String username , String firstName, String lastName, String address, String email, String phone, String gender, String birthDate, String birthPlace, String city, String country, LocalDate joinDate, double salary) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.city = city;
        this.country = country;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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

    public List<DiplomeDto> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<DiplomeDto> diplomes) {
        this.diplomes = diplomes;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
        this.grades = grades;
    }

    public List<CongeDto> getConges() {
        return conges;
    }

    public void setConges(List<CongeDto> conges) {
        this.conges = conges;
    }

    public List<QualificationDto> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<QualificationDto> qualifications) {
        this.qualifications = qualifications;
    }

    public List<PosteDto> getPostes() {
        return postes;
    }

    public void setPostes(List<PosteDto> postes) {
        this.postes = postes;
    }

    public List<AffectationDto> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<AffectationDto> affectations) {
        this.affectations = affectations;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDecisionRecrutement() {
        return decisionRecrutement;
    }

    public void setDecisionRecrutement(String decisionRecrutement) {
        this.decisionRecrutement = decisionRecrutement;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

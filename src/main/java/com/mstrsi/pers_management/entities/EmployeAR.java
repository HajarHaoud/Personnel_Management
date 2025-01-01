package com.mstrsi.pers_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeAR")
public class EmployeAR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeId;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}

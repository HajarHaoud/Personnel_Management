package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unite_affectation")
public class UniteAffectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uniteAffectationCode;
    private String uniteAffectationName;
    private String uniteAffectationDescription;
    private String uniteAffectationType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Agent> responsableUniteAffectation;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Poste> postesAffectation;
}

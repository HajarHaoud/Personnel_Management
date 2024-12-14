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
    private long unite_affectation_code;
    private String unite_affectation_name;
    private String unite_affectation_description;
    private String unite_affectation_type;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Agent> responsable_unite_affectation;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Poste> postes_affectation;
}

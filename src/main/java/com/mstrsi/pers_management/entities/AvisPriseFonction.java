package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avis_prise_fonction")
public class AvisPriseFonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long afp_id;

    @OneToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "unite_affectation_id")
    private UniteAffectation uniteAffectation;
    private LocalDate afp_date;

    @Column(name = "responsable_name")
    private String afp_responsable_name;
}

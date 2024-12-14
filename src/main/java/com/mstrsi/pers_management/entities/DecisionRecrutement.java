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
@Table(name = "decision")
public class DecisionRecrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long decision_id;

    @Column(nullable = false, unique = true)
    private String decision_numero;

    private LocalDate decision_date;
    private LocalDate date_effet_previsionnelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @Enumerated(EnumType.STRING)
    private Visa visa;
}

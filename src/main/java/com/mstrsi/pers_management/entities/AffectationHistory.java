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
@Table(name = "affectation_history")
public class AffectationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long affectation_history_id;

    private String affectation_history_name;
    private LocalDate affectation_history_start_date;
    private LocalDate affectation_history_end_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affectation_id", nullable = false)
    private Affectation affectation;


}

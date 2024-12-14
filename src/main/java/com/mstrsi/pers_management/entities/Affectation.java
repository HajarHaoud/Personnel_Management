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
@Table(name = "affectation")
public class Affectation {
    @Id
    @GeneratedValue
    private long affectation_id;

    private String affectation_name;
    private LocalDate affectation_date;
    private LocalDate end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "affectation" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<AffectationHistory> affectationHistories;

}

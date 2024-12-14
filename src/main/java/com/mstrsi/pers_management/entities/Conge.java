package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long conge_id;;
    private String conge_type;
    private LocalDate conge_date_debut;
    private LocalDate conge_date_fin;
    private String conge_description;
    private int conge_nb_jours;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}

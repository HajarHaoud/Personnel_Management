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
@Table(name = "qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long qualificationId;
    private String qualificationName;
    private String qualificationDescription;
    private LocalDate qualificationDate;
    private String qualificationType;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

}

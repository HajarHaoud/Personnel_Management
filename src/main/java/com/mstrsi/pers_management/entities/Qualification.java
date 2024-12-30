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
    private long qualification_id;
    private String qualification_name;
    private String qualification_description;
    private LocalDate qualification_date;
    private String qualification_type;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

}

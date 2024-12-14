package com.mstrsi.pers_management.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long poste_id;
    private String poste_name;
    private String poste_description;
    private int poste_salary;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Grade> grade_requested;

    @OneToMany(mappedBy = "poste", fetch = FetchType.LAZY)
    private List<Agent> agents_assigned;


}

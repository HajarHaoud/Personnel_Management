package com.mstrsi.pers_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scf")
public class SCF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scf_id;
    private String scf_name;
}

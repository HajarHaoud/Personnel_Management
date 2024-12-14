package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dcp")
public class DCP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dcp_id;
    private String dcp_name;

}

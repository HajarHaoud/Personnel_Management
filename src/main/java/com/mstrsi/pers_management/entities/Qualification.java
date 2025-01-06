package com.mstrsi.pers_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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

    public long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationDescription() {
        return qualificationDescription;
    }

    public void setQualificationDescription(String qualificationDescription) {
        this.qualificationDescription = qualificationDescription;
    }

    public LocalDate getQualificationDate() {
        return qualificationDate;
    }

    public void setQualificationDate(LocalDate qualificationDate) {
        this.qualificationDate = qualificationDate;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

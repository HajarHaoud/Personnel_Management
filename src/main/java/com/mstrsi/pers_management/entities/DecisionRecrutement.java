package com.mstrsi.pers_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "decision")
public class DecisionRecrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long decisionId;

    @Column(nullable = false, unique = true)
    private String decisionNumero;

    private LocalDate decisionDate;
    private LocalDate dateEffetPrevisionnelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @Enumerated(EnumType.STRING)
    private Visa visa;

    public long getDecision_id() {
        return decisionId;
    }

    public void setDecisionId(long decisionId) {
        this.decisionId = decisionId;
    }

    public String getDecisionNumero() {
        return decisionNumero;
    }

    public void setDecisionNumero(String decisionNumero) {
        this.decisionNumero = decisionNumero;
    }

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }

    public LocalDate getDateEffetPrevisionnelle() {
        return dateEffetPrevisionnelle;
    }

    public void setDateEffetPrevisionnelle(LocalDate dateEffetPrevisionnelle) {
        this.dateEffetPrevisionnelle = dateEffetPrevisionnelle;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }
}

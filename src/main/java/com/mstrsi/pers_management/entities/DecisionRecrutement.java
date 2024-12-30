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
    private long decision_id;

    @Column(nullable = false, unique = true)
    private String decision_numero;

    private LocalDate decision_date;
    private LocalDate date_effet_previsionnelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @Enumerated(EnumType.STRING)
    private Visa visa;

    public long getDecision_id() {
        return decision_id;
    }

    public void setDecision_id(long decision_id) {
        this.decision_id = decision_id;
    }

    public String getDecision_numero() {
        return decision_numero;
    }

    public void setDecision_numero(String decision_numero) {
        this.decision_numero = decision_numero;
    }

    public LocalDate getDecision_date() {
        return decision_date;
    }

    public void setDecision_date(LocalDate decision_date) {
        this.decision_date = decision_date;
    }

    public LocalDate getDate_effet_previsionnelle() {
        return date_effet_previsionnelle;
    }

    public void setDate_effet_previsionnelle(LocalDate date_effet_previsionnelle) {
        this.date_effet_previsionnelle = date_effet_previsionnelle;
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

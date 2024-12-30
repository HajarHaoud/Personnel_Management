package com.mstrsi.pers_management.dtos;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.DecisionRecrutement;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
public class RecrutementRequest {
    private Agent agent;
    private DecisionRecrutement decision;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public DecisionRecrutement getDecision() {
        return decision;
    }

    public void setDecision(DecisionRecrutement decision) {
        this.decision = decision;
    }
}

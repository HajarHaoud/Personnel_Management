package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.DecisionRectrutementDto;
import com.mstrsi.pers_management.entities.Visa;
import org.springframework.stereotype.Service;

@Service
public interface SCFService {
    DecisionRectrutementDto attribuerVisa(Long decisionId , Visa visa);
}

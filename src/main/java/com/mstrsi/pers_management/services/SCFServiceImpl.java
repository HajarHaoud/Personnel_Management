package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.DecisionRectrutementDto;
import com.mstrsi.pers_management.entities.DecisionRecrutement;
import com.mstrsi.pers_management.entities.Visa;
import com.mstrsi.pers_management.mappers.DecisionRecrutementMapper;
import com.mstrsi.pers_management.repositories.DecisionRecrutementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCFServiceImpl implements SCFService {


    private DecisionRecrutementRepository decisionRepository;
    private DecisionRecrutementMapper decisionMapper;

    @Override
    public DecisionRectrutementDto attribuerVisa(Long decisionId, Visa visa) {
        DecisionRecrutement decision = decisionRepository.findById(decisionId)
                .orElseThrow(() -> new IllegalArgumentException("La decision n'est pas trouvée"));

        decision.setVisa(visa);

        return decisionMapper.toDto(decisionRepository.save(decision));
    }
}

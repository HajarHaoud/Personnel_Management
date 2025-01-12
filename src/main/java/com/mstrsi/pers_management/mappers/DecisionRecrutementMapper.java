package com.mstrsi.pers_management.mappers;

import com.mstrsi.pers_management.dtos.DecisionRectrutementDto;
import com.mstrsi.pers_management.entities.DecisionRecrutement;
import com.mstrsi.pers_management.entities.DecisionStatus;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.entities.Visa;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DecisionRecrutementMapper {

    private PosteMapper posteMapper ;

    public DecisionRectrutementDto toDto(DecisionRecrutement entity) {
        if (entity == null) {
            return null;
        }

        DecisionRectrutementDto dto = new DecisionRectrutementDto();
        dto.setDecisionId(entity.getDecisionId());
        dto.setPosteId(entity.getPoste() != null ? entity.getPoste().getId() : null);
        dto.setVisaStatus(entity.getVisa() != null ? entity.getVisa().name() : null);
        dto.setDecisionStatus(entity.getStatus()  != null ? entity.getStatus().name() : null);


        return dto;
    }

    public DecisionRecrutement toEntity(DecisionRectrutementDto dto) {
        if (dto == null) {
            return null;
        }

        DecisionRecrutement entity = new DecisionRecrutement();
        entity.setDecisionId(dto.getDecisionId());
        // Le Poste doit être chargé séparément via le repository
        entity.setVisa(dto.getVisaStatus() != null ? Visa.valueOf(dto.getVisaStatus()) : null);
        entity.setStatus(dto.getDecisionStatus() != null ? DecisionStatus.valueOf(dto.getDecisionStatus()) : null);

        return entity;
    }

    public List<DecisionRectrutementDto> toDtoList(List<DecisionRecrutement> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<DecisionRecrutement> toEntityList(List<DecisionRectrutementDto> dtos) {
        if (dtos == null) {
            return Collections.emptyList();
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    // Méthode utilitaire pour mettre à jour une entité existante avec les données d'un DTO
    public void updateEntityFromDto(DecisionRectrutementDto dto, DecisionRecrutement entity) {
        if (dto == null || entity == null) {
            return;
        }

        // Ne pas mettre à jour l'ID car c'est la clé primaire
        if (dto.getVisaStatus() != null) {
            entity.setVisa(Visa.valueOf(dto.getVisaStatus()));
        }
        if (dto.getDecisionStatus() != null) {
            entity.setStatus(DecisionStatus.valueOf(dto.getDecisionStatus()));
        }

    }
}

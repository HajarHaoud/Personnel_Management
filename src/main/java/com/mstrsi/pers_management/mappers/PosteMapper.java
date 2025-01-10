package com.mstrsi.pers_management.mappers;

import com.mstrsi.pers_management.dtos.PosteDto;
import com.mstrsi.pers_management.entities.Poste;

public class PosteMapper {
    public static Poste mapPosteDtoToPoste(PosteDto posteDto) {
        Poste poste = new Poste(
                posteDto.getId(),
                posteDto.getPosteName(),
                posteDto.getPosteDescription(),
                posteDto.getPosteSalary()
        );
        return poste;
    }
    public static PosteDto mapPosteToPosteDto(Poste poste) {
        PosteDto posteDto = new PosteDto(
                poste.getId(),
                poste.getPosteName(),
                poste.getPosteDescription(),
                poste.getPosteSalary()
        );
        if (poste.getAgent() != null) {
            posteDto.setAgentId(poste.getAgent().getId());
        }
        if (poste.getUniteAffectation() != null) {
            posteDto.setUniteAffectationId(poste.getUniteAffectation().getId());
        }
        return posteDto;
    }
}

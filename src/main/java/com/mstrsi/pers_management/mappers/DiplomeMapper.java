package com.mstrsi.pers_management.mappers;

import com.mstrsi.pers_management.dtos.DiplomeDto;
import com.mstrsi.pers_management.entities.Diplome;

public class DiplomeMapper {
    public static Diplome mapDiplomeDtoToDiplome(DiplomeDto diplomeDto) {
        Diplome diplome = new Diplome(
                diplomeDto.getId(),
                diplomeDto.getNomDiplome(),
                diplomeDto.getDateObtention(),
                diplomeDto.getEtablissement()
        );

    /*   // Vous devez mapper l'agent de DiplomeDto vers l'Agent de Diplome
        if (diplomeDto.getAgent() != null) {
            diplome.setAgent(AgentMapper.mapAgentDtoToAgent(diplomeDto.getAgent())); // Si vous avez un AgentMapper
        } */

        return diplome;
    }

    public static DiplomeDto mapDiplomeToDiplomeDto(Diplome diplome) {
        DiplomeDto diplomeDto = new DiplomeDto(
                diplome.getId(),
                diplome.getNomDiplome(),
                diplome.getDateObtention(),
                diplome.getEtablissement()
        );


        // Vous devez mapper l'agent de Diplome vers DiplomeDto
        if (diplome.getAgent() != null) {
            diplomeDto.setAgentId(diplome.getAgent().getId());
        }

        return diplomeDto;
    }
}

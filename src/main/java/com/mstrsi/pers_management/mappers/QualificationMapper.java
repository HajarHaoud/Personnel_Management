package com.mstrsi.pers_management.mappers;

import com.mstrsi.pers_management.dtos.QualificationDto;
import com.mstrsi.pers_management.entities.Qualification;


public class QualificationMapper {
    public static Qualification mapQualificationDtoToQualification(QualificationDto qualificationDto) {
        Qualification qualification = new Qualification(
                qualificationDto.getId(),
                qualificationDto.getQualificationName(),
                qualificationDto.getQualificationDescription(),
                qualificationDto.getQualificationDate(),
                qualificationDto.getQualificationType()
        );
        return qualification;

    }
    public static QualificationDto mapQualificationToQualificationDto(Qualification qualification) {
        QualificationDto qualificationDto = new QualificationDto(
                qualification.getId(),
                qualification.getQualificationName(),
                qualification.getQualificationDescription(),
                qualification.getQualificationDate(),
                qualification.getQualificationType()
        );
        if (qualification.getAgent() != null) {
            qualificationDto.setAgentId(qualification.getAgent().getId());
        }
        return qualificationDto;
    }
}

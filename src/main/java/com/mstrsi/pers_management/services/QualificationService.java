package com.mstrsi.pers_management.services;



import com.mstrsi.pers_management.dtos.QualificationDto;
import com.mstrsi.pers_management.entities.Qualification;


import java.util.List;

public interface QualificationService {
    QualificationDto createQualification(QualificationDto qualification);
    QualificationDto updateQualification(long id , QualificationDto qualificationDto);
    QualificationDto deleteQualification(long id);
    QualificationDto getQualificationById(long id);
    List<QualificationDto> getAllQualifications();
}

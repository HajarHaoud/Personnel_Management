package com.mstrsi.pers_management.services;
import com.mstrsi.pers_management.dtos.QualificationDto;
import com.mstrsi.pers_management.entities.Qualification;
import com.mstrsi.pers_management.mappers.QualificationMapper;
import com.mstrsi.pers_management.repositories.QualificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {
    private QualificationRepository qualificationRepository;
    public QualificationServiceImpl(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public QualificationDto createQualification(QualificationDto qualificationDto) {
        Qualification qualification = QualificationMapper.mapQualificationDtoToQualification(qualificationDto);
        Qualification savedQualification = qualificationRepository.save(qualification);
        return QualificationMapper.mapQualificationToQualificationDto(savedQualification);
    }

    @Override
    public QualificationDto updateQualification(long id, QualificationDto qualificationDto) {
        if (!qualificationRepository.existsById(id)) {
            throw new RuntimeException("Qualification not found with id: " + id);
        }
        Qualification qualification = QualificationMapper.mapQualificationDtoToQualification(qualificationDto);
        qualification.setId(id);
        Qualification savedQualification = qualificationRepository.save(qualification);
        return QualificationMapper.mapQualificationToQualificationDto(savedQualification);
    }

    @Override
    public QualificationDto deleteQualification(long id) {
        Qualification qualification = qualificationRepository.findById(id).orElse(null);
        qualificationRepository.delete(qualification);
        return QualificationMapper.mapQualificationToQualificationDto(qualification);

    }

    @Override
    public QualificationDto getQualificationById(long id) {
        Qualification qualification = qualificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Qualification non trouvé"));
        return QualificationMapper.mapQualificationToQualificationDto(qualification);
    }

    @Override
    public List<QualificationDto> getAllQualifications() {
        List<Qualification> qualificationList = qualificationRepository.findAll();
        return qualificationList.stream()
                .map((qualification -> QualificationMapper.mapQualificationToQualificationDto(qualification))).collect(Collectors.toList());
    }

}

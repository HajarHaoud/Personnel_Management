package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.AffectationDto;
import com.mstrsi.pers_management.entities.Affectation;
import com.mstrsi.pers_management.mappers.AffectationMapper;
import com.mstrsi.pers_management.repositories.AffectationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AffectationServiceImpl implements AffectationService {

private AffectationRepository affectationRepository;

    public AffectationServiceImpl(AffectationRepository affectationRepository) {
        this.affectationRepository = affectationRepository;
    }

    @Override
    public AffectationDto createAffectation(AffectationDto affectationDto) {
        Affectation affectation = AffectationMapper.mapAffectationDtoToAffection(affectationDto);
        Affectation savedAffectation = affectationRepository.save(affectation);
        return AffectationMapper.matAffectationToAffectationDto(savedAffectation);
    }

    @Override
    public AffectationDto updateAffectation(Long id, AffectationDto affectationDto) {
        if (!affectationRepository.existsById(id)) {
            throw new RuntimeException("Affectation not found with id: " + id);
        }
        Affectation affectation = AffectationMapper.mapAffectationDtoToAffection(affectationDto);
        affectation.setId(id);
        Affectation savedAffectation = affectationRepository.save(affectation);
        return AffectationMapper.matAffectationToAffectationDto(savedAffectation);
    }

    @Override
    public AffectationDto deleteAffectation(Long id) {
        Affectation affectation = affectationRepository.findById(id).orElse(null);
        affectationRepository.delete(affectation);
        return AffectationMapper.matAffectationToAffectationDto(affectation);
    }

    public  AffectationDto getAffectationById(Long id) {
        Affectation affectation = affectationRepository.findById(id).orElseThrow(() -> new RuntimeException("Affectation non trouvé"));
        return AffectationMapper.matAffectationToAffectationDto(affectation);
    }

    @Override
    public List<AffectationDto> getAllAffectations() {
        List<Affectation> affectationDtoList = affectationRepository.findAll();
        return affectationDtoList.stream().map((affectation -> AffectationMapper.matAffectationToAffectationDto(affectation))).collect(Collectors.toList());
    }
}

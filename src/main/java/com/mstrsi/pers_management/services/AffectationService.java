package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.AffectationDto;
import java.util.List;

public interface AffectationService {
    AffectationDto createAffectation(AffectationDto affectationDto);
    AffectationDto updateAffectation(Long id , AffectationDto affectationDto);
    AffectationDto deleteAffectation(Long id);
    AffectationDto getAffectationById(Long id);
    List<AffectationDto> getAllAffectations();
}

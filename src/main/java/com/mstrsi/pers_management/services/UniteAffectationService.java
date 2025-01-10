package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.AffectationDto;
import com.mstrsi.pers_management.dtos.PosteDto;
import com.mstrsi.pers_management.dtos.UniteAffectationDto;
import com.mstrsi.pers_management.entities.Affectation;
import com.mstrsi.pers_management.entities.Poste;

import java.util.List;

public interface UniteAffectationService {
    UniteAffectationDto createUniteAffectation(UniteAffectationDto uniteAffectationDto);
    UniteAffectationDto updateUniteAffectation(Long id , UniteAffectationDto uniteAffectationDto);
    UniteAffectationDto deleteUniteAffectation(Long id);
    UniteAffectationDto getUniteAffectationById(Long id);
    List<UniteAffectationDto> getAllUniteAffectations();

    //Gestion des Unites d'affectation avec les affectations
    UniteAffectationDto addAffectationToUniteAffectation(Long uniteAffectationId, Long affectationId);
    UniteAffectationDto removeAffectationFromUniteAffectation(Long uniteAffectationId, Long affectationId);
    UniteAffectationDto updateUniteAffectationAffectation(Long uniteAffectationId, Long affectationId, AffectationDto affectationDto);
    List<Affectation> getAffectationsByUniteAffectation(Long uniteAffectationId);

    // Gestion des postes

    UniteAffectationDto addPosteToUniteAffectation(Long uniteAffectationId, Long posteId);
    UniteAffectationDto removePosteFromUniteAffectation(Long uniteAffectationId, Long posteId);
    UniteAffectationDto updateUniteAffectationPoste(Long uniteAffectationId, Long posteId, PosteDto posteDto);
    List<Poste> getPostesByUniteAffectation(Long uniteAffectationId);



}

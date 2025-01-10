package com.mstrsi.pers_management.services;


import com.mstrsi.pers_management.dtos.*;
import com.mstrsi.pers_management.entities.*;
import com.mstrsi.pers_management.mappers.*;
import com.mstrsi.pers_management.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CongeServiceImpl implements CongeService {

    private CongeRepository congeRepository;
    public CongeServiceImpl(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    @Override
    public CongeDto createConge(CongeDto congeDto) {
        Conge conge = CongeMapper.mapCongeDtoToConge(congeDto);
        Conge savedConge = congeRepository.save(conge);
        return CongeMapper.mapCongeToCongeDto(savedConge);
    }

    @Override
    public CongeDto updateConge(long id, CongeDto congeDto) {
        if (!congeRepository.existsById(id)) {
            throw new RuntimeException("Conge not found with id: " + id);
        }
        Conge conge = CongeMapper.mapCongeDtoToConge(congeDto);
        conge.setId(id);
        Conge savedConge = congeRepository.save(conge);
        return CongeMapper.mapCongeToCongeDto(savedConge);
    }

    @Override
    public CongeDto deleteConge(long id) {
        Conge conge = congeRepository.findById(id).orElse(null);
        congeRepository.delete(conge);
        return CongeMapper.mapCongeToCongeDto(conge);
    }

    @Override
    public CongeDto getCongeById(long id) {
        Conge conge = congeRepository.findById(id).orElseThrow(() -> new RuntimeException("Conge non trouvé"));
        return CongeMapper.mapCongeToCongeDto(conge);
    }

    @Override
    public List<CongeDto> getAllConges() {
        List<Conge> congeList = congeRepository.findAll();
        return congeList.stream()
                .map((conge -> CongeMapper.mapCongeToCongeDto(conge))).collect(Collectors.toList());
    }
}

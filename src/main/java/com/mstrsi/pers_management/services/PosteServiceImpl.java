package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.PosteDto;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.mappers.PosteMapper;
import com.mstrsi.pers_management.repositories.PosteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteServiceImpl implements PosteService {
    private PosteRepository posteRepository;

    public PosteServiceImpl(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @Override
    public PosteDto createPoste(PosteDto posteDto) {
        Poste poste = PosteMapper.mapPosteDtoToPoste(posteDto);
        Poste savePoste = posteRepository.save(poste);
        return PosteMapper.mapPosteToPosteDto(savePoste);
    }

    @Override
    public PosteDto updatePoste(long id, PosteDto posteDto) {
        if (!posteRepository.existsById(id)) {
            throw new RuntimeException("Poste not found with id: " + id);
        }
        Poste poste = PosteMapper.mapPosteDtoToPoste(posteDto);
        poste.setId(id);
        Poste savedPoste = posteRepository.save(poste);
        return PosteMapper.mapPosteToPosteDto(savedPoste);
    }

    @Override
    public PosteDto deletePoste(long id) {
        Poste poste = posteRepository.findById(id).orElse(null);
        posteRepository.delete(poste);
        return PosteMapper.mapPosteToPosteDto(poste);
    }

    @Override
    public PosteDto getPosteById(long id) {
        Poste poste = posteRepository.findById(id).orElseThrow(() -> new RuntimeException("Poste non trouvé"));
        return PosteMapper.mapPosteToPosteDto(poste);
    }

    @Override
    public List<PosteDto> getAllPostes() {
        List<Poste> posteList = posteRepository.findAll();
        return posteList.stream().map((poste -> PosteMapper.mapPosteToPosteDto(poste))).collect(Collectors.toList());
    }
}

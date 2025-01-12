package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.PosteDto;
import com.mstrsi.pers_management.entities.Poste;
import com.mstrsi.pers_management.mappers.PosteMapper;
import com.mstrsi.pers_management.repositories.PosteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DCPServiceImpl implements DCPService {

    private final PosteRepository posteRepository;

    public DCPServiceImpl(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @Override
    public boolean verifierExistencePoste(Long posteId) {
        return posteRepository.findById(posteId)
                .map(Poste::isActive)
                .orElse(false);
    }

    @Override
    public PosteDto getPosteDetails(Long posteId) {
        return posteRepository.findById(posteId)
                .map(PosteMapper::mapPosteToPosteDto)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé"));
    }
}

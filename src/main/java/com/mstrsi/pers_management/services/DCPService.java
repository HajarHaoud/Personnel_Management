package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.PosteDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface DCPService {
    boolean verifierExistencePoste(Long posteId);
    PosteDto getPosteDetails(Long posteId);
}

package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Role;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface IdentificationService {
    String genererMatricule(Role role);
    String genererMotDePasse();
}

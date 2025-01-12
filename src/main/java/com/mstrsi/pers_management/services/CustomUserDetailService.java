package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.dtos.AgentDto;
import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.mappers.AgentMapper;
import com.mstrsi.pers_management.repositories.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;


    public CustomUserDetailService(AgentRepository agentRepository, AgentMapper agentMapper) {
        this.agentRepository = agentRepository;
        this.agentMapper = agentMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
        // Récupérer l'entité Agent
        Agent agent = agentRepository.findByMatricule(matricule)
                .orElseThrow(() -> new UsernameNotFoundException("Agent non trouvé"));

        // Construire et retourner UserDetails
        return User.builder()
                .username(agent.getMatricule())  // Utiliser l'entité Agent, pas le DTO
                .password(agent.getPassword())
                .roles(agent.getRole().name())   // Ajouter les rôles si nécessaire
                .build();
    }
}

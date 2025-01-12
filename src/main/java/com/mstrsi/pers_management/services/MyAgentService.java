package com.mstrsi.pers_management.services;
import java.util.Optional;

import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyAgentService implements UserDetailsService{

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return agentRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Agent not found with username: " + username));
    }



}
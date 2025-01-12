package com.mstrsi.pers_management.controllers;

import com.mstrsi.pers_management.repositories.MyAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

    @Autowired
    private MyAgentRepository myAgentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@PostMapping(value = "/req/signup", consumes = "application/json")
    public MyAgent createUser(@RequestBody MyAgent user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myAgentRepository.save(user);
    }*/

}
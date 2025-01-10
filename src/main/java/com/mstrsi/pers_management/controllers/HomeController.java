package com.mstrsi.pers_management.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {


    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String admin() {
        return "Personnel Management";
    }

    @GetMapping("/agent")
    @PreAuthorize("hasRole('user')")
    public String agent() {
        return "Hello Agent";
    }


}

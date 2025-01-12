package com.mstrsi.pers_management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/req/login")
    public String login(){
        return "login";
    }


    @GetMapping("/index")
    public String home(){
        return "index";
    }

}

package com.galaxy.moon.pp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @RequestMapping("/pp/health")
    public String health(){
        System.out.println("get health");
        return "health";
    }
}

package com.wereis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String helloWorld() {
        return "Welcome to WereIs first deployment. Congrats :)";
    }
}

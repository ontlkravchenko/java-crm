package com.whereis.controllers;

import com.whereis.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping
    public String showForm() {
        return "register";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute User user) {
        System.out.println(user);
        return "register";
    }
}

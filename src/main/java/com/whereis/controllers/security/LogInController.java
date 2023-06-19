package com.whereis.controllers.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("login")
    public String showLoginForm(Model model) {
        return "security/login";
    }
}

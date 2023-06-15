package com.whereis.controllers.security;

import com.whereis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @Autowired
    UserService userService;

    @GetMapping("login")
    public String showLoginForm(Model model) {
        return "security/login";
    }
}

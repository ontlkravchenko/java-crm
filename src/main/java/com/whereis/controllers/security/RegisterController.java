package com.whereis.controllers.security;

import com.whereis.entities.User;
import com.whereis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "security/register";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute User user) {

        userService.saveUser(user);
        return "security/register";
    }
}

package com.whereis.controllers.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

    @GetMapping("logout")
    public String showLogOutForm() {
        return "logout";
    }
}

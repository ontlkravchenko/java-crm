package com.whereis.controllers;

import com.whereis.entities.User;
import com.whereis.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SecurityControllerTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        User u = userService.findByUsername("Test");
        if (u == null) return;

        userService.deleteUser(u);
    }

    @Test
    void registrationTest() {
        User u = new User();
        u.setUsername("Test");
        u.setPassword("Test");

        User savedUser = userService.saveUser(u);
        Assert.isTrue(savedUser != null, "Unable to register user.");
    }
}
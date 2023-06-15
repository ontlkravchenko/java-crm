package com.whereis.services;

import com.whereis.entities.User;
import com.whereis.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /*
    Since it is considered better practice to store encoded passwords
    this service is created to encode user's password for us
    so that we could just use the saveUser method
    instead of inserting userRepo and passwordEncoder into controller
     */

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        String pass = user.getPassword();
        String encodedPass = passwordEncoder.encode(pass);
        user.setPassword(encodedPass);

        return userRepo.save(user);
    }
}

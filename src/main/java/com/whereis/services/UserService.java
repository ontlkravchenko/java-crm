package com.whereis.services;

import com.whereis.entities.User;
import com.whereis.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User getAuthorizedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            // Handle anonymous authentication case
            return null;
        }

        // Get username from User Details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        // Find user by username in DB
        Optional<User> userOptional = userRepo.findByUsername(username);

        if (userOptional.isEmpty()) return null;

        User user = userOptional.get();

        return user;
    }
}

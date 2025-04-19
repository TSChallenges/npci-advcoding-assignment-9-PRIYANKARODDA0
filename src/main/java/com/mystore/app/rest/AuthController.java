package com.mystore.app.rest;

import com.mystore.app.config.JwtUtil;
import com.mystore.app.entity.MynameUsers;
import com.mystore.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody MynameUsers user) {
        MynameUsers authenticatedUser = userRepository.findByUsername(user.getUsername());
        if (authenticatedUser != null && user.getPassword().equals(authenticatedUser.getPassword())) {
            return jwtUtil.generateToken(authenticatedUser.getUsername());
        }
        return "Invalid credentials";
    }
}

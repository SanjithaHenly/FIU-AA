package com.sahmatinet.sahamati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.JwtUtil;

@RestController
@RequestMapping("/iam/v1/user")
public class UserTokenController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserTokenController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/token/generate")
    public ResponseEntity<String> generateToken(@RequestParam String username, @RequestParam String password) {
        // Authenticate the user
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        
        // Generate a JWT token
        String token = jwtUtil.generateToken(username);
        
        return ResponseEntity.ok(token);
    }
}
package com.sahmatinet.sahamati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.JwtUtil;

@RestController
@RequestMapping("/iam/v1/entity/token")
public class MemberTokenController {

    @Autowired
    private JwtUtil jwtUtil;

    // Inject member credentials from application.properties
    @Value("${member.id}")
    private String configuredMemberId;

    @Value("${member.secret}")
    private String configuredMemberSecret;

    @PostMapping("/generate")
    public ResponseEntity<String> generateMemberToken(@RequestParam String id, @RequestParam String secret) {
        // Validate against configured values
        if (id.equals(configuredMemberId) && secret.equals(configuredMemberSecret)) {
            String token = jwtUtil.generateToken(id);
            return ResponseEntity.ok(token);
        }
        // Return unauthorized response if validation fails
        return ResponseEntity.status(401).body("Invalid Member ID or Secret");
    }
}

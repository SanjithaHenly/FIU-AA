package com.sahmatinet.sahamati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.JwtUtil;
import com.sahmatinet.sahamati.model.SecretRequest;
import com.sahmatinet.sahamati.model.SecretResponse;

@RestController
@RequestMapping("/iam/v1/entity")
public class SecretController {
	
	@Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/secret/read")
    public ResponseEntity<SecretResponse> readMemberSecret(@RequestHeader("Authorization") String token, @RequestBody SecretRequest request) {
        // Remove "Bearer " prefix from token
        token = token.replace("Bearer ", "");

        // Validate JWT token
        if (!jwtUtil.validateTokens(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // If token is valid, return mock secret response
        SecretResponse response = new SecretResponse(
            "1.0.0",
            java.time.ZonedDateTime.now().toString(),
            request.getTxnId(),
            request.getEntityId(),
            "g7IyHcaB6H55FRKMd3IHT8sgNpXacxHx",
            "2024-12-24 12:22"
        );

        return ResponseEntity.ok(response);
    }
}

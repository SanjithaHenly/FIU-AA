package com.sahmatinet.sahamati.controller;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.model.SecretRequest;
import com.sahmatinet.sahamati.model.SecretResponse;
import com.sahmatinet.sahamati.util.JwtUtil;

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
        String secret = generateRandomSecret();
        // If token is valid, return mock secret response
        SecretResponse response = new SecretResponse(
            "1.0.0",
            java.time.ZonedDateTime.now().toString(),
            request.getTxnId(),
            request.getEntityId(),
            secret,
            getCurrentTimestamp()
        );

        return ResponseEntity.ok(response);
    }
    private String generateRandomSecret() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] bytes = new byte[32]; // 32 bytes => 256-bit secret
		secureRandom.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes); // URL-safe base64 encoding
	}
    private String getCurrentTimestamp() {
		return java.time.Instant.now().toString();
	}

}

package com.sahmatinet.sahamati.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.model.SecretRequest;
import com.sahmatinet.sahamati.model.SecretResponse;
import com.sahmatinet.sahamati.service.SecretService;

@RestController
@RequestMapping("/iam/v1/entity/secret")
public class SecretController {

    @Autowired
    private SecretService secretService;

    @PostMapping("/read")
    public ResponseEntity<Map<String, Object>> readSecret(@RequestBody SecretRequest request) {
        try {
            // Validate the input
            secretService.validateRequest(request);

            // Fetch the secret
            SecretResponse secretResponse = secretService.readSecret(request);

            return ResponseEntity.ok(secretResponse.toMap());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<Map<String, Object>> resetSecret(@RequestBody SecretRequest request) {
        try {
            // Validate the input
            secretService.validateRequest(request);

            // Reset the secret
            SecretResponse secretResponse = secretService.resetSecret(request);

            return ResponseEntity.ok(secretResponse.toMap());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }
}

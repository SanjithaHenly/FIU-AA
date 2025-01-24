package com.sahmatinet.sahamati.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sahmatinet.sahamati.model.SecretInfo;
import com.sahmatinet.sahamati.model.SecretRequest;
import com.sahmatinet.sahamati.model.SecretResponse;

@Service
public class SecretService {

    private static final long SECRET_EXPIRATION_MILLIS = 24 * 60 * 60 * 1000; // 24 hours
    private final Map<String, SecretInfo> secretStorage = new HashMap<>();

    public SecretResponse readSecret(SecretRequest request) {
        SecretInfo secretInfo = secretStorage.get(request.getEntityId());
        if (secretInfo == null) {
            throw new RuntimeException("Secret not found for entity ID: " + request.getEntityId());
        }

        return new SecretResponse(request.getVer(), request.getTimestamp(), request.getTxnId(),
                request.getEntityId(), secretInfo.getSecret(), secretInfo.getExpiresOn());
    }

    public SecretResponse resetSecret(SecretRequest request) {
        // Generate a new secret
        String newSecret = generateSecretKey();
        long expiresOn = System.currentTimeMillis() + SECRET_EXPIRATION_MILLIS;

        // Store the new secret
        SecretInfo secretInfo = new SecretInfo(newSecret, expiresOn);
        secretStorage.put(request.getEntityId(), secretInfo);

        return new SecretResponse(request.getVer(), request.getTimestamp(), request.getTxnId(),
                request.getEntityId(), newSecret, expiresOn);
    }

    public void validateRequest(SecretRequest request) {
        if (request.getEntityId() == null || request.getEntityId().isEmpty()) {
            throw new IllegalArgumentException("Entity ID cannot be null or empty");
        }
        if (request.getTxnId() == null || request.getTxnId().isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or empty");
        }
    }

    private String generateSecretKey() {
        byte[] key = new byte[32]; // 256 bits
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}

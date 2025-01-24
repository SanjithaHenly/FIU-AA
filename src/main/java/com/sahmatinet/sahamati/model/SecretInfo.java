package com.sahmatinet.sahamati.model;
public class SecretInfo {
    private String secret;
    private long expiresOn;

    public SecretInfo(String secret, long expiresOn) {
        this.secret = secret;
        this.expiresOn = expiresOn;
    }

    public String getSecret() { return secret; }
    public long getExpiresOn() { return expiresOn; }
}

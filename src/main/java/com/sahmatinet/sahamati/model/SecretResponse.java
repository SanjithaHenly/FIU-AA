package com.sahmatinet.sahamati.model;

public class SecretResponse {
    private String ver;
    private String timestamp;
    private String txnId;
    private String entityId;
    private String secret;
    private String expiresOn;

    public SecretResponse(String ver, String timestamp, String txnId, String entityId, String secret, String expiresOn) {
        this.ver = ver;
        this.timestamp = timestamp;
        this.txnId = txnId;
        this.entityId = entityId;
        this.secret = secret;
        this.expiresOn = expiresOn;
    }

    // Getters and Setters

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }
}

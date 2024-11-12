package com.sahmatinet.sahamati.model;

public class MemberTokenRequest {
    private String id;
    private String secret;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

	@Override
	public String toString() {
		return "MemberTokenRequest [id=" + id + ", secret=" + secret + "]";
	}
    
}

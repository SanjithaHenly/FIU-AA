package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityTokenRequest {
	@JsonProperty("id")
    private String id;
	@JsonProperty("secret")
    private String secret;
	
	public EntityTokenRequest(String entityId, String entitySecret) {
		
	}
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty("secret")
	public String getSecret() {
		return secret;
	}
	@JsonProperty("secret")
	public void setSecret(String secret) {
		this.secret = secret;
	}

    // Getters and Setters
}
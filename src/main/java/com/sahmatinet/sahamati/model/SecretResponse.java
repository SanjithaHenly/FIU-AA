package com.sahmatinet.sahamati.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecretResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7304937352510161043L;
	@JsonProperty("ver")
	private String ver;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("txnId")
	private String txnId;
	@JsonProperty("entityId")
	private String entityId;
	@JsonProperty("secret")
	private String secret;
	@JsonProperty("expiresOn")
	private String expiresOn;

	public SecretResponse(String ver, String timestamp, String txnId, String entityId, String secret,
			String expiresOn) {
		this.ver = ver;
		this.timestamp = timestamp;
		this.txnId = txnId;
		this.entityId = entityId;
		this.secret = secret;
		this.expiresOn = expiresOn;
	}

	// Getters and Setters
	@JsonProperty("ver")
	public String getVer() {
		return ver;
	}

	@JsonProperty("ver")
	public void setVer(String ver) {
		this.ver = ver;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("txnId")
	public String getTxnId() {
		return txnId;
	}

	@JsonProperty("txnId")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@JsonProperty("entityId")
	public String getEntityId() {
		return entityId;
	}

	@JsonProperty("entityId")
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@JsonProperty("secret")
	public String getSecret() {
		return secret;
	}

	@JsonProperty("secret")
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@JsonProperty("expiresOn")
	public String getExpiresOn() {
		return expiresOn;
	}

	@JsonProperty("expiresOn")
	public void setExpiresOn(String expiresOn) {
		this.expiresOn = expiresOn;
	}
}

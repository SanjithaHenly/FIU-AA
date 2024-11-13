package com.sahmatinet.sahamati.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DHPublicKey {

	@JsonProperty("expiry")
	private Instant expiry;

	@JsonProperty("Parameters")
	private String parameters;

	@JsonProperty("KeyValue")
	private String keyValue;

	@JsonProperty("expiry")
	public Instant getExpiry() {
		return expiry;
	}

	@JsonProperty("expiry")
	public void setExpiry(Instant expiry) {
		this.expiry = expiry;
	}

	@JsonProperty("Parameters")
	public String getParameters() {
		return parameters;
	}

	@JsonProperty("Parameters")
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	@JsonProperty("KeyValue")
	public String getKeyValue() {
		return keyValue;
	}

	@JsonProperty("KeyValue")
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
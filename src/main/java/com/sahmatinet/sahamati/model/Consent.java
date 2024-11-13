package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Consent {

	@JsonProperty("id")
	private String id;

	@JsonProperty("digitalSignature")
	private String digitalSignature;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("digitalSignature")
	public String getDigitalSignature() {
		return digitalSignature;
	}

	@JsonProperty("digitalSignature")
	public void setDigitalSignature(String digitalSignature) {
		this.digitalSignature = digitalSignature;
	}

}
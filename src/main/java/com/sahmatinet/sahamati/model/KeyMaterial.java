package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KeyMaterial {

	@JsonProperty("cryptoAlg")
	private String cryptoAlgorithm;

	@JsonProperty("curve")
	private String curve;

	@JsonProperty("params")
	private String parameters;

	@JsonProperty("DHPublicKey")
	private DHPublicKey dhPublicKey;

	@JsonProperty("Nonce")
	private String nonce;

	@JsonProperty("cryptoAlg")
	public String getCryptoAlgorithm() {
		return cryptoAlgorithm;
	}

	@JsonProperty("cryptoAlg")
	public void setCryptoAlgorithm(String cryptoAlgorithm) {
		this.cryptoAlgorithm = cryptoAlgorithm;
	}

	@JsonProperty("curve")
	public String getCurve() {
		return curve;
	}

	@JsonProperty("curve")
	public void setCurve(String curve) {
		this.curve = curve;
	}

	@JsonProperty("params")
	public String getParameters() {
		return parameters;
	}

	@JsonProperty("params")
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	@JsonProperty("DHPublicKey")
	public DHPublicKey getDhPublicKey() {
		return dhPublicKey;
	}

	@JsonProperty("DHPublicKey")
	public void setDhPublicKey(DHPublicKey dhPublicKey) {
		this.dhPublicKey = dhPublicKey;
	}

	@JsonProperty("Nonce")
	public String getNonce() {
		return nonce;
	}

	@JsonProperty("Nonce")
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

}
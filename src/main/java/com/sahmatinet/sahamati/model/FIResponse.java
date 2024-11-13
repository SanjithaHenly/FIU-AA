package com.sahmatinet.sahamati.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FIResponse {

	@JsonProperty("ver")
	private String version;

	@JsonProperty("timestamp")
	private Instant timestamp;

	@JsonProperty("txnid")
	private UUID transactionId;

	@JsonProperty("consentId")
	private String consentId;

	@JsonProperty("sessionId")
	private UUID sessionId;

	@JsonProperty("FI")
	private List<FIData> fiData;

	@JsonProperty("FI")
	public List<FIData> getFiData() {
		return fiData;
	}

	@JsonProperty("FI")
	public void setFiData(List<FIData> fiData) {
		this.fiData = fiData;
	}

	@JsonProperty("ver")
	public String getVersion() {
		return version;
	}

	@JsonProperty("ver")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("timestamp")
	public Instant getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("txnid")
	public UUID getTransactionId() {
		return transactionId;
	}

	@JsonProperty("txnid")
	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	@JsonProperty("consentId")
	public String getConsentId() {
		return consentId;
	}

	@JsonProperty("consentId")
	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}

	@JsonProperty("sessionId")
	public UUID getSessionId() {
		return sessionId;
	}

	@JsonProperty("sessionId")
	public void setSessionId(UUID sessionId) {
		this.sessionId = sessionId;
	}

}
package com.sahmatinet.sahamati.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FIRequest {

	@JsonProperty("ver")
	private String version;

	@JsonProperty("timestamp")
	private Instant timestamp;

	@JsonProperty("txnid")
	private UUID transactionId;

	@JsonProperty("Consent")
	private Consent consent;

	@JsonProperty("FIDataRange")
	private FIDataRange fiDataRange;

	@JsonProperty("KeyMaterial")
	private KeyMaterial keyMaterial;

	@JsonProperty("fipId")
	private String fipId;

	@JsonProperty("linkRefNumber")
	private List<LinkRefNumber> linkRefNumber;

	@JsonProperty("fipId")
	public String getFipId() {
		return fipId;
	}

	@JsonProperty("fipId")
	public void setFipId(String fipId) {
		this.fipId = fipId;
	}

	@JsonProperty("linkRefNumber")
	public List<LinkRefNumber> getLinkRefNumber() {
		return linkRefNumber;
	}

	@JsonProperty("linkRefNumber")
	public void setLinkRefNumber(List<LinkRefNumber> linkRefNumber) {
		this.linkRefNumber = linkRefNumber;
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

	@JsonProperty("Consent")
	public Consent getConsent() {
		return consent;
	}

	@JsonProperty("Consent")
	public void setConsent(Consent consent) {
		this.consent = consent;
	}

	@JsonProperty("FIDataRange")
	public FIDataRange getFiDataRange() {
		return fiDataRange;
	}

	@JsonProperty("FIDataRange")
	public void setFiDataRange(FIDataRange fiDataRange) {
		this.fiDataRange = fiDataRange;
	}

	@JsonProperty("KeyMaterial")
	public KeyMaterial getKeyMaterial() {
		return keyMaterial;
	}

	@JsonProperty("KeyMaterial")
	public void setKeyMaterial(KeyMaterial keyMaterial) {
		this.keyMaterial = keyMaterial;
	}

}
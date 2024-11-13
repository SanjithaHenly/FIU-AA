package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DataItem {

	@JsonProperty("linkRefNumber")
	private String linkRefNumber;

	@JsonProperty("maskedAccNumber")
	private String maskedAccountNumber;

	@JsonProperty("encryptedFI")
	private String encryptedFI;

	@JsonProperty("linkRefNumber")
	public String getLinkRefNumber() {
		return linkRefNumber;
	}

	@JsonProperty("linkRefNumber")
	public void setLinkRefNumber(String linkRefNumber) {
		this.linkRefNumber = linkRefNumber;
	}

	@JsonProperty("maskedAccNumber")
	public String getMaskedAccountNumber() {
		return maskedAccountNumber;
	}

	@JsonProperty("maskedAccNumber")
	public void setMaskedAccountNumber(String maskedAccountNumber) {
		this.maskedAccountNumber = maskedAccountNumber;
	}

	@JsonProperty("encryptedFI")
	public String getEncryptedFI() {
		return encryptedFI;
	}

	@JsonProperty("encryptedFI")
	public void setEncryptedFI(String encryptedFI) {
		this.encryptedFI = encryptedFI;
	}

}

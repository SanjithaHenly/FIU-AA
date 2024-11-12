package com.sahmatinet.sahamati.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class ConsentRequest {
	
	@JsonProperty("ver")
	private String ver;
	
	@JsonProperty("timestamp")
	private OffsetDateTime timestamp;
	
	@JsonProperty("txnid")
	private UUID txnid;
	
	@JsonProperty("ConsentDetail")
	private ConsentDetail consentDetail;

	@JsonProperty("ver")
	public String getVer() {
		return ver;
	}

	@JsonProperty("ver")
	public void setVer(String value) {
		this.ver = value;
	}

	@JsonProperty("timestamp")
	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(OffsetDateTime value) {
		this.timestamp = value;
	}

	@JsonProperty("txnid")
	public UUID getTxnid() {
		return txnid;
	}

	@JsonProperty("txnid")
	public void setTxnid(UUID value) {
		this.txnid = value;
	}

	@JsonProperty("ConsentDetail")
	public ConsentDetail getConsentDetail() {
		return consentDetail;
	}

	@JsonProperty("ConsentDetail")
	public void setConsentDetail(ConsentDetail value) {
		this.consentDetail = value;
	}

	@Override
	public String toString() {
		return "ConsentRequest [ver=" + ver + ", timestamp=" + timestamp + ", txnid=" + txnid + ", consentDetail="
				+ consentDetail + "]";
	}
	
	
}
package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsentHandleRequest {

	@JsonProperty("ver")
	private String ver;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("txnid")
	private String txnid;

	@JsonProperty("ConsentHandle")
	private String consentHandle;

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

	@JsonProperty("txnid")
	public String getTxnid() {
		return txnid;
	}

	@JsonProperty("txnid")
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	@JsonProperty("ConsentHandle")
	public String getConsentHandle() {
		return consentHandle;
	}

	@JsonProperty("ConsentHandle")
	public void setConsentHandle(String consentHandle) {
		this.consentHandle = consentHandle;
	}

	@Override
	public String toString() {
		return "ConsentHandleRequest [ver=" + ver + ", timestamp=" + timestamp + ", txnid=" + txnid + ", consentHandle="
				+ consentHandle + "]";
	}

}

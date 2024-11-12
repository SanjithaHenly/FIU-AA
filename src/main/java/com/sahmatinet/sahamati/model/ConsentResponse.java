package com.sahmatinet.sahamati.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class ConsentResponse {

	@JsonProperty("ver")
	private String ver;
	
	@JsonProperty("timestamp")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private String timestamp;

	@JsonProperty("txnid")
	private UUID txnid;

	@JsonProperty("Customer")
	private CustomerResp Customer;
	
	@JsonProperty("ConsentHandle")
	private String ConsentHandle;



	public ConsentResponse() {
		// TODO Auto-generated constructor stub
	}

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
	public UUID getTxnid() {
		return txnid;
	}

	@JsonProperty("txnid")
	public void setTxnid(UUID uuid) {
		this.txnid = uuid;
	}

	@JsonProperty("Customer")
	public CustomerResp getCustomer() {
		return Customer;
	}

	@JsonProperty("Customer")
	public void setCustomer(CustomerResp customer) {
		Customer = customer;
	}

	@JsonProperty("ConsentHandle")
	public String getConsentHandle() {
		return ConsentHandle;
	}

	@JsonProperty("ConsentHandle")
	public void setConsentHandle(String consentHandle) {
		ConsentHandle = consentHandle;
	}

	@Override
	public String toString() {
		return "ConsentResponse [ver=" + ver + ", timestamp=" + timestamp + ", txnid=" + txnid + ", Customer="
				+ Customer + ", ConsentHandle=" + ConsentHandle + "]";
	}

	
}

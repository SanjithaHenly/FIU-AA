package com.sahmatinet.sahamati.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {
	@JsonProperty("ver")
	private String ver;
	@JsonProperty("timestamp")
	private OffsetDateTime timestamp;
	@JsonProperty("txnId")
	private String txnID;
	@JsonProperty("accessToken")
	private String accessToken;
	@JsonProperty("expiresIn")
	private long expiresIn;
	@JsonProperty("refreshExpiresIn")
	private long refreshExpiresIn;
	@JsonProperty("tokenType")
	private String tokenType;
	@JsonProperty("notBeforePolicy")
	private long notBeforePolicy;
	@JsonProperty("scope")
	private String scope;

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

	@JsonProperty("txnId")
	public String getTxnID() {
		return txnID;
	}

	@JsonProperty("txnId")
	public void setTxnID(String value) {
		this.txnID = value;
	}

	@JsonProperty("accessToken")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("accessToken")
	public void setAccessToken(String value) {
		this.accessToken = value;
	}

	@JsonProperty("expiresIn")
	public long getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expiresIn")
	public void setExpiresIn(long value) {
		this.expiresIn = value;
	}

	@JsonProperty("refreshExpiresIn")
	public long getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	@JsonProperty("refreshExpiresIn")
	public void setRefreshExpiresIn(long value) {
		this.refreshExpiresIn = value;
	}

	@JsonProperty("tokenType")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("tokenType")
	public void setTokenType(String value) {
		this.tokenType = value;
	}

	@JsonProperty("notBeforePolicy")
	public long getNotBeforePolicy() {
		return notBeforePolicy;
	}

	@JsonProperty("notBeforePolicy")
	public void setNotBeforePolicy(long value) {
		this.notBeforePolicy = value;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String value) {
		this.scope = value;
	}
}
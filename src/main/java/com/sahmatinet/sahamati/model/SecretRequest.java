package com.sahmatinet.sahamati.model;

public class SecretRequest {

	private String ver;
	private String timestamp;
	private String txnId;
	private String entityId;

	// Getters and Setters
	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
}
//    private String entityId;
//    private String txnId;
//
//    // Getters and Setters
//    public String getEntityId() {
//        return entityId;
//    }
//
//    public void setEntityId(String entityId) {
//        this.entityId = entityId;
//    }
//
//    public String getTxnId() {
//        return txnId;
//    }
//
//    public void setTxnId(String txnId) {
//        this.txnId = txnId;
//    }

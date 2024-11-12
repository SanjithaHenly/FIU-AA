package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsentStatus {

	@JsonProperty("id")
	private String id;

	@JsonProperty("status")
	private String status;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ConsentStatus [id=" + id + ", status=" + status + "]";
	}

}

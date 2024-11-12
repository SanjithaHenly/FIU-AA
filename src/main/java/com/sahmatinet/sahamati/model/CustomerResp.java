package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class CustomerResp {
	@JsonProperty("id")
	private String id;

	@JsonProperty("id")
	public String getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(String value) {
		this.id = value;
	}

}

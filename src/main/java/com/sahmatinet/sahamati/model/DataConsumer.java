package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class DataConsumer {
	@JsonProperty("id")
	private String id;
	
	
	@JsonProperty("type")
	private String type;

	@JsonProperty("id")
	public String getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(String value) {
		this.id = value;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String value) {
		this.type = value;
	}

	@Override
	public String toString() {
		return "DataConsumer [id=" + id + ", type=" + type + "]";
	}
	
	
}
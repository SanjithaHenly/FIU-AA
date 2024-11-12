package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Category {
	
	@JsonProperty("type")
	private String type;

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
		return "Category [type=" + type + "]";
	}
	
}

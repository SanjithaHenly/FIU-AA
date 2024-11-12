package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class DataLife {
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("value")
	private String value;

	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	@JsonProperty("unit")
	public void setUnit(String value) {
		this.unit = value;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DataLife [unit=" + unit + ", value=" + value + "]";
	}
	
}
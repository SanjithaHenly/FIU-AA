package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Frequency {
	@JsonProperty("unit")
	private String unit;

	@JsonProperty("value")
	private int value;

	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	@JsonProperty("unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonProperty("value")
	public int getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Frequency [unit=" + unit + ", value=" + value + "]";
	}

}

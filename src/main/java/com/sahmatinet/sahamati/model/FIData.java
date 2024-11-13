package com.sahmatinet.sahamati.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FIData {

	@JsonProperty("fipID")
	private String fipId;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("KeyMaterial")
	private KeyMaterial keyMaterial;

	@JsonProperty("fipID")
	public String getFipId() {
		return fipId;
	}

	@JsonProperty("fipID")
	public void setFipId(String fipId) {
		this.fipId = fipId;
	}

	@JsonProperty("data")
	public List<DataItem> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<DataItem> data) {
		this.data = data;
	}

	@JsonProperty("KeyMaterial")
	public KeyMaterial getKeyMaterial() {
		return keyMaterial;
	}

	@JsonProperty("KeyMaterial")
	public void setKeyMaterial(KeyMaterial keyMaterial) {
		this.keyMaterial = keyMaterial;
	}

}

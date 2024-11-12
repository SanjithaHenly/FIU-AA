package com.sahmatinet.sahamati.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Customer {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("Identifiers")
	private Identifier[] identifiers;

	@JsonProperty("id")
	public String getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(String value) {
		this.id = value;
	}

	@JsonProperty("Identifiers")
	public Identifier[] getIdentifiers() {
		return identifiers;
	}

	@JsonProperty("Identifiers")
	public void setIdentifiers(Identifier[] value) {
		this.identifiers = value;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", identifiers=" + Arrays.toString(identifiers) + "]";
	}
	
	
}
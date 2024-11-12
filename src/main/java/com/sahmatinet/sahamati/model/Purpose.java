package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Purpose {
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("refUri")
	private String refURI;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("Category")
	private Category category;

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String value) {
		this.code = value;
	}

	@JsonProperty("refUri")
	public String getRefURI() {
		return refURI;
	}

	@JsonProperty("refUri")
	public void setRefURI(String value) {
		this.refURI = value;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String value) {
		this.text = value;
	}

	@JsonProperty("Category")
	public Category getCategory() {
		return category;
	}

	@JsonProperty("Category")
	public void setCategory(Category value) {
		this.category = value;
	}

	@Override
	public String toString() {
		return "Purpose [code=" + code + ", refURI=" + refURI + ", text=" + text + ", category=" + category + "]";
	}
	
}

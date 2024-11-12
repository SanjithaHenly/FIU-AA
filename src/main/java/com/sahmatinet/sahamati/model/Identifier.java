package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Identifier {
	@JsonProperty("type")
    private String type;
	
	@JsonProperty("value")
    private String value;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
	@Override
	public String toString() {
		return "Identifier [type=" + type + ", value=" + value + "]";
	}
    
    
}

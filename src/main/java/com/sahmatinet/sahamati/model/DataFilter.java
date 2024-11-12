package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class DataFilter {
	@JsonProperty("type")
    private String type;
	
	@JsonProperty("operator")
    private String operator;
	
	@JsonProperty("value")
    private String value;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("operator")
    public String getOperator() { return operator; }
    @JsonProperty("operator")
    public void setOperator(String value) { this.operator = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
	@Override
	public String toString() {
		return "DataFilter [type=" + type + ", operator=" + operator + ", value=" + value + "]";
	}
    
    
}
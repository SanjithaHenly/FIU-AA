package com.sahmatinet.sahamati.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.time.OffsetDateTime;
@Data
public class FIDataRange {
	@JsonProperty("from")
    private OffsetDateTime from;
	
	@JsonProperty("to")
    private OffsetDateTime to;

    @JsonProperty("from")
    public OffsetDateTime getFrom() { return from; }
    @JsonProperty("from")
    public void setFrom(OffsetDateTime value) { this.from = value; }

    @JsonProperty("to")
    public OffsetDateTime getTo() { return to; }
    @JsonProperty("to")
    public void setTo(OffsetDateTime value) { this.to = value; }
	@Override
	public String toString() {
		return "FIDataRange [from=" + from + ", to=" + to + "]";
	}
    
    
    
}
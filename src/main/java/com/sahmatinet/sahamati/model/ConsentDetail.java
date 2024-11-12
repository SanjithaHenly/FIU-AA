package com.sahmatinet.sahamati.model;

import java.time.OffsetDateTime;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class ConsentDetail {
	@JsonProperty("consentStart")
	private OffsetDateTime consentStart;
	
	@JsonProperty("consentExpiry")
	private OffsetDateTime consentExpiry;
	
	@JsonProperty("consentMode")
	private String consentMode;
	
	@JsonProperty("fetchType")
	private String fetchType;
	
	@JsonProperty("consentTypes")
	private String[] consentTypes;
	
	@JsonProperty("fiTypes")
	private String[] fiTypes;
	
	@JsonProperty("DataConsumer")
	private DataConsumer dataConsumer;
	
	@JsonProperty("Customer")
	private Customer customer;
	
	@JsonProperty("Purpose")
	private Purpose purpose;
	
	@JsonProperty("FIDataRange")
	private FIDataRange fiDataRange;
	
	@JsonProperty("DataLife")
	private DataLife dataLife;
	
	@JsonProperty("Frequency")
	private DataLife frequency;
	
	@JsonProperty("DataFilter")
	private DataFilter[] dataFilter;

	@JsonProperty("consentStart")
	public OffsetDateTime getConsentStart() {
		return consentStart;
	}

	@JsonProperty("consentStart")
	public void setConsentStart(OffsetDateTime value) {
		this.consentStart = value;
	}

	@JsonProperty("consentExpiry")
	public OffsetDateTime getConsentExpiry() {
		return consentExpiry;
	}

	@JsonProperty("consentExpiry")
	public void setConsentExpiry(OffsetDateTime value) {
		this.consentExpiry = value;
	}

	@JsonProperty("consentMode")
	public String getConsentMode() {
		return consentMode;
	}

	@JsonProperty("consentMode")
	public void setConsentMode(String value) {
		this.consentMode = value;
	}

	@JsonProperty("fetchType")
	public String getFetchType() {
		return fetchType;
	}

	@JsonProperty("fetchType")
	public void setFetchType(String value) {
		this.fetchType = value;
	}

	@JsonProperty("consentTypes")
	public String[] getConsentTypes() {
		return consentTypes;
	}

	@JsonProperty("consentTypes")
	public void setConsentTypes(String[] value) {
		this.consentTypes = value;
	}

	@JsonProperty("fiTypes")
	public String[] getFiTypes() {
		return fiTypes;
	}

	@JsonProperty("fiTypes")
	public void setFiTypes(String[] value) {
		this.fiTypes = value;
	}

	@JsonProperty("DataConsumer")
	public DataConsumer getDataConsumer() {
		return dataConsumer;
	}

	@JsonProperty("DataConsumer")
	public void setDataConsumer(DataConsumer value) {
		this.dataConsumer = value;
	}

	@JsonProperty("Customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("Customer")
	public void setCustomer(Customer value) {
		this.customer = value;
	}

	@JsonProperty("Purpose")
	public Purpose getPurpose() {
		return purpose;
	}

	@JsonProperty("Purpose")
	public void setPurpose(Purpose value) {
		this.purpose = value;
	}

	@JsonProperty("FIDataRange")
	public FIDataRange getFiDataRange() {
		return fiDataRange;
	}

	@JsonProperty("FIDataRange")
	public void setFiDataRange(FIDataRange value) {
		this.fiDataRange = value;
	}

	@JsonProperty("DataLife")
	public DataLife getDataLife() {
		return dataLife;
	}

	@JsonProperty("DataLife")
	public void setDataLife(DataLife value) {
		this.dataLife = value;
	}

	@JsonProperty("Frequency")
	public DataLife getFrequency() {
		return frequency;
	}

	@JsonProperty("Frequency")
	public void setFrequency(DataLife value) {
		this.frequency = value;
	}

	@JsonProperty("DataFilter")
	public DataFilter[] getDataFilter() {
		return dataFilter;
	}

	@JsonProperty("DataFilter")
	public void setDataFilter(DataFilter[] value) {
		this.dataFilter = value;
	}

	@Override
	public String toString() {
		return "ConsentDetail [consentStart=" + consentStart + ", consentExpiry=" + consentExpiry + ", consentMode="
				+ consentMode + ", fetchType=" + fetchType + ", consentTypes=" + Arrays.toString(consentTypes)
				+ ", fiTypes=" + Arrays.toString(fiTypes) + ", dataConsumer=" + dataConsumer + ", customer=" + customer
				+ ", purpose=" + purpose + ", fiDataRange=" + fiDataRange + ", dataLife=" + dataLife + ", frequency="
				+ frequency + ", dataFilter=" + Arrays.toString(dataFilter) + "]";
	}
	
	
}
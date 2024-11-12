package com.sahmatinet.sahamati.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sahmatinet.sahamati.model.ConsentHandleRequest;
import com.sahmatinet.sahamati.model.ConsentHandleResponse;
import com.sahmatinet.sahamati.model.ConsentRequest;
import com.sahmatinet.sahamati.model.ConsentResponse;
import com.sahmatinet.sahamati.model.ConsentStatus;
import com.sahmatinet.sahamati.model.CustomerResp;

@Service
public class ConsentService {

	public ConsentResponse processConsentRequest(ConsentRequest consentRequest) {
		if (consentRequest == null || consentRequest.getConsentDetail() == null) {
			throw new IllegalArgumentException("ConsentDetail is required in the request.");
		}

		ConsentResponse response = new ConsentResponse();

		response.setVer(consentRequest.getVer());
		response.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
		response.setTxnid(consentRequest.getTxnid());

		CustomerResp customer = new CustomerResp();
		customer.setID(consentRequest.getConsentDetail().getCustomer().getID());
		response.setCustomer(customer);

		response.setConsentHandle(UUID.randomUUID().toString()); // Example generated consent handle

		return response;
	}

	public ConsentHandleResponse processConsentHandleRequest(ConsentHandleRequest consentHandleRequest) {
		if (consentHandleRequest == null) {
			throw new IllegalArgumentException("ConsentHandleRequest is required in the request.");
		}

		// Creating response object
		ConsentHandleResponse response = new ConsentHandleResponse();

		// Setting response details
		response.setVer(consentHandleRequest.getVer());
		response.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
		response.setTxnid(consentHandleRequest.getTxnid());
		response.setConsentHandle(consentHandleRequest.getConsentHandle());

		// Simulating a consent status
		ConsentStatus consentStatus = new ConsentStatus();
		consentStatus.setId(UUID.randomUUID().toString()); // Example consent status ID
		consentStatus.setStatus("APPROVED"); // Hardcoded for this example, you can dynamically decide this

		response.setConsentStatus(consentStatus);
		return response;
	}
}

package com.sahmatinet.sahamati.controller;

import java.time.Instant;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.model.FIRequest;
import com.sahmatinet.sahamati.model.FIResponse;

@RestController
@RequestMapping("/proxy/v2/FI")
public class FIRequestController {

	@PostMapping("/request")
	public FIResponse handleFIRequest(@RequestBody FIRequest fiRequest) {
		// Processing logic here (if any)

		// Create and populate FIResponse
		FIResponse response = new FIResponse();
		response.setVersion("2.0.0");
		response.setTimestamp(Instant.now());
		response.setTransactionId(UUID.randomUUID()); // Generate new txnid or use from request if needed
		response.setConsentId(fiRequest.getConsent().getId());
		response.setSessionId(UUID.randomUUID()); // Generate a session ID

		return response;
	}
}

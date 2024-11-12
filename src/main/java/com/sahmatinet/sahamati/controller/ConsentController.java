package com.sahmatinet.sahamati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.model.ConsentHandleRequest;
import com.sahmatinet.sahamati.model.ConsentHandleResponse;
import com.sahmatinet.sahamati.model.ConsentRequest;
import com.sahmatinet.sahamati.model.ConsentResponse;
import com.sahmatinet.sahamati.service.ConsentService;

@RestController
@RequestMapping("/proxy/v2")
public class ConsentController {
	@Autowired
	private ConsentService consentService;

	@PostMapping("/Consent")
	public ResponseEntity<ConsentResponse> createConsent(@RequestBody ConsentRequest consentRequest) {
		ConsentResponse consentResponse = consentService.processConsentRequest(consentRequest);
		return ResponseEntity.ok(consentResponse);

	}

	@PostMapping("/Consent/handle")
	public ResponseEntity<ConsentHandleResponse> handleConsent(@RequestBody ConsentHandleRequest consentHandleRequest) {
		ConsentHandleResponse consentHandleResponse = consentService.processConsentHandleRequest(consentHandleRequest);
		return ResponseEntity.ok(consentHandleResponse);

	}
}

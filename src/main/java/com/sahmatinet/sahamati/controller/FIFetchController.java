package com.sahmatinet.sahamati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.model.FIRequest;
import com.sahmatinet.sahamati.model.FIResponse;
import com.sahmatinet.sahamati.service.FIFetchService;

@RestController
@RequestMapping("/proxy/v2/FI")
public class FIFetchController {

	@Autowired
	private FIFetchService fiService;

	@PostMapping("/fetch")
	public ResponseEntity<FIResponse> fetchFIData(@RequestBody FIRequest fiRequest) {
		FIResponse fiResponse = fiService.processRequest(fiRequest);
		return ResponseEntity.ok(fiResponse);
	}
}

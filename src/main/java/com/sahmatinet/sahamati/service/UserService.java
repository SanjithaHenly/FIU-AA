package com.sahmatinet.sahamati.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahmatinet.sahamati.model.SecretResponse;
import com.sahmatinet.sahamati.util.JwtUtil;

@Service
public class UserService {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private static final long SECRET_EXPIRATION_MILLIS = 24 * 60 * 60 * 1000; // 24 hours

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	public UserService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	public void fetchTokenAndSendToQueue(String username, String password) {
		// Authenticate the user
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		// Step 1: Call IAM to generate user token
		// String tokenUrl = "/v1/user/token/generate";
		String tokenResponse = callIAMTokenApi(username, password);
		
		// Send to ActiveMQ
		jmsTemplate.convertAndSend("iam.user.token.response.queue", tokenResponse);
		// Remove "Bearer " prefix from token
		tokenResponse = tokenResponse.replace("Bearer ", "");

		// Validate JWT token
//		if (!jwtUtil.validateTokens(tokenResponse)) {
//			System.out.println("INVALID TOKEN / token expires");
//		}
		
		
		// Step 2: Fetch entity secret read using the token
		// String entitySecretUrl = "/v1/entity/secret/read";
		String entityId = "lucidledger-01-fiu";
		String entitySecretResponse = callEntitySecretApi(tokenResponse, entityId);
		// Send to ActiveMQ
		jmsTemplate.convertAndSend("iam.secret.read.response.queue", entitySecretResponse);
		
		
		

	}

	private String callIAMTokenApi(String username, String password) {
		String url = "/iam/v1/user/token/generate";
		// Generate a JWT token
		String token = jwtUtil.generateUserToken(username);
		System.out.println("usertoken : " +token);
		// Call the API using RestTemplate or any HTTP client
		// Assume this method handles the POST request and maps the response to
		// TokenResponse
		return "accesstoken:" + token;
	}

	private String callEntitySecretApi(String token, String entityId) {
		String url = "/iam/v1/entity/secret/read";
		// Set Authorization header and make the API call
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		// headers.setContentType(MediaType.);
		String secret = generateRandomSecret();
		  String txnid = UUID.randomUUID().toString();
		  long expiresOn = System.currentTimeMillis() + SECRET_EXPIRATION_MILLIS;
		try {
	        // Create the response object
	        SecretResponse response = new SecretResponse(
	                "1.0.0",
	                java.time.ZonedDateTime.now().toString(),
	                txnid, 
	                entityId,
	                secret,
	                expiresOn
	        );

	        // Convert the response object to a JSON string
	        ObjectMapper objectMapper = new ObjectMapper();
	        String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);

	        // Print the JSON response
	        System.out.println("Response of Secret Read API:");
	        System.out.println(jsonResponse);

	        // Return the response object
	        return jsonResponse;
	    } catch (Exception e) {
	        // Handle exceptions
	        e.printStackTrace();
	        return null;
	    }

	}

	private String generateRandomSecret() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] bytes = new byte[32]; // 32 bytes => 256-bit secret
		secureRandom.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes); // URL-safe base64 encoding
	}

	private String getCurrentTimestamp() {
		return java.time.Instant.now().toString();
	}

}

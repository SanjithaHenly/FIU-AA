package com.sahmatinet.sahamati.util;

import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String SECRET_KEY = generateSecretKey();

	// Generate JWT token
	public Map<String, Object> generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("ver", "1.0.0");
		claims.put("name", username);

		// Generate tokens
		String accessToken = createToken(claims, username, 24 * 60 * 60 * 1000); // 24-hour validity
		String refreshToken = createToken(claims, username, 30L * 24 * 60 * 60 * 1000); // 30-day validity

		// Response body
		Map<String, Object> response = new HashMap<>();
		response.put("ver", "1.0.0");
		response.put("timestamp", new Date());
		response.put("txnId", UUID.randomUUID().toString());
		response.put("accessToken", accessToken);
		response.put("expiresIn", 24 * 60 * 60);
		response.put("refreshToken", refreshToken);
		response.put("tokenType", "Bearer");
		response.put("scope", "email profile");

		return response;
	}

	private String generateSecretKey() {
		// Generate a 256-bit (32-byte) key for HMAC
		byte[] key = new byte[32]; // 256 bits
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(key);

		// Encode to a Base64 string
		String secretKey = Base64.getEncoder().encodeToString(key);
		// System.out.println("Secret Key: " + secretKey);

		return secretKey;
	}

	private String createToken(Map<String, Object> claims, String subject, long validity) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validity)) // 24 hours validity
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	// Validate token FOR secret
	public boolean validateTokens(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Validate token FOR USER
	public Boolean validateToken(String token, String username) {
		final String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}

	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractAllClaims(token).getExpiration().before(new Date());
	}

	// Generate JWT token for asyncall
	public String generateUserToken(String username) {

		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username, 24 * 60 * 60 * 1000);

	}

	public Map<String, Object> generateMemberTokenD(HttpHeaders headers) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("ver", "1.0.0");
		claims.put("name", headers);

		// Generate tokens
		String accessToken = createMemberToken(claims, headers, 24 * 60 * 60 * 1000); // 24-hour validity
		String refreshToken = createMemberToken(claims, headers, 30L * 24 * 60 * 60 * 1000); // 30-day validity

		// Response body
		Map<String, Object> response = new HashMap<>();
		response.put("ver", "1.0.0");
		response.put("timestamp", new Date());
		response.put("txnId", UUID.randomUUID().toString());
		response.put("accessToken", accessToken);
		response.put("expiresIn", 24 * 60 * 60);
		response.put("refreshToken", refreshToken);
		response.put("tokenType", "Bearer");
		response.put("scope", "email profile");

		return response;
	}

	private String createMemberToken(Map<String, Object> claims, HttpHeaders headers, long i) {
		
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + i)) // 24 hours validity
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	

}

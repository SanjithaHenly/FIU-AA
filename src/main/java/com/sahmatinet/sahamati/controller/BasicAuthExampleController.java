package com.sahmatinet.sahamati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.util.JwtUtil;

@RestController
@RequestMapping("/auth/realms/sahamati/protocol/openid-connect")
public class BasicAuthExampleController {

//	@Autowired
//	MemberTokenDeprecatedService tokenService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/token")
	public ResponseEntity<Map<String, Object>> securedApi(@RequestHeader HttpHeaders headers) {
		Map<String, Object> tokenResponse = jwtUtil.generateMemberTokenD(headers);
		if (headers.containsKey(HttpHeaders.AUTHORIZATION)) {
			String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader.startsWith("Basic ")) {
				return ResponseEntity.ok(tokenResponse);

			}
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
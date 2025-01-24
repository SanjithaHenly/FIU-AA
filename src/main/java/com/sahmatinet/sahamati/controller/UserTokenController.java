package com.sahmatinet.sahamati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.service.UserService;
import com.sahmatinet.sahamati.util.JwtUtil;

@RestController
@RequestMapping("/iam/v1/user")
public class UserTokenController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	
	private final UserService iamService;

	@Autowired
	public UserTokenController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService iamService) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.iamService = iamService;
	}

	@PostMapping("/execute")
	public String executeAPIFlow(@RequestParam String username, @RequestParam String password) {
		iamService.fetchTokenAndSendToQueue(username, password);
		return "API calls initiated and responses sent to ActiveMQ!";
	}

	@PostMapping("/token/generate")
	public ResponseEntity<Map<String, Object>> generateToken(@RequestParam String username, @RequestParam String password) {
		// Authenticate the user
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		// Generate a JWT token
		Map<String, Object> token = jwtUtil.generateToken(username);

		return ResponseEntity.ok(token);
	}
}
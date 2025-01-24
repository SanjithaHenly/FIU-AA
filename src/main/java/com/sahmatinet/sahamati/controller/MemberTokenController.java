package com.sahmatinet.sahamati.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahmatinet.sahamati.util.JwtUtil;

@RestController
@RequestMapping("/iam/v1/entity/token")
public class MemberTokenController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/generate")
	public ResponseEntity<Map<String, Object>> generateMemberToken(@RequestParam String id,
			@RequestParam String secret) {

		Map<String, Object> token = jwtUtil.generateToken(id);
		return ResponseEntity.ok(token);

	}
}

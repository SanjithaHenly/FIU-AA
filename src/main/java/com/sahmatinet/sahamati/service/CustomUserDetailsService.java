package com.sahmatinet.sahamati.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sahmatinet.sahamati.model.UserSecurityRequest;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserSecurityRequest securityProperties;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demonstration, we are using an in-memory user
        // In a real application, fetch user details from a database
        if (securityProperties.getUsername().equals(username)) {
            return new User(securityProperties.getUsername(), securityProperties.getPassword(), Collections.emptyList());
            // The password above is "password123" encoded using BCrypt
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

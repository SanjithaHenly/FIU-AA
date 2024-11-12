package com.sahmatinet.sahamati.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityRequest {

    @Value("${app.security.username}")
    private String username;

    @Value("${app.security.password}")
    private String password;

    // Getters for username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

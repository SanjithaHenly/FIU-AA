package com.sahmatinet.sahamati.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sahmatinet.sahamati.JwtRequestFilter;
import com.sahmatinet.sahamati.model.UserSecurityRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	UserSecurityRequest securityProperties;
    private final JwtRequestFilter jwtRequestFilter;
    
    private final RestAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
		this.authenticationEntryPoint = new RestAuthenticationEntryPoint();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF protection for this example
            .authorizeRequests()
            .requestMatchers("/iam/v1/user/token/generate").permitAll() 
            .requestMatchers("/iam/v1/entity/token/generate").permitAll() // Allow access to this endpoint
            .requestMatchers("/iam/v1/entity/secret/read").authenticated()// Other requests require authentication
            .and()
            .httpBasic(); // Enable basic authentication

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter

        return http.build(); // Build the security filter chain
    }

//    @Bean
//    public  PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
//    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.inMemoryAuthentication()
            .withUser(securityProperties.getUsername())
            .password(PasswordEncoderConfig.passwordEncoder().encode(securityProperties.getPassword()))
            .roles("USER");
        return authenticationManagerBuilder.build();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.csrf().disable();

      http.authorizeRequests()
           .requestMatchers("/auth/realms/sahamati/protocol/openid-connect/token")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic()
          .authenticationEntryPoint(authenticationEntryPoint);
      return http.build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,PasswordEncoder passwordEncoder) throws Exception {
      auth.inMemoryAuthentication()
              .passwordEncoder(PasswordEncoderConfig.passwordEncoder())
              .withUser("lucidledger-01-fiu")
              .password(PasswordEncoderConfig.passwordEncoder().encode("976qYDSY9dXZ7cgg5LkjuF9zXtoa5MFzBoxP3x54hmI="))
              .roles("ADMIN");
    }
}

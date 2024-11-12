package com.sahmatinet.sahamati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SahamatiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahamatiApplication.class, args);
	}

	

}

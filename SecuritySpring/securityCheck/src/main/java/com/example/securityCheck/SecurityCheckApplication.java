package com.example.securityCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class SecurityCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityCheckApplication.class, args);
	}

}



package com.uvsoftgroup.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserRegistrationFlywayApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserRegistrationFlywayApplication.class, args);
	}

}

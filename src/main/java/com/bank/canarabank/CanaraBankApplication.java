package com.bank.canarabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bank.canarabank.repository")
@EntityScan("com.bank.canarabank.model")
public class CanaraBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanaraBankApplication.class, args);
	}

}

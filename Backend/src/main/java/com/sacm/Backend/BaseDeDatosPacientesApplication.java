package com.sacm.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class BaseDeDatosPacientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseDeDatosPacientesApplication.class, args);
	}

}

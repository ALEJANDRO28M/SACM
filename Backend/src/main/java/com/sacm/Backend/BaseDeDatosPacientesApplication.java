package com.sacm.Backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sacm.Backend.Controllers.Controllers.RecoverController;
@EnableScheduling
@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class BaseDeDatosPacientesApplication implements CommandLineRunner{

	@Autowired	
     RecoverController recoverController;
	public static void main(String[] args) {
		SpringApplication.run(BaseDeDatosPacientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	// 	System.out.println("El Codigo es : ");
	
	 
	}

}

package com.javeriana.funkoStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FunkoStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunkoStoreApplication.class, args);
	}

}

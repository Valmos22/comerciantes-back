package com.hugovalderrama.comerciantes_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hugovalderrama.comerciantes_backend.repository")
@EntityScan(basePackages = "com.hugovalderrama.comerciantes_backend.entity")
public class ComerciantesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComerciantesBackendApplication.class, args);
	}

}

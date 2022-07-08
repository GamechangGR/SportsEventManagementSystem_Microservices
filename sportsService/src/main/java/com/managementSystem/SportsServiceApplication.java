package com.managementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.managementSystem")
@EntityScan(basePackages = "com.managementSystem")
@EnableJpaRepositories(basePackages = "com.managementSystem")
public class SportsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsServiceApplication.class, args);
	}

}

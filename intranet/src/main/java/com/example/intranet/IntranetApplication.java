package com.example.intranet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IntranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}

}

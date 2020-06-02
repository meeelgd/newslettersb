package com.mbegyn.newslettersb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.mbegyn.newslettersb.repository")
@SpringBootApplication
public class NewslettersbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewslettersbApplication.class, args);
	}

}

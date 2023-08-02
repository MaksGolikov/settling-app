package com.holikov.settling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.holikov.settling"})
public class SettlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SettlingApplication.class, args);
	}

}

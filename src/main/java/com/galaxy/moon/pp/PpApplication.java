package com.galaxy.moon.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.galaxy.moon.*"})
public class PpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpApplication.class, args);
	}
}

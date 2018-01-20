package com.galaxy.moon.pp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.galaxy.moon.pp.dao")
@SpringBootApplication(scanBasePackages = {"com.galaxy.moon.*"})
public class PpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpApplication.class, args);
	}
}

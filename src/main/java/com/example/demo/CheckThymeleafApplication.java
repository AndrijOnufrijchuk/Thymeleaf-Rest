package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;







@EntityScan("com.example.demo.entities")
@EnableMongoRepositories("com.example.demo.repositories")
@SpringBootApplication(scanBasePackages = "com.example.demo")
public class CheckThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckThymeleafApplication.class, args);
	}

}



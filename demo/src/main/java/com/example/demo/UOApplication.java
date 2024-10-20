package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080/", description = "UO HACK Server")})
//@OpenAPIDefinition(servers = {@Server(url = "https://ducktimes.store/", description = "UO HACK Server")})
@SpringBootApplication
public class UOApplication {

	public static void main(String[] args) {
		SpringApplication.run(UOApplication.class, args);
		System.out.println("Application started successfully!");
	}
}
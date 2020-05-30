package com.poruka.Poruka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PorukaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorukaApplication.class, args);
	}

}

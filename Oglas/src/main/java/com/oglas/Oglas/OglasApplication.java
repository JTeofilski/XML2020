package com.oglas.Oglas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OglasApplication {

	public static void main(String[] args) {
		SpringApplication.run(OglasApplication.class, args);
	}

}

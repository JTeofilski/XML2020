package com.izvestaj.Izvestaj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IzvestajApplication {

	public static void main(String[] args) {
		SpringApplication.run(IzvestajApplication.class, args);
	}

}

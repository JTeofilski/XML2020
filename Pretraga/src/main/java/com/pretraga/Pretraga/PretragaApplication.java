package com.pretraga.Pretraga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PretragaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PretragaApplication.class, args);
		MyTimeTask mtt= new MyTimeTask();
		mtt.timer();
	}

}

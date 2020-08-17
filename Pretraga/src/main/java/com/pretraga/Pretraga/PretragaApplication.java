package com.pretraga.Pretraga;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling

public class PretragaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PretragaApplication.class, args);
		/*
		try {
			TimeUnit.SECONDS.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyTimeTask mtt= new MyTimeTask();
		mtt.timer();
		*/
		ScheduledTasks st= new ScheduledTasks();

	}

}

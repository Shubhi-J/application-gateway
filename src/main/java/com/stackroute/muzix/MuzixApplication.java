package com.stackroute.muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MuzixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

}

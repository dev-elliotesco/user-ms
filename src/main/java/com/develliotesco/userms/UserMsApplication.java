package com.develliotesco.userms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class UserMsApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserMsApplication.class, args);
		final Logger log = LoggerFactory.getLogger(UserMsApplication.class);
		log.info("Bienvenido a demo de microservicios - user ms");
	}

}

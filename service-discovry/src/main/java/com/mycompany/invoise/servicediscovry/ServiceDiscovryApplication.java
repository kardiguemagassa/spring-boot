package com.mycompany.invoise.servicediscovry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscovryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscovryApplication.class, args);
	}

}

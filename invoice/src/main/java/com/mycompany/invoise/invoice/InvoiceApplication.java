package com.mycompany.invoise.invoice;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan("com.mycompagny.invoise.core.entity.invoice")
public class InvoiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean
	public Hibernate6Module datatypeHibernateModule(){
		Hibernate6Module module = new Hibernate6Module();
		module.disable(Hibernate6Module.Feature.USE_TRANSIENT_ANNOTATION);
		//tu prend le proxy faisant un veritable objet de maniere qu'on puisse serealiser le identfiant
		module.enable(Hibernate6Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		return module;
	}

	// mise en place de client cloud
	// avec WebClient plus besion de cette
	/*
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}*/

	//utilisation de reactive WebClient
	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}

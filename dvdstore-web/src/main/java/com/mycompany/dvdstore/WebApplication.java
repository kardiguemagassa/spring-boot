package com.mycompany.dvdstore;

import org.springframework.boot.SpringApplication;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public Hibernate6Module datatypeHibernateModule(){
		return new Hibernate6Module();
	}

}

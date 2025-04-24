package com.mycompany.invoise;


import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoiseWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(InvoiseWebApplication.class, args);

	}

	// pour nullifier les proxy on peut créer une class de config pour mettre cette partie
	@Bean
	public Hibernate6Module datatypeHibernateModule(){
		return new Hibernate6Module();
	}

}

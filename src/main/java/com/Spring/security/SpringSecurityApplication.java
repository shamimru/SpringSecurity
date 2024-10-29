package com.Spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Spring.security","com.Spring.security.ReceiveMail"}) 
public class SpringSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
	}

}

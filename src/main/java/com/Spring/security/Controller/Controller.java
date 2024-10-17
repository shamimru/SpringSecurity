package com.Spring.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String sayHello() {
		System.out.println("home");
		return "hello shamim";
	}

}

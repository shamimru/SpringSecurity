package com.Spring.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.security.Model.MyUser;
import com.Spring.security.repository.MyUserRepository;

@RestController
public class Controller {
	@Autowired
	MyUserRepository myUserRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String sayHello() {
		System.out.println("home");
		return "hello shamim";
	}
	@GetMapping("/home")
	public String home() {
		System.out.println("home");
		return "hello home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		System.out.println("home");
		return "hello Admin";
	}
	
	@PostMapping("/register")
	public String createUser(@RequestBody MyUser user) {
		System.out.println("register");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		myUserRepository.save(user);
		return "success";
	}

}

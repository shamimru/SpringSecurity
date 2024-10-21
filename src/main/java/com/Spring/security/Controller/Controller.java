package com.Spring.security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.security.Model.MyUser;
import com.Spring.security.Model.People;
import com.Spring.security.MyUserDetailsService.MyUserDetailsService;
import com.Spring.security.repository.MyUserRepository;
import com.Spring.security.storeProcedured.StoreProceduredService;
import com.Spring.security.webToken.JwtService;
import com.Spring.security.webToken.LoginForm;

@RestController
public class Controller {
	@Autowired
	MyUserRepository myUserRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	StoreProceduredService storeProceduredService;

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
	
	
	@GetMapping("/user")
	public String user() {
		System.out.println("user");
		return "hello user";
	}
	
	@PostMapping("/register")
	public String createUser(@RequestBody MyUser user) {
		System.out.println("register");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		MyUser usersaved = myUserRepository.save(user);
		return "success "+usersaved;
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
		System.out.println("signup");
		Authentication authenticate  = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));
		if(authenticate.isAuthenticated()) {
			return jwtService.generateToken(myUserDetailsService.loadUserByUsername(loginForm.username()));
		}else {
			throw new UsernameNotFoundException("Not found "+loginForm.username());
		}
	}
	
	@GetMapping("/getPeople")
	public List<People> getAllPeople(){
		System.out.println("getAllPeople");
		
		List<People> allPeopleFromdb = storeProceduredService.getAllPeopleFromdb();
		for (People people : allPeopleFromdb) {
			System.out.println(people);
		}
		return allPeopleFromdb;
	}
	
	@GetMapping("/getPeople2")
	public List<People> getAllPeople2(){
		System.out.println("getAllPeople2");

		
		List<People> allPeopleFromdb = storeProceduredService.getAllPeopleFromdb2();
		for (People e : allPeopleFromdb) {
			System.out.println(e +" \n");
		}
		
		return allPeopleFromdb;
	}
	
	
	@PostMapping("/getByFname/{fname}")
	public People getByFName(@PathVariable("fname") String fname){
		System.out.println("getByFName");
		People byFName = storeProceduredService.getByFName(fname);
		return byFName;
	}
	
	
	

}

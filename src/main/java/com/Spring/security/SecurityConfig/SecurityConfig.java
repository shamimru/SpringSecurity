package com.Spring.security.SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user").password(passwordEncoder().encode("123")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(user,admin);

	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 http.cors().disable().authorizeHttpRequests().anyRequest().authenticated().and().formLogin();	
	 return http.build();
	}
}

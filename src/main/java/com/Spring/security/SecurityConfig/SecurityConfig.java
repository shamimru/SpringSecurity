package com.Spring.security.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Spring.security.MyUserDetailsService.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	MyUserDetailsService myUserDetailsService;

//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("user").password(passwordEncoder().encode("123")).roles("USER").build();
//		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//
//	}
	@Bean
	public UserDetailsService userDetailsService() {
		return myUserDetailsService;
	}

	@Bean
	public  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(authenticationProvider());
	}

//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors(cors -> cors.disable()).authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
//
//				.formLogin(Customizer.withDefaults());
//		
//		http.sessionManagement(session -> {
//			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		});
//		return http.build();
//	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry -> {
//			registry.requestMatchers("/").permitAll();
			
			registry.requestMatchers("/home","/authenticate","/register").permitAll();
			registry.requestMatchers("/user").hasRole("USER");
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			
			registry.anyRequest().authenticated();

		}).formLogin(form -> form.permitAll()).build();
	}
	
	


	

}

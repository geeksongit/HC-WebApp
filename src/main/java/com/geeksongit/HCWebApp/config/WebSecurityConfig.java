package com.geeksongit.HCWebApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import com.geeksongit.HCWebApp.EnvironmentVariables;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
    @Autowired
    EnvironmentVariables environmentVariables;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		System.out.println(environmentVariables.toString());
		
		String username = environmentVariables.getAppUsername();
		String password = environmentVariables.getAppPassword();
		
		if(username == null || password == null) { // temporary
			username = "test";
			password = "test";
		}
		
		// TODO - DB Authentication, Encryption
		
		UserDetails user = User.builder()
		        .username(username)
		        .password(passwordEncoder().encode(password))
		        .roles("USER")
		        .build();
		   
		    return new InMemoryUserDetailsManager(user);	
	}
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
}

package com.vps.management.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vps.management.service.Impl.UserDetailServices;
import com.vps.management.utils.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class Config {


	@Autowired
	UserDetailServices userdetail;
	@Autowired
	JwtFilter jwtFilter;

	//Authentication Provider
	@Bean
	public AuthenticationProvider authentication() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetail);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;

	}


	//Security Config
	@Bean
	public SecurityFilterChain chain (HttpSecurity http) throws Exception
	{
		http.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasRole("admin")
											   .requestMatchers("/student/**").hasRole("Student")
											   .requestMatchers("/teacher/**").hasRole("Teacher")
											   .anyRequest().permitAll()
								   )
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}


	//Authentication
	@Bean
	public AuthenticationManager auth(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}

}

package com.sahayji.exp.management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
	private CustomUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/users/register").permitAll();
			auth.anyRequest().authenticated();
		});
		http.httpBasic(Customizer.withDefaults());
		http.formLogin(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	
//	@Bean
//	public InMemoryUserDetailsManager detailsManager() {
//		UserDetails userDetails1 = User.builder()
//				                       .username("amit@gmail.com")
//				                       .password(passwordEncoder()
//				                       .encode("test1234"))
//				                       .roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(userDetails1);
//	}
	
}

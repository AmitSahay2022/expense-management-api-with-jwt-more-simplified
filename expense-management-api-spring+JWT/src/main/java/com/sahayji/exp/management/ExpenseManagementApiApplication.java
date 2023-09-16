package com.sahayji.exp.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApiApplication.class, args);
	}
   
}



/*
Step 1: ADD JWT Dependency Step 1/5,  Springboot 3.X with jwt also need jaxb-api

Step 2: create JwtTokenUtil class.

Step 3: create JwtRequestFilter class

Step 4: modify SecurityFilterChain of SecurityConfiguration class 

Step 5: create AuthController class to return JWT Token to the logged in user

Step 6: add jwt.secret=amitSoftware in application.properties file

*/
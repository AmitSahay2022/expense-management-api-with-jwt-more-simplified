package com.sahayji.exp.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayji.exp.management.entity.User;
import com.sahayji.exp.management.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
 
	private UserService userService;
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		return new ResponseEntity<User>(userService.update(user),HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteUser(){
		return new ResponseEntity<String>(userService.delete(),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<User> getUser(){
		return new ResponseEntity<User>(userService.getUser(),HttpStatus.OK);
	}
}

package com.sahayji.exp.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayji.exp.management.dto.LoginModel;
import com.sahayji.exp.management.jwt.JwtResponse;
import com.sahayji.exp.management.jwt.JwtTokenUtil;
import com.sahayji.exp.management.security.CustomUserDetailsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth") 
@AllArgsConstructor
public class AuthController {

	private CustomUserDetailsService userDetailsService;

	private JwtTokenUtil jwtTokenUtil;

	private AuthenticationManager authenticationManager;
/*
 * Step:5/5    This Login method will return JWT Token to the user
 * 
 * */
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginModel loginModel) throws Exception {

		authenticate(loginModel.getUsername(), loginModel.getPassword());

		// we need to generate the jwt token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);
	}

	private void authenticate(String email, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("User disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}

	}

}

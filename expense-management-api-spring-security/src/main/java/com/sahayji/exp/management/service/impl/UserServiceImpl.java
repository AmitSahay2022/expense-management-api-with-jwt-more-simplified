package com.sahayji.exp.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sahayji.exp.management.entity.User;
import com.sahayji.exp.management.exception.ResourceNotFoundException;
import com.sahayji.exp.management.exception.UserAllReadyExistException;
import com.sahayji.exp.management.repository.UserRepository;
import com.sahayji.exp.management.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new UserAllReadyExistException("User with this email is already registered");
		} else {
			String password = passwordEncoder.encode(user.getPassword());
			user.setPassword(password);
		}

		return userRepository.save(user);
	}

	@Override
	public User update(User usr) {
		// TODO Auto-generated method stub
		User user = getUser();
		user.setAge(usr.getAge());
		user.setEmail(usr.getEmail());
		user.setName(usr.getName());
		user.setPassword(passwordEncoder.encode(usr.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		User user = getUser();
		userRepository.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		User loggedInUser = getLoggedInUser();
		User user = userRepository.findById(loggedInUser.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return user;
	}

	@Override
	public User getLoggedInUser() {
		// TODO Auto-generated method stub
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepository.findByEmail(email).get();
	}

}

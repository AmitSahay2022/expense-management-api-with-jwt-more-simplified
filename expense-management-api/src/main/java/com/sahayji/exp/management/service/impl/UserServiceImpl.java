package com.sahayji.exp.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new UserAllReadyExistException("User with this email is already registered");
		}else
			
		return userRepository.save(user);
	}

	@Override
	public User update(User usr, long id) {
		// TODO Auto-generated method stub
		User user = getUser(id);
		user.setAge(usr.getAge());
		user.setEmail(usr.getEmail());
		user.setName(usr.getName());
		user.setPassword(usr.getPassword());
		return userRepository.save(user);
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		User user = getUser(id);
		userRepository.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
		return user;
	}

	
	
}

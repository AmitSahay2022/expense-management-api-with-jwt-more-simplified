package com.sahayji.exp.management.service;

import com.sahayji.exp.management.entity.User;

public interface UserService {
	
	public User save(User user);
	
	public User update(User user);
	
	public String delete();
	
	public User getUser();
	
	public User getLoggedInUser();

}

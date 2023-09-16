package com.sahayji.exp.management.service;

import com.sahayji.exp.management.entity.User;

public interface UserService {
	
	public User save(User user);
	
	public User update(User user,long id);
	
	public String delete(long id);
	
	public User getUser(long id);

}

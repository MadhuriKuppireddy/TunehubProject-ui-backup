package com.kodnest.service;

import com.kodnest.entity.User;

public interface UserService {

	public void saveUser(User user);

	public boolean emailExists(User user);

	public boolean validUser(String email, String password);


	public String getRole(String email);

	public User getUser(String mail);

	public void updateUser(User user);
	
	

	
}

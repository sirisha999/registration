package com.register.dao;

import com.register.model.User;

public interface UserDAO {
	
	public User getStudentDetailsByEmailAndPassword(String email,String password);
	public abstract void saveUser(User user);
}

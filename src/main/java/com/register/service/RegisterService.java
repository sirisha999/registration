package com.register.service;

import com.register.model.User;

public interface RegisterService {

	void saveUser(User user);
	User getStudentDetailsByEmailAndPassword(String name,String password);
}

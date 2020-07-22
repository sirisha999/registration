package com.register.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.register.dao.UserDAO;
import com.register.model.User;
import com.register.service.RegisterService;

@Service("registrationService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserDAO dao;
	public void setUserDAO(UserDAO userDAO) {
		this.dao = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return dao;
	}
	 public void saveUser(User user) {
	        // TODO Auto-generated method stub
		 getUserDAO().saveUser(user);
	    }
	 
	 public User getStudentDetailsByEmailAndPassword(String name,String password) {
	        return getUserDAO().getStudentDetailsByEmailAndPassword(name,password);
	    }
}

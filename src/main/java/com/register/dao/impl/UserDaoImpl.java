package com.register.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.register.dao.UserDAO;
import com.register.model.User;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
//@Autowired

@Repository("userDAO")
public class UserDaoImpl implements UserDAO{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Override
	public void saveUser(User user) {
		System.out.println(user.getPassword()+"hello"+user.getLastname());
		hibernateTemplate.save(user);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public User getStudentDetailsByEmailAndPassword(String username,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("username", username));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<User> findByCriteria = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
}
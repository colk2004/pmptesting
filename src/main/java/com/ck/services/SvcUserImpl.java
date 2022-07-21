package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.User;

@Service("userService")
@Transactional
public class SvcUserImpl implements SvcUser {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from User").list();		
		
	};
	
	public User findById(Long id){
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
		
	};
	public void save(User user){
		/*sessionFactory.getCurrentSession().saveOrUpdate(user);*/
		sessionFactory.getCurrentSession().save(user);
	};

}

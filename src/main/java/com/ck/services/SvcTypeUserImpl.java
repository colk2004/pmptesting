package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.TypeUser;

@Service("typeUserService")
@Transactional
public class SvcTypeUserImpl implements SvcTypeUser {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<TypeUser> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from TypeUser").list();		
		
	};
	
	public TypeUser findById(Long id){
		return (TypeUser) sessionFactory.getCurrentSession().get(TypeUser.class, id);
		
	};
	public void save(TypeUser typeUser){
		sessionFactory.getCurrentSession().saveOrUpdate(typeUser);
	};

}

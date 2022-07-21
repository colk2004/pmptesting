package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.Role;

@Service("roleService")
@Transactional
public class SvcRoleImpl implements SvcRole {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Role> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from Role").list();		
		
	};
	
	public Role findById(Long id){
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
		
	};
	public void save(Role role){
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	};

}

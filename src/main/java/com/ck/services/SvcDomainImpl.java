package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ck.entities.Domain;

@Service("domainService")
@Transactional
public class SvcDomainImpl implements SvcDomain {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Domain> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from Domain order by Id").list();		
		
	};
	
	public Domain findById(Long id){
		
		return (Domain) sessionFactory.getCurrentSession().get(Domain.class, id);
	
	};
	
	public void save(Domain domain){
		sessionFactory.getCurrentSession().save(domain);
	};

}

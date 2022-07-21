package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.ProcessGroup;

@Service("processGroupService")
@Transactional
public class SvcProcessGroupImpl implements SvcProcessGroup {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ProcessGroup> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from ProcessGroup").list();		
		
	};
	
	public ProcessGroup findById(Long id){
		return (ProcessGroup) sessionFactory.getCurrentSession().get(ProcessGroup.class, id);
		
	};
	public void save(ProcessGroup processGroup){
		sessionFactory.getCurrentSession().save(processGroup);
	};

}

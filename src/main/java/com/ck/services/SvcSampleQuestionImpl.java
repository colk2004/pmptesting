package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.SampleQuestion;

@Service("sampleQuestionService")
@Transactional
public class SvcSampleQuestionImpl implements SvcSampleQuestion {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<SampleQuestion> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from SampleQuestion").list();		
		
	};
	
	public SampleQuestion findById(Long id){
		return (SampleQuestion) sessionFactory.getCurrentSession().get(SampleQuestion.class, id);
		
	};
	public void save(SampleQuestion sampleQuestion){
		sessionFactory.getCurrentSession().saveOrUpdate(sampleQuestion);
	};

}

package com.ck.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.Question;

@Service("questionService")
@Transactional
public class SvcQuestionImpl implements SvcQuestion {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Question> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from Question").list();		
		
	};
	
	public Question findById(Long id){
		return (Question) sessionFactory.getCurrentSession().get(Question.class, id);
		
	};
	public void save(Question questionDb){
		sessionFactory.getCurrentSession().save(questionDb);
	};
	


}

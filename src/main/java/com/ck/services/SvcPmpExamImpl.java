package com.ck.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.entities.PmpExam;
import com.ck.entities.Question;



@Service("pmpExamService")
@Transactional
public class SvcPmpExamImpl implements SvcPmpExam {
	
	SvcQuestion questionService = new SvcQuestionImpl();

	@Autowired
	private SessionFactory sessionFactory;
	ArrayList<Question> questionDuTest ;

	@SuppressWarnings("unchecked")
	public List<PmpExam> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from PmpExam").list();

	};

	public PmpExam findById(Long id) {
		return (PmpExam) sessionFactory.getCurrentSession().get(PmpExam.class, id);

	};

	public void save(PmpExam pmpExam) {
		sessionFactory.getCurrentSession().save(pmpExam);
	}

	
	public ArrayList<Question> getQuestionDuTest() {
		return questionDuTest;
	}

	public void setQuestionDuTest(ArrayList<Question> questionDuTest) {
		this.questionDuTest = questionDuTest;
	}

	@SuppressWarnings({ "unchecked", "null" })
	public ArrayList<Question> genererExam() {
		int pos;
		int n = 30;
		//on recupere les questions en bd
		List<Question> questions =  sessionFactory.getCurrentSession().createQuery("from Question").list();
	     
		if (questions.isEmpty()){ 
			System.out.println("Tableau des question vide-Creer d'abord les questions !!");
			return null;
			
		} else{		
		
		Long j = (long) 0;
		int taille = Math.min(n, questions.size());
		int[] num = new int[taille];
		questionDuTest = new ArrayList<Question>();
		
		
		for (int i =  0; i < taille; i++) {
			
			pos =  (int) (Math.random() * taille);
		
			while (pos >= taille ){ pos = (int) (Math.random() * taille); } ;
			System.out.println("pos = " + pos);
			System.out.println("Int pos = " + (int) pos);
			System.out.println("Round pos = " + Math.round(pos) );
			
			/*num[i] = pos;
			j = (long) i;
			j = (long) i;*/
			
			
			System.out.println("i= " + i);
			/*System.out.println("code =" + question.get(i).getId());
			System.out.println("Description =" + question.get(i).getDescription());
			Question q = question.get(i);			
			questionDuTest.add(q);*/
			
			pos = Math.round(pos);
			
			//on recupere les question de la liste de selection, affecte aux question du test
			questionDuTest.add(questions.get( pos)) ;
			
			System.out.println("code =" + questionDuTest.get(i).getId()+ " Question = "+ questionDuTest.get(i).getDescription() );
		}
		System.out.println("Taille =" + questionDuTest.size());
		
		}
		
		return questionDuTest;

		
	}
}

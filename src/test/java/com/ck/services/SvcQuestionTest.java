package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.Question;

public class SvcQuestionTest {
	
	private  static ClassPathXmlApplicationContext context;
	private static SvcQuestion questionService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		questionService = (SvcQuestion) context.getBean("questionService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		Question questionDb = new Question();
		
		questionDb.setDescription("Question 1");;
		questionService.save(questionDb);
		assertNotNull(questionDb.getId());
	}

	@Test
	public void testFindAll() {
		List<Question> allQuestionDbs = questionService.findAll();
		assertNotNull(allQuestionDbs);
		System.out.println(allQuestionDbs.size());
		assertNotNull("Taille different", allQuestionDbs.size()==2);
		
		
	}

	@Test
	public void testFindById() {
		Question question = questionService.findById(10L);
		System.out.println(question.getDescription());
		System.out.println(question.getId());
		assertNotNull(question);
	}

	

}

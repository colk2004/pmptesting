package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.SampleQuestion;

public class SvcSampleQuestionTest {
	
	private  static ClassPathXmlApplicationContext context;
	private static SvcSampleQuestion sampleQuestionService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sampleQuestionService = (SvcSampleQuestion) context.getBean("sampleQuestionService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		SampleQuestion sampleQuestion = new SampleQuestion();
		
		sampleQuestion.setDescription("Question n 2");
		sampleQuestionService.save(sampleQuestion);
		assertNotNull(sampleQuestion.getId());
	}

	@Test
	public void testFindAll() {
		List<SampleQuestion> allSampleQuestions = sampleQuestionService.findAll();
		assertNotNull(allSampleQuestions);
		System.out.println(allSampleQuestions.size());
		assertNotNull("Taille different", allSampleQuestions.size()==1);
		
		
	}

	@Test
	public void testFindById() {
		SampleQuestion sampleQuestion = sampleQuestionService.findById(1L);
		assertNotNull(sampleQuestion);
	}

	

}

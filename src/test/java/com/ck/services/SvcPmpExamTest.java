package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.PmpExam;


public class SvcPmpExamTest {

	private static ClassPathXmlApplicationContext context;
	private static SvcPmpExam pmpExamService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		pmpExamService = (SvcPmpExam) context.getBean("pmpExamService");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		PmpExam pmpExam = new PmpExam();

		pmpExam.setDescription("Test 2");
		pmpExamService.save(pmpExam);
		assertNotNull(pmpExam.getId());
	}

	@Test
	public void testFindAll() {
		List<PmpExam> allPmpTests = pmpExamService.findAll();
		assertNotNull(allPmpTests);
		System.out.println(allPmpTests.size());
		assertNotNull("Taille different", allPmpTests.size() == 1);

	}

	@Test
	public void testFindById() {
		PmpExam pmpTest = pmpExamService.findById(1L);
		assertNotNull(pmpTest);
	}

}

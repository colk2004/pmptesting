package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.Domain;

public class SvcDomainTest {
	
	private  static ClassPathXmlApplicationContext context;
	private static SvcDomain domainService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		domainService = (SvcDomain) context.getBean("domainService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		Domain domain = new Domain();
		
		domain.setDescription("Scope Management");
		domainService.save(domain);
		assertNotNull(domain.getId());
	}

	@Test
	public void testFindAll() {
		List<Domain> allDomains = domainService.findAll();
		assertNotNull(allDomains);
		System.out.println(allDomains.size());
		assertNotNull("Taille different", allDomains.size()==2);
		
		
	}

	@Test
	public void testFindById() {
		Domain domain = domainService.findById(1L);
		assertNotNull(domain);
	}

	

}

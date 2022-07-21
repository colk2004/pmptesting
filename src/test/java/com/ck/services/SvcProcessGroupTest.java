package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.ProcessGroup;

public class SvcProcessGroupTest {
	
	private  static ClassPathXmlApplicationContext context;
	private static SvcProcessGroup processGroupService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		processGroupService = (SvcProcessGroup) context.getBean("processGroupService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		ProcessGroup processGroup = new ProcessGroup();
		
		processGroup.setDescription("Monitoring");
		processGroupService.save(processGroup);
		assertNotNull(processGroup.getId());
	}

	@Test
	public void testFindAll() {
		List<ProcessGroup> allprocessGroups = processGroupService.findAll();
		assertNotNull(allprocessGroups);
		System.out.println(allprocessGroups.size());
		
	}

	@Test
	public void testFindById() {
		ProcessGroup processGroup = processGroupService.findById(1L);
		assertNotNull(processGroup);
	}

	

}

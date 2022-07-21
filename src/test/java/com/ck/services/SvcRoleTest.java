package com.ck.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.entities.Role;

public class SvcRoleTest {
	
	private  static ClassPathXmlApplicationContext context;
	private static SvcRole roleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		roleService = (SvcRole) context.getBean("roleService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testSave() {
		Role role = new Role();
		
		role.setDescription("Super Administrateur");
		roleService.save(role);
		assertNotNull(role.getId());
	}

	@Test
	public void testFindAll() {
		List<Role> allRoles = roleService.findAll();
		assertNotNull(allRoles);
		System.out.println(allRoles.size());
		assertNotNull("Taille different", allRoles.size()==0);
		
		
	}

	@Test
	public void testFindById() {
		Role role = roleService.findById(1L);
		assertNotNull(role);
	}

	

}

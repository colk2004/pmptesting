package com.ck.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ck.entities.Domain;
import com.ck.services.SvcDomain;

@Component("domainBean")

public class DomainBean {


	@Autowired
	private transient SvcDomain domainService;
	
	private List<Domain> domainList;
	
	
	private List<SelectItem> domaines;
	
	private Domain currentDomain = new Domain();
	private String description;
	

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Domain> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<Domain> DomainList) {
		this.domainList = DomainList;
	}



	public DomainBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String newDomain() {
		return "newDomain";
	}


 public String creer(){
	 try{
		 currentDomain = new Domain();
		 currentDomain.setDescription(description);
	 domainService.save(currentDomain);
	 }catch (Exception e) {
		System.out.println(e.getMessage());
		return "newDomain";
	}
	 
	 domainList = domainService.findAll();
	 
	
	 
		 
	 return "newDomain";
	 
 }
 
 public void setDomaines(List<SelectItem> domaines) {
		this.domaines = domaines;
	}
 
 
 public List<SelectItem> getDomaines() {

		domainList = domainService.findAll();
		
		domaines = new ArrayList<SelectItem>();

		for (Domain d : domainList) {

			domaines.add(new SelectItem((d.getId()), d.getDescription()));

		}
		;

		return domaines;
	}
 
	@PostConstruct
	public void init() {
		domainList = domainService.findAll();
		
	}

}

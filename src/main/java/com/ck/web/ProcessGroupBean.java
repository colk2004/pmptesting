package com.ck.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.annotation.PostConstruct;

import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ck.entities.ProcessGroup;
import com.ck.services.SvcProcessGroup;

@SuppressWarnings("restriction")
@Component("processGroupBean")
@ViewScoped
public class ProcessGroupBean  {

	
	@Autowired
	private transient SvcProcessGroup processGroupService;
	
	
	private List<ProcessGroup> processGroupList;
	private List<SelectItem> processGroups;

	private ProcessGroup currentProcessGroup=new ProcessGroup() ;
	private String description;

	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProcessGroup getCurrentProcessGroup() {
		return currentProcessGroup;
	}

	public void setCurrentProcessGroup(ProcessGroup currentProcessGroup) {
		this.currentProcessGroup = currentProcessGroup;
	}

	public List<ProcessGroup> getProcessGroupList() {
		return processGroupList;
	}

	public void setProcessGroupList(List<ProcessGroup> processGroupList) {
		this.processGroupList = processGroupList;
	}

	

	public ProcessGroupBean() {
		super();
		// TODO Auto-generated constructor stub
	}


 public String creer(){
	 try{
		 currentProcessGroup.setDescription(description);
	 processGroupService.save(currentProcessGroup);
	 }catch (Exception e) {
		System.out.println(e.getMessage());
	
	}
	 
	 processGroupList = processGroupService.findAll();
	 return "newProcessGroup";
	 
 }
 
 public List<SelectItem> getprocessGroups() {

		processGroupList = processGroupService.findAll();

		processGroups = new ArrayList<SelectItem>();

		for (ProcessGroup p : processGroupList) {

			processGroups.add(new SelectItem((p.getId()), p.getDescription()));

		}
		;

		return processGroups;
	}
	@PostConstruct
	public void init() {
		processGroupList = processGroupService.findAll();
		
	}

}

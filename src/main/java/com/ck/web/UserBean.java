package com.ck.web;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.persistence.PostLoad;

import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ck.entities.User;
import com.ck.services.SvcUser;

@Component("userBean")
@ViewScoped
public class UserBean  {


	@Autowired
	private transient SvcUser userService;
	private List<User> UserList;
	private transient DataTable dataTable;
	private User currentUser = new User();

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public List<User> getUserList() {
		return UserList;
	}

	public void setUserList(List<User> UserList) {
		this.UserList = UserList;
	}

	public DataTable getDataTable() {

		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	public UserBean() {
		super();
		
	}


 public String creer(){
	 try{
	 userService.save(currentUser);
	 }catch (Exception e) {
		System.out.println(e.getStackTrace());
		return "createUser";
	}
	 
	 UserList = userService.findAll();
	 return "newUser";
	 
 }
 	@PostLoad
	public void init() {
		UserList = userService.findAll();
		
	}

}

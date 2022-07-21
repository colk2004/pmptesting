

package com.ck.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private String name;
	private String firstName;
	private String password;
	private String email;
	private String phone;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="typeUser_fk")
	private TypeUser typeUser;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="role_fk")
	private Role role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String firstName, String password,
			String email, String phone, TypeUser typeUser, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.typeUser = typeUser;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

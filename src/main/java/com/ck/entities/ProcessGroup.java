package com.ck.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProcessGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( unique=true, nullable=false)
	private String description;
	@OneToMany(mappedBy="processGroup")
	private List<Question> questions;
	public ProcessGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessGroup(Long id, String description, List<Question> questions) {
		super();
		this.id = id;
		this.description = description;
		this.questions = questions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
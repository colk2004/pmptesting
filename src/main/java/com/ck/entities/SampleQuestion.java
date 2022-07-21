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
public class SampleQuestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String description;
	private String response;
	private String responseComment;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pmpExam_fk")
	private PmpExam pmpExam;
	
	public SampleQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SampleQuestion(Long id, String description, String response,
			String responseComment, PmpExam pmpExam) {
		super();
		this.id = id;
		this.description = description;
		this.response = response;
		this.responseComment = responseComment;
		this.pmpExam = pmpExam;
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
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getResponseComment() {
		return responseComment;
	}
	public void setResponseComment(String responseComment) {
		this.responseComment = responseComment;
	}
	public PmpExam getPmpExam() {
		return pmpExam;
	}
	public void setPmpExam(PmpExam pmpExam) {
		this.pmpExam = pmpExam;
	}
	
	
	
}
	
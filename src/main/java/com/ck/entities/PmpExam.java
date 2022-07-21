package com.ck.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PmpExam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String description;
	private Date examDate;
	private Integer score;
	private Date startDate;
	private Date endDate;
	private User user;
	@OneToMany(mappedBy="pmpExam")
	private List<SampleQuestion> sampleQuestions;
	public PmpExam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PmpExam(Long id, String description, Date examDate, Integer score,
			Date startDate, Date endDate, User user
			) {
		super();
		this.id = id;
		this.description = description;
		this.examDate = examDate;
		this.score = score;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		
	}
	public PmpExam(String description) {
		super();
		
		this.description = description;
		this.examDate= new Date();
		
		
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
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<SampleQuestion> getSampleQuestions() {
		return sampleQuestions;
	}
	public void setSampleQuestions(List<SampleQuestion> sampleQuestions) {
		this.sampleQuestions = sampleQuestions;
	}
	
	
	
}
package com.ck.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ck.enums.Complexity;
import com.sun.istack.internal.NotNull;

@Entity
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String description;
	private String reponsea;
	private String reponseb;
	private String reponsec;
	private String reponsed;
	private String bonneReponse;
	private String explication;
	private Date dateCreation = new Date();
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="processGroup_fk")
	@NotNull
	private ProcessGroup processGroup;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="domain_fk")
	@NotNull
	private Domain domain;
	
	@NotNull
	private Complexity complexity;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question( String description) {
		super();
		this.description = description;
		
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
	
	public ProcessGroup getProcessGroup() {
		return processGroup;
	}
	public void setProcessGroup(ProcessGroup processGroup) {
		this.processGroup = processGroup;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public Complexity getComplexity() {
		return complexity;
	}
	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}
	public String getReponsea() {
		return reponsea;
	}
	public void setReponsea(String reponsea) {
		this.reponsea = reponsea;
	}
	public String getReponseb() {
		return reponseb;
	}
	public void setReponseb(String reponseb) {
		this.reponseb = reponseb;
	}
	public String getReponsec() {
		return reponsec;
	}
	public void setReponsec(String reponsec) {
		this.reponsec = reponsec;
	}
	public String getReponsed() {
		return reponsed;
	}
	public void setReponsed(String reponsed) {
		this.reponsed = reponsed;
	}
	public String getBonneReponse() {
		return bonneReponse;
	}
	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}
	public String getExplication() {
		return explication;
	}
	public void setExplication(String explication) {
		this.explication = explication;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
}

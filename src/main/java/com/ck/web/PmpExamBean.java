package com.ck.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ck.entities.PmpExam;
import com.ck.entities.Question;
import com.ck.services.SvcPmpExam;

@Component("pmpExamBean")
@ViewScoped
public class PmpExamBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient SvcPmpExam pmpExamService;
	private PmpExam currentPmpExam = new PmpExam();
	List<Question> questionsExamEnCours;
	List<PmpExam> examList = new ArrayList<PmpExam>();
	private int numQuestion = 0;
	private boolean afficherReponse = false;
	private boolean suivant =false;
	private boolean numeroVisible= false;
	private Question questionEncours;
	String bonneReponse;
	

	
	
	public Question getQuestionEncours() {
		return questionEncours;
	}

	public void setQuestionEncours(Question questionEncours) {
		this.questionEncours = questionEncours;
	}

	public boolean isNumeroVisible() {
		return numeroVisible;
	}

	public void setNumeroVisible(boolean numeroVisible) {
		this.numeroVisible = numeroVisible;
	}

	public void terminer() {
		System.out.println("c terminé");
	}

	public void afficherBonneReponse() {
		if (!afficherReponse) afficherReponse=true;
		else afficherReponse=false;
			
		
		
		
	
		
		
	}

	public boolean isAfficherReponse() {

		return afficherReponse;
	}

	public void setAfficherReponse(boolean afficherReponse) {
		this.afficherReponse = afficherReponse;
	}

	public Question getCurrentQuestion() {
		return questionsExamEnCours.get(numQuestion);
	}

	public void setCurrentQuestion(Question currentQuestion) {
	}

	public int getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}

	public List<PmpExam> getExamList() {
		return examList;
	}

	public void setExamList(List<PmpExam> examList) {
		this.examList = examList;
	}

	public PmpExam getCurrentPmpExam() {
		return currentPmpExam;
	}

	public void setCurrentPmpExam(PmpExam currentPmpExam) {
		this.currentPmpExam = currentPmpExam;
	}

	public List<Question> getQuestionsExamEnCours() {
		return questionsExamEnCours;
	}

	public void setQuestionsExamEnCours(List<Question> questionsExamEnCours) {
		this.questionsExamEnCours = questionsExamEnCours;
	}

	public String creer() {
		try {
			pmpExamService.save(currentPmpExam);
			questionsExamEnCours = pmpExamService.genererExam();
			numeroVisible = true;
			
			System.out.println("c fait");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return "pmpExamCompteur";
		}

		return "pmpExamCompteur";

	}

	@PostConstruct
	public void init() {
		examList = pmpExamService.findAll();

	}

}

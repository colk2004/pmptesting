package com.ck.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ck.entities.Question;
import com.ck.enums.Complexity;
import com.ck.services.SvcDomain;
import com.ck.services.SvcProcessGroup;
import com.ck.services.SvcQuestion;

@Component("questionBean")
@ViewScoped
public class QuestionBean {

	@Autowired
	private transient SvcQuestion questionService;
	@Autowired
	private SvcDomain svcDomaine;
	@Autowired
	private transient SvcProcessGroup processGroupService;

	private List<Question> questionList;

	private List<SelectItem> questions;
	private Question currentQuestion = new Question();
	private Long codDomain;
	private Long codProcessGroup;
	private String description;
	private String bonneReponse;
	private String explication;

	private String reponsea;
	private String reponseb;
	private String reponsec;
	private String reponsed;

	private String complexity;

	public String getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(String bonneResponse) {
		this.bonneReponse = bonneResponse;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExplication() {
		return explication;
	}

	public void setExplication(String explication) {
		this.explication = explication;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public Long getCodDomain() {
		return codDomain;
	}

	public void setCodDomain(Long codDomain) {
		this.codDomain = codDomain;
	}

	public Long getCodProcessGroup() {
		return codProcessGroup;
	}

	public void setCodProcessGroup(Long codProcessGroup) {
		this.codProcessGroup = codProcessGroup;
	}

	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public QuestionBean() {
		super();
		// questionList = questionService.findAll();
	}

	public String viewNew() {
		currentQuestion = new Question();
		return "newPg";
	}

	public String viewDetail() {
		currentQuestion = new Question();
		return "detailPg";
	}

	public String creer() {

		try {
			if (complexity.equals("faible"))
				currentQuestion.setComplexity(Complexity.Low);
			else if (complexity.equals("moyen"))
				currentQuestion.setComplexity(Complexity.Medium);
			else if (complexity.equals("expert"))
				currentQuestion.setComplexity(Complexity.Expert);

			currentQuestion.setDescription(description);

			currentQuestion.setDomain(svcDomaine.findById(codDomain));

			currentQuestion.setProcessGroup(processGroupService.findById(codProcessGroup));

			currentQuestion.setReponsea(reponsea);
			currentQuestion.setReponseb(reponseb);
			currentQuestion.setReponsec(reponsec);
			currentQuestion.setReponsed(reponsed);
			currentQuestion.setBonneReponse(bonneReponse);
			currentQuestion.setExplication(explication);

			questionService.save(currentQuestion);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		questionList = questionService.findAll();

		return "newQuestion";

	}

	public Question rechercher() {
		Question q = new Question();
		q = questionService.findById(currentQuestion.getId());
		System.out.println(q.getDescription());
		System.out.println("bon");
		return q;
	}

	public List<SelectItem> getQuestions() {

		questionList = questionService.findAll();

		questions = new ArrayList<SelectItem>();

		for (Question q : questionList) {

			questions.add(new SelectItem(q.getId(), q.getDescription()));

		}
		;

		return questions;
	}

	@PostConstruct
	public void init() {
		questionList = questionService.findAll();

	}

	public void setQuestions(List<SelectItem> questions) {
		this.questions = questions;
	}

}

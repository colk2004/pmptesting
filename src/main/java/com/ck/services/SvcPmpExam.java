package com.ck.services;

import java.util.ArrayList;
import java.util.List;

import com.ck.entities.PmpExam;
import com.ck.entities.Question;

public interface SvcPmpExam {
	public List<PmpExam> findAll();
	public PmpExam findById(Long id);
	public void save(PmpExam pmpExam);
	public ArrayList<Question> genererExam();

}

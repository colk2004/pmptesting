package com.ck.services;

import java.util.List;

import com.ck.entities.SampleQuestion;

public interface SvcSampleQuestion {
	public List<SampleQuestion> findAll();
	public SampleQuestion findById(Long id);
	public void save(SampleQuestion sampleQuestion);

}

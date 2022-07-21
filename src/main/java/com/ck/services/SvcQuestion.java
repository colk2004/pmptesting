package com.ck.services;

import java.util.List;
import com.ck.entities.Question;

public interface SvcQuestion {
	public List<Question> findAll();
	public Question findById(Long id);
	public void save(Question questionDb);
	
}

package com.ck.services;

import java.util.List;

import com.ck.entities.Domain;

public interface SvcDomain {
	public List<Domain> findAll();
	public Domain findById(Long id);
	public void save(Domain domain);

}

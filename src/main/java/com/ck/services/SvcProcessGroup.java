package com.ck.services;

import java.util.List;

import com.ck.entities.ProcessGroup;

public interface SvcProcessGroup {
	public List<ProcessGroup> findAll();
	public ProcessGroup findById(Long id);
	public void save(ProcessGroup processGroup);

}

package com.ck.services;

import java.util.List;

import com.ck.entities.Role;

public interface SvcRole {
	public List<Role> findAll();
	public Role findById(Long id);
	public void save(Role role);

}

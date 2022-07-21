package com.ck.services;

import java.util.List;

import com.ck.entities.TypeUser;

public interface SvcTypeUser {
	public List<TypeUser> findAll();
	public TypeUser findById(Long id);
	public void save(TypeUser typeUser);

}

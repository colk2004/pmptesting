package com.ck.services;

import java.util.List;

import com.ck.entities.User;

public interface SvcUser {
	public List<User> findAll();
	public User findById(Long id);
	public void save(User user);

}

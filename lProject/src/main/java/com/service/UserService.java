package com.service;

import java.util.List;
import java.util.Optional;

import com.model.User;

public interface UserService {
	
	public List<User> getAll();
	
	public Optional<User> getById(Long id);
	
	public void add(User user);
	
	public Optional<User> update(User user);
	
	public Optional<User> delete(Long id);
	
	
}

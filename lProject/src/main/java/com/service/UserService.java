package com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.model.User;

public interface UserService {
	
	public Page<User> getAll(Pageable pageable);
	
	public Optional<User> getById(Long id);
	
	public void add(User user);
	
	public Optional<User> update(User user);
	
	public Optional<User> delete(Long id);
	
	
}

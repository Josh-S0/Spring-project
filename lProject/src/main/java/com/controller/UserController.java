package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<?> findByCriteria(@RequestParam(name = "criteria", required = true) String criteria, @RequestParam(name = "searchItem", required = true) String searchItem){
		return new ResponseEntity<List<User>>(userService.findByCriteria(criteria, searchItem),HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable){
		
		return new ResponseEntity<Page<User>>(userService.getAll(pageable), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		
		Optional<User> userOpt = userService.getById(id);
		
		if (userOpt.isPresent()) {
			return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user){
		
		userService.add(user);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user){
		
		Optional<User> optUser = userService.update(user);
		if(optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<User> optUser = userService.delete(id);
		
		if(optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
		
	
}

package com.component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersInDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user1 = new User("MyaG",UUID.randomUUID().toString(),"Mya", "Greer", 22, "US");
		User user2 = new User("CarolB", UUID.randomUUID().toString(),"Carolyn","Buckley",24 ,"Canada");
		User user3 = new User("JoeS",UUID.randomUUID().toString() ,"Joe ","Sykes",31 ,"UK");
		User user4 = new User("EvanN",UUID.randomUUID().toString() , "Evan  ","Nixon",53 ,"Wales");
		
		List<User> usersList = Arrays.asList(user1,user2,user3,user4);
		
		usersList = usersList.stream().map(user -> {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return user;
		}).collect(Collectors.toList());
		
		userRepository.saveAll(usersList);

	}
	


}

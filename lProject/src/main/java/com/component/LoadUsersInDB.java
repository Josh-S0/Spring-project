package com.component;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersInDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user1 = new User("Mya", "Greer", 22, "US");
		User user2 = new User("Carolyn","Buckley",24 ,"Canada");
		User user3 = new User("Joe ","Sykes",31 ,"UK");
		User user4 = new User("Evan  ","Nixon",53 ,"Wales");
		
		List<User> usersList = Arrays.asList(user1,user2,user3,user4);
		
		userRepository.saveAll(usersList);

	}
	


}

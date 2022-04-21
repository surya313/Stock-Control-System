package project.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.model.Roles;
import project.springboot.model.User;
import project.springboot.repository.RolesRepository;
import project.springboot.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	public boolean validate(User user) {
		String userName = user.getUserName();
	    String password = user.getPassword();
		Optional<User> optional = userRepository.findById(userName);
		System.out.println("user");
		if(userRepository.existsById(userName) && optional.get().getPassword().matches(password)) {
			return true;
		}
		else
			return false;
	
	}


	public void adminEdit(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}


	public void createUser(User user) {
		Roles roles = rolesRepository.findByName("User");
		user.addRole(roles);
		userRepository.save(user);
		
	}


}

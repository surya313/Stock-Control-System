package project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.springboot.model.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	
}

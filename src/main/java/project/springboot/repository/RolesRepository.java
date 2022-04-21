package project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.springboot.model.Roles;

public interface RolesRepository extends JpaRepository<Roles,Long>{
    
	@Query("SELECT r from Roles r where r.name = ?1")
	Roles findByName(String name);

}

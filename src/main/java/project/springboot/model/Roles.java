package project.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Roles {
	
	@Id
	private Long id;
	
	private String name;
	

	public Roles() {
		
	}
	
	public Roles(String name) {
		this.name = name;
	}
	
	public Roles(Long id) {
		this.id = id;
	}

	public Roles(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

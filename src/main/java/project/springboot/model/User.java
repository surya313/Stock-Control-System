package project.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class User {
	
	
	@Id
	private String userName;
	private String password;
	private String gender;
	private int contactNum;
	private String emailID;
	
	
	
	public User() {
		
	}


	public User(String userName, String password, String gender, int contactNum, String emailID) {
		super();
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.contactNum = contactNum;
		this.emailID = emailID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getContactNum() {
		return contactNum;
	}


	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	@ManyToMany
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			
			)
	
	private Set<Roles> roles = new HashSet<>();


	public Set<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	public void addRole(Roles roles) {
		this.roles.add(roles);
	}
	

}

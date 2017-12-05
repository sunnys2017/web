package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="useraccount")
public class UserAccount {
	
	@Id
    @Column(name="userName")
    @NotEmpty
	@Size(min=1, max=255)
	private String userName;
    
    @Column(name="password")
	@Size(min=1, max=255)
	private String password;
    
    @Column(name="role")
	@Size(min=1, max=255)
	private String role;
    
    @Column(name="ssn")
	@Size(min=1, max=255)
	private String ssn;

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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
}

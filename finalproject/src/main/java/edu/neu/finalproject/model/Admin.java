package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin{

    @Id
    @Column(name="adminID")
	@Size(min=1, max=255)
	private String adminID; //primary key//

    public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	@Column(name="firstName")
	@Size(min=1, max=255)
	private String firstName;
    
    @Column(name="lastName")
	@Size(min=1, max=255)
	private String lastName;
    
    @Column(name="middleName")
	private String middleName;
    
    @Column(name="ssn")
	private String ssn;        
    
    @Column(name="phoneNumber")
	private String phoneNumber;
    
    @Column(name="email")
	private String email;

    

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}

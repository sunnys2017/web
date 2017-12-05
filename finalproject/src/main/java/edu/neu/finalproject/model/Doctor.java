package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="doctor")
public class Doctor {
	
    @Id
    @Column(name="doctorID")
    @NotEmpty
	private String doctorID; //primary key//
    
    @Column(name="department")
    @NotEmpty
	@Size(min=1, max=255)
	private String department;
    
    @Column(name="title") 
	private String title;
    
    @Column(name="availableDate")
	private String availableDate;
    
    @Column(name="availableTime")
	private String availableTime;
    
    @Column(name="doctorVisitFee")
	private String doctorVisitFee;
    
    @Column(name="status")
	private String status;
	
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
    
	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getDoctorVisitFee() {
		return doctorVisitFee;
	}

	public void setDoctorVisitFee(String doctorVisitFee) {
		this.doctorVisitFee = doctorVisitFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

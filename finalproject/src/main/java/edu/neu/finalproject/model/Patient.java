package edu.neu.finalproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="patient")
public class Patient{
	
	@Id
    @Column(name="patientID")
    @NotEmpty
	private String patientID;
	
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
    
    @Column(name="dateOfBirth")
	private String dateOfBirth;
    
    @Column(name="gender")
	private String gender;
    
    @Column(name="marryStatus")
	private String marryStatus;
    
    @Column(name="phoneNumber")
	private String phoneNumber;
    
    @Column(name="email")
	private String email;
    

    @Column(name="address")
	private String address;
    
    @Column(name="zipCode")
	private String zipCode;
    
    
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(String marryStatus) {
		this.marryStatus = marryStatus;
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

	public String getPatientID() {
		return patientID;
	}

	
	
}

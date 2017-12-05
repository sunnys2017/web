package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="appointment")
public class Appointment {
	
    
    @Column(name="doctorID")
	private String doctorID;
    
    
    @Column(name="patientID")
	private String patientID;
    
	
    @Column(name="recordID")
	private String recordID;
    
    @Id
    @Column(name="appointmentID")
    @NotEmpty
	@Size(min=1, max=255)
	private String appointmentID;
    
    @Column(name="date")
	private String date;
    
    @Column(name="location")
	private String location;
    
    @Column(name="time")
	private String time;
    
    @Column(name="doctorLastName")
    private String doctorLastName;
    
    @Column(name="patientLastName")
    private String patientLastName;
    
    @Column(name="status")
    private String status;
    
    @Column(name="appointmentFee")
    private String appointmentFee;
    
    
	public String getAppointmentFee() {
		return appointmentFee;
	}
	public void setAppointmentFee(String appointmentFee) {
		this.appointmentFee = appointmentFee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getRecordID() {
		return recordID;
	}
	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getDoctorLastName() {
		return doctorLastName;
	}
	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	

}

package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="invoice")
public class Invoice {
	
    
    @Column(name="hospitalAddress")
	@Size(min=1, max=255)
	private String hospitalAddress = "HospitalAddress";
    
    @Column(name="invoiceDueDate")
	private String invoiceDueDate = "30d";
	
    @Id
    @Column(name="invoiceID")
    @NotEmpty
    private String invoiceID;
    
    @Column(name="total")
    private String total;
    
    @Column(name="invoiceDate")
    private String invoiceDate;
    
    
    @Column(name="appointmentID")
    private String appointmentID;
    
    @Column(name="note")
    private String note;
    
    @Column(name="status")
    private String status;
    
    @Column(name="patientAddress")
    private String patientAddress;
    
    @Column(name="patientName")
    private String patientName;
    
    @Column(name="appointmentDate")
    private String appointmentDate;
    
    @Column(name="doctorName")
    private String doctorName;

    @Column(name="patientID")
    private String patientID;

    
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getInvoiceDueDate() {
		return invoiceDueDate;
	}
	public void setInvoiceDueDate(String invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	

	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}

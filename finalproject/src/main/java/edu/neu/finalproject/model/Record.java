package edu.neu.finalproject.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="record")
public class Record {
	
    @Id
    @Column(name="recordID")    
    @NotEmpty
	private String recordID;
    
    @Column(name="symptom")
	private String symptom;
	
    @Column(name="diagnosis")
	private String diagnosis;
    
    @Column(name="patientID")
	private String patientID;
    
    @Column(name="doctorID")
	private String doctorID;
    
    @Column(name="recordDate")
	private String recordDate;

    @Column(name="patientName")
	private String patientName;

    
	//private ArrayList<Medicine> medicineList;
    
    
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getRecordID() {
		return recordID;
	}
	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
/*
	public ArrayList<Medicine> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(ArrayList<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	*/
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	

}

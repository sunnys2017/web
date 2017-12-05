package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.Patient;



public interface PatientDAO {
	
    public void addPatient(Patient patient);
    public List<Patient> listPatient();
    public void removePatient(String id);	
    public Patient findPatient(String id);	

}

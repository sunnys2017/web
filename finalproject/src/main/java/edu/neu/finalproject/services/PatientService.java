package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.Patient;

public interface PatientService {
 
    public void addPatient(Patient c);
    public List<Patient> listPatient();
    public void removePatient(String id);
    public Patient findPatient(String id);
}

package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.finalproject.DAOs.PatientDAO;
import edu.neu.finalproject.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
 
    @Autowired
    private PatientDAO patientDAO;
 
    @Transactional
    public void addPatient(Patient a) {
    	patientDAO.addPatient(a);
    }
 
    @Transactional
    public List<Patient> listPatient() {
        return patientDAO.listPatient();
    }
 
    @Transactional
    public void removePatient(String id) {
    	patientDAO.removePatient(id);
    }
    @Transactional
    public Patient findPatient(String id) {
    	return  patientDAO.findPatient(id);	
    }
}

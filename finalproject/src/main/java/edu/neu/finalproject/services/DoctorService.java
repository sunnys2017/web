package edu.neu.finalproject.services;

import java.util.List;

import edu.neu.finalproject.model.Doctor;

public interface DoctorService {
 
    public void addDoctor(Doctor c);
    public List<Doctor> listDoctor();
    public void removeDoctor(String id);
    public Doctor findDoctor(String id);
    public List<Doctor> searchDoctor(String department) ;
}

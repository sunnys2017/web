package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.Doctor;




public interface DoctorDAO {

    public void addDoctor(Doctor doctor);
    public List<Doctor> listDoctor();
    public void removeDoctor(String id);	
    public Doctor findDoctor(String doctorID);
    public List<Doctor> searchDoctor(String department) ;
    
}

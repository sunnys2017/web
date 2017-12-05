package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.neu.finalproject.DAOs.DoctorDAO;
import edu.neu.finalproject.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
 
    @Autowired
    private DoctorDAO doctorDAO;
 
    @Transactional
    public void addDoctor(Doctor a) {
    	doctorDAO.addDoctor(a);
    }
 
    @Transactional
    public List<Doctor> listDoctor() {
        return doctorDAO.listDoctor();
    }
    
    @Transactional
    public List<Doctor> searchDoctor(String department) {
        return doctorDAO.searchDoctor(department);
    }
 
    @Transactional
    public void removeDoctor(String id) {
    	doctorDAO.removeDoctor(id);
    }
    
    @Transactional
    public Doctor findDoctor(String id) {
    	return  doctorDAO.findDoctor(id);	
    }
}

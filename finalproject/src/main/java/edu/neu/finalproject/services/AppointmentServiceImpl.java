package edu.neu.finalproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.finalproject.DAOs.AppointmentDAO;
import edu.neu.finalproject.model.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
 
    @Autowired
    private AppointmentDAO appointmentDAO;
 
    @Transactional
    public void addAppointment(Appointment a) {
    	appointmentDAO.addAppointment(a);
    }
 
    @Transactional
    public List<Appointment> listAppointment() {
 
        return appointmentDAO.listAppointment();
    }
 
    @Transactional
    public void removeAppointment(String id) {
    	appointmentDAO.removeAppointment(id);
    }
    
    @Transactional
    public Appointment findAppointment(String id) {
    	return appointmentDAO.findAppointment(id);
    }
    
    @Transactional
    public List<Appointment> patientAppointment(String patientID) {
        return appointmentDAO.patientAppointment(patientID);
    }
    
    @Transactional
    public List<Appointment> doctorAppointment(String patientID) {
        return appointmentDAO.doctorAppointment(patientID);
    }
}

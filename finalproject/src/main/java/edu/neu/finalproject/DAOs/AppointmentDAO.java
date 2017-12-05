package edu.neu.finalproject.DAOs;

import java.util.List;

import edu.neu.finalproject.model.Appointment;


public interface AppointmentDAO {
	
    public void addAppointment(Appointment appointment);
    public List<Appointment> listAppointment();
    public void removeAppointment(String id);	
    public Appointment findAppointment(String appointmentID);
    public List<Appointment> patientAppointment(String id);
    public List<Appointment> doctorAppointment(String s) ;

}

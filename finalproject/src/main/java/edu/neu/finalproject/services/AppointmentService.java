package edu.neu.finalproject.services;

import java.util.List;


import edu.neu.finalproject.model.Appointment;

public interface AppointmentService {
 
    public void addAppointment(Appointment c);
    public List<Appointment> listAppointment();
    public void removeAppointment(String id);
    public Appointment findAppointment(String id);
    public List<Appointment> patientAppointment(String patientID);
    public List<Appointment> doctorAppointment(String patientID);
}

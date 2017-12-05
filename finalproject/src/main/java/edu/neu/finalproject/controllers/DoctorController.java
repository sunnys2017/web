package edu.neu.finalproject.controllers;


import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.neu.finalproject.model.Appointment;
import edu.neu.finalproject.model.Doctor;
import edu.neu.finalproject.model.Invoice;
import edu.neu.finalproject.model.Patient;
import edu.neu.finalproject.model.Record;
import edu.neu.finalproject.model.UserAccount;
import edu.neu.finalproject.services.AppointmentService;
import edu.neu.finalproject.services.DoctorService;
import edu.neu.finalproject.services.InvoiceService;
import edu.neu.finalproject.services.PatientService;
import edu.neu.finalproject.services.RecordService;
import edu.neu.finalproject.services.UserAccountService;

import java.util.UUID;
/**
 * Handles requests for the application home page.
 */
@Controller
public class DoctorController {

	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	UserAccountService userAccountService;
	@Autowired
	PatientService patientService;
	@Autowired
	RecordService recordService;	
	/**
	 * Simply selects the home view to render by returning its name.
	 */


	//doctor review appointment---------------------------------------------------------------
	
	@RequestMapping(value = "doctor/manageDoctorAppointments", method = RequestMethod.GET)
	public String manageDoctorAppointments(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	String s =(String)session.getAttribute("userName");
    	UserAccount ua= userAccountService.findUserAccount(s);
    	
    	String userID = ua.getSsn();
        Doctor d = doctorService.findDoctor(userID);
    	String doctorID = d.getDoctorID();
		map.put("appointment", new Appointment());
		map.put("appointmentList", appointmentService.doctorAppointment(doctorID));
		return "doctor/manageDoctorAppointments";
	}
	
	
	
	
	//doctor update appointment---------------------------------------------------------------
    @RequestMapping("/doctor/updateAppointment/{appointmentID}" )
    public String updateAppointment(@PathVariable("appointmentID") String appointmentID,Map<String, Object> map,HttpServletRequest request ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	Appointment appointment = appointmentService.findAppointment(appointmentID);
    	map.put("appointment", appointment);

        return "doctor/updateAppointment";
    }
    
    @RequestMapping("renewAppointment/{appointmentID}" )
    public String renewAppointment(@PathVariable("appointmentID") String appointmentID,Map<String, Object> map,HttpServletRequest request,Appointment appointment ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
        Appointment app = appointmentService.findAppointment(appointmentID);
        
    	if(app.getStatus().equals("accepted")||app.getStatus().equals("Accepted")){
    		return "doctor/updateAppointment";
    	}
    	
    	String id = app.getAppointmentID();
    	String patientID = app.getPatientID();
    	String patientLastName= app.getPatientLastName();
    	String doctorLastName= app.getDoctorLastName();
    	String appointmentFee = app.getAppointmentFee();
    	String doctorID = app.getDoctorID();
    	String recordID = app.getRecordID();
    	
    	appointment.setAppointmentID(id);
    	appointment.setStatus("accepted");
    	appointment.setAppointmentFee(appointmentFee);
    	appointment.setDoctorID(doctorID);
    	appointment.setDoctorLastName(doctorLastName);
    	appointment.setPatientID(patientID);
    	appointment.setPatientLastName(patientLastName);
    	appointment.setRecordID(recordID);
    	
    	appointmentService.removeAppointment(appointmentID);
    	appointmentService.addAppointment(appointment);
    	
    	map.put("appointment", appointment);
        
        //if the appointment is renewed, it can't be updated again. so invoice can be generated once.
    	Invoice invoice = new Invoice();
    	UUID uuid = UUID.randomUUID();
    	invoice.setAppointmentDate(appointment.getDate());
    	invoice.setAppointmentID(appointment.getAppointmentID());
    	invoice.setDoctorName(doctorLastName);
    	invoice.setHospitalAddress("ABC Hospital,123Rd,Boston,MA ");
    	invoice.setInvoiceDate(appointment.getDate());
    	invoice.setInvoiceDueDate("30days");
    	invoice.setInvoiceID(uuid.toString());
    	invoice.setNote("DoctorVisitFee");
    	Patient p = patientService.findPatient(patientID);
    	invoice.setPatientAddress(p.getAddress());
    	invoice.setPatientID(patientID);
    	invoice.setPatientName(patientLastName);
    	invoice.setStatus("unpaid");
    	invoice.setTotal(appointmentFee);
    	invoiceService.addInvoice(invoice);

        return "doctor/updateAppointment";
    }
  
/*
    @RequestMapping(value = "doctor/updateAppointment", method = RequestMethod.GET)
    public String updateDoctorAppointment(Map<String, Object> map,HttpServletRequest request ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	request.removeAttribute("appointment");
    
        return "doctor/updateAppointment";
    }
  */
    
  //doctor update profile--------------------------------------------------------------- 
	@RequestMapping(value = "doctor/manageDoctorProfile", method = RequestMethod.GET)
	public String manageDoctorProfile(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	String userName = (String)session.getAttribute("userName");
    	UserAccount ua = userAccountService.findUserAccount(userName);
    	System.out.println(ua.getUserName());
    	Doctor doctor = doctorService.findDoctor(ua.getSsn());
    	System.out.println(doctor.getDoctorID());
    	map.put("doctor", doctor);
		return "doctor/manageDoctorProfile";
	}
	
	@RequestMapping("updateDoctorProfile/{doctorID}" )
    public String updateAdminProfile(@PathVariable("doctorID") String doctorID,Map<String, Object> map,HttpServletRequest request,Doctor doc ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	Doctor doctorOriginal = doctorService.findDoctor(doctorID);
    	
    	Doctor atemp = new Doctor();
    	if(doc.getFirstName()!=""){atemp.setFirstName(doc.getFirstName());}
    	else{atemp.setFirstName(doctorOriginal.getFirstName());}
    	System.out.println(atemp.getFirstName());
    	
    	if(doc.getMiddleName()!=""){
    		atemp.setMiddleName(doc.getMiddleName());
    	}else{atemp.setMiddleName(doctorOriginal.getMiddleName());}
    	System.out.println(atemp.getMiddleName());
    	
    	if(doc.getLastName()!=""){
    		atemp.setLastName(doc.getLastName());
    	}else{atemp.setLastName(doctorOriginal.getLastName());}
    	System.out.println(atemp.getLastName());
    	
    	if(doc.getPhoneNumber()!=""){
    		atemp.setPhoneNumber(doc.getPhoneNumber());
    	}else{atemp.setPhoneNumber(doctorOriginal.getPhoneNumber());}
    	System.out.println(atemp.getPhoneNumber());
    	
    	if(doc.getEmail()!=""){
    		atemp.setEmail(doc.getEmail());
    	}else{atemp.setEmail(doctorOriginal.getEmail());}
    	System.out.println(atemp.getEmail());
    	
    	if(doc.getSsn()!=""){
    		atemp.setSsn(doc.getSsn());
    	}else{atemp.setSsn(doctorOriginal.getSsn());}
    	System.out.println(atemp.getSsn());
    	
    	if(doc.getDepartment()!=""){
    		atemp.setDepartment(doc.getDepartment());
    	}else{atemp.setDepartment(doctorOriginal.getDepartment());}
    	System.out.println(atemp.getDepartment());
    	
    	if(doc.getTitle()!=""){
    		atemp.setTitle(doc.getTitle());
    	}else{atemp.setTitle(doctorOriginal.getTitle());}
    	System.out.println(atemp.getTitle());
    	
    	if(doc.getDoctorVisitFee()!=""){
    		atemp.setDoctorVisitFee(doc.getDoctorVisitFee());
    	}else{atemp.setDoctorVisitFee(doctorOriginal.getDoctorVisitFee());}
    	System.out.println(atemp.getDoctorVisitFee());
    	
    	if(doc.getStatus()!=""){
    		atemp.setStatus(doc.getStatus());
    	}else{atemp.setStatus(doctorOriginal.getStatus());}
    	System.out.println(atemp.getStatus());
    	
    	if(doc.getAvailableDate()!=""){
    		atemp.setAvailableDate(doc.getAvailableDate());
    	}else{atemp.setAvailableDate(doctorOriginal.getAvailableDate());}
    	System.out.println(atemp.getAvailableDate());
    	
    	if(doc.getAvailableTime()!=""){
    		atemp.setAvailableTime(doc.getAvailableTime());
    	}else{atemp.setAvailableTime(doctorOriginal.getAvailableTime());}
    	System.out.println(atemp.getAvailableTime());
    	
    	atemp.setDoctorID(doctorID);
    	doctorService.removeDoctor(doctorID);
    	doctorService.addDoctor(atemp);
    	
        return "redirect:/doctor/manageDoctorProfile";
    }
	/*
    @RequestMapping("/updateRecord/{recordID}" )
    public String updateRecord(@PathVariable("recordID") String recordID,Map<String, Object> map,HttpServletRequest request ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}

    	Record record = recordService.findRecord(recordID);
    	System.out.println(record.getRecordID()+"good");
    	map.put("record", record);

        return "doctor/updateRecord";
    }*/
    @RequestMapping("/doctor/updateRecord/{recordID}" )
    public String doctorUpdateRecord(@PathVariable("recordID") String recordID,Map<String, Object> map,HttpServletRequest request ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	Record record = recordService.findRecord(recordID);
    	System.out.println(record.getRecordID()+"bad");
    	map.put("record", record);

        return "doctor/updateRecord";
    }
    
    @RequestMapping("/renewRecord/{recordID}" )
    public String renewRecord(@PathVariable("recordID") String recordID,Map<String, Object> map,HttpServletRequest request,Record record1 ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
        Record app = recordService.findRecord(recordID);
        
        String symptom = record1.getSymptom();
        String diagnosis = record1.getDiagnosis();
        Record rec = new Record();
        rec.setDiagnosis(diagnosis);
        rec.setSymptom(symptom);
        rec.setRecordID(app.getRecordID());
        rec.setDoctorID(app.getDoctorID());
        rec.setPatientID(app.getPatientID());
        rec.setPatientName(app.getPatientName());
        Date date = new Date();
        record1.setPatientID(app.getPatientID());
        record1.setPatientName(app.getPatientName());
        record1.setRecordDate(date.toString());
        rec.setRecordDate(date.toString());
        System.out.print(rec.getPatientID());
        recordService.removeRecord(recordID);
        recordService.addRecord(rec);
    	
        return "doctor/updateRecord";
    }
    

}

package edu.neu.finalproject.controllers;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PatientController {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
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

	//patient find a doctor, and make appointment.----------------------------------------------
		@RequestMapping(value = "/patient/findDoctors", method = RequestMethod.GET)
		public String findDoctors(HttpServletRequest request,Map<String, Object> map,Model model) {
			HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	map.put("doctor", new Doctor());
			map.put("doctorList", doctorService.listDoctor());
			return "patient/findDoctors";	
		}
		
    //------------------------------------------------------------------------------------ 
   
/*
	@RequestMapping(value = "/patientFindDepDoctors", method = RequestMethod.POST)
	public String patientFindDepDoctors(Doctor doctor,Map<String, Object> map,HttpServletRequest request) {
		String department = doctor.getDepartment();
		System.out .println(department);
		request.setAttribute("department",department);
		//List<Doctor> list = doctorService.searchDoctor(department);
		
		//System.out .println(list.size());
		//map.put("doctorList",new Doctor());
		//map.put("doctorList",list);
		
		map.remove("doctor");map.remove("doctorList");
    	
		if(request.getAttribute("department")==null||request.getAttribute("department").equals("--Select--")){
			map.put("doctor", new Doctor());
			map.put("doctorList", doctorService.listDoctor());
		}else{
			List<Doctor> list = doctorService.searchDoctor(department);
			map.put("doctor",new Doctor());
			map.put("doctorList",list);
		}
		return "/patient/findDoctors";
	}
	*/    
	    @RequestMapping("/dateDoctor/{doctorId}" )
	    public String dateDoctor(@PathVariable("doctorId") String doctorId, HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	
	    	System.out.println(doctorId);
	    	Doctor d = doctorService.findDoctor(doctorId);
	    	//System.out.println(d.getDoctorID());
	    	System.out.println(d.getFirstName());
	    	Appointment appointment = new Appointment();
	    	UUID uuid = UUID.randomUUID();
	    	appointment.setDoctorID(d.getDoctorID());
	    	appointment.setDoctorLastName(d.getFirstName()+","+d.getLastName());
	    	appointment.setAppointmentID(uuid.toString());
	    	appointment.setAppointmentFee(d.getDoctorVisitFee());
	    	
	    	String s =(String)session.getAttribute("userName");
	    	UserAccount ua= userAccountService.findUserAccount(s);
	    	String userID = ua.getSsn();
	    	System.out.println(userID);
	    	Patient p = patientService.findPatient(userID);
	    	System.out.println(p.getFirstName());
	    	
	    	appointment.setPatientID(userID);
	    	appointment.setPatientLastName(p.getFirstName()+","+p.getLastName());
	    	appointment.setStatus("Applying");
	    	
	    	Record record = new Record();
	    	UUID uuidR = UUID.randomUUID();
	    	record.setRecordID(uuidR.toString());
	    	record.setPatientID(userID);
	    	record.setDoctorID(d.getDoctorID());
	    	record.setPatientName(p.getFirstName()+","+p.getLastName());
	    	Date date = new Date();
	    	record.setRecordDate(date.toString());
	    	recordService.addRecord(record);
	    	
	    	appointment.setRecordID(uuidR.toString());
	    	appointmentService.addAppointment(appointment);
	    	
	        return "redirect:/patient/reviewAppointments";
	    }
	//patient review doctor's detail and can also make appointment here.
	    @RequestMapping("/reviewDoctor/{doctorId}" )
	    public String deleteDoctor(@PathVariable("doctorId") String doctorId, Map<String, Object> map,HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	Doctor d = doctorService.findDoctor(doctorId);
	    	map.put("doctor",d);
	        return "patient/reviewDoctor";
	    }	
    
	//patient review appointments.------------------------------------------------------------
		@RequestMapping(value = "patient/reviewAppointments", method = RequestMethod.GET)
		public String reviewAppointments(Map<String, Object> map,HttpServletRequest request) {
			HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	String s =(String)session.getAttribute("userName");
	    	UserAccount ua= userAccountService.findUserAccount(s);
	    	String userID = ua.getSsn();
	    	Patient p = patientService.findPatient(userID);
	    	String patientID = p.getPatientID();
	    	//System.out.print(patientID);//
			map.put("appointment", new Appointment());
			map.put("appointmentList", appointmentService.patientAppointment(patientID));
			return "patient/reviewAppointments";
		}
	
	//patient delete unaccepted appointments.-----------------------------------------------------
	    @RequestMapping("/deleteAppointment/{appointmentId}" )
	    public String deleteAppointment(@PathVariable("appointmentId") String appointmentId,HttpServletRequest request) {
	    	HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	
	    	Appointment a = appointmentService.findAppointment(appointmentId);
	    	if(a.getStatus().equals("accepted")||a.getStatus().equals("Accepted")){
	    		return "redirect:/patient/reviewAppointments";
	    	}
	    	String recordID = a.getRecordID();
	    	appointmentService.removeAppointment(appointmentId);
	    	recordService.removeRecord(recordID);
	        return "redirect:/patient/reviewAppointments";
	    }

	//patient review invoices.----------------------------------------------------------------
		@RequestMapping(value = "patient/reviewInvoice", method = RequestMethod.GET)
		public String reviewInvoices(Map<String, Object> map,HttpServletRequest request) {
			HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	String s =(String)session.getAttribute("userName");
	    	UserAccount ua= userAccountService.findUserAccount(s);
	    	String userID = ua.getSsn();
	    	System.out.println(userID);
	    	Patient p = patientService.findPatient(userID);
	    	String patientID = p.getPatientID();
	    	System.out.println(p.getPatientID()+"good");
	    	
			map.put("invoice", new Invoice());
			map.put("invoiceList", invoiceService.patientInvoice(patientID));
			return "patient/reviewInvoice";
		}
	//patient manage profile.----------------------------------------------------------------
		@RequestMapping(value = "patient/manageProfile", method = RequestMethod.GET)
		public String manageProfile(Map<String, Object> map,HttpServletRequest request) {
			HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}
	    	String userName = (String)session.getAttribute("userName");
	    	UserAccount ua = userAccountService.findUserAccount(userName);
	    	System.out.println(ua.getUserName());
	    	Patient patient = patientService.findPatient(ua.getSsn());
	    	System.out.println(patient.getPatientID());
	    	map.put("patient", patient);
			
			return "patient/manageProfile";
		}
		
		@RequestMapping("/updatePatientProfile/{patientID}")
		public String updatePatientProfile(@PathVariable("patientID") String patientID,Patient pa,Map<String, Object> map, HttpServletRequest request) { 
			HttpSession session = request.getSession();
	    	if(session.getAttribute("userName")==null){
	    		return "redirect:/login";
	    	}

	    	Patient patientOriginal = patientService.findPatient(patientID);
	    	System.out.println(patientOriginal.getFirstName());
	    	
	    	Patient atemp = new Patient();
	    	if(pa.getFirstName()!=""){atemp.setFirstName(pa.getFirstName());}
	    	else{atemp.setFirstName(patientOriginal.getFirstName());}
	    	System.out.println(atemp.getFirstName());
	    	
	    	if(pa.getMiddleName()!=""){
	    		atemp.setMiddleName(pa.getMiddleName());
	    	}else{atemp.setMiddleName(patientOriginal.getMiddleName());}
	    	System.out.println(atemp.getMiddleName());
	    	
	    	if(pa.getLastName()!=""){
	    		atemp.setLastName(pa.getLastName());
	    	}else{atemp.setLastName(patientOriginal.getLastName());}
	    	System.out.println(atemp.getLastName());
	    	
	    	if(pa.getPhoneNumber()!=""){
	    		atemp.setPhoneNumber(pa.getPhoneNumber());
	    	}else{atemp.setPhoneNumber(patientOriginal.getPhoneNumber());}
	    	System.out.println(atemp.getPhoneNumber());
	    	
	    	if(pa.getEmail()!=""){
	    		atemp.setEmail(pa.getEmail());
	    	}else{atemp.setEmail(patientOriginal.getEmail());}
	    	System.out.println(atemp.getEmail());
	    	
	    	if(pa.getSsn()!=""){
	    		atemp.setSsn(pa.getSsn());
	    	}else{atemp.setSsn(patientOriginal.getSsn());}
	    	System.out.println(atemp.getSsn());
	    	
	    	if(pa.getGender()!=""){
	    		atemp.setGender(pa.getGender());
	    	}else{atemp.setGender(patientOriginal.getGender());}
	    	System.out.println(atemp.getGender());
	    	
	    	if(pa.getMarryStatus()!=""){
	    		atemp.setMarryStatus(pa.getMarryStatus());
	    	}else{atemp.setMarryStatus(patientOriginal.getMarryStatus());}
	    	System.out.println(atemp.getMarryStatus());
	    	
	    	if(pa.getAddress()!=""){
	    		atemp.setAddress(pa.getAddress());
	    	}else{atemp.setAddress(patientOriginal.getAddress());}
	    	System.out.println(atemp.getAddress());
	    	
	    	if(pa.getZipCode()!=""){
	    		atemp.setZipCode(pa.getZipCode());
	    	}else{atemp.setZipCode(patientOriginal.getZipCode());}
	    	System.out.println(atemp.getZipCode());
	    	
	    	if(pa.getDateOfBirth()!=""){
	    		atemp.setDateOfBirth(pa.getDateOfBirth());
	    	}else{atemp.setDateOfBirth(patientOriginal.getDateOfBirth());}
	    	System.out.println(atemp.getDateOfBirth());
	    	
	    	atemp.setPatientID(patientID);
	    	patientService.removePatient(patientID);
	    	patientService.addPatient(atemp);
	    	
	        return "redirect:/patient/manageProfile";
	        
			
		}

}

package edu.neu.finalproject.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neu.finalproject.model.Admin;
import edu.neu.finalproject.model.Doctor;
import edu.neu.finalproject.model.Invoice;
import edu.neu.finalproject.model.Patient;
import edu.neu.finalproject.model.UserAccount;
import edu.neu.finalproject.services.AdminService;
import edu.neu.finalproject.services.AppointmentService;
import edu.neu.finalproject.services.DoctorService;
import edu.neu.finalproject.services.InvoiceService;
import edu.neu.finalproject.services.PatientService;
import edu.neu.finalproject.services.UserAccountService;




/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	AdminService adminService;
	@Autowired
	InvoiceService invoiceService;
	//@Autowired
	//MedicineService m;
	@Autowired
	PatientService patientService;
	//@Autowired
	//RecordService r;
	@Autowired
	UserAccountService userAccountService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String history(Locale locale, Model model) {
		return "history";
	}
	@RequestMapping(value = "/research", method = RequestMethod.GET)
	public String research(Locale locale, Model model) {
		return "research";
	}
	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String contactUs(Locale locale, Model model) {
		return "contactUs";
	}
	@RequestMapping(value = "/healthPlans", method = RequestMethod.GET)
	public String healthPlans(Locale locale, Model model) {
		return "healthPlans";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		//test use only
		//System.out.println(a.listAppointment().size());
		//System.out.println(d.listDoctor().size());
		//System.out.println(i.listInvoice().size());
		//System.out.println(m.listMedicine().size());
		//System.out.println(p.listPatient().size());
		//System.out.println(r.listRecord().size());
		//System.out.println(ua.listUserAccount().size());
		return "login";
	}
	@RequestMapping(value = "/adminView", method = RequestMethod.GET)
	public String adminView(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	return "adminView";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "register";
	}
	@RequestMapping(value = "/patientView", method = RequestMethod.GET)
	public String patientView(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	return "patientView";
	}
	@RequestMapping(value = "/doctorView", method = RequestMethod.GET)
	public String doctorView(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	return "doctorView";
	}
	@RequestMapping(value = "/searchDoctors", method = RequestMethod.GET)
	public String searchDoctors(Locale locale, Model model) {
		return "searchDoctors";
	}
	//---------------------show person's name of the useraccount------------------
	@RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
	public @ResponseBody String getcustomer(Locale locale, Model model,String q) {
		String name ="";
		Patient pat=patientService.findPatient(q);
		if(pat!=null){
			name=pat.getFirstName()+","+pat.getLastName();
			System.out.print(name);
			return name;
		};
		Admin adm = adminService.findAdmin(q);
		if(adm!=null){
			name=adm.getFirstName()+","+adm.getLastName();
			System.out.print(name);
			return name;
		};
		Doctor doc =doctorService.findDoctor(q);
		if(doc!=null){
			name=doc.getFirstName()+","+doc.getLastName();
			System.out.print(name);
			return name;
		};
		System.out.print(name);
		return name;
	}
	//--------------------------------------------for test use only--------
	//for admin view links.
	//admin/managerdoctors.-----------------------------------------------------------------
	@RequestMapping(value = "admin/manageDoctors", method = RequestMethod.GET)
	public String manageDocotors(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
		
		map.put("doctor", new Doctor());
		map.put("doctorList", doctorService.listDoctor());
		return "admin/manageDoctors";
	}
	
    @RequestMapping("/deleteDoctor/{doctorId}" )
    public String deleteDoctor(@PathVariable("doctorId") String doctorId,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	doctorService.removeDoctor(doctorId);
   	    //remove relate useraccounts of doctors.
        userAccountService.searchUAListByEntID(doctorId);
        return "redirect:/admin/manageDoctors";
    }
    
    @RequestMapping(value ="/addDoctor",method = RequestMethod.POST)
    public String addDoctor(Doctor doctor,Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	UUID uuid = UUID.randomUUID(); 
    	doctor.setDoctorID(uuid.toString());
    	doctorService.addDoctor(doctor);
		map.put("doctor", new Doctor());
		map.put("doctorList", doctorService.listDoctor());
        return "redirect:/admin/manageDoctors";
    }
    
    //admin manage invoices.-----------------------------------------------------------
	@RequestMapping(value = "admin/manageInvoices", method = RequestMethod.GET)
	public String manageInvoices(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
		//Iterator<Invoice> it= invoiceService.listInvoice().iterator();
		//model.addAttribute("invoiceAll", it);
		map.put("invoice", new Invoice());
		map.put("invoiceList", invoiceService.listInvoice());
		return "admin/manageInvoices";
	}
    @RequestMapping("/deleteInvoice/{invoiceId}" )
    public String deleteInvoice(@PathVariable("invoiceId") String invoiceId) {
    	invoiceService.removeInvoice(invoiceId);
        return "redirect:/admin/manageInvoices";
    }
	
	//admin manage useraccounts.------------------------------------------------------------
	@RequestMapping(value = "admin/manageUserAccounts", method = RequestMethod.GET)
	public String manageUserAccounts(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	map.put("userAccount", new UserAccount());
		map.put("userAccountList", userAccountService.listUserAccount());
		map.put("patient", new Patient());
		map.put("patientList", patientService.listPatient());
		map.put("admin", new Admin());
		map.put("adminList", adminService.listAdmin());
		map.put("doctor", new Doctor());
		map.put("doctorList", doctorService.listDoctor());
		return "admin/manageUserAccounts";
	}
    @RequestMapping("/deleteUserAccount/{userName}" )
    public String deleteUserAccount(@PathVariable("userName") String userName,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	userAccountService.removeUserAccount(userName);
        return "redirect:/admin/manageUserAccounts";
    }
    
    @RequestMapping(value ="/addUserAccount",method = RequestMethod.POST)
    public String addUserAccount(UserAccount userAccount,Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	boolean flag = userAccountService.checkUserName(userAccount.getUserName());
    	if(flag==true){
    		return "redirect:/admin/manageUserAccounts";
    	}
    	System.out.println(userAccount.getSsn());
    	userAccountService.addUserAccount(userAccount);
		map.put("userAccount", new UserAccount());
		map.put("userAccountList", userAccountService.listUserAccount());
        return "redirect:/admin/manageUserAccounts";
    }

    /*
	private boolean authFirst(UserAccount uaInput){
		boolean flag = false;
		for (UserAccount uaOutput:userAccountService.listUserAccount()){
		   if(uaInput.getUserName().equalsIgnoreCase(uaOutput.getUserName())){
			   flag=true;
			   return flag;
		   }
		}   
		return flag;
	}
	*/
	//admin manage patients.-------------------------------------------------------------
	@RequestMapping(value = "admin/managePatients", method = RequestMethod.GET)
	public String managePatients(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
		map.put("patient", new Patient());
		map.put("patientList", patientService.listPatient());
		return "admin/managePatients";
	}
    @RequestMapping("/deletePatient/{patientID}" )
    public String deletePatient(@PathVariable("patientID") String patientID) {
    	patientService.removePatient(patientID);
    	 //remove relate useraccounts of patients.
        userAccountService.searchUAListByEntID(patientID);
        return "redirect:/admin/managePatients";
    }
    @RequestMapping(value ="/addPatient",method = RequestMethod.POST)
    public String addPatient(Patient patient,Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	UUID uuid = UUID.randomUUID(); 
    	patient.setPatientID(uuid.toString());
    	patientService.addPatient(patient);
		map.put("patient", new Patient());
		map.put("patientList", patientService.listPatient());
        return "redirect:/admin/managePatients";
    }
    
	//admin manage admin employees.-----------------------------------------------------------
	@RequestMapping(value = "admin/manageAdmins", method = RequestMethod.GET)
	public String manageAdmins(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	map.put("admin", new Admin());
		map.put("adminList", adminService.listAdmin());
		return "admin/manageAdmins";
	}
    @RequestMapping("/deleteAdmin/{adminID}" )
    public String deleteAdmin(@PathVariable("adminID") String adminID,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	adminService.removeAdmin(adminID);
        //remove relate useraccounts of admin.
        userAccountService.searchUAListByEntID(adminID);
        return "redirect:/admin/manageAdmins";
    }
    @RequestMapping(value ="/addAdmin",method = RequestMethod.POST)
    public String addAdmin(Admin admin,Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	UUID uuid = UUID.randomUUID(); 
    	admin.setAdminID(uuid.toString());
    	adminService.addAdmin(admin);
		map.put("admin", new Admin());
		map.put("adminList", adminService.listAdmin());
        return "redirect:/admin/manageAdmins";
    }
    
    //admin manage own profile and update.-----------------------------------------------------
	@RequestMapping(value = "admin/manageProfile", method = RequestMethod.GET)
	public String manageAdminProfile(Map<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	String userName = (String)session.getAttribute("userName");
    	UserAccount ua = userAccountService.findUserAccount(userName);
    	System.out.println(ua.getUserName());
    	Admin admin = adminService.findAdmin(ua.getSsn());
    	System.out.println(admin.getAdminID());
    	map.put("admin", admin);
		return "admin/manageProfile";
	}
	
    @RequestMapping("updateAdminProfile/{adminID}" )
    public String updateAdminProfile(@PathVariable("adminID") String adminID,Map<String, Object> map,HttpServletRequest request,Admin admin1 ) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("userName")==null){
    		return "redirect:/login";
    	}
    	Admin adminOriginal = adminService.findAdmin(adminID);
    	
    	Admin atemp = new Admin();
    	if(admin1.getFirstName()!=""){atemp.setFirstName(admin1.getFirstName());}
    	else{atemp.setFirstName(adminOriginal.getFirstName());}
    	System.out.println(atemp.getFirstName());
    	
    	if(admin1.getMiddleName()!=""){
    		atemp.setMiddleName(admin1.getMiddleName());
    	}else{atemp.setMiddleName(adminOriginal.getMiddleName());}
    	System.out.println(atemp.getMiddleName());
    	
    	if(admin1.getLastName()!=""){
    		atemp.setLastName(admin1.getLastName());
    	}else{atemp.setLastName(adminOriginal.getLastName());}
    	System.out.println(atemp.getLastName());
    	
    	if(admin1.getPhoneNumber()!=""){
    		atemp.setPhoneNumber(admin1.getPhoneNumber());
    	}else{atemp.setPhoneNumber(adminOriginal.getPhoneNumber());}
    	System.out.println(atemp.getPhoneNumber());
    	
    	if(admin1.getEmail()!=""){
    		atemp.setEmail(admin1.getEmail());
    	}else{atemp.setEmail(adminOriginal.getEmail());}
    	System.out.println(atemp.getEmail());
    	
    	if(admin1.getSsn()!=""){
    		atemp.setSsn(admin1.getSsn());
    	}else{atemp.setSsn(adminOriginal.getSsn());}
    	System.out.println(atemp.getSsn());
    	
    	atemp.setAdminID(adminID);
    	adminService.removeAdmin(adminID);
    	adminService.addAdmin(atemp);
    	
        return "redirect:/admin/manageProfile";
    }
    //------------------------------------------------------------------------------------ 
   
	//any user an search doctors without login.
	@RequestMapping(value = "/findDepDoctors", method = RequestMethod.POST)
	public String findDepDoctors(Doctor doctor,Map<String, Object> map) {
		String department = doctor.getDepartment();
		System.out .println(department);
		List<Doctor> list = doctorService.searchDoctor(department);
		
		System.out .println(list.size());
		map.put("doctorList",new Doctor());
		map.put("doctorList",list);
		return "searchDoctors";
	}	
	
	//------------------------------------------------------------------------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		//session.removeAttribute("password");
		return "home";
	}

}

package edu.neu.finalproject.controllers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.neu.finalproject.model.Admin;
import edu.neu.finalproject.model.Doctor;
import edu.neu.finalproject.model.Patient;
import edu.neu.finalproject.model.UserAccount;
import edu.neu.finalproject.services.AdminService;
import edu.neu.finalproject.services.DoctorService;
import edu.neu.finalproject.services.PatientService;
import edu.neu.finalproject.services.UserAccountService;

import java.util.UUID;
/**
 * Handles requests for the application home page.
 */
@Controller
public class RequestController {

	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	String ssn;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private AdminService adminService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/submitREG", method = RequestMethod.POST)
	public String submitREG(UserAccount ua,Patient pa,Map<String, Object> map, HttpServletRequest request) { 
		if(pa.getEmail()==null){
			return "register";
		}
        //boolean flag = authUA(ua);
		String userName = pa.getEmail();
		boolean flag = userAccountService.checkUserName(userName);
        if(flag ==true){
        	return "register";
        }

		UUID uuid = UUID.randomUUID(); 
		pa.setPatientID(uuid.toString());
		ua.setRole("patient");
		ua.setSsn(pa.getPatientID());
		ua.setUserName(userName);
		
        patientService.addPatient(pa);
        userAccountService.addUserAccount(ua);
        
        String userNameS = ua.getUserName();
        //String passwordS = ua.getPassword();
        HttpSession session = request.getSession();
        if (session.getAttribute("userName")!=null){
        	session.removeAttribute("userName");
        }
        if (session.getAttribute("password")!=null){
        	session.removeAttribute("password");
        }
        session.setAttribute("userName", userNameS);
        //session.setAttribute("password", passwordS);
        
        map.put("patient",pa);
        
		return "patientView";
	}
	
	//BELOW IS USED FOR TRYING AJAX.
	//--------------------------------------------------------------------------------
		
	@RequestMapping(value = "/authenticateAJAX", method = RequestMethod.POST)
	public  @ResponseBody String authenticateAJAX(HttpServletRequest request, UserAccount ua,Map<String, Object> map) {
        if(ua==null){
        	return  "false";
        }
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("userName")!=null){
        	session.removeAttribute("userName");
        }
        if (session.getAttribute("password")!=null){
        	session.removeAttribute("password");
        }
        
        String userNameCheck = ua.getUserName();
        String passwordCheck = ua.getPassword();
        boolean flag1 = userAccountService.checkUserAccount(userNameCheck, passwordCheck);
        System.out.println(flag1);
        if(flag1==false){
        	return "false";
        }
		return "true";
		
	}
	//ABOVE IS USED FOR TRYING AJAX.
	//--------------------------------------------------------------------------------
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request, UserAccount ua,Map<String, Object> map) {
        if(ua==null){
        	return "login";
        }
        
        //record username and password in session.
        HttpSession session = request.getSession();
        
        if (session.getAttribute("userName")!=null){
        	session.removeAttribute("userName");
        }
        if (session.getAttribute("password")!=null){
        	session.removeAttribute("password");
        }

        //boolean flag1= authFirst(ua);
        String userNameCheck = ua.getUserName();
        String passwordCheck = ua.getPassword();
        boolean flag1 = userAccountService.checkUserAccount(userNameCheck, passwordCheck);
        System.out.println(flag1);
        if(flag1==false){
        	return "login";
        }
        
        //UserAccount uu = auth(ua);
        UserAccount uu = userAccountService.findUserAccount(userNameCheck);
        session.setAttribute("userName", uu.getUserName());
        //session.setAttribute("password", uu.getPassword());

        //System.out.println(uu.getRole());
        
        //anthenticate the username and password and pass to related page.
        if (uu.getRole().equals("patient")){
        	Patient pa = patientService.findPatient(uu.getSsn());
        	map.put("patient",pa);
        	map.put("userAccount", uu);
        	return "patientView";
        }
        if (uu.getRole().equalsIgnoreCase("doctor")){
        	Doctor doc = doctorService.findDoctor(uu.getSsn());
        	map.put("doctor",doc);
        	map.put("userAccount", uu);
        	return "doctorView";
        }
        if (uu.getRole().equalsIgnoreCase("admin")){
        	Admin adm = adminService.findAdmin(uu.getSsn());
        	map.put("admin",adm);
        	map.put("userAccount", uu);
        	return "adminView";
        }
		return "login";
		
	}
	
	
	/*user to check the username/password, but changed to DBservice check.
	private boolean authFirst(UserAccount uaInput){
		boolean flag = false;
		for (UserAccount uaOutput:userAccountService.listUserAccount()){
		   if(uaInput.getUserName().equalsIgnoreCase(uaOutput.getUserName())
				   &&uaInput.getPassword().equalsIgnoreCase(uaOutput.getPassword())){
			   flag=true;
			   return flag;
		   }
		}   
		return flag;
	}
	*/
	private boolean authUA(UserAccount uaInput){
		boolean flag = false;
		for (UserAccount uaOutput:userAccountService.listUserAccount()){
		   if(uaInput.getUserName().equalsIgnoreCase(uaOutput.getUserName())){
			   flag=true;
			   return flag;
		   }
		}   
		return flag;
	}
	
	/*used to get username/password before daoservice valid.
	private UserAccount auth(UserAccount uaInput){
		for (UserAccount uaOutput:userAccountService.listUserAccount()){
		   if(uaInput.getUserName().equalsIgnoreCase(uaOutput.getUserName())
				   &&uaInput.getPassword().equalsIgnoreCase(uaOutput.getPassword())){
			   return uaOutput;
		   }
		}   
		return null;
	}
	*/
}

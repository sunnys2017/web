<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ page session="false" %>

<html>
<head>
<link href="/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/table.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>
	<title>Update Profile</title>
</head>
<body>



<div id = "all">

   <div id ="top">
        <h1 style="color:white;background-color:#009fcc"><img src="/finalproject/resources/image/blueEarth.png"width="30" height="30"/>Welcome to ABC Hospital!</h1>
       <br><br>
       <ul class="nav nav-pills"  >
         <li><a href="/finalproject/home">Home</a></li>
         <li class="active"><a href="#">Service</a></li>
         <li><a href="/finalproject/searchDoctors">Search Doctors</a></li>
         <li><a href="/finalproject/history">History</a></li>
         <li><a href="/finalproject/research">Research</a></li>
         <li><a href="/finalproject/contactUs">Contact Us</a></li>
         <li><a href="/finalproject/logout">Log out</a></li>
         <li><a href="/finalproject/healthPlans">Health Plans</a></li>
        
         <li class="dropdown">
         <a href="#" class="dropdown-toggle" data-toggle="dropdown">Partners <b class="caret"></b></a>
             <ul class="dropdown-menu">
               <li><a href="http://www.emersonhospital.org/">EmersonHospital</a></li>
               <li><a href="http://www.massgeneral.org/">MassGeneralHospital</a></li>
               <li><a href="http://www.bidmc.org/">BethIsraelMedicialCenter</a></li>
               <li><a href="http://www.mclean.harvard.edu/">McleanHospital</a></li>
               <li><a href="http://www.nwh.org/">NewtonWellesleyHospital</a></li>
               <li class="divider"></li>
               <li><a href="http://www.mountauburnhospital.org/">MountAuburnHospital</a></li>
             </ul>
         </li>
       </ul>
    </div>
       
    <div id="left">
      <div class="panel panel-info">
      <div class="panel-heading"><h4>Navigation</h4></div>
      <div class="panel-body">
         <small> 
         <a href="/finalproject/patient/findDoctors">Find a Doctor</a>
         <br><br>
         <a href="/finalproject/patient/manageProfile">Manage Profile</a>
         <br><br>
         <a href="/finalproject/patient/reviewAppointments">Review Appointments</a>
         <br><br>
         <a href="/finalproject/patient/reviewInvoice">Review Invoices</a>
         </small>
      </div>
      </div>
    </div>
    
    <br>
    <div id = "right">
    <br>                                                                 
    <div class="panel panel-info">
     <div class="panel-heading"><h4>Update Profile</h4></div>
        <div class="panel-body">
            
        <div>
			<table id = "tableTry">
				<tr id = "tdTry">
		    		<th align="center"><strong>Name</strong></th>
		    		<th align="center">SSN</th>
		    		<th align="center">DateOfBirth</th>
		    		<th align="center">Gender</th>
		    		<th align="center">MarryStatus</th>
		    		<th align="center">Email</th>
		    		<th align="center">Address</th>
		    		<th align="center">ZipCode</th>
				</tr>
		    		<tr>
		        		<td id = "tdTry">${patient.firstName},${patient.middleName},${patient.lastName} </td>
		          		<td id = "tdTry">${patient.ssn}</td>
		        		<td id = "tdTry">${patient.dateOfBirth}</td>
		        		<td id = "tdTry">${patient.gender} </td>
		        		<td id = "tdTry">${patient.marryStatus}</td>
		        		<td id = "tdTry">${patient.email}</td>
		        		<td id = "tdTry">${patient.address} </td>
		        		<td id = "tdTry">${patient.zipCode} </td>
                    </tr>
			  </table>
		</div>
		<br>
            
            
               
        <form ACTION="../updatePatientProfile/${patient.patientID}" method="POST">
       <div class="input-group input-group-sm"><span class="input-group-addon">First Name   :</span>
       <input type="text" class="form-control" placeholder="${patient.firstName}" name = "firstName"><br>
       <span class="input-group-addon">Middle Name  :</span>
       <input type="text" class="form-control" placeholder="${patient.middleName}" name = "middleName">
       </div><br>
       <div class="input-group input-group-sm"><span class="input-group-addon">Last Name    :</span>
       <input type="text" class="form-control" placeholder="${patient.lastName}" name = "lastName">
       </div><br>

       <div class="input-group input-group-sm"><span class="input-group-addon">Social Security No.:</span>
       <input type="text" class="form-control" placeholder="${patient.ssn}" name = "ssn" >
       </div><br>
       <div class="input-group input-group-sm"><span class="input-group-addon">Date Of Birth:</span>
       <input type="text" class="form-control" placeholder="${patient.dateOfBirth}" name = "dateOfBirth" >
       </div><br>
       
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Marry Status:</span>
       <input type="text" class="form-control" placeholder="${patient.marryStatus}" name = "marryStatus">
       <span class="input-group-addon">Gender:       </span>
       <input type="text" class="form-control" placeholder="${patient.gender}" name = "gender">
       </div><br>
       
       <div class="input-group input-group-sm"><span class="input-group-addon">Phone Number:</span>
       <input type="text" class="form-control" placeholder="${patient.phoneNumber}" name = "phoneNumber"><br>
       </div><br>
       
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Address:</span>
       <input type="text" class="form-control" placeholder="${patient.address}" name = "address" >
       <span class="input-group-addon">ZipCode:</span>
       <input type="text" class="form-control" placeholder="${patient.zipCode}" name = "zipCode" ><br>
       </div><br>
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Email:</span>
       <input type="email" class="form-control" placeholder="${patient.email}" name = "email" >
       </div><br>
       <button type="submit" class="btn btn-default">Submit</button>
       </form>
       
        </div> 
    </div>

		
		
    </div>
   
   
</div>

 
</body>
</html>

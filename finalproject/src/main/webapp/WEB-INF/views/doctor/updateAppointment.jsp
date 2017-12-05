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

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
	<title>Review Appointments</title>
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
         <li class="active"><a href="/finalproject/healthPlans">Health Plans</a></li>
        
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
         <a href="/finalproject/doctor/manageDoctorAppointments">Manage Appointments</a>
         <br><br>
         <a href="/finalproject/doctor/manageDoctorProfile">Manage Profile</a>
         <br><br>
         </small>
      </div>
      </div>
    </div>
    
    <br>
    <div id = "right">
    <br>                                                                 
    <div class="panel panel-info">
     <div class="panel-heading"><h4>Update Appointments</h4></div>
        <div class="panel-body">
            <table >
                <tr id = "tdTry">
		    		<th align="center"><strong>Doctor Name</strong></th>
		    		<th align="center">Patient Name</th>
		    		<th align="center">Date</th>
		    		<th align="center">Time</th>
		    		<th align="center">Location</th>
		    		<th align="center">Status</th>
		    		
		    		<th align="center">AppointmentFee</th>
                </tr>
                <tr>
		        		<td id = "tdTry">${appointment.doctorLastName} </td>
		          		<td id = "tdTry">${appointment.patientLastName}</td>
		        		<td id = "tdTry">${appointment.date}</td>
		        		<td id = "tdTry">${appointment.time} </td>
		        		<td id = "tdTry">${appointment.location}</td>
		        	    <td id = "tdTry">${appointment.status}</td>
		        		
		        		<td id = "tdTry">${appointment.appointmentFee} </td>
		        </tr>
             </table> 
             <br><br>
            <form ACTION="/finalproject/renewAppointment/${appointment.appointmentID}" method="POST">
             Date: <input type="text" id="datepicker" name = "date" required>
             
             Time: <select name = "time">
                           <option>09:00am - 10:00am</option>
                           <option>10:00am - 11:00am</option>
                           <option>11:00am - 11:50am</option>
                           <option>13:00pm - 14:00pm</option>
                           <option>14:00pm - 15:00pm</option>
                           <option>15:00pm - 16:00pm</option>
                           <option>16:00pm - 17:00pm</option>
                    </select>
             <br><br>
             Location:<select name = "location">
                           <option>Building ABC, Room101</option>
                           <option>Building ABC, Room102</option>
                           <option>Building ABC, Room103</option>
                           <option>Building ABC, Room104</option>
                           <option>Building XYZ, Room321</option>
                           <option>Building XYZ, Room321</option>
                           
                      </select>
             <br><br>
             
             <button type="submit" class="btn btn-default">UpdateAppointment</button>
             </form>
               
               
          </div> 
    </div>

		
		
    </div>
   
   
</div>

 
</body>
</html>

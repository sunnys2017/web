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
	<title>FindDoctors</title>
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
     <div class="panel-heading"><h4>Search Doctors</h4></div>
        <div class="panel-body">
 <!-- 
        <form class="form-inline" role="form" ACTION="../patientFindDepDoctors" method="POST">
          <div class="form-group">
            <select class="form-control" name = "department">
            <option>--Select--</option>
            <option>Cardiology</option>
            <option>Dermatology</option>
            <option>Gastroenterology</option>
            <option>General surgery</option>
            <option>Laryngology</option>
            <option>Microbiology</option>
            <option>Nephrology</option>
            </select>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-default">Search</button>
          </div>
        </form>
 --> 
          
          <div>
		   <c:if  test="${!empty doctorList}">
		    <div class="table-responsive">
			<table id = "tableTry">
				<tr id = "tdTry">
		    		<th align="center"><strong>Name</strong></th>
		    		<th align="center">Department</th>
		    		<th align="center">Title</th>
		    		<th align="center">Status</th>
		    		<th align="center">Available Date</th>
		    		<th align="center">Available Time</th>
		   		    <th>Action</th>
		   		    <th>Review</th>
				</tr>
				<c:forEach items="${doctorList}" var="doctor">
		    		<tr>
		        		<td id = "tdTry">${doctor.firstName},${doctor.lastName} </td>
		          		<td id = "tdTry">${doctor.department}</td>
		        		<td id = "tdTry">${doctor.title}</td>
		        		<td id = "tdTry">${doctor.status} </td>
		        		<td id = "tdTry">${doctor.availableDate}</td>
		        		<td id = "tdTry">${doctor.availableTime}</td>
             		    <td><a href="../dateDoctor/${doctor.doctorID}"><button type="submit" class="btn btn-default">MakeAppointment</button></a></td>
              		    <td><a href="../reviewDoctor/${doctor.doctorID}"><button type="submit" class="btn btn-default">Review Doctor</button></a></td>                
                 </c:forEach>
			  </table>
			  </div>
		  </c:if>
          </div>
          
          
        </div> 
    </div>

		
		
    </div>
   
   
</div>

 
</body>
</html>

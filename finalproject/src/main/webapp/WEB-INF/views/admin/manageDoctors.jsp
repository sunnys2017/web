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
	<title>ManageDoctors</title>
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
         <a href="http://localhost:8080/finalproject//admin/manageUserAccounts">Manage UserAccount</a>
         <br><br>
         <a href="http://localhost:8080/finalproject//admin/manageDoctors">Manage Doctors</a>
         <br><br>
         <a href="http://localhost:8080/finalproject//admin/manageInvoices">Manage Invoices</a>
         <br><br>
         <a href="http://localhost:8080/finalproject//admin/managePatients">Manage Patients</a>
         <br><br>
         <a href="http://localhost:8080/finalproject//admin/manageAdmins">Manage Admins</a>
         <br><br>
         <a href="http://localhost:8080/finalproject//admin/manageProfile">Manage Profile</a>
         </small>
      </div>
      </div>
    </div>
    
    <br>
    <div id = "right">
    <br>                                                                 
    <div class="panel panel-info">
     <div class="panel-heading"><h4>Manage Doctors</h4></div>
        <div class="panel-body">
        
        <div>
            <form class="form-inline" role="form" ACTION="../addDoctor" method="POST">
              <div class="form-group">
                   <div ><button type="submit" class="btn btn-default">Add New</button></div>
              </div> <br><br>
              <div class="form-group">
                   <div class="input-group input-group-sm"><span class="input-group-addon">First    Name:</span>
                   <input type="text" class="form-control" placeholder="required" name = "firstName" required><br>
                   <span class="input-group-addon">Middle Name  :</span>
                   <input type="text" class="form-control" placeholder="input" name = "middleName">
                   </div><br>
                   
                   <div class="input-group input-group-sm"><span class="input-group-addon">Last     Name:</span>
                   <input type="text" class="form-control" placeholder="required" name = "lastName" required>
                   <span class="input-group-addon">SocialSecurityNo:</span>
                   <input type="text" class="form-control" placeholder="input" name = "ssn" required>
                   </div><br>

                   <div class="input-group input-group-sm"><span class="input-group-addon">Phone Number:</span>
                   <input type="text" class="form-control" placeholder="input" name = "phoneNumber"><br>
                   <span class="input-group-addon">Email:</span>
                   <input type="email" class="form-control" placeholder="required" name = "email" required>
                   </div><br>
                   
                   <div class="input-group input-group-sm"><span class="input-group-addon">Department :</span>
                   <input type="text" class="form-control" placeholder="input" name = "department" required><br>
                   <span class="input-group-addon">Title:</span>
                   <input type="text" class="form-control" placeholder="input" name = "title" >
                   </div><br>
                   
                   <div class="input-group input-group-sm"><span class="input-group-addon">AvailableDate:</span>
                   <input type="text" class="form-control" placeholder="input" name = "availableDate" required><br>
                   <span class="input-group-addon">AvailableTime:</span>
                   <input type="text" class="form-control" placeholder="input" name = "AvailableTime" required>
                   </div><br>
                   
                   <div class="input-group input-group-sm"><span class="input-group-addon">Doctor VisitFee:</span>
                   <input type="text" class="form-control" placeholder="input" name = "doctorVisitFee" required><br>
                   <span class="input-group-addon">Status:</span>
                   <input type="text" class="form-control" placeholder="input" name = "status" >
                   </div><br>
		   		  
              </div>
            </form>
        </div>
        
       
        <div>
		   <c:if  test="${!empty doctorList}">
		    <div class="table-responsive">
			<table id = "tableTry">
				<tr id = "tdTry">
		    		<th align="center"><strong>Name</strong></th>
		    		<th align="center">Department</th>
		    		<th align="center">Title</th>
		    		<th align="center">Doctor VisitFee</th>
		    		<th align="center">Email</th>
		    		<th align="center">PhoneNo.</th>
		    		<th align="center">SSN</th>
		    		<th align="center">Status</th>
		    		<th align="center">Available Date</th>
		    		<th align="center">Available Time</th>
		   		    <th>Action</th>
				</tr>
				<c:forEach items="${doctorList}" var="doctor">
		    		<tr>
		        		<td id = "tdTry">${doctor.firstName},${doctor.lastName} </td>
		          		<td id = "tdTry">${doctor.department}</td>
		        		<td id = "tdTry">${doctor.title}</td>
		        		<td id = "tdTry">${doctor.doctorVisitFee} </td>
		        		<td id = "tdTry">${doctor.email}</td>
		        		<td id = "tdTry">${doctor.phoneNumber}</td>
		        		<td id = "tdTry">${doctor.ssn} </td>
		        		<td id = "tdTry">${doctor.status} </td>
		        		<td id = "tdTry">${doctor.availableDate}</td>
		        		<td id = "tdTry">${doctor.availableTime}</td>
		        		<td><a href="../deleteDoctor/${doctor.doctorID}">delete</a></td>
                    </tr>
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

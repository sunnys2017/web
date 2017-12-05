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

	<title>ManageInvoices</title>
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
     <div class="panel-heading"><h4>Manage Invoices</h4></div>
        <div class="panel-body">
        
        
        <div>
		   <c:if  test="${!empty invoiceList}">
		    <div class="table-responsive">
			<table id = "tableTry">
				<tr id = "tdTry">
		    		<th align="center"><strong>Hospital Address</strong></th>
		    		<th align="center">Invoice Date</th>
		    		<th align="center">Invoice DueDate</th>
		    		<th align="center">Total Amount</th>
		    		<th align="center">Status</th>
		    		<th align="center">Note</th>
		    		<th align="center">Patient Name</th>
		    		<th align="center">Patient Address</th>
		    		<th align="center">Appointment Date</th>
		    		<th align="center">Doctor Name</th>
		   		    <th>Action</th>
				</tr>
				<c:forEach items="${invoiceList}" var="invoice">
		    		<tr>
		        		<td id = "tdTry">${invoice.hospitalAddress} </td>
		          		<td id = "tdTry">${invoice.invoiceDate}</td>
		        		<td id = "tdTry">${invoice.invoiceDueDate}</td>
		        		<td id = "tdTry">${invoice.total} </td>
		        		<td id = "tdTry">${invoice.status}</td>
		        		<td id = "tdTry">${invoice.note}</td>
		        		<td id = "tdTry">${invoice.patientName}</td>
		        		<td id = "tdTry">${invoice.patientAddress} </td>
		          		<td id = "tdTry">${invoice.appointmentDate}</td>
		        		<td id = "tdTry">${invoice.doctorName}</td>	        		
		        		<td><a href="../deleteInvoice/${invoice.invoiceID}"><small>delete</small></a></td>
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

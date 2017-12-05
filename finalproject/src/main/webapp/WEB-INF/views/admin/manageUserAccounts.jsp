<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/table.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>
<script>
function showCustomer(str)
{
var xmlhttp;    
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","/finalproject/getcustomer?q="+str,true);
xmlhttp.send();
}
</script>
	<title>ManageUserAccounts</title>
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
     <div class="panel-heading"><h4>Manage UserAccounts</h4></div>
        <div class="panel-body">
        
        <div>
            <form class="form-inline" role="form" ACTION="../addUserAccount" method="POST">
              <div class="form-group">
                   <div ><button type="submit" class="btn btn-default">Add New</button></div>
              </div> <br><br>
              <div class="form-group">
                   <div class="input-group input-group-sm"><span class="input-group-addon">UserName:</span>
                   <input type="text" class="form-control" placeholder="required" name = "userName" required><br>
                   </div><br>
                   
                   <div class="input-group input-group-sm"><span class="input-group-addon">Password:</span>
                   <input type="text" class="form-control" placeholder="required" name = "password" required>
                   </div><br>
                   
                   <div>Please Select EnterpriseID: 
                   <select class="form-control" name = "ssn" onchange="showCustomer(this.value)">
                       <c:if  test="${!empty doctorList}">
                        <c:forEach items="${doctorList}" var="doctor">
                        <option value="${doctor.doctorID}">${doctor.doctorID}</option> 
                        </c:forEach>
                       </c:if>
                       <c:if  test="${!empty patientList}">
                           <c:forEach items="${patientList}" var="patient">
                           <option value="${patient.patientID}">${patient.patientID}</option>
                           </c:forEach>
                       </c:if>  
                       <c:if  test="${!empty adminList}">
                           <c:forEach items="${adminList}" var="admin">
                           <option value="${admin.adminID}">${admin.adminID}</option>
                           </c:forEach>
                       </c:if> 
                   </select>
                   </div><br>
                   <div id="txtHint">Person info will be listed here...</div>
                   
                   <br>
                   <div>Please select Role:
                   <select class="form-control" name = "role">
                       <option>admin</option>
                       <option>patient</option>
                       <option>doctor</option>
                   </select>
                   </div>
              </div>
            </form>
        </div>
                
        <div>
		   <c:if  test="${!empty userAccountList}">
		    <div class="table-responsive">
			<table id = "tableTry">
				<tr id = "tdTry">
		    		<th align="center"><strong>User Name</strong></th>
		    		<th align="center">Password</th>
		    		<th align="center">Role</th>
		    		<th align="center">EnterpriseID</th>
		   		    <th>Action</th>
				</tr>
				<c:forEach items="${userAccountList}" var="userAccount">
		    		<tr>
		        		<td id = "tdTry">${userAccount.userName} </td>
		          		<td id = "tdTry">${userAccount.password}</td>
		        		<td id = "tdTry">${userAccount.role}</td>
		        		<td id = "tdTry">${userAccount.ssn} </td>
		        		<td><a href="../deleteUserAccount/${userAccount.userName}"><small>delete</small></a></td>
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

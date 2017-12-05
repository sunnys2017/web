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
<script type="text/javascript">
       $(document).ready(function () {  
          $('.dropdown-toggle').dropdown();  
      });
</script>
	<title>HospitalHomepage</title>
</head>
<body>

<div id = "all">

   <div id ="top">
        <h1 style="color:white;background-color:#009fcc"><img src="/finalproject/resources/image/blueEarth.png"width="30" height="30"/>Welcome to ABC Hospital!</h1>
       <br><br>
       <ul class="nav nav-pills"  >
         <li><a href="/finalproject/home">Home</a></li>
         <li><a href="/finalproject/login">Service</a></li>
         <li class="active"><a href="/finalproject/searchDoctors">Search Doctors</a></li>
         <li><a href="/finalproject/history">History</a></li>
         <li><a href="/finalproject/research">Research</a></li>
         <li><a href="/finalproject/contactUs">Contact Us</a></li>
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
      <div class="panel-heading"><h4>News</h4></div>
      <div class="panel-body">
      <small> 
      <a href="http://www.bizjournals.com/boston/blog/health-care/2013/12/mass-hospital-ceos-urge-halt-to.html">
       Mass. hospital CEOs urge halt to Medicaid cuts.
      </a>
      <br><br>
      <a href="http://www.naplesnews.com/news/2013/dec/03/boston-red-sox-childrens-hospital-celebrity-classi/?partner=RSS">
      Boston Red Sox Children's Hospital Celebrity Classic.
      </a>
      <br><br>
      <a href="http://www.boston.com/news/local/new-hampshire/2013/12/04/hospital-wants-network-decision-documents/8eUufmikFYOKilYX1ZDy1N/story.html">
      NH hospital wants network decision documents.
      </a>
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
          <form class="form-inline" role="form" ACTION="./findDepDoctors" method="POST">
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
		    		<th align="center">Status</th>
		    		<th align="center">Available Date</th>
		    		<th align="center">Available Time</th>
		   		    
				</tr>
				  <c:forEach items="${doctorList}" var="doctor">
		    		<tr>
		        		<td id = "tdTry">${doctor.firstName},${doctor.lastName} </td>
		          		<td id = "tdTry">${doctor.department}</td>
		        		<td id = "tdTry">${doctor.title}</td>
		        		<td id = "tdTry">${doctor.doctorVisitFee} </td>
		        		<td id = "tdTry">${doctor.email}</td>
		        		<td id = "tdTry">${doctor.phoneNumber}</td>
		        		<td id = "tdTry">${doctor.status} </td>
		        		<td id = "tdTry">${doctor.availableDate}</td>
		        		<td id = "tdTry">${doctor.availableTime}</td>
             		    
                   </c:forEach>
			    </table>
			    </div>
		     </c:if>
           </div>
           
             <div class="col-sm-6 col-md-4">
               <div class="thumbnail">
                <img  src="/finalproject/resources/image/doctor1.jpg" alt="..."  width="150" height="150" >
                <div class="caption">
                     <h3>Dr. Jonas Salk</h3>
                     <p><small>This miracle man was born in New York City and was the son of Jewish Russian immigrants. He studied microbiology at NYU's School of Medicine.
                     </small></p>
                </div>
               </div>
               </div>

             <div class="col-sm-6 col-md-4">
               <div class="thumbnail">
                <img  src="/finalproject/resources/image/doctor2.jpg" alt="..."  width="150" height="150" >
                <div class="caption">
                     <h3>Dr. Carlo Urbani</h3>
                     <p><small>The man that identified SARS (Severe Acute Respiratory Syndrome) as a highly contagious disease and warned the WHO (World Health Organization) to take strict action against it.
                     </small></p>
                </div>
               </div>
             </div>

             <div class="col-sm-6 col-md-4">
               <div class="thumbnail">
                <img  src="/finalproject/resources/image/doctor3.jpg" alt="..."  width="150" height="150" >
                <div class="caption">
                     <h3>Dr. Carl Wood</h3>
                     <p><small>Dr. Wood was a renowned Australian gynecologist known for developing and commercializing the IVF or (In-Vitro Fertilization) technique.
                     </small></p>
                </div>
               </div>
             </div>
           
       </div>
    </div>
    </div>
</div>

</body>
</html>

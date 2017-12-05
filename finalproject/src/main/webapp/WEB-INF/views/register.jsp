<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>

	<title>HospitalHomepage</title>
</head>

<body>
<div id = "all">

   <div id ="top">
        <h1 style="color:white;background-color:#009fcc"><img src="/finalproject/resources/image/blueEarth.png"width="30" height="30"/>Welcome to ABC Hospital!</h1>
       <br><br>
       <ul class="nav nav-pills"  >
         <li><a href="/finalproject/home">Home</a></li>
         <li class="active"><a href="/finalproject/login">Service</a></li>
         <li><a href="/finalproject/searchDoctors">Search Doctors</a></li>
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
    <div class="panel-heading"><h4>Registration</h4></div>
     <div class="panel-body">
       <form ACTION="./submitREG" method="POST">
       <div class="input-group input-group-sm"><span class="input-group-addon">First Name   :</span>
       <input type="text" class="form-control" placeholder="required" name = "firstName" required><br>
       <span class="input-group-addon">Middle Name  :</span>
       <input type="text" class="form-control" placeholder="input" name = "middleName">
       </div><br>
       <div class="input-group input-group-sm"><span class="input-group-addon">Last Name    :</span>
       <input type="text" class="form-control" placeholder="required" name = "lastName" required>
       </div><br>

       <div class="input-group input-group-sm"><span class="input-group-addon">Social Security No.:</span>
       <input type="text" class="form-control" placeholder="input" name = "ssn" required>
       </div><br>
       <div class="input-group input-group-sm"><span class="input-group-addon">Date Of Birth:</span>
       <input type="text" class="form-control" placeholder="required" name = "dateOfBirth" >
       </div><br>
       
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Marry Status:</span>
       <input type="text" class="form-control" placeholder="input" name = "marryStatus">
       <span class="input-group-addon">Gender:       </span>
       <input type="text" class="form-control" placeholder="input" name = "gender">
       </div><br>
       
       <div class="input-group input-group-sm"><span class="input-group-addon">Phone Number:</span>
       <input type="text" class="form-control" placeholder="input" name = "phoneNumber"><br>
       </div><br>
       
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Address:</span>
       <input type="text" class="form-control" placeholder="required" name = "address" required>
       <span class="input-group-addon">ZipCode:</span>
       <input type="text" class="form-control" placeholder="required" name = "zipCode" required><br>
       </div><br>
       <div class="input-group input-group-sm">
       <span class="input-group-addon">Email:</span>
       <input type="email" class="form-control" placeholder="required as UserName" name = "email" required>
       <span class="input-group-addon">Password:</span>
       <input type="text" class="form-control" placeholder="required" name = "password" required><br>
       </div><br>
       
       <button type="submit" class="btn btn-default">Submit</button>
       </form>
     </div>
     </div>
     </div>
    
</div>


</body>
</html>

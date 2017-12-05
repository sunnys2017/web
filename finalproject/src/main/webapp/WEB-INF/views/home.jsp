<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
         <li class="active"><a href="/finalproject/home">Home</a></li>
         <li><a href="/finalproject/login">Service</a></li>
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
    <div class="panel-heading"><h4>Introduction</h4></div>
     <div class="panel-body">
     <p>  
       <br>ABC Hospital is an international leader in virtually every area of medicine and has been the site of pioneering breakthroughs that have improved lives around the world. A major teaching hospital of Harvard Medical School, BBH has a legacy of excellence that continues to grow year after year. With two outstanding hospitals and over 15 outpatient practices with over 1,20 physicians, we serve patients from New England, throughout the United States, and from 40 countries around the world.
       <small><br>To login in click <a href="./login">here</a>.<br>
                  New user click <a href="./register">here</a>.
       </small>
     </p>
     </div>
     
     <div align="center">
     <img class="img-thumbnail" src="/finalproject/resources/image/123.jpg" alt="..." width="500" height="150" >
  
    <br><br>
   <ul class="pagination">
      <li><a href="#">&laquo;</a></li>
      <li><a href="./history">1</a></li>
      <li><a href="./research">2</a></li>
      <li><a href="./contactUs">3</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>
       </div>
    <br>
    </div>
    </div>
   
   
</div>

</body>
</html>

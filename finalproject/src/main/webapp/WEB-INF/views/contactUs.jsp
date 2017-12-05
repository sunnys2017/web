<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link href="http://localhost:8080/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="http://localhost:8080/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
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
         <li ><a href="/finalproject/home">Home</a></li>
         <li><a href="/finalproject/login">Service</a></li>
         <li><a href="/finalproject/searchDoctors">Search Doctors</a></li>
         <li><a href="/finalproject/history">History</a></li>
         <li><a href="/finalproject/research">Research</a></li>
         <li class="active"><a href="/finalproject/contactUs">Contact Us</a></li>
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
    <div class="panel-heading"><h4>Contact Us</h4></div>
     <div class="panel-body">
       Address:
       <div align = "center"> <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Northeastern+University,+Huntington+Avenue,+Boston,+MA&amp;aq=0&amp;oq=northeastern.&amp;sll=42.448081,-71.225088&amp;sspn=0.145921,0.336113&amp;ie=UTF8&amp;hq=&amp;hnear=&amp;ll=42.339807,-71.089172&amp;spn=0.006295,0.006295&amp;t=m&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Northeastern+University,+Huntington+Avenue,+Boston,+MA&amp;aq=0&amp;oq=northeastern.&amp;sll=42.448081,-71.225088&amp;sspn=0.145921,0.336113&amp;ie=UTF8&amp;hq=&amp;hnear=&amp;ll=42.339807,-71.089172&amp;spn=0.006295,0.006295&amp;t=m" style="color:#0000FF;text-align:left">View Larger Map</a></small></div>
       <br>
       <address>
             <strong>ABC Hospital, Inc.</strong><br>
             Huntington Avenue, <br>
             Boston, MA 02110<br>
       <abbr title="Phone">P:</abbr> (123) 456-7890
       </address>

       <address>
            <strong>Full Name</strong><br>
            <a href="mailto:#">first.last@abchospitl.com</a>
       </address>
     
     </div>
     
     <div align="center">
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

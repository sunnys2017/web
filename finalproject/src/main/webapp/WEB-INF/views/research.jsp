<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link href="http://localhost:8080/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="http://localhost:8080/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>

<link rel="stylesheet" href="/resources/demos/style.css">
	<title>HospitalHomepage</title>
<!-- cited: from http://jqueryui.com/switchClass/ -->
<style>
  .toggler { width: 1000px; height: 200px; position: relative; }
  #button { padding: .5em 1em; text-decoration: none; }
  #effect { position: relative; }
  .newClass { width: 240px;  padding: 1em; letter-spacing: 0; font-size: 1.2em; margin: 0; }
  .anotherNewClass { text-indent: 40px; letter-spacing: .4em; width: 410px; height: 100px; padding: 30px; margin: 10px; font-size: 1.6em; }
  </style>
  <script>
  $(function() {
    $( "#button" ).click(function(){
      $( ".newClass" ).switchClass( "newClass", "anotherNewClass", 1000 );
      $( ".anotherNewClass" ).switchClass( "anotherNewClass", "newClass", 1000 );
      return false;
    });
  });
  </script>
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
         <li class="active"><a href="/finalproject/research">Research</a></li>
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
    <div class="panel-heading"><h4>Research</h4></div>
     <div class="panel-body">
     
           <div align="center">
           <img class="img-thumbnail" src="/finalproject/resources/image/research.jpg" alt="..." width="500" height="150" >
           </div>
          
          <p>
          <br>Whether sleep environment is safe or not, SIDS is linked to brainstem abnormality 
          <small><a href ="http://vectorblog.org/2013/11/whether-sleep-environment-is-safe-or-not-sids-is-linked-to-brainstem-abnormality/">
          See more...
          </a></small>
          <br>Could we have given her intravenous oxygen? Breathing an idea to life.
          <small><a href ="http://vectorblog.org/2013/04/could-we-have-given-her-intravenous-oxygen-breathing-an-idea-to-life/">
          See more...
          </a></small>
          <br>Out of the fire, into the pan: Lessons on managing chronic care in developing countries
          <small><a href ="http://vectorblog.org/2013/12/out-of-the-fire-into-the-pan-lessons-on-managing-chronic-care-in-developing-countries/">
          See more...
          </a></small>
          <br>
          </p>
          
          <div class="toggler">
          <div id="effect" class="newClass ui-corner-all">
          <small><br>To login in click <a href="./login">here</a>.<br>
                  New user click <a href="./register">here</a>.
          </small>
          
          </div>
          </div>
          <a href="#" id="button" class="ui-state-default ui-corner-all">Make it Large</a>

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

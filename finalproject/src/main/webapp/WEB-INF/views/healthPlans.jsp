<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html >
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link href="/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
       $(document).ready(function () {  
          $('.dropdown-toggle').dropdown();  
      });
</script>

<!-- AIzaSyDHV64-qvGNYcXkM-mqQwmzpsun-SqnYkw -->
<style type="text/css">
 .mouseout
 {
  background:"";
  background-color:#6E97B3;
  font-weight:normal;
  }
 .mouseon
 {
  background:url(images/bg1.gif);
  background-color:none;
  font-weight:bold;
  }
 </style>
<script type="text/javascript">
        function $(id)
         {
           return document.getElementById(id);
            }
        function classNormal()
         {
        var focusBtn = $('nb').getElementsByTagName('li');
        var focusImg = $('show').getElementsByTagName('li');
        for (var i = 0; i < 3; i++) {
            focusBtn[i].className = 'mouseout';
            focusImg[i].style.display="none";
        }
    }
 function change()
 {
   var focusBtn = $('nb').getElementsByTagName('li');
   var focusImg = $('show').getElementsByTagName('li');
  focusBtn[0].onmouseover = function() {
                classNormal();
                focusBtn[0].className = 'mouseon';
                focusImg[0].style.display='block';
            }
  focusBtn[1].onmouseover = function() {
                classNormal();
                focusBtn[1].className = 'mouseon';
                focusImg[1].style.display='block';
            }      
  focusBtn[2].onmouseover = function() {
                classNormal();
                focusBtn[2].className = 'mouseon';
                focusImg[2].style.display='block';
            }
}
         window.onload = function() {
            change();
        }
</script>

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
         <li ><a href="/finalproject/contactUs">Contact Us</a></li>
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
    <div class="panel-heading"><h4>Health Plans</h4></div>
     <div class="panel-body">



<div id="show" style="width:690px;height:220px; padding:0; margin:0;">
 <ul style="width:690px;height:220px;float:left;list-style-type:none; padding:0; margin:0;">
  <li style="list-style-type:none;float:left;width:330px;height:220px;background:url(/finalproject/resources/autopic/1eng_startbild.jpg);display:block;"></li>
    <li style="list-style-type:none;float:left;width:330px;height:220px;background:url(/finalproject/resources/autopic/Hospital123.jpg);display:none;"></li>
    <li style="list-style-type:none;float:left;width:330px;height:220px;background:url(/finalproject/resources/autopic/1foto-hospital.jpg);display:none;"></li>
  <li style="list-style-type:none;float:left;width:360px;height:220px">
   <div id="nb" style="width:360px;height:220px;padding:0; margin:0;">
    <ul style="width:360px;height:220px;list-style-type:none;padding:0; margin:0;">
     <li class="mouseon" style="width:360px;height:72px;list-style-type:none;background-color:#EEEEEE;color:#009FCC;font-size:17px;"><a href ="http://minutemanhealth.org/members?gclid=CKnA_-bbrbsCFSbNOgodonYA_A">MinuteMan Health</a></li>
     <li style="width:360px;height:72px;list-style-type:none;margin-top:2px;background-color:#EEEEEE;color:#009FCC;font-size:17px;"><a href ="http://www.tuftshealthplan.com/">TUFTS HealthPlan</a></li>
     <li style="width:360px;height:72px;list-style-type:none;margin-top:2px;background-color:#EEEEEE;color:#009FCC;font-size:17px;"><a href ="https://www.nhp.org/Pages/Home.aspx">Neighborhood Health</a></li>
    </ul>
   </div>
  </li>
 </ul>
</div>






     </div>
 
    <br>
    </div>
    </div>
   
 <!-- cite AUTOPIC:http://zhidao.baidu.com/link?url=iRrB3yLE54afHafOv4ai1Ko2GyGApRmol1p9U6kUH3UJ9a0TJZTTTHTfZ_p8aLu6Qz2H9QXLHlP6AOK5BuUW8_ -->  
<!-- cite: http://stackoverflow.com/questions/17107509/twitter-bootstrap-dropdown-menu-javascript?rq=1 -->
</div>

</body>
</html>

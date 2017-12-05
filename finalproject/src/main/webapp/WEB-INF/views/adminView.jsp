<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="/finalproject/resources/css/bootstrap.css" type=text/css rel=stylesheet>
<link href="/finalproject/resources/css/common.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
<script src="/finalproject/resources/js/bootstrap.js" type="text/javascript"></script>

  <style type="text/css">
html, body, #map-canvas {
    width: 100%;
    height: 500px;
    margin: 0px;
    padding: 0px
}
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=weather"></script>
 <script type="text/javascript">
 var map;
 function initialize() {
	    var latlng = new google.maps.LatLng(40.7428, -80.4019);
	    var weatherOn = false; //starts off false because the weather layer is not on by default

	     // Setting up the map options
	     var mapOptions = {
	      center: latlng,
	      zoom: 5,
	      mapTypeId: google.maps.MapTypeId.ROADMAP,
	      backgroundColor:'#c0c0c0',
	      draggableCursor: 'pointer',
	      draggingCursor: 'crosshair'
	      };

	    // Assigning map to its variable
	    map = new google.maps.Map(document.getElementById("map-canvas"),
	        mapOptions);

	    var weatherLayer = new google.maps.weather.WeatherLayer({
	    	TemperatureUnits: google.maps.weather.TemperatureUnit.FAHRENHEIT
	    });
	     weatherLayer.setMap(map);
	    var cloudLayer = new google.maps.weather.CloudLayer();
		  cloudLayer.setMap(map);
	    // Setting a listener that will toggle the weather layer
	    google.maps.event.addDomListener(document.getElementById("weatherToggle"), 'click', function() {
	        if ( weatherLayer.getMap() != null ) {
	            weatherLayer.setMap(null);
	        }
	        else {
	            weatherLayer.setMap(map);
	        }
	    });
	};
	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script>  
function startTime()
{
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout(function(){startTime()},500);
}

function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}
</script>
	<title>HospitalHomepage</title>
</head>
<body onload="startTime()">

<div id = "all" >

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
      <a href="./admin/manageUserAccounts">Manage UserAccount</a>
      <br><br>
      <a href="./admin/manageDoctors">Manage Doctors</a>
      <br><br>
      <a href="./admin/manageInvoices">Manage Invoices</a>
      <br><br>
      <a href="./admin/managePatients">Manage Patients</a>
      <br><br>
      <a href="./admin/manageAdmins">Manage Admins</a>
      <br><br>
      <a href="./admin/manageProfile">Manage Profile</a>
      </small>
      </div>
      </div>
    </div>
    
    <br>
    <div id = "right">
    <br>
    <div class="panel panel-info">
    <div class="panel-heading"><h4>Admin WorkArea</h4>       </div>
     <div class="panel-body">
      
        Welcome, admin,${admin.firstName}.     Current time is :<div id="txt"></div>  
     <br>
     Today's weather:
     
     <input type="button" id="weatherToggle" value="Show Temperature"></input>
     <div id="map-canvas"></div> 
 
     <br>
     </div>
    

    </div>
    </div>
   
   
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search Page</title>
  <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
     <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">

   function changeFunc() {
	 
    var selectBox = document.getElementById("city");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
   $.ajax({
       type:'GET',
       url:'fetchHotelName.html',
       data:{credit:selectedValue},
       success : function(data) {
         document.getElementById("hotel").innerHTML = data;
       
       }
   });
}
</script>

 <script>
   
$(function () {
    $("#checkIndate").datepicker({
    appendText:"(DD-MM-YYYY)",
             dateFormat:"dd-mm-yy",
             minDate: 0,
             maxDate: "+60D",
             numberOfMonths: 1,
             onSelect: function(selected) {
               $("#checkOutDate").datepicker("option","minDate", selected)
             }
         });
         $("#checkOutDate").datepicker({ 
        	 appendText:"(DD-MM-YYYY)",
             dateFormat:"dd-mm-yy",
             minDate: 0,
             maxDate:"+60D",
             numberOfMonths: 1,
             onSelect: function(selected) {
                $("#checkIndate").datepicker("option","maxDate", selected)
             }
         });  
     });

</script>
<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
       alert("Enter only numbers");
       return false;
    }
    return true;
}

</script>
</head>

<body bgcolor="#58F293">
<br>
<br>
<br>
<h2><center>Book a Room</center></h2>

<form action="save.control" method="get" commandName="userForm">
<br>
<br>
<br>
<table align="center" cellpadding="4" cellspacing="4" frame="value">
<tr>
<td>
City:</td>
<td><select size="1" id="city" title="" name="city" onchange="changeFunc();" required>
  <option value="">Choose City</option>
      <c:forEach items="${hotel}" var="city">
        <option value="${city}">${city}</option>
    </c:forEach>
</select></td></tr>
<tr>
<td>
HotelName:</td><td><div class="hotel" id = "hotel" required></div></td>
</tr>
<tr>
<td>Check-in date:</td><td><input type = "text" id = "checkIndate" name="checkInDate" required></td>
</tr>
<tr>
<td>Check-out date:</td><td><input type = "text" id = "checkOutDate" name="checkOutDate" required></td>
</tr>
<tr>
<td>Number Of Rooms:</td><td><input type = "text"  onkeypress="return isNumber(event)" value ="" name="noOfRooms" required></td>
</tr>
<tr>
</tr>
</table>
<br>
<center>
<input type="submit" value="Book Room"></center>
<center><input type="submit" value="cancel"  onclick="window.location.replace('http://localhost:8080/HotelBookingSystem/')">
</center>



</form>

</body>

</html>
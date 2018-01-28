<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Lowest Priced Hotels</title>
  <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
     <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
     <script type="text/javascript">

   function changeFunc() {
	 
    var selectBox = document.getElementById("city");
    var selectedValue = city.options[city.selectedIndex].value;
   $.ajax({
       type:'GET',
       url:'lowPricedHotel.html',
       data:{credit:selectedValue},
       success : function(data) {
         document.getElementById("hotel").innerHTML = data;
       
       }
   });
}
</script>
</head>
<body bgcolor="#58F293">
<h2><center>Lowest Priced Hotels</center></h2>


<center>City:<select size="1" id="city" title="" name="city" onchange="changeFunc();" required>
  <option value="">Choose City</option>
      <c:forEach items="${hotel}" var="city">
        <option value="${city}">${city}</option>
    </c:forEach>
</select></center>
<center><br><br><div class="hotel" id = "hotel" required></div></br></br></center>
<center><input type="submit" value="cancel"  onclick="window.location.replace('http://localhost:8080/HotelBookingSystem/')">
</center>
</body>
</html>
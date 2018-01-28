 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Success page</title>

</head>

<body bgcolor="#58F293">

<h2><center>Booking Confirmed</center></h2>
<br>
<br>

<table align ="center" cellpadding="4" cellspacing="4" >

<tr>
<td>Booking Id</td><td>Rate</td>
</tr>
<tr>
<td>${hotel.get(1)}</td><td>${hotel.get(0)}</td></tr>
<tr>
<td>
<input type="submit" value="Go Back"  onclick="window.location.replace('http://localhost:8080/HotelBookingSystem/')">
</td></tr>
</table>

</body>

</html>
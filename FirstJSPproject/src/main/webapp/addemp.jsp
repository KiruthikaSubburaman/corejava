<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new emp</title>
</head>
<body>
<form action="AddEmployee" method="post">
<div>
<label for="Name">Name:</label>
<input id="name" type="text" placeholder="Enter your name here"></div>
<div><label for="city">City:</label>
<input id="city" type="text" placeholder="Enter your city here"></div>
<div><label for="Salary">Salary:</label>
<input id="salary" type="text" placeholder="Enter your salary here"></div>
<input type="submit" value="add">
</form>

</body>
</html>
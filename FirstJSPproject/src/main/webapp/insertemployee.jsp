<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,java.util.ArrayList"%>
<%@ page import="com.chainsys.jspproject.pojo.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
<%
  int result = (int)request.getAttribute("addemployee");
  %>
  <div>Add Employee: <%=result%></div>
</body>
</html>
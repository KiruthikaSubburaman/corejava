<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteEmployeesDetails</title>
</head>
<body>
    <form action="/FirstJSPproject/DeleteEmpServlet" method="post">
        <br>
        <div style="width: 50%; margin: 0 auto">
            ID:<input type='text' name='id' placeholder="Employee Id">
        </div>
        <div style="width: 40%; margin: 0 auto">
            <br> <input type=submit name='submit' value='DELETE_EMP'>
        </div>
    </form>
</body>
</html>


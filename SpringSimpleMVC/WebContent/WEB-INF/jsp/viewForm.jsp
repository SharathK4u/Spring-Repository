<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Person</title>
</head>
<body>
	<table>
	<tr>  
   		<td>${person.id}</td>  
   		<td>${person.name}</td>  
   		<td>${person.age}</td>  
   		<td>${person.address}</td>  
   	</tr>
   	<tr>
   		<td><a href="add.do">Add another</a></td>
   	</tr>
	</table>
</body>
</html>
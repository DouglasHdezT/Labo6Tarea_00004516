<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Estudiantes registrados:</h1>
	
	<form action="${pageContext.request.contextPath}/result" method="post">
		<label for = "id">Ingrese c&oacute;digo a buscar: </label>
		<input name = "id" type = "number">
		<input type="submit" value = "Buscar">
		 
	</form>
	
	<br>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
				</tr>	
			</c:forEach>
	</table>
</body>
</html>
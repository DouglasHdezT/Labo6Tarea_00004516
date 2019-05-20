<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>

	<h1>Modulo de edicion de estudiantes</h1>
	<h4>${message}</h4>
	
	<form:form action="${pageContext.request.contextPath}/studentInsert" method = "POST" modelAttribute="student">
	
		<form:input type = "hidden" name = "id" path="cStudent"/>
		
		<label>Ingrese nombre:</label><br>
		<form:input type = "text" name = "name" path="sName"/><br>
		
		<label>Ingrese Apellido:</label><br>
		<form:input type = "text" name = "lname" path="lName"/><br>
		
		<label>Ingrese nombre:</label><br>
		<form:input type = "number" name = "age" path="sAge"/><br>
		
		<label>Ingrese nombre:</label><br>
		<form:radiobutton name = "status" path="bActivo" value="true"/><label>Activo</label>
		<form:radiobutton name = "status" path="bActivo" value="false"/><label>Inactivo</label><br>
		
		<input type= "submit" value = "Actualizar registro">
	
	</form:form>

</body>
</html>
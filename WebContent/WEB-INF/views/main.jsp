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
	
	<button onclick="window.location.href = '${pageContext.request.contextPath}/student?id=0'">Agregar estudiante</button>
	
	<br>
	<br>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.sName}</td>
					<td>${student.lName}</td>
					<td>${student.sAge}</td>
					<td>${student.activoDelegate}</td>
					<td>
						<button onclick="window.location.href = '${pageContext.request.contextPath}/student?id=${student.cStudent}'">Editar</button>
					</td>
					<td>
						<button onclick="window.location.href = '${pageContext.request.contextPath}/deletestudent?id=${student.cStudent}'">Borrar</button>
					</td>
				</tr>	
			</c:forEach>
	</table>
</body>
</html>
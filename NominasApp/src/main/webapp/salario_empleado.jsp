<%@ page import = "laboral.*" %>
<%@ page import = "bbdd.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% BBDD bbdd = new BBDD();
		Backup backup = new Backup(bbdd); %>
		
		<p>El salario del empleado con dni <%= request.getParameter("dni_salario") %> es: <%= bbdd.buscarSalario(request.getParameter("dni_salario"))%>
		<a href="index.jsp"><button type="submit">Pagina principal</button></a>
</body>
</html>
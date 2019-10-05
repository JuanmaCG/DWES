<%@ page language="java" import="java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta content="text/html">
<title>ErrorPage</title>
</head>
<body>
	
	<% if(response.getStatus() == 500){ %>
		<h3>No existe el usuario introducido</h3>
		<a href="index.jsp"><button>Index</button></a>
	<%  }else {%>
		<h3>Error del servidor</h3>
	<%} %>
	
	
	
</body>
</html>
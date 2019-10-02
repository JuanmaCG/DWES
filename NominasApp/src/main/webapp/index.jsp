
<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
		<ol>
			<li>Ver todos los empleados  <a href="empleados.jsp"><button type="submit">Mostrar</button></a></li>
			<form action="salario_empleado.jsp" method="GET">
				<li>Ver salario de un empleado especifico <input type="text" name="dni_salario"><input type="submit"></li>
			</form>
			
			<li>Submenu de edicion</li>
			<form action="ActualizaNominas" method="POST">
				<li>Recalcular y actualizar sueldo de un empleado<input type="text" name="salario_actualizado"><input type="submit"></li>
			</form>
			
			<li>Recalcular y actualizar sueldos de todos los empleados</li>
			<li>Realizar copia de seguridad de la BBDD en fichero</li>
		</ol>	
		

</body>
</html>
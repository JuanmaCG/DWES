package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import Laboral.Empleado;
import Laboral.Nomina;

public class BBDD {

	Connection con;
	Statement stmt;
	ResultSet rs;

	public BBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoevaluacion", "root", "root");
	}

	public void altaEmpleado(Empleado emp) throws SQLException {
		stmt = con.createStatement();
		String query = "Insert into Empleados values ('" + emp.nombre + "','" + emp.dni + "','" + emp.sexo + "'," + emp.getCategoria() + "," + emp.anyos + ")";
		stmt.executeUpdate(query);
		String salario = "insert into Nominas values (" + Nomina.sueldo(emp) + ',' + emp.dni + ")";
		stmt.execute(salario);
		
//		if(emplexistente(emp.dni) == null) {
//			stmt.executeUpdate(consulta);
//		}else {
//			throw new DatosNoCorrectosException("Empleado con ese DNI ya existente");
//		}
	}

	public List<String> mostrarEmpleados() throws ClassNotFoundException, SQLException {
		stmt = con.createStatement();

		List<String> empleados = new ArrayList<String>();

		rs = stmt.executeQuery("select * from Empleados");

		while (rs.next()) {
			char sexo = rs.getString(3).charAt(0);
			String empleado = rs.getString(1) + "," + rs.getString(2) + "," + sexo + "," + rs.getInt(4) + ","
					+ rs.getInt(5);
			empleados.add(empleado);
		}

		return empleados;

	}

	public int buscarSalario(String dni) throws SQLException {
		int salario = 0;
		String query = "select salario from nominas where dni = ?";
		PreparedStatement ps = this.con.prepareStatement(query);
		ps.setString(1, dni);
		rs = ps.executeQuery();
		while (rs.next()) {
			salario = rs.getInt("salario");
		}

		return salario;
	}

}

package bbdd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import laboral.Nomina;

public class ficheros {

	public static void main(String[] args) throws IOException, DatosNoCorrectosException {
		// TODO Auto-generated method stub
		//Creacion de fichero empleados
				File empleados = new File("empleados.txt");
				
				FileReader fr = new FileReader (empleados);
				BufferedReader br = new BufferedReader(fr);
				String lectura1 = br.readLine();
				String[] registro1 = lectura1.split(",");
				
				
				
				Empleado emp1 = new Empleado(registro1[0], registro1[1], registro1[2].charAt(0), Integer.parseInt(registro1[3]), Integer.parseInt(registro1[4]));
				
				
				String lectura2 = br.readLine();
				String[] registro2 = lectura2.split(",");
				
				br.close();
				Empleado emp2 = new Empleado(registro2[0], registro2[1], registro2[2].charAt(0));
				
				System.out.println(escribe(emp1, emp2));
				
				emp1.setCategoria(9);
				registro1[3] = Integer.toString(emp1.getCategoria());
				emp2.incrAnyo();
				registro2[3] = Integer.toString(emp2.anyos);
				
				empleados.delete();
				FileWriter fw = new FileWriter(empleados);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int i = 0; i < registro1.length; i++) {
					bw.write(registro1[i] + ",");
				}
				bw.write("\n");
				
				for (int i = 0; i < registro2.length; i++) {
					bw.write(registro2[i] + ",");
				}
				bw.close();
				
				
				 FileOutputStream fos = new FileOutputStream("datos.dat");
				 DataOutputStream dos = new DataOutputStream(fos);
				
				fos.write(registro1[1].getBytes());
				fos.write(Nomina.sueldo(emp1));
				fos.write(registro2[2].getBytes());
				fos.write(Nomina.sueldo(emp2));
				
				
	}
	
	private static String escribe(Empleado emp1, Empleado emp2) {
		return emp1.toString() + " Gana: " + Nomina.sueldo(emp1) + emp2.toString() + " Gana: " + Nomina.sueldo(emp2);
	}

}

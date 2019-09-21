package Laboral;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CalculadoraNominas {

	public static void main(String[] args) throws DatosNoCorrectosException, IOException {
		// TODO Auto-generated method stub
		
		//Creacion de fichero empleados
		File empleados = new File("empleados.txt");
		
		Scanner sc = new Scanner(empleados);
		String registro1 = sc.nextLine();
		
		//Recogida de la informacion del primer empleado
		
		String[] campo1 = registro1.split(",");
		
		Empleado emp1 = new Empleado(campo1[0], campo1[1], campo1[2].charAt(0), Integer.parseInt(campo1[3]), Integer.parseInt(campo1[4]));

		
		//Recogida de la informacion del segundo empleado
		
		String registro2 = sc.nextLine();
		String[] campo2 = registro2.split(",");
		
		Empleado emp2 = new Empleado(campo2[0], campo2[1], campo2[2].charAt(0));
		
		System.out.println(escribe(emp1, emp2));
		
		emp1.setCategoria(9);
		campo1[3] = Integer.toString(emp1.getCategoria());
		emp2.incrAnyo();
		campo2[2] = Integer.toString(emp2.anyos);
		
		
		empleados.delete();
		FileWriter fw = new FileWriter(empleados);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(campo1.toString() + "\n" + campo2.toString());

        bw.close();
		
	}

	private static String escribe(Empleado emp1, Empleado emp2) {
		return emp1.toString() + " Gana: " + Nomina.sueldo(emp1) + emp2.toString() + " Gana: " + Nomina.sueldo(emp2);
	}
	
}


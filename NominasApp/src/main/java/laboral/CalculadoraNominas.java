package laboral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bbdd.BBDD;
import bbdd.Backup;

public class CalculadoraNominas {

	public static void main(String[] args) throws DatosNoCorrectosException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
			
//		File altaEmpleados = new File("C:\\Users\\juanm\\git\\DWES\\NominasRepaso\\altaNuevosEmpleados.txt");
		BBDD bbdd = new BBDD();
		Backup backup = new Backup(bbdd);
		boolean salir = false;		
		
		Scanner numeros = new Scanner(System.in);
		Scanner palabras = new Scanner(System.in);
				
		while (!salir) {
			
			System.out.println("1. Ver todos los empleados \n"
					+ "2. Ver salario de un empleado especifico \n"
					+ "3. Submenu de edicion \n"
					+ "4. Recalcular y actualizar sueldo de un empleado \n"
					+ "5. Recalcular y actualizar sueldos de todos los empleados \n"
					+ "6. Realizar copia de seguridad de la BBDD en fichero \n"
					+ "Pulsa cualquier otra tecla para salir");
			String opcionMenu = palabras.nextLine();
			
		
			switch (opcionMenu) {
				case "1": 
					
					for (String empleado : bbdd.mostrarEmpleados()) {
						System.out.println(empleado);
					}
					
					break;
				case "2":
					
					System.out.println("Introduce el dni: ");
					String dni = palabras.nextLine();
					System.out.println(bbdd.buscarSalario(dni));
					
					
					break;
				case "3":
					System.out.println("Introduce DNI para editar el empleado");
					String dniEditar = palabras.nextLine();
					String nombreNuevo;
					String sexoNuevo;
					int categoriaNueva;
					int anyosNuevos;
					
					
						System.out.println("Elige un campo para editar \n"
								+ "1. Nombre \n"
								+ "2. Sexo \n"
								+ "3. Categoria \n"
								+ "4. Anyos \n"
								+ "5. Todos los campos \n"
								+ "Introduce cualquier otra tecla para salir.");
						
						
							Empleado empleadoParaEditar = bbdd.buscarEmpleado(dniEditar);
							String opcionSubmenu = numeros.nextLine();
							
						switch (opcionSubmenu) {
						case "1":
							System.out.println("Elija el nuevo nombre");
							nombreNuevo = palabras.nextLine();
							bbdd.editarEmpleado(new Empleado(nombreNuevo, dniEditar, empleadoParaEditar.sexo, empleadoParaEditar.getCategoria(), empleadoParaEditar.anyos));
							
							break;
						case "2":
							System.out.println("Elija el nuevo sexo");
							sexoNuevo = palabras.nextLine();
							bbdd.editarEmpleado(new Empleado(empleadoParaEditar.nombre, dniEditar, sexoNuevo.charAt(0), empleadoParaEditar.getCategoria(), empleadoParaEditar.anyos));

							
							
							break;
						case "3":
							System.out.println("Elija la nueva categoria");
							categoriaNueva = numeros.nextInt();
							bbdd.editarEmpleado(new Empleado(empleadoParaEditar.nombre, dniEditar, empleadoParaEditar.sexo, categoriaNueva, empleadoParaEditar.anyos));

							break;
						case "4":
							System.out.println("Elija los nuevos anyos");
							anyosNuevos = numeros.nextInt();
							bbdd.editarEmpleado(new Empleado(empleadoParaEditar.nombre, dniEditar, empleadoParaEditar.sexo, empleadoParaEditar.getCategoria(), anyosNuevos));

							break;
						case "5":
							System.out.println("Elija el nuevo nombre");
							nombreNuevo = palabras.nextLine();
							
							System.out.println("Elija el nuevo sexo");
							sexoNuevo = palabras.nextLine();
							
							System.out.println("Elija la nueva categoria");
							categoriaNueva = numeros.nextInt();
							
							System.out.println("Elija los nuevos anyos");
							anyosNuevos = numeros.nextInt();
							
							bbdd.editarEmpleado(new Empleado(nombreNuevo, dniEditar, sexoNuevo.charAt(0), categoriaNueva, anyosNuevos));

							break;
						default:
							System.out.println("");
							break;
						}
						
					
					break;
					
				case "4":
					System.out.println("Introduce el dni para recalcular el sueldo");
					dniEditar = palabras.nextLine();
					bbdd.calcularSueldo(bbdd.buscarEmpleado(dniEditar));
					
					
					break;
					
				case "5":
					for(String registro : bbdd.mostrarEmpleados()) {
						dni = registro.split(",")[1];
						bbdd.calcularSueldo(bbdd.buscarEmpleado(dni));
					}
					
					break;
					
				case "6":
					
					backup.backupbbddafichero();
					
					break;
					
				
					
				default:
					salir=true;
					break;
			}
		
	
		};
			

	}
}
		
	

	
	



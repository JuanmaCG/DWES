package bbdd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Backup {

	BBDD bbdd;

	public Backup(BBDD bbdd) {
		super();
		this.bbdd = bbdd;
	}
	
	public void backupbbddafichero() throws ClassNotFoundException, IOException, SQLException {
		File backup = new File("backup.txt");
		BufferedWriter wr = new BufferedWriter(new FileWriter(backup,false));
		
		for(String empleado : bbdd.mostrarEmpleados()) {
			wr.write(empleado + "\n");
		}
		
		wr.close();
	}
	
	
}

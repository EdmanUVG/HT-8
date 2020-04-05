
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class ArchivoTXT {
	
	public static Object[] leerTXT() {
		
		ArrayList<Paciente> lineas = new ArrayList<Paciente>();
		
		try {
						
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader("src/pacientes.txt"));
			
			
			String linea = "";
			
			while((linea = reader.readLine()) != null) {
				String[] split = linea.split(", "); 
				lineas.add(new Paciente(split[0].trim(),split[1].trim(),split[2].trim()));
				
			}
			
			
			reader.close();
			
			
		} catch (Exception e) {
			
		}
		
		return lineas.toArray();
	}

}
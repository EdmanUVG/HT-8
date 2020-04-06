
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Leer {
	
	public static Object[] leer() {
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		try {
						
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader("src/pacientes.txt"));
			
			
			String paciente = "";
			
			while((paciente = reader.readLine()) != null) {
				String[] split = paciente.split(", "); 
				pacientes.add(new Paciente(split[0].trim(),split[1].trim(),split[2].trim()));
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			
		}
		
		return pacientes.toArray();
	}

}
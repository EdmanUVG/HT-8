/**
 * 
 * @author edman
 *
 */

public class Controller {
	
	private PriorityQueue<Paciente> data;
	private Paciente PacienteActual;
	
	
	public Controller(String factory) {
		Factory<Paciente> fact = new Factory<Paciente>();
		data = fact.getPriority(factory);
	}
	

	public void addPacientes() {
		Object[] data = Leer.leer();
		for (Object a : data) {
			this.data.add(((Paciente)a));
		}
	}
	
	
	public void transferir() {
		PacienteActual = data.remove();
	}


	public Paciente getPaciente() {
		return PacienteActual;
	}
	
	public boolean atender() {
		PacienteActual = null;
		return true;
	}
	

	public PriorityQueue<Paciente> getPacientes(){
		return data.clone();
	}
	
	public int size() {
		return data.size();
	}
	
	
	
	
}

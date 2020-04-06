import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author edman
 *
 */
public class JUnitTest {
	
	VectorHeap<Paciente> paciente = new VectorHeap<Paciente>();

	@Test
	public void VectorHeapTest() {
		
		paciente.add(new Paciente("Doublas Barrios", "Fiebre", "B"));
		paciente.add(new Paciente("Jimmi Morales", "COVID-19", "E"));
		paciente.add(new Paciente("Alejandro Guimattei", "Tos","A"));
		
		assertEquals(paciente.remove().getNombre(), "Alejandro Guimattei");
		assertEquals(paciente.remove().getSintoma(), "Fiebre");
		
	}

}

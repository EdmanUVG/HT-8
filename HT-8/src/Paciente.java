

public class Paciente implements Comparable<Paciente> {
	
	private String nombre;
	private String sintoma;
	private String codigo;
	
	public Paciente() {
		nombre = "";
		sintoma = "";
		codigo = "";
	}

	/**
	 * @param nombre
	 * @param sintoma
	 * @param codigo
	 */
	public Paciente(String nombre, String sintoma, String codigo) {
		super();
		this.nombre = nombre;
		this.sintoma = sintoma;
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sintoma
	 */
	public String getSintoma() {
		return sintoma;
	}

	/**
	 * @param sintoma the sintoma to set
	 */
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		return codigo.compareTo(o.toString());
	}

	
	@Override
	public String toString() {
		return "Codigo: " + codigo + "\nNombre: " + nombre + "\nSintoma: " + sintoma;
	}

}

package datos;


public class PersonaFisica extends Cliente{
	private String apellido;
	private String nombre;
	private int dni;
	public PersonaFisica(int idCliente, String nroCliente, String apellido, String nombre, int dni) {
		super(idCliente, nroCliente);
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "PersonaFisica [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	@Override
	public boolean equals(Object obj) {
		PersonaFisica other = (PersonaFisica) obj;
		return dni == other.dni;
	}
	
	
}

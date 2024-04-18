package datos;


public class Contacto {
	private long idContacto;
	private String email;
	private String movil;
	private String fijo;
	public Contacto(long idContacto, String email, String movil, String fijo) {
		this.idContacto = idContacto;
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
	}
	public long getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getFijo() {
		return fijo;
	}
	public void setFijo(String fijo) {
		this.fijo = fijo;
	}
	
	public boolean equals(Contacto contacto) {
		return this.idContacto==contacto.getIdContacto();
	}
	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", movil=" + movil + ", fijo=" + fijo + "]";
	}
	
	
}

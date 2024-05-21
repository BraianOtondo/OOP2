package datos;

import java.util.Objects;

public class PersonaJuridica extends Cliente{
	private String razonSocial;
	private String cuit;
	public PersonaJuridica(int idCliente, String nroCliente, String razonSocial, String cuit) {
		super(idCliente, nroCliente);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuit);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		PersonaJuridica other = (PersonaJuridica) obj;
		return Objects.equals(cuit, other.cuit);
	}
	@Override
	public String toString() {
		return "PersonaJuridica [razonSocial=" + razonSocial + ", cuit=" + cuit + "]";
	}
	
	
}

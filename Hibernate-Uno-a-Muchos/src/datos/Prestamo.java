package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;

	public Prestamo() {
	}

	public Prestamo(LocalDate fecha, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + fecha + ", interes=" + interes + ", cantCuotas="
				+ cantCuotas + "]";
	}

	public boolean equals(Prestamo prestamo) {
		return this.idPrestamo == prestamo.getIdPrestamo();
	}

}

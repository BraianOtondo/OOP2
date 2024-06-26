package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) {
		return dao.traer(idPrestamo);
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}

	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente)throws Exception{
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(p);
	}
	// public Prestamo(LocalDate fecha, double monto, double interes, int
	// cantCuotas, Cliente cliente) {

	public void eliminar(long idPrestamo) {
		Prestamo objeto=this.traerPrestamo(idPrestamo);
		dao.eliminar(objeto);
	}
}

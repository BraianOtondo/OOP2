package negocio;

import java.time.LocalDate;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	private ClienteDao dao = new ClienteDao();

	// TRAE PERO SIN LISTA. NO SE PUEDE ACCEDER CON GET
	public Cliente traer(int idCliente) {
		return dao.traer(idCliente);
	}
	public Cliente traer(long dni) {
		return dao.traer(dni);
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente cliente = this.traer(dni);
		if (cliente != null) {
			throw new Exception("Ya existe cliente con DNI: " + dni);
		}
		cliente = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(cliente);
	}

	public void modificar(Cliente cliente) throws Exception {
		Cliente objeto=this.traer(cliente.getDni());
			if(objeto!=null) {
				throw new Exception("El cliente que quiere cambiar ya existe con ese dni");
			}
			dao.actualizar(cliente);
		}

	// TRAE CON LISTA. SE PUEDE ACCEDER CON GET
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}

}

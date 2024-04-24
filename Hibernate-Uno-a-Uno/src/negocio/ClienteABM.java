package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	ClienteDao dao1 = new ClienteDao();
	public Cliente traerClienteYContacto(long idCliente) {
		Cliente c = dao.traerClienteYContacto(idCliente);
		return c;
	}

	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto) throws Exception {
		// consultar si existe un cliente con el mismo dni, si existe arrojar la
		// Excepcion
		Cliente objeto=this.traer(dni);
		if (objeto != null) {
			throw new Exception("Ya existe un cliente con el mismo dni");
		}
		objeto = new Cliente(apellido, nombre,dni, fechaDeNacimiento, contacto);
		return dao.agregar(objeto);
	}

	@SuppressWarnings("unused")
	public void modificar(Cliente cliente) throws Exception {
		// implementar antes de actualizar que no exista un cliente con el mismo
		// documento a modificar y con el mismo id, lanzar la Exception
		Cliente objeto=dao.traer(cliente.getDni());
		if(cliente.getIdCliente()!=objeto.getIdCliente()) {
			throw new Exception("No se puede cambiar el id de un cliente ya existente ");
		}else if (objeto!= null) {
			throw new Exception("Ya existe un cliente con el mismo dni que se quiere cambiar");
		}
		dao.actualizar(cliente);
	}

	/*
	 * Cliente objeto = traer(c.getDni()); if (objeto != null && c.getIdCliente() !=
	 * objeto.getIdCliente()){ throw new Exception
	 * ("Ya existe un cliente con ese DNI."); }
	 */
	public void eliminar(long idCliente) throws Exception {
		// Implementar que si es null que arroje la excepción la Excepción
		Cliente c = dao.traer(idCliente);
		if (c == null) {
			throw new Exception("El cliente no existe");
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}

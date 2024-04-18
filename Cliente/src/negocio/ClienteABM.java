package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	public Cliente traer(long idCliente) {
	return dao.traer(idCliente);
	}
	public Cliente traer(int dni) {
	return dao.traer(dni);
	}
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento)throws Exception{
	// consultar si existe un cliente con el mismo dni, y si existe, arrojar la Excepcion
	Cliente objeto=this.traer(dni);
		if(objeto!=null) {
			throw new Exception("El cliente con dni:"+dni+" ya existe en la base de datos");
		}
		objeto = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(objeto);
	}
	/**
	En caso de editar el dni, antes de actualizar, validar que no exista un cliente con el mismo
	dni y si eso pasa lanzar la Exception
	*/
	public void modificar(Cliente c) throws Exception{
		Cliente objeto=this.traer(c.getDni());
		// existe este dni en la base de datos? && este id 
		if(objeto!=null) {
			throw new Exception("Ya existe un cliente con ese mismo dni en la bdd");
		}
		
		dao.actualizar(c);
	}
	/**
	En este caso la baja es física y sabemos que la entidad no tiene relaciones
	* pero en caso de tenerlas, hay que validar que el cliente no tenga dependencias que
	generen errores al borrarlo.
	*/
	public void eliminar(long idCliente) throws Exception{
	Cliente objeto=dao.traer(idCliente);
	if(objeto==null) {
		throw new Exception("El cliente no existe");
	}
	dao.eliminar(objeto);
	}
	public List<Cliente> traer() {
	return dao.traer();
	}
}


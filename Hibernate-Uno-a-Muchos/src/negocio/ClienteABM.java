package negocio;

import java.time.LocalDate;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	private ClienteDao dao=new ClienteDao();
	
	

	public int agregar(String apellido,String nombre,int dni,LocalDate fechaDeNacimiento) {
		Cliente cliente= new Cliente(apellido, nombre, dni, fechaDeNacimiento);	
		return dao.agregar(cliente);
		}
	//TRAE CON LISTA. SE PUEDE ACCEDER CON GET
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
		}
	//TRAE PERO SIN LISTA. NO SE PUEDE ACCEDER CON GET
	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}
}

package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	ContactoDao dao = new ContactoDao();

	public Contacto traer(long idContacto) {
		Contacto c = dao.traer(idContacto);
		return c;
	}

	public int agregar(String email, String movil, String fijo, Cliente cliente)throws Exception{// PREGUNTAR SI HAY OTRO CONTACTO???
		Contacto objeto=this.traer(cliente.getIdCliente());
		if(objeto!=null) {
			throw new Exception("Ya existe un contacto en este cliente en la bdd");
		}
		Contacto c = new Contacto(email, movil, fijo, cliente);
		return dao.agregar(c);
	}

	public void modificar(Contacto c) {
		dao.actualizar(c);
	}

	public void eliminar(long idContacto) {
		Contacto c = dao.traer(idContacto);
		dao.eliminar(c);
	}
}

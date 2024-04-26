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
		objeto = new Contacto(email, movil, fijo, cliente);
		return dao.agregar(objeto);
	}

	public void modificar(Contacto c)throws Exception{
		Contacto contacto=this.traer(c.getIdContacto());
		if(contacto!=null) {
			throw new Exception("El contacto que se quiere cambiar ya existe en un cliente");
		}
		
		dao.actualizar(c);
	}

	public void eliminar(long idContacto) throws Exception{
		//Cliente c = dao.traer(idCliente);
		Contacto c = dao.traer(idContacto);
		if(c==null) {//existe
			throw new Exception("No se puede eliminar porque no existe este contacto");
		}
		
		dao.eliminar(c);
	}
}

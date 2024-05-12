package test;
import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente=new ClienteABM();
		System.out.println("Lista 1");
		System.out.println(abmCliente.traer());
		// Eliminar Cliente sin Contacto
		try {
			abmCliente.eliminar(5L);
			System.out.println("Se elimino el cliente correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Lista 2");
		System.out.println(abmCliente.traer());
		
		//Eliminar Cliente que tiene contacto
		try {
			abmCliente.eliminar(1L);
			System.out.println("Se elimino el cliente correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		ContactoABM abmContacto=new ContactoABM();
		System.out.println("Contacto 1");
		System.out.println(abmContacto.traer(1L));
		try {
			abmContacto.eliminar(4L);
			System.out.println("El contacto se elimino correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Lista 3: TRAER");
		System.out.println(abmCliente.traer());
		//Traer CLiente y contacto
		System.out.println("Cliente y Contacto especifico" );
		System.out.println(abmCliente.traerClienteYContacto(1L));
	}


}

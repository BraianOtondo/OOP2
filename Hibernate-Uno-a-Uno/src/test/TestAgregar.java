package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int idUltimoCliente=0;
		//sistema abm para crear clienes, no es un solo cliente. Pueden ser varios
		//ClienteABM clientes=new ClienteABM();
		
		//Agregar Clientes a contacto
		ClienteABM abmCliente = new ClienteABM();
		ContactoABM abmContacto = new ContactoABM();

		long idCliente = 1;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		try {
			abmContacto.agregar("ajaramillo@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente);//NECESITA EXCEPCION ? para no crear otro contacto dentro del existente

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}

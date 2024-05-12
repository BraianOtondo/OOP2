package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente=new ClienteABM();
		long idCliente=1;
		try {
			Cliente c=abmCliente.traerClienteYContacto(idCliente);
			System.out.println(c.getContacto());
			System.out.println(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
	
		System.out.println("Traer por DNI:");
		Cliente cliente2=null;
		try {
			cliente2=abmCliente.traer(14000000);
			System.out.println(cliente2);
			System.out.println(cliente2.getContacto());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error traer por dni");
		}
		
	}

}

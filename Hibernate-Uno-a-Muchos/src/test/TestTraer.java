package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraer {
	public static void main(String[] args) {
		ClienteABM clienteABM=new ClienteABM();
		Cliente cliente = null;
		try {
			cliente=clienteABM.traerClienteYPrestamos(1L);
			System.out.println(cliente);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("ERROR");
			
		}
		System.out.println("IMPRESION");
		System.out.println(cliente);
		System.out.println(cliente.getPrestamos());

	}
}

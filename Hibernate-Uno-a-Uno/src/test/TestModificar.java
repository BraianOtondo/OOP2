package test;
import datos.Cliente;
import negocio.ClienteABM;
import test.TestAgregar;
public class TestModificar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente=new ClienteABM();
		Cliente cliente=abmCliente.traer(1L);
		cliente.setApellido("Sanchez");
		cliente.setNombre("Coti");
		//Salta error de que no se puede cambiar el id de un cliente que ya existe
		//cliente.setIdCliente(5);
		//Test Modificar todo menos id
		try {
			abmCliente.modificar(cliente);
			System.out.println("La modificacion fue todo un exito");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println();
	}

}

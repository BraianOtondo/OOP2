package test;

import dao.ClienteDao;
import datos.Cliente;

public class TestModificar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteDao dao=new ClienteDao();
		Cliente cliente1=dao.traer(4);
		cliente1.setNombre("Julio");
		cliente1.setDni(42617454);
		System.out.println(cliente1);
		try {
			System.out.println("El cliente se actualizo perfectamente");
			dao.actualizar(cliente1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
		
		System.out.println("Nuevo:");
		System.out.println(cliente1);

	}

}

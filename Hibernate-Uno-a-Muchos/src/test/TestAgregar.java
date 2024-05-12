package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dni=42091996;
		ClienteABM clienteABM=new ClienteABM();
		try {
			int id=clienteABM.agregar("Guzz","Marcos",dni,LocalDate.now());
			System.out.println(id);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}

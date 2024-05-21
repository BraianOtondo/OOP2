package test;

import java.time.LocalDate;
import java.util.TimeZone;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long dni=42091997;
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		ClienteABM clienteABM = new ClienteABM();
		PrestamoABM prestamoABM = new PrestamoABM();

		try {
			int id1 = clienteABM.agregar("Guzz", "Marcos", 8458175, LocalDate.now());
			System.out.println(id1);
			// System.out.println((long)id);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			// System.out.println("Error1");
		}
		try {
			int id2=clienteABM.agregar("Guzz","Roberto", 4214241,LocalDate.now());
			System.out.println(id2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			int id3=clienteABM.agregar("Lopez","Ricardo", 45321440,LocalDate.now());
			System.out.println(id3);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			int id4=clienteABM.agregar("Lopez","Ricardo", 45321441,LocalDate.now());
			System.out.println(id4);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			int id5=clienteABM.agregar("Gutierrez","Ricardo", 45321442,LocalDate.now());
			System.out.println(id5);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		Cliente cliente=clienteABM.traer(45321442);
		try {
			int idP=prestamoABM.agregar(LocalDate.now(), 200.00, 10.00, 3,cliente);
			System.out.println(idP);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println("CORROBORAR");
		System.out.println(clienteABM.traer(19L));
		System.out.println("----------------------");
		//System.out.println(clienteABM.traerClientesEnRangoCumpleanio(LocalDate.of(2024, 5, 19),LocalDate.now()));
		//System.out.println(clienteABM.traerClientesAbiertoFechaCumpleaño(LocalDate.of(2024, 5, 19),LocalDate.now()));
		System.out.println(clienteABM.traerPorFechaPrestamo(LocalDate.now()));
	}

}

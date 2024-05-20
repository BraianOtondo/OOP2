package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long dni=42091997;
		ClienteABM clienteABM=new ClienteABM();
		PrestamoABM prestamoABM= new PrestamoABM();
		
		try {
			int id1=clienteABM.agregar("Guzz","Marcos",8458175,LocalDate.now());
			System.out.println(id1);
			System.out.println("Se agrego");
			//System.out.println((long)id);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//System.out.println("Error1");
		}
		Cliente cliente1=clienteABM.traer(1L);
		//Agregar Prestamo
		System.out.println("-----------------------------------------------------------------");
		try {
			double num1=200.00;
			double num2=10.00;
			int id=prestamoABM.agregar(LocalDate.now(),num1,num2,12,cliente1);
			System.out.println(id);
			//(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//System.out.println("Error2");
		}
		//System.out.println("CLIENTE Y PRESTAMOS");
		///System.out.println(clienteABM.traerClienteYPrestamos(2));
	}

}

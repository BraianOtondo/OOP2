package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int idUltimoCliente=0;
		//sistema abm para crear clienes, no es un solo cliente. Pueden ser varios
		//ClienteABM clientes=new ClienteABM();
		//PRUEBA CON AUTOINCREMENTAL 4. 1... 4 ...8..12
		//Agregar Clientes a contacto
		ClienteABM abmCliente = new ClienteABM();
		ContactoABM abmContacto = new ContactoABM();

		long idCliente = 1;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		//Agregar Cliente
		try {
			abmCliente.agregar(cliente.getApellido(),cliente.getNombre(),(int)cliente.getDni(),cliente.getFechaDeNacimiento(), null);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
			
		//Agregar Contacto
		try {
			abmContacto.agregar("ajaramillo@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente);//NECESITA EXCEPCION ? para no crear otro contacto dentro del existente

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			abmCliente.agregar("Lopez","Roberto",42951257,LocalDate.now(), null);
			System.out.println("El proceso de agregar tuvo exito");
			//agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto)
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		Cliente cliente2=abmCliente.traer((long)4);
		try {
			abmContacto.agregar("ajaramillo@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente2);//NECESITA EXCEPCION ? para no crear otro contacto dentro del existente

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Lista:");
		System.out.println(abmCliente.traer());
	}

}

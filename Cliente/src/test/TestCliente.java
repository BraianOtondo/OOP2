package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {
	public static void main(String[] args) {
		/*
		 * En el formateo de Strings con printf tiene varios especificadores de formato.
		 * Algunos de los más comunes son: %d: Entero con signo (para int y long). %f:
		 * Número de punto flotante (para float y double). %s: Cadena de caracteres. %c:
		 * Carácter. %b: Valor booleano.
		 */
		int ultimoIdCliente = 0;
		// agregar Cliente
		ClienteABM abm = new ClienteABM();

		try {
			abm.agregar("Marcell", "Mariano", 35000000, LocalDate.now());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		// Traer Lista de clientes
		// System.out.println("Lista: ");
		// System.out.println(abm.traer());

		// Agregar Cliente Nuevo

		try {
			ultimoIdCliente = abm.agregar("Lopez", "Ramon", 42634655, LocalDate.now());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("No se pudo agregar");

		}

		System.out.printf("Id cliente: %d \n", ultimoIdCliente);
		System.out.println("Lista  : ");
		System.out.println(abm.traer());

		// Traer el objeto del primer cliente
		System.out.println("Primer Cliente :" + abm.traer(7L));

		// Modificar algun dato de un cliente
		Cliente c = abm.traer(35000000);
		c.setDni(42091996);
		try {
			abm.modificar(c);
			System.out.println("El cliente se modifico con exito");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

		// Traer Lista de clientes
		System.out.println("Lista 2:");
		System.out.println(abm.traer());

		// Eliminar Cliente

		try {
			abm.eliminar(9L);
			System.out.println("El cliente se elimino con exito");

		} catch (Exception e) { // TODO: handle exception
			System.out.println(e.getMessage());
		}

		System.out.println("Lista 3:");
		System.out.println(abm.traer());

	}
}

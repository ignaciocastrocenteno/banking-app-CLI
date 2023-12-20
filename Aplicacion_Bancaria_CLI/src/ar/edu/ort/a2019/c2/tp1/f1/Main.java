package ar.edu.ort.a2019.c2.tp1.f1;

import java.util.ArrayList;

import ar.edu.ort.a2019.c2.tp1.f1.clases.Banco;
import ar.edu.ort.a2019.c2.tp1.f1.clases.Cliente;
import ar.edu.ort.a2019.c2.tp1.f1.clases.ClienteEstandar;
import ar.edu.ort.a2019.c2.tp1.f1.clases.ClienteVIP;
import ar.edu.ort.a2019.c2.tp1.f1.clases.Mes;
import ar.edu.ort.a2019.c2.tp1.f1.clases.Operacion;
import ar.edu.ort.a2019.c2.tp1.f1.clases.TipoOperacion;

public class Main {

	public static void main(String[] args) {

		Banco banco = new Banco("Santander Rio", generarClientes(), 3);

		trabajarConBanco(banco);

		banco.finDelDia();

	}

	private static void trabajarConBanco(Banco banco) {

		try {
			banco.atender();
		} catch (RuntimeException e) {
			System.out.println(Banco.NO_HABIA_CLIENTES_PARA_ATENDER);
		}

		System.out.println("----------------------------------------------------------");
		recibirClientes(banco);
		System.out.println("----------------------------------------------------------");

		banco.atender();

		System.out.println("----------------------------------------------------------");

		banco.atender();

		System.out.println("----------------------------------------------------------");

		banco.atender();

		System.out.println("----------------------------------------------------------");
	}

	private static void recibirClientes(Banco banco) {
		final String ERROR_RECIBIENDO_CLIENTES = "Error recibiendo un cliente: ";
		try {
			banco.recibirCliente(313, new Operacion(TipoOperacion.DEPOSITO, 4432, 2, Mes.JULIO, 2019));
		} catch (Exception e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(44, new Operacion(TipoOperacion.DEPOSITO, 433, 22, Mes.ENERO, 2019));
		} catch (Exception e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(19, new Operacion(TipoOperacion.DEPOSITO, 4432, 2, Mes.JULIO, 2019));
		} catch (Exception e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(887786574, new Operacion(TipoOperacion.EXTRACCION, 4432, 2, Mes.JULIO, 2019));
		} catch (RuntimeException e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(22, new Operacion(TipoOperacion.EXTRACCION_DOLARES, 4432, 22, Mes.AGOSTO, 2019));
		} catch (RuntimeException e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(192, new Operacion(TipoOperacion.DEPOSITO_DOLARES, 4432, 22, Mes.OCTUBRE, 2019));
		} catch (RuntimeException e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(18, new Operacion(TipoOperacion.DEPOSITO, 4432, 44, Mes.SEPTIEMBRE, 2019));
		} catch (RuntimeException e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

		try {
			banco.recibirCliente(18, new Operacion(TipoOperacion.DEPOSITO, 4432, 29, Mes.SEPTIEMBRE, 2019));
		} catch (RuntimeException e) {
			System.out.println(ERROR_RECIBIENDO_CLIENTES + e.getMessage());
		}

	}

	private static ArrayList<Cliente> generarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		clientes.addAll(generarClientesVip());
		System.out.println("----------------------------------------------------------");
		clientes.addAll(generarClientesEstandar());
		System.out.println("----------------------------------------------------------");

		return clientes;
	}

	private static ArrayList<Cliente> generarClientesVip() {
		final String ERROR_GENERANDO_CLIENTES_VIP = "Error creando un cliente vip: ";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//AYUDITA: LOS ERRORES DE COMPILACIÓN SE RESUELVEN AL COMPLETAR LAS CLASES PERTINENTES
		try {
			clientes.add(new ClienteVIP(19, "20-29323432-2", "Cliente vip 19", "un@email.com", "1145452332"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(44, "20-23324432-1", "Cliente vip 44", "un2@email.com", "1145532332"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(-44, "20-42324432-1", "Cliente vip -44", "un2@email.com", "1145538932"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(33, "20-12345432-1", "Cliente vip 33", "un33@email.com", "2213214587"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (Exception e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(1, "", "Cliente vip -44", "un2@email.com", "1145538932"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (Exception e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(22, "20-12322432-1", "Cliente vip 22", "un22@email.com", "2213214327"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(1, "20-12345432-1", null, "un2@email.com", "1145538932"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}

		try {
			clientes.add(new ClienteVIP(18, "20-18323432-2", "Cliente vip 18", "un18@email.com", "1145451832"));
			System.out.println("Se agrego correctamente un cliente");
			
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_VIP + e.getMessage());
		}
		
		return clientes;
	}

	private static ArrayList<Cliente> generarClientesEstandar() {
		final String ERROR_GENERANDO_CLIENTES_ESTANDAR = "Error creando un cliente estandar: ";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		//AYUDITA: LOS ERRORES DE COMPILACIÓN SE RESUELVEN AL COMPLETAR LAS CLASES PERTINENTES
		
		try {
			clientes.add(new ClienteEstandar(192, "20-29323432-2", "Cliente vip 19", "un@email.com", "1145452332"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(444, "20-23324432-1", "Cliente vip 44", "un2@email.com", "1145532332"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(212, "20-42324432-1", "Cliente vip -44", "un2@email.com", null));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(313, "20-12345432-1", "Cliente vip 33", "un33@email.com", "2213214587"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(155, "20-123444432-1", "Cliente vip -44", null, "1145538932"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (RuntimeException e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(25232, "20-12322432-1", "Cliente vip 22", "un22@email.com", "2213214327"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (Exception e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		try {
			clientes.add(new ClienteEstandar(15542, "20-12345432-1", "", "un2@email.com", "1145538932"));
			System.out.println("Se agrego correctamente un cliente");
		} catch (Exception e) {
			System.out.println(ERROR_GENERANDO_CLIENTES_ESTANDAR + e.getMessage());
		}

		return clientes;
	}

}

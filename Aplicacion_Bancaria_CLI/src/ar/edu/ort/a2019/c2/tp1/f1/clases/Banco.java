package ar.edu.ort.a2019.c2.tp1.f1.clases;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ort.a2019.c2.tp1.f1.tad.Cola;
import ar.edu.ort.a2019.c2.tp1.f1.tad.Pila;
import ar.edu.ort.a2019.c2.tp1.f1.tad.implementaciones.nodo.ColaNodos;
import ar.edu.ort.a2019.c2.tp1.f1.tad.implementaciones.nodo.PilaNodos;

public class Banco {

	// DESCOMENTAR y UTILIZAR DONDE CORRESPONDA.
	public static final String NO_HABIA_CLIENTES_PARA_ATENDER = "No había clientes para atender";
	private static final String CLIENTE_INGRESADO_EN_LA_FILA_ESTANDAR = "Cliente ingresado en la fila Estandar";
	private static final String NO_SE_PUEDEN_RECIBIR_MAS_CLIENTES_ESTANDAR = "No se pueden recibir mas clientes Estandar";
	private static final String CLIENTE_INGRESADO_EN_LA_FILA_VIP = "Cliente ingresado en la fila VIP";
	private static final String NO_SE_PUEDEN_RECIBIR_MAS_CLIENTES_VIP = "No se pueden recibir mas clientes VIP";
	private static final String NOMBRE_DEL_BANCO_INVALIDO = "Nombre del banco inválido";
	private static final String LISTADO_DE_CLIENTES_INVALIDO = "Listado de clientes inválido";
	private static final String TAMANIO_DE_LAS_FILAS_INVALIDO = "Tamaño de las filas inválido";
	private final static int CANTIDAD_MAXIMA_HISTORIAL_OPERACIONES = 10000;
	// TODO COMPLETAR
	private String nombre;
	private int tamanioMaximoFilas;
	private List<Cliente> listaDeClientes;
	private Cola<Cliente> colaDeClientesVIP;
	private Cola<Cliente> colaDeClientesEstandar;
	private Pila<Operacion> historialDeOperaciones;
	private int[] operacionesPorMes;

	/**
	 * Constructor del banco.
	 * 
	 * @param nombre             Nombre del banco
	 * @param clientes           Nomina de clientes del banco
	 * @param tamanioMaximoFilas Tamaño máximo de las filas.
	 * @throws RuntimeException En caso de haber un error construyendo el banco.
	 */
	public Banco(String nombre, ArrayList<Cliente> clientes, int tamanioMaximoFilas) throws RuntimeException {
		// TODO COMPLETAR
		setNombre(nombre);
		crearListaDeClientes();
		inyectarClientes(clientes);
		setTamanioMaximoFilas(tamanioMaximoFilas);
		crearColasDeClientes();
		crearHistorialDeOperaciones();
		crearContadorDeOperacionesPorMes();
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isBlank()) {
			throw new RuntimeException(NOMBRE_DEL_BANCO_INVALIDO);
		}
		this.nombre = nombre;
	}
	
	private void crearListaDeClientes() {
		this.listaDeClientes = new ArrayList<Cliente>();
	}
	
	private void inyectarClientes(List<Cliente> clientes) {
		if(clientes.isEmpty()) {
			throw new RuntimeException(LISTADO_DE_CLIENTES_INVALIDO);
		}
		
		// Inyectando los clientes desde la lista externa hacia una lista interna
		for (Cliente cliente : clientes) {
			this.listaDeClientes.add(cliente);
		}
	}

	private void setTamanioMaximoFilas(int tamanioMaximoFilas) {
		if(tamanioMaximoFilas <= 0) {
			throw new RuntimeException(TAMANIO_DE_LAS_FILAS_INVALIDO);
		}
		this.tamanioMaximoFilas = tamanioMaximoFilas;
	}
	
	private void crearColasDeClientes() {
		this.colaDeClientesVIP = new ColaNodos<Cliente>(tamanioMaximoFilas);
		this.colaDeClientesEstandar = new ColaNodos<Cliente>(tamanioMaximoFilas);
	}
	
	private void crearHistorialDeOperaciones() {
		this.historialDeOperaciones = new PilaNodos<Operacion>(CANTIDAD_MAXIMA_HISTORIAL_OPERACIONES);
	}
	
	private void crearContadorDeOperacionesPorMes() {
		this.operacionesPorMes = new int[Mes.values().length];
	}
	
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", colaDeClientesVIP=" + colaDeClientesVIP + ", colaDeClientesEstandar="
				+ colaDeClientesEstandar + "]";
	}

	/**
	 * Recibe a un cliente que desea ser atendido.
	 * 
	 * @param nroCliente         Número de cliente que lo identifica
	 * @param operacionRequerida {@link Operacion} que desea realizar
	 * @throws RuntimeException En caso de ocurrir un error recibiendo a un cliente.
	 */
	public void recibirCliente(int nroCliente, Operacion operacionRequerida) 
			throws RuntimeException {
		// TODO COMPLETAR
		Cliente cliente = buscarCliente(nroCliente);
	
		if(cliente == null) {
			throw new RuntimeException("Cliente nro " + nroCliente + " no encontrado");
		}
		
		cliente.indicarOperacionRequerida(operacionRequerida);
		
		if(cliente.esVip()) {
			if(this.colaDeClientesVIP.isFull()) {
				throw new RuntimeException(NO_SE_PUEDEN_RECIBIR_MAS_CLIENTES_VIP);
			}
			this.colaDeClientesVIP.add(cliente);
			System.out.println(CLIENTE_INGRESADO_EN_LA_FILA_VIP);
		} else {
			if(this.colaDeClientesEstandar.isFull()) {
				throw new RuntimeException(NO_SE_PUEDEN_RECIBIR_MAS_CLIENTES_ESTANDAR);
			}
			this.colaDeClientesEstandar.add(cliente);
			System.out.println(CLIENTE_INGRESADO_EN_LA_FILA_ESTANDAR);
		}
	}

	/**
	 * Busca un cliente en la nomina de clientes en base a su número.
	 * 
	 * @param nroCliente Número del cliente a buscar
	 * @return el cliente buscado, o null si no lo encuentra
	 */
	// TODO COMPLETAR
	private Cliente buscarCliente(int nroCliente) {
		Cliente clienteDevolver = null;
		int i = 0;
		
		while(clienteDevolver == null && i < this.listaDeClientes.size()) {
			Cliente clienteActual = this.listaDeClientes.get(i);
			if(clienteActual.esMiNumero(nroCliente)) {
				clienteDevolver = clienteActual;
			} else {
				i++;
			}
		}
		
		return clienteDevolver;
	}

	/**
	 * Atiende al proximo cliente en la fila, primero agota los clientes vip, si no
	 * hay mas vip atiende a un estandar.
	 * 
	 * @throws RuntimeException si no hay clientes para atender.
	 */
	public void atender() throws RuntimeException {
		// TODO COMPLETAR
		if(this.colaDeClientesVIP.isEmpty() && this.colaDeClientesEstandar.isEmpty()) {
			throw new RuntimeException(NO_HABIA_CLIENTES_PARA_ATENDER);
		}
		
		// Atiendo primero a todos los clientes VIP que haya disponibles
		if(!this.colaDeClientesVIP.isEmpty()) {
			atender(this.colaDeClientesVIP);
		}
		
		// Cuando no haya mas clientes VIP por ser atendidos, se atienden a los Estandar
		if(!this.colaDeClientesEstandar.isEmpty()) {
			atender(this.colaDeClientesEstandar);
		}
	}

	/**
	 * Atiende un cliente de la fila especificada
	 * 
	 * @param fila la fila de la cual atender al cliente.
	 */
	// TODO COMPLETAR
	private void atender(Cola<Cliente> clientes) {
		Cliente c = clientes.remove();
		Operacion op = c.indicarOperacionRequerida();
		op.operar();
		this.historialDeOperaciones.push(op);
		this.operacionesPorMes[op.getMes().ordinal()]++;
	}
	

	/**
	 * Muestra un resumen con el diario de operaciones.
	 */
	public void finDelDia() {
		// TODO COMPLETAR
		System.out.println("Final del dia del banco " + nombre);
		System.out.println("- Cantidad de clientes: " + listaDeClientes.size());
		System.out.println("Cantidad total de operaciones: " + totalDeOperacionesRealizadas());
		System.out.println("Operaciones, mostradas en orden inverso al cual se ingresaron");
		mostrarOperaciones();
		cantidadDeOperacionesPorMes();
	}

	/**
	 * Muestra las operaciones alojadas una arriba de la otra, primero mostrará la
	 * ultima ingresada. el almacen de historico debe quedar en el mismo orden tras
	 * la ejecución.
	 */
	// TODO COMPLETAR
	private void mostrarOperaciones() {
		Pila<Operacion> pilaAux = new PilaNodos<Operacion>();
		
		while(!this.historialDeOperaciones.isEmpty()) {
			Operacion operacion = this.historialDeOperaciones.pop();
			pilaAux.push(operacion);
			/* Procesamiento de la pila: un output de todos las operaciones por
			 * medio de la interface Mostrable
			 */
			operacion.mostrar();
		}
		
		while(!pilaAux.isEmpty()) {
			this.historialDeOperaciones.push(pilaAux.pop());
		}
	}

	/**
	 * Calcula el total de operaciones realizadas
	 * 
	 * @return un entero conteniendo la cantidad de operaciones realizadas.
	 */
	// TODO COMPLETAR
	private int totalDeOperacionesRealizadas() {
		int totalOperaciones = 0;
		Pila<Operacion> pilaAux = new PilaNodos<Operacion>();
		
		while(!historialDeOperaciones.isEmpty()) {
			Operacion operacion = this.historialDeOperaciones.pop();
			pilaAux.push(operacion);
			// Procesamiento de la pila: contar todas las operaciones
			totalOperaciones++;
		}
		
		while(!pilaAux.isEmpty()) {
			historialDeOperaciones.push(pilaAux.pop());
		}
		
		return totalOperaciones;
	}
	
	private void cantidadDeOperacionesPorMes() {
		Mes[] meses = Mes.values();
		System.out.println("Operaciones por mes:");
		for (int i = 0; i < meses.length; i++) {
			System.out.println("Mes: " + meses[i].name() + " " + this.operacionesPorMes[i] + " operaciones");
		}
	}
}

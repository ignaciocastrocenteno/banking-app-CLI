/**
 * 
 */
package ar.edu.ort.a2019.c2.tp1.f1.clases;

/**
 *
 */
public abstract class Cliente implements EsVip, Mostrable {

	// TODO COMPLETAR
	private static final String NRO_CLIENTE_INVALIDO = "Numero de cliente invalido";
	private static final String CUIT_INVALIDO = "Cuit del cliente invalido";
	private static final String NOMBRE_APELLIDO_INVALIDO = "Nombre y Apellido del cliente invalido";
	private static final String EMAIL_INVALIDO = "Email del cliente invalido";
	private static final String CELULAR_INVALIDO = "Celular del cliente invalido";
	public static final String OPERACION_INVALIDA = "Operacion Invalida";
	private static final byte MINIMO_NRO_CLIENTE = 1;
	private int nroCliente;
	private String cuit;
	private String nombreApellido;
	private String email;
	private String celular;
	private Operacion operacionRequerida;

	/**
	 * Construye el Cliente
	 * 
	 * @param nroCliente     Número del cliente, mayor a 0
	 * @param cuit           No nulo ni vacío
	 * @param nombreApellido Nombre y Apellido del cliente, no nulo ni vacío
	 * @param email          No nulo ni vacío
	 * @param celular        No nulo ni vacío
	 * @throws RuntimeException en caso de problemas de validación
	 */
	public Cliente(int nroCliente, String cuit, String nombreApellido, String email, String celular)
			throws RuntimeException {
		// TODO COMPLETAR
		setNroCliente(nroCliente);
		setCuit(cuit);
		setNombreApellido(nombreApellido);
		setEmail(email);
		setCelular(celular);
		setOperacionRequerida(null);
	}

	private void setNroCliente(int nroCliente) {
		if(nroCliente < MINIMO_NRO_CLIENTE) {
			throw new RuntimeException(NRO_CLIENTE_INVALIDO);
		}
		this.nroCliente = nroCliente;
	}

	private void setCuit(String cuit) {
		if(cuit == null || cuit.trim().isBlank()) {
			throw new RuntimeException(CUIT_INVALIDO);
		}
		this.cuit = cuit;
	}

	private void setNombreApellido(String nombreApellido) {
		if(nombreApellido == null || nombreApellido.trim().isBlank()) {
			throw new RuntimeException(NOMBRE_APELLIDO_INVALIDO);
		}
		this.nombreApellido = nombreApellido;
	}

	private void setEmail(String email) {
		if(email == null || email.trim().isBlank()) {
			throw new RuntimeException(EMAIL_INVALIDO);
		}
		this.email = email;
	}

	private void setCelular(String celular) {
		if(celular == null || celular.trim().isBlank()) {
			throw new RuntimeException(CELULAR_INVALIDO);
		}
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", cuit=" + cuit + ", nombreApellido=" + nombreApellido
				+ ", email=" + email + ", celular=" + celular + ", operacionRequerida=" + operacionRequerida + "]";
	}

	/**
	 * Indica la operación que desea realizar el cliente en su visita al banco.
	 * 
	 * @param operacion la operación que desea realizar el cliente.
	 * @throws RuntimeException en caso de algun problema (operación no valida para
	 *                          el tipo de cliente.)
	 */
	public abstract void indicarOperacionRequerida(Operacion operacion) throws RuntimeException;
	
	protected void setOperacionRequerida(Operacion operacion) {		
		this.operacionRequerida = operacion;
	}
	
	public Operacion indicarOperacionRequerida() {
		return this.operacionRequerida;
	}
	
	/**
	 * Indica si el número de cliente indicado como parámetro coincide con el
	 * propio.
	 * 
	 * @param nroCliente
	 * @return <code>true</code> si el número pasado coincide con el del cliente,
	 *         <code>false</code> en cualquier otro caso.
	 */
	public boolean esMiNumero(int nroCliente) {
		return this.nroCliente == nroCliente;
	}
}

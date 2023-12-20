/**
 * 
 */
package ar.edu.ort.a2019.c2.tp1.f1.clases;

/**
 *
 */
public class ClienteVIP extends Cliente {

	public ClienteVIP(int nroCliente, String cuit, String nombreApellido, String email, String celular)
			throws RuntimeException {
		// TODO COMPLETAR
		super(nroCliente, cuit, nombreApellido, email, celular);
	}

	@Override
	public boolean esVip() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void indicarOperacionRequerida(Operacion operacion) throws RuntimeException {
		// TODO Auto-generated method stub
		if(operacion == null) {
			throw new RuntimeException(Cliente.OPERACION_INVALIDA);
		}
		super.setOperacionRequerida(operacion);
	}
}

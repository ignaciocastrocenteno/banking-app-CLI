/**
 * 
 */
package ar.edu.ort.a2019.c2.tp1.f1.clases;

/**
 *
 */
public class ClienteEstandar extends Cliente{
		
	
	public ClienteEstandar(int nroCliente, String cuit, String nombreApellido, String email, String celular)
			throws RuntimeException {
		// TODO COMPLETAR
		super(nroCliente, cuit, nombreApellido, email, celular);
	}

	@Override
	public boolean esVip() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void indicarOperacionRequerida(Operacion operacion) throws RuntimeException {
		/* ERROR QUE TUVE AL MOMENTO DE LA IMPLEMENTACION: crear un metodo que no
		 * que no estaba en el enunciado, preguntandole a la clase Cliente si
		 * this.operacionRequerida es de tipo VIP. En los casos que sean 'null' se rompe.
		 */
//		if(esOperacionVIP()) {
//			throw new RuntimeException(Cliente.OPERACION_INVALIDA);
//		}
		if(operacion.esTipoVIP()) {
			throw new RuntimeException(Cliente.OPERACION_INVALIDA);
		}
		
		setOperacionRequerida(operacion);
	}
}

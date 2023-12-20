package ar.edu.ort.a2019.c2.tp1.f1.clases;

public class Operacion implements Mostrable {
	// TODO COMPLETAR
	private static final String TIPO_DE_OPERACION_INVALIDA = "Operacion invalida";
	private static final String MONTO_INVALIDO = "Monto invalido";
	private static final String MES_INVALIDO = "Mes invalido";
	private static final String DIA_INVALIDO = "El día debe estar en el rango de dias del mes";
	private static final String ANIO_INVALIDO = "Anio invalido";
	private static final byte MONTO_MINIMO_OPERACION = 1;
	private static final byte PRIMER_DIA_DEL_MES = 1;
	private static final short ANIO_MINIMO = 2000;
	private static final short ANIO_MAXIMO = 2019;
	private float monto;
	private int dia;
	private int anio;
	private TipoOperacion tipo;
	private Mes mes;

	/**
	 * Construye una operación.
	 * 
	 * @param tipo  No nulo
	 * @param monto Mayor a 0
	 * @param dia   en el rango correcto.
	 * @param mes   No nulo
	 * @param anio  En el rango correcto (de 2000 a 2019 inclusive)
	 * @throws RuntimeException
	 */
	public Operacion(TipoOperacion tipo, float monto, int dia, Mes mes, int anio)
			throws RuntimeException {
		// TODO COMPLETAR
//		Ayudita Ojo el orden aqui
		setTipo(tipo);
		setMonto(monto);
		setMes(mes);
		setDia(dia);
		setAnio(anio);
	}

	private void setTipo(TipoOperacion tipo) {
		if(tipo == null) {
			throw new RuntimeException(TIPO_DE_OPERACION_INVALIDA);
		}
		this.tipo = tipo;
	}
	
	private void setMonto(float monto) {
		if(monto < MONTO_MINIMO_OPERACION) {
			throw new RuntimeException(MONTO_INVALIDO);
		}
		this.monto = monto;
	}

	private void setMes(Mes mes) {
		if(mes == null) {
			throw new RuntimeException(MES_INVALIDO);
		}
		this.mes = mes;
	}
	
	public Mes getMes() {
		return mes;
	}

	private void setDia(int dia) {
		if(dia < PRIMER_DIA_DEL_MES || dia > mes.getCantidadDias()) {
			throw new RuntimeException(DIA_INVALIDO);
		}
		this.dia = dia;
	}

	private void setAnio(int anio) {
		if(anio < ANIO_MINIMO || anio > ANIO_MAXIMO) {
			throw new RuntimeException(ANIO_INVALIDO);
		}
		this.anio = anio;
	}


	// DESCOMENTAR Y UTILIZAR
	public void operar() {
		System.out.println("Operando....");
		this.mostrar();
	}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Operacion (" + (esTipoVIP() ? "VIP" : "Estandar") +") " + tipo + ". Monto: " + monto + " fecha: " + formatearFecha());
	}
	
	public boolean esTipoVIP() {
		return tipo == TipoOperacion.DEPOSITO_DOLARES || tipo == TipoOperacion.EXTRACCION_DOLARES;
	}

	/**
	 * Devuelve un String con una representación visual de la fecha.
	 * 
	 * @return
	 */
	// TODO Decomentar y utilizar.
	private String formatearFecha() {
		return this.dia + " de " + mes.getNombre() + " de " + anio;
	}

}

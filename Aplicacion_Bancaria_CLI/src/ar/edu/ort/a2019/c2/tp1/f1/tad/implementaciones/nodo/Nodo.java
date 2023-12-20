package ar.edu.ort.a2019.c2.tp1.f1.tad.implementaciones.nodo;

public class Nodo<TipoElemento> {
	private TipoElemento dato;
	private Nodo<TipoElemento> next;
	
	public Nodo(TipoElemento dato) {
		this.dato = dato;
		this.next = null;
	}

	/**
	 * @return El dato
	 */
	public TipoElemento getDato() {
		return dato;
	}

	/**
	 * @return the siguiente
	 */
	public Nodo<TipoElemento> getNext() {
		return next;
	}
	
	public void setNext(Nodo<TipoElemento> next) {
		this.next = next;
	}
	
	/**
	 * @return the siguiente
	 */
	public boolean hasNext() {
		return next!=null;
	}
	
	
}

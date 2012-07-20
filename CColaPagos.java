package Caja;

import java.util.LinkedList;

public class CColaPagos {
		
	CColaPagos() {};

	private Object _SYNC_ = new Object();
	LinkedList<CPagos> ColaEnt = new LinkedList<CPagos>();
	public CPagos Temporal = new CPagos();

	public void Agregar(CPagos Mensaje) {
		synchronized (_SYNC_) {	ColaEnt.add(Mensaje); }
	}

	public CPagos Obtener(int i) {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.get(i);
			return Temporal;
		}
	}

	public CPagos Sacar() {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.remove();
			return Temporal;
		}
	}

	public void Limpiar() {
		synchronized (_SYNC_) { ColaEnt.clear(); }
	}

	public int TamañoCola() {
		synchronized (_SYNC_) { return ColaEnt.size(); }
	}

	public CPagos UltimoCola() {
		synchronized (_SYNC_) { return ColaEnt.getLast(); }
	}

	public boolean EstaVacio() {
		synchronized (_SYNC_) { return ColaEnt.isEmpty(); }
	}
	
	public void Borrar(int Index) {
		synchronized (_SYNC_) { ColaEnt.remove(Index); }
	}
}


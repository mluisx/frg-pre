package Caja;

import java.util.LinkedList;

public class CColaDatos {
	
	private Object _SYNC_ = new Object();
	LinkedList<CDatos> ColaEnt = new LinkedList<CDatos>();
	public CDatos Temporal = new CDatos();
	
	CColaDatos() {};
	
	CColaDatos(CColaDatos ColaDatos) { for (int i=0;i<ColaDatos.TamañoCola();i++) { Agregar(ColaDatos.Obtener(i)); }};

	public void Agregar(CDatos Mensaje) { synchronized (_SYNC_) {	ColaEnt.add(Mensaje); } }

	public CDatos Obtener(int i) {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.get(i);
			return Temporal;
		}
	}

	public CDatos Sacar() {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.remove();
			return Temporal;
		}
	}

	public void Limpiar() { synchronized (_SYNC_) { ColaEnt.clear(); } }

	public int TamañoCola() { synchronized (_SYNC_) { return ColaEnt.size(); } }

	public CDatos UltimoCola() { synchronized (_SYNC_) { return ColaEnt.getLast(); } }

	public boolean EstaVacio() { synchronized (_SYNC_) { return ColaEnt.isEmpty(); } }
	
	public CDatos Borrar(int Index) {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.remove(Index);
			return Temporal;
		}
	}
	
	public void Modificar(CDatos Mensaje, int Index) { synchronized (_SYNC_) {	ColaEnt.set(Index, Mensaje); } }

	public CDatos ObtenerPrimero() {
		synchronized (_SYNC_)
		{
			Temporal = ColaEnt.getFirst();
			return Temporal;
		}
	}
}

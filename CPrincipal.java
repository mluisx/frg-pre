// Ver 0.6.4 - Última Corriendo en Prune Posadas //
package Caja;

public class CPrincipal {

	public static CGUI Main;
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main = new CGUI();
				Main.setVisible(true);
			}
	    });
	}
}

// Sistema De Stock Ver 0.3.0 //

/**
 * Para Hacer:
 * 1) Permitir que queden saldos negativos (haberes) en el sistema.
 * 2) Ver si puedo cargar historial de clientes en jGrid.
 * 3) Permitir cargar vales de compras que permitan descontar valores en ventas de clientes.
**/
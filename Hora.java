package Caja;

public class Hora {

	public static HoraGUI Main;
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main = new HoraGUI();
				Main.setVisible(true);
			}
	    });
	}
}
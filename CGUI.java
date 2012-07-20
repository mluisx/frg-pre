/**
 * Prune POS Ver 0.6.4
 * @author Maurix
**/
package Caja;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CGUI extends JFrame implements KeyListener { 

	private static final long serialVersionUID = 1L;

	public CGUI() {
		initComponents();
		Caracteres = 160;
		ColaDatos = new CColaDatos();
		ColaPagos = new CColaPagos();
		Nucleo = new CNucleo(ColaDatos);
		Ventanas = new CVentanas(Nucleo, ColaDatos, this, ColaPagos);
		Ventanas.AccesoBD = Ventanas.new VentanaAccesoBD();
		Ventanas.AccesoBD.setVisible(true);
	}

	public JFrame VentanaPrincipal;
	public int Caracteres;
	public CVentanas Ventanas;
	public CNucleo Nucleo;
	public CColaDatos ColaDatos;
	public CColaPagos ColaPagos;
	private JButton jButton1; // Boton
	private JButton jButton2; // Boton
	private JButton jButton3; // Boton
	private JButton jButton4; // Boton
	private JButton jButton5; // Boton
	private JButton jButton6; // Boton
	private JButton jButton7; // Boton
	private JButton jButton8; // Boton
	private JButton jButton9; // Boton
	private JButton jButton10; // Boton Importar Stock Presea
	private JButton jButton11; // Boton Remito
	private JButton jButton12; // Boton Comparar Stock
	private JButton jButton13; // Boton Historial
	private JButton jButton14; // Boton Historial
	private JButton jButton15; // Boton Historial
	private JButton jButton16; // Boton Historial
	// private JLabel jLabel1;
	// private JLabel jLabel2;
	// private JLabel jLabel3; // Label de ""
	// private JLabel jLabel4; //
	// private JLabel jLabel5; //
	private JPanel jPanel1; //
	public JTextArea jTextArea1; //
	public JTextField jTextField1; //
	public JTextField jTextField2; //

	private void initComponents() {

		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButton5 = new JButton();
		jButton6 = new JButton();
		jButton7 = new JButton();
		jButton8 = new JButton();
		jButton9 = new JButton();
		jButton10 = new JButton();
		jButton11 = new JButton();
		jButton12 = new JButton();
		jButton13 = new JButton();
		jButton14 = new JButton();
		jButton15 = new JButton();
		jButton16 = new JButton();
		// jLabel1 = new JLabel();
		// jLabel2 = new JLabel();
		// jLabel3 = new JLabel();
		// jLabel4 = new JLabel();
		// jLabel5 = new JLabel();
		jPanel1 = new JPanel();
		jTextArea1 = new JTextArea();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Fringo");
		// setIconImage (new ImageIcon("fichero.gif").getImage());
		setResizable(false);
		jPanel1.setBorder(BorderFactory.createEtchedBorder());
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent event) {
				CerrarAplicacion(event);
			}
		});

		jButton1.setText("Agregar Venta");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Mostrar Ventas");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Cerrar Caja");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		// jButton4.setText("Eliminar Venta");
		jButton4.setText("Abrir Caja");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("Porcentajes");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("Precios");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setText("Stock");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("Gastos");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		
		jButton9.setText("Clientes");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		
		jButton10.setText("Importar Stock");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});
		
		jButton11.setText("Remitos");
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		
		jButton12.setText("Comparar Stock");
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed();
			}
		});
		
		jButton13.setText("Datos Friedman");
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed();
			}
		});
		
		jButton14.setText("Historial"); // Asteriscos
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed();
			}
		});
		
		jButton15.setText("Asteriscos"); // Asteriscos
		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed();
			}
		});
		
		jButton16.setText("Recepciones"); // Asteriscos
		jButton16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton16ActionPerformed();
			}
		});
		
        jButton1.addKeyListener(this);
        jButton2.addKeyListener(this);
        jButton3.addKeyListener(this);
        jButton4.addKeyListener(this);
        jButton5.addKeyListener(this);
        jButton6.addKeyListener(this);
        jButton7.addKeyListener(this);
        jButton8.addKeyListener(this);
        jButton9.addKeyListener(this);
        jButton10.addKeyListener(this);
        jButton11.addKeyListener(this);
        jButton12.addKeyListener(this);
        jButton13.addKeyListener(this);
        jButton14.addKeyListener(this);
        jButton15.addKeyListener(this);
        jButton16.addKeyListener(this);
        jButton1.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton2.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton3.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton4.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton5.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton6.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton7.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton8.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton9.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } }); 
        jButton10.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton11.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton12.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton13.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton14.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton15.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        jButton16.addMouseListener(new MouseAdapter() { public void mousePressed(MouseEvent me) { MarcarBoton((JButton) me.getComponent()); } });
        
		jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
		jTextField1.setText("Gestión de Stocks");
		jTextField1.setEditable(false);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 140,GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton2,	GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton3,	GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton5, GroupLayout.PREFERRED_SIZE,	140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton6, GroupLayout.PREFERRED_SIZE,	140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton7,	GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//														.addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														)
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																GroupLayout.Alignment.LEADING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jTextField1)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton1)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton3)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton4)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton5)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton6)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton7)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton8)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton9)
/*																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton10)*/
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton11)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton12)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton13)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton14)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton15)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jButton16)
																		))
										.addContainerGap()));

		// Panel

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.TRAILING).addComponent(
								jPanel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				/*
				 * .addGroup(layout.createSequentialGroup()
				 * .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
				 * GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				 * .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
				 * GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				 */
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING, false)
						// .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
						// GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				// .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11,
				// Short.MAX_VALUE)
						// .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
						// GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();

//		.setBorder(BorderFactory.createLineBorder(Color.blue));
//		jButton1.setBorderPainted(true);
		jButton1.requestFocusInWindow();
		getRootPane().setDefaultButton(jButton1);
//		jButton1.setBorder(BorderFactory.createBevelBorder(1));
//		System.out.println(ROLLOVER_ENABLED_CHANGED_PROPERTY);
//		jButton1.isr
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Nucleo.CajaAbierta()) {
			if (Ventanas.Ventas == null) {
				Ventanas.Ventas = Ventanas.new VentanaVentas();
				Ventanas.Ventas.CargarDatos();
				Ventanas.Ventas.setVisible(true);
			} else {
				Ventanas.Ventas.CargarDatos();
				Ventanas.Ventas.setVisible(true);
			}
		} else {
			if (Ventanas.ErrorCajaNoAbierta == null) {
				Ventanas.ErrorCajaNoAbierta = Ventanas.new VentanaErrorCajaNoAbierta();
				Ventanas.ErrorCajaNoAbierta.setVisible(true);
			} else { Ventanas.ErrorCajaNoAbierta.setVisible(true); }
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.MostrarVentas == null) {
			Ventanas.MostrarVentas = Ventanas.new VentanaMostrarVentas();
			Ventanas.MostrarVentas.setVisible(true);
		}
		else {
			Ventanas.MostrarVentas.CargarFechaCajaAbierta();
			Ventanas.MostrarVentas.setVisible(true);
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.CerrarCaja == null) { Ventanas.CerrarCaja = Ventanas.new VentanaCerrarCaja(); }
		Ventanas.CerrarCaja.setVisible(true);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String Caja = Nucleo.VerificarCajaAbierta();
		if (Caja.compareTo("0")==0) { 
			if (Ventanas.AbrirCaja == null) { Ventanas.AbrirCaja = Ventanas.new VentanaAbrirCaja(); }
			Ventanas.AbrirCaja.AbrirVentana();
			Ventanas.AbrirCaja.setVisible(true);			
		}
		else if (Caja.compareTo("1")==0) { Ventanas.MostrarError("La Caja Del Día Se Encuentra Abierta",null); }
		else if (Caja.compareTo("2")==0) { Ventanas.MostrarError("Se Produjo Un Error En La Base De Datos",null); }
		else { Ventanas.MostrarError("La Caja De la Fecha " + Caja + " Esta Abierta",null); }
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
/*		if (Ventanas.Cuotas == null) {
			Ventanas.Cuotas = Ventanas.new VentanaCuotas();
			Ventanas.Cuotas.setVisible(true);
			System.out.println("Ventana Cuotas Size: X:"
					+ Ventanas.Cuotas.getWidth() + " Y:"
					+ Ventanas.Cuotas.getHeight());
		} else {
			Ventanas.Cuotas.setLocation(getBounds().x + 198,
					getBounds().y + 200);
			// Ventanas.Ventas.jTextField1.setText("");
			Ventanas.Cuotas.setVisible(true);
		}*/
		if (Ventanas.Presea == null) { Ventanas.Presea = Ventanas.new VentanaPresea(); } 
//		Ventanas.Pedidos.CargarPedidos();
		Ventanas.Presea.setVisible(true);	
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// jTextArea2.setText("");
		if (Ventanas.CambioPrecio == null) {
			Ventanas.CambioPrecio = Ventanas.new VentanaCambioPrecio();
			Ventanas.CambioPrecio.setVisible(true);
			System.out.println("Ventana Presea Size: X:" + Ventanas.CambioPrecio.getWidth() + " Y:" + Ventanas.CambioPrecio.getHeight());
		} else {
//			Ventanas.CambioPrecio.setLocation(getBounds().x + 198, getBounds().y + 200);
//			Ventanas.Ventas.jTextField1.setText("");
			Ventanas.CambioPrecio.setVisible(true);
		}
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.Stock == null) {
			Ventanas.Stock = Ventanas.new VentanaStock();
			Ventanas.Stock.setVisible(true);
		} else {
			Ventanas.Stock.CargarDatos();
//			Ventanas.Stock.setLocation(getBounds().x + 198, getBounds().y);
			Ventanas.Stock.setVisible(true);
		}
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		int CajaAbierta = Nucleo.VerCajaAbierta();
        if (CajaAbierta != 0) {
        	if (Ventanas.Gastos == null) {
        		Ventanas.Gastos = Ventanas.new VentanaGastos();
        		Ventanas.Gastos.setVisible(true);
        		System.out.println("Ventana Gastos Size: X:"
        				+ Ventanas.Gastos.getWidth() + " Y:"
        				+ Ventanas.Gastos.getHeight());
        	} else {
//        		Ventanas.Gastos.setLocation(getBounds().x + 198, getBounds().y + 239);
        		Ventanas.Gastos.setVisible(true);
        	}
        }
        else { Ventanas.MostrarError("Abrir Caja Antes de Cargar Un Gasto",null); }
	}
	
	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.Clientes == null) {
			Ventanas.Clientes = Ventanas.new VentanaClientes();
			Ventanas.Clientes.setVisible(true);
		} 
		else {
			Ventanas.Clientes.CargarClientes();
			Ventanas.Clientes.jComboBox1ActionPerformed();
			Ventanas.Clientes.setVisible(true);
		}
	}
	
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.ImportarStock == null) {
			Ventanas.ImportarStock = Ventanas.new VentanaImportarStock();
			Ventanas.ImportarStock.setVisible(true);
		} 
		else { Ventanas.ImportarStock.setVisible(true); }
	}
	
	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
		if (Ventanas.Remitos == null) {
			Ventanas.Remitos = Ventanas.new VentanaRemitos();
			Ventanas.Remitos.setVisible(true);
		} 
		else { Ventanas.Remitos.setVisible(true); }
	}
	
	private void jButton12ActionPerformed() {
		if (Ventanas.CompararStock == null) {
			Ventanas.CompararStock = Ventanas.new VentanaCompararStock();
			Ventanas.CompararStock.setVisible(true);
		} 
		else { Ventanas.CompararStock.setVisible(true); }
	}
	
	private void jButton13ActionPerformed() {
		if (Ventanas.Friedman == null) { Ventanas.Friedman = Ventanas.new VentanaFriedman(); }
		Ventanas.Friedman.setVisible(true);
	}
	
	private void jButton14ActionPerformed() {
		if (Ventanas.Historial == null) { Ventanas.Historial = Ventanas.new VentanaHistorial(); }
		Ventanas.Historial.setVisible(true);
	}
	
	private void jButton15ActionPerformed() {
		if (Ventanas.Asteriscos == null) { Ventanas.Asteriscos = Ventanas.new VentanaAsteriscos(); }
		Ventanas.Asteriscos.setVisible(true);		
	}
	
	private void jButton16ActionPerformed() {
		if (Ventanas.Recepciones == null) { Ventanas.Recepciones = Ventanas.new VentanaRecepciones(); }
		Ventanas.Recepciones.setVisible(true);
	}

	public void SalgoAccesoBD() { System.exit(0); }
	
	public void CerrarAplicacion(java.awt.event.WindowEvent event) {
		int Cerrar = Nucleo.DesactivarBD();
		if (Cerrar==0) {
			System.out.println("Finaliza Aplicación");
// 			Inicio.CierroLog();
			System.exit(0);		
		}
		else { Ventanas.MostrarError("No Se Pudo Cerrar La Base De Datos",null);	}
	}

	public void keyPressed(KeyEvent e) {  }

	public void keyTyped(KeyEvent e) {	}
	
	public void keyReleased(KeyEvent e) { 
		int KeyCode = e.getKeyCode();
		if (KeyCode==40) {
			if (e.getComponent()==jButton1) { MarcarBoton(jButton2); }
			else if (e.getComponent()==jButton2) { MarcarBoton(jButton3); }
			else if (e.getComponent()==jButton3) { MarcarBoton(jButton4); }
			else if (e.getComponent()==jButton4) { MarcarBoton(jButton5); }
			else if (e.getComponent()==jButton5) { MarcarBoton(jButton6); }
			else if (e.getComponent()==jButton6) { MarcarBoton(jButton7); }
			else if (e.getComponent()==jButton7) { MarcarBoton(jButton8); }
			else if (e.getComponent()==jButton8) { MarcarBoton(jButton9); }
			else if (e.getComponent()==jButton9) { MarcarBoton(jButton11); }
//			else if (e.getComponent()==jButton10) { MarcarBoton(jButton11); }
			else if (e.getComponent()==jButton11) { MarcarBoton(jButton12); }
			else if (e.getComponent()==jButton12) { MarcarBoton(jButton13); }
			else if (e.getComponent()==jButton13) { MarcarBoton(jButton14); }
			else if (e.getComponent()==jButton14) { MarcarBoton(jButton15); }
			else if (e.getComponent()==jButton15) { MarcarBoton(jButton16); }
		}
		else if (KeyCode==38) {
			if (e.getComponent()==jButton2) { MarcarBoton(jButton1); }
			else if (e.getComponent()==jButton3) { MarcarBoton(jButton2); }
			else if (e.getComponent()==jButton4) { MarcarBoton(jButton3); }
			else if (e.getComponent()==jButton5) { MarcarBoton(jButton4); }
			else if (e.getComponent()==jButton6) { MarcarBoton(jButton5); }
			else if (e.getComponent()==jButton7) { MarcarBoton(jButton6); }
			else if (e.getComponent()==jButton8) { MarcarBoton(jButton7); }
			else if (e.getComponent()==jButton9) { MarcarBoton(jButton8); }
//			else if (e.getComponent()==jButton10) { MarcarBoton(jButton9); }
			else if (e.getComponent()==jButton11) { MarcarBoton(jButton9); }
			else if (e.getComponent()==jButton12) { MarcarBoton(jButton11); }
			else if (e.getComponent()==jButton13) { MarcarBoton(jButton12); }
			else if (e.getComponent()==jButton14) { MarcarBoton(jButton13); }
			else if (e.getComponent()==jButton15) { MarcarBoton(jButton14); }
			else if (e.getComponent()==jButton16) { MarcarBoton(jButton15); }
		}
	}
	

//  public void mouseClicked(MouseEvent e) { MarcarBoton((JButton) e.getComponent()); }
    
	public void MarcarBoton(JButton Boton) {
		Boton.requestFocusInWindow();
		getRootPane().setDefaultButton(Boton);
	}
}

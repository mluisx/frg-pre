/**
 * Prune POS
 * @author Maurix
**/

package Caja;

/**
 * Errores:
 * 
 * 1480: Catch al Verificar Caja Abierta;
 * 1490: Catch al Obtener Saldo de Cuenta y Actualizacion de Cuenta en Tabla Clientes
 * 1500: Catch al Agregar Movimiento de Stock;
 * 1510: Catch al Cargar Historial de un Cliente en Tabla historialclientes
 * 1520: Catch al Modificar Cantidad en Tabla Productos;
 * 1530: Catch al Actualizar Stock De Productos Que Salen;
 * 1540: Catch al Actualizar Stock De Productos Que Entran;
 * 1550: Catch al Obtener Datos De Ventas;
 * 1560: Catch al Obtener Datos De Ventas Totales;
 * 1570: Catch al Ingresar Datos en Tabla Ventas;
 * 1600: Catch al Ingresar Datos en Tabla DescripcionVentas;
 * 1610: Catch al Actualizar Precio de un Producto en Tabla productos o al Ingresar la Modificación en la tabla historialproductos;
 * 1620: Catch al Cargar Una Seña En La Tabla Señas Cuando Se Procede A Señar Un Producto;
 * 1630: Catch al Hacer Un Cierre de una Venta Señada en la tabla Señas;
 *   
**/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.FontSelector;
import com.lowagie.text.FontFactory;

import javax.swing.JFileChooser;
import java.io.File; 
import jxl.*; 

public class CVentanas {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaAbrirCaja AbrirCaja;
	public VentanaVentas Ventas;
	public VentanaMostrarVentas MostrarVentas;
	public VentanaCerrarCaja CerrarCaja;
	public VentanaErrorCajaNoAbierta ErrorCajaNoAbierta;
	public VentanaCajaCerrada CajaCerrada;
	public VentanaCuotas Cuotas;
	public VentanaCambioPrecio CambioPrecio;
	public VentanaStock Stock;
	public VentanaGastos Gastos;
	public VentanaErrores Errores;
	public VentanaExcepciones Excepciones;
	public VentanaClientes Clientes;
	public VentanaErrorEnBD ErrorEnBD;
	public VentanaAccesoBD AccesoBD;
	public VentanaDescuento Descuentos;
	public VentanaIntereses Intereses;
	public VentanaAgregarCliente AgregarCliente;
	public VentanaAyuda Ayuda;
	public VentanaConfirmar Confirmar;
	public CNucleo Nucleo;
	public CColaDatos ColaDatos;
	public CColaPagos ColaPagos;
	public CGUI Principal;
	public VentanaIngresoCliente IngresoCliente;
	public VentanaHistorialCliente HistorialCliente;
	public VentanaPedidos Pedidos;
	public VentanaIngresarSeña IngresoSeña;
	public VentanaIngresoRubro IngresoRubro;
	public VentanaIngresoOpciones IngresoOpciones;
	public VentanaAviso Aviso;
	public VentanaProdEspeciales ProdEspeciales;
	public VentanaFactura vFactura;
	public VentanaClave Clave;
	public VentanaImportarStock ImportarStock;
	public VentanaRemitos Remitos;
	public VentanaCompararStock CompararStock;
	public VentanaFriedman Friedman;
	public VentanaHistorial Historial;
	public VentanaAsteriscos Asteriscos;
	public VentanaPresea Presea;
	public VentanaRecepciones Recepciones;
	
	public CVentanas(CNucleo Nucleo, CColaDatos ColaDatos, CGUI Principal, CColaPagos ColaPagos) {
		
		AbrirCaja = null;
		Ventas = null;
		MostrarVentas = null;
		CerrarCaja = null;
		ErrorCajaNoAbierta = null;
		CajaCerrada = null;
		Cuotas = null;
		CambioPrecio = null;
		Gastos = null;
		Clientes = null;
		Errores = null;
		Excepciones = null;
		AccesoBD = null;
		Descuentos = null;
		Intereses = null;
		AgregarCliente = null;
		Ayuda = null;
		IngresoCliente = null;
		Confirmar = null;
		HistorialCliente = null;
		Pedidos = null;
		IngresoSeña = null;
		IngresoRubro = null;
		IngresoOpciones = null;
		Aviso = null;
		ProdEspeciales = null;
		vFactura = null;
		Clave = null;
		ImportarStock = null;
		Remitos = null;
		CompararStock = null;
		Friedman = null;
		Historial = null;
		Asteriscos = null;
		Presea = null;
		Recepciones = null;
//		Pedidos = null;
		
		this.Nucleo = Nucleo;
		this.ColaDatos = ColaDatos;
		this.ColaPagos = ColaPagos;
		this.Principal = Principal;			
	}

	// Ventana Abrir Caja
	
	public class VentanaAbrirCaja extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel2;
		private JTextField jTextField1, jTextField2;
		private JButton jButton1;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
		
		public VentanaAbrirCaja() {

	        jPanel1 = new JPanel();
	        jLabel2 = new JLabel();			 	// Cambio: $
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Cambio: $
	        jButton1 = new JButton();
	        
	        setTitle("Abrir Caja");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Cambio: $");       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel2.getFont());
	        jTextField1.setText(Nucleo.CrearFechaConNombres());
	        jTextField1.setEditable(false);	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel2.getFont());
	        jTextField2.setEditable(false);
	        
	        jButton1.setText("Abrir");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed() {
			String Resultado, Cambio;
			Cambio = jTextField2.getText().replace(",",".");
			Resultado = Nucleo.AbrirCaja(Cambio);
			if (Resultado.compareTo("0")!=0) { MostrarError("Se Produjo Un Error al Abrir La Caja",this); }
			else {
				jTextField1.setText("");
				jTextField2.setText("");
				dispose();
			}
		}
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	jTextField1.setText("");
        	jTextField2.setText("");
        	dispose();
        }
        
        public void AbrirVentana() { 
        	jTextField1.setText(Nucleo.CrearFechaConNombres());
        	jTextField2.setText(Nucleo.ObtenerCambioCaja());
        }
        
	}
	
// 	Ventana Agregar Venta
	
	public class VentanaVentas extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9;
		private JComboBox jComboBox1, jComboBox3, jComboBox4, jComboBox5;
		private JButton jButton1, jButton2, jButton3, jButton4;
		private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
		private JScrollPane jScrollPane1, jScrollPane2;
	    private JList jList1, jList2;
	    private int CantProd, Flag, Flag1, Flag2, ProdVendidos, CodigoCliente, NroSeña; // Flag2 = Avisa si Paga Saldo El Cliente
        public DefaultListModel SampleModel1, SampleModel2;
        public BigDecimal Precio, Total, MontoPagar, Descuento, Interes, PagoCuenta, SaldoCliente, MontoCuenta;
		public LinkedList<String> Productos = new LinkedList<String>();
		public LinkedList<String[]> ProductosDeEntrada = new LinkedList<String[]>();
		public String CodigoProductoNuevo;
		public String jComboBoxItem;
		public String nFactura;
		public Object[] clienteFact;
		public boolean Aceptar, Seña, VentaSeñada;
        public LinkedList<String> Vendedoras;
	
// 		Ventana Ventas
		
		public VentanaVentas() {

	        jPanel1 = new JPanel();				// Panel Productos
	        jPanel2 = new JPanel();			    // Panel Cobros
	        jPanel3 = new JPanel();			    // Panel Total
	        jPanel4 = new JPanel();			    // Panel Cliente
	        jPanel5 = new JPanel();			    // Panel Datos Extras
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel3 = new JLabel();          	// Precio
	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora
	        jLabel8 = new JLabel();          	// Monto a Pagar
	        jLabel9 = new JLabel();          	// Total De Monto a Pagar
	        jLabel10= new JLabel();          	// Presea (Selección de si se realizó Ticket)
	        jLabel11= new JLabel();          	// Sale La Mercadería del Stock O Ingresa al Stock
	        jLabel12 = new JLabel();			// F1 - Ayuda
	        jTextField1 = new JTextField();  	// Código Del Producto 
	        jTextField2 = new JTextField();  	// Precio Del Producto
	        jTextField3 = new JTextField();  	// Total
	        jTextField4 = new JTextField();  	// Nro de producto a ingresar
	        jTextField5 = new JTextField();  	// Monto a Pagar
	        jTextField6 = new JTextField();  	// Total Cobrado
	        jTextField7 = new JTextField();		// Descripcion del Producto
	        jTextField8 = new JTextField();		// Nombre del Cliente
	        jTextField9 = new JTextField();		// Información del Estado de la Ventana
	        jButton1 = new JButton();		 	// Agregar producto a la lista
	        jButton2 = new JButton();		 	// Cancelar Venta
	        jButton3 = new JButton();		 	// Agregar Venta
	        jButton4 = new JButton();		 	// Agregar Pago
	        jComboBox1 = new JComboBox();	 	// Método de pago
	        jComboBox3 = new JComboBox();	 	// Selección de vendedora
	        jComboBox4 = new JComboBox();	 	// Cobrador
	        jComboBox5 = new JComboBox();	 	// Sale o Entra la Mercaderia al Stock
	        jScrollPane1 = new JScrollPane();	// Lista de Productos
	        jScrollPane2 = new JScrollPane();	// Lo que pagó
	        jList1 = new JList();
	        jList2 = new JList();
	        CantProd = ProdVendidos = Flag = Flag1 = Flag2 = CodigoCliente = NroSeña = 0;
	        Total = MontoPagar = Descuento = Interes = PagoCuenta = SaldoCliente = MontoCuenta = new BigDecimal(0);
	        Precio = null;
	        MontoPagar = MontoPagar.setScale(2, RoundingMode.HALF_UP);
	        Total = Total.setScale(2, RoundingMode.HALF_UP);
	        Descuento = Descuento.setScale(2, RoundingMode.HALF_UP);
	        Interes = Interes.setScale(2, RoundingMode.HALF_UP);
	        PagoCuenta = PagoCuenta.setScale(2, RoundingMode.HALF_UP);
	        SaldoCliente = SaldoCliente.setScale(2, RoundingMode.HALF_UP);
	        MontoCuenta = MontoCuenta.setScale(2, RoundingMode.HALF_UP);
	        jComboBoxItem = nFactura = "";
	        clienteFact = null;
	        Aceptar = false;
	        Seña = false;
			VentaSeñada = false;
	        
	        setTitle("Agregar Venta");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        jPanel2.setBorder(BorderFactory.createEtchedBorder());
	        jPanel2.setName("");	        
	        jPanel3.setBorder(BorderFactory.createEtchedBorder());
	        jPanel3.setName("");
	        jPanel4.setBorder(BorderFactory.createEtchedBorder());
	        jPanel4.setName("");
	        jPanel5.setBorder(BorderFactory.createEtchedBorder());
	        jPanel5.setName("");
     	    
	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jTextField1.requestFocusInWindow();
	            }
	        });
	        
	        Font FuenteGrande = new Font("TimesRoman", Font.BOLD, 30);
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Código Del Producto");
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Precio");
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("Método de Pago");
	        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
//	        jLabel5.setFont(FuenteGrande);
//	        jLabel5.setVerticalAlignment(1);
	        jLabel5.setText("Total");
	        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel6.setText("Nro");	        
	        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel7.setText("Vendedora");	        
	        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel8.setText("Monto a Pagar");	       
	        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel9.setText("Total Cobrado");	        
	        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel10.setText("Ticket");	        
	        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel11.setText("Stock");
	        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel12.setText("F1 - Ayuda");
	        
	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel6.getFont());	        
	        jTextField1.addKeyListener(this);
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setFont(jLabel6.getFont());
	        jTextField2.addKeyListener(this);
     	    
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(FuenteGrande);
	        jTextField3.setText("$ 0");
	        jTextField3.setEditable(false);
	        jTextField3.addKeyListener(this);
	        
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField4.setFont(jLabel6.getFont());
	        jTextField4.setText("1");
	        jTextField4.setEditable(false);
	        jTextField4.addKeyListener(this);
	        
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField5.setFont(jLabel6.getFont());
     	    jTextField5.addKeyListener(this);
     	    
	        jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField6.setFont(jLabel6.getFont());
	        jTextField6.setText("$ 0");
	        jTextField6.setEditable(false);
	        jTextField6.addKeyListener(this);
	        
	        jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField7.setFont(jLabel6.getFont());
	        jTextField7.setEditable(false);
	        jTextField7.addKeyListener(this);
	        
	        jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField8.setFont(jLabel6.getFont());
	        jTextField8.setEditable(false);
	        jTextField8.addKeyListener(this);
	        jTextField8.setText("Cliente: Consumidor Final");
	        
	        jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField9.setFont(jLabel6.getFont());
	        jTextField9.setEditable(false);
	        
	        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta", "A Cuenta", "Otros" }));
	        jComboBox1.addKeyListener(this);
	        
/*	        jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "$ (Pesos)", "u$s (Dolares)", "€ (Euros)", "Otros" }));
	        jComboBox2.addKeyListener(this);
	        jComboBox2.setEnabled(false);*/
	        
	        Vendedoras = Nucleo.BuscarVendedoras();
			for (int i=0;i<Vendedoras.size();i++) { jComboBox3.addItem(Vendedoras.get(i)); }
	        jComboBox3.addKeyListener(this);
	        
	        jComboBox4.setModel(new DefaultComboBoxModel(new String[] { "Factura B", "Asterisco", "Factura A" }));
	        jComboBox4.addKeyListener(this);
	        
	        jComboBox5.setModel(new DefaultComboBoxModel(new String[] { "Sale", "Entra" }));
	        jComboBox5.addKeyListener(this);
	        
	        jScrollPane1.setViewportView(jList1);
	        jScrollPane2.setViewportView(jList2);
	        SampleModel1 = new DefaultListModel();
	        SampleModel2 = new DefaultListModel();
	        jList1.setModel(SampleModel1);
	        jList2.setModel(SampleModel2);
	        jList1.addKeyListener(this);
	        jList2.addKeyListener(this);
	        
	        jButton1.setText("Agregar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton1ActionPerformed(); }
	        });

	        jButton2.setText("Cancelar Venta");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed();
	            }
	        });
	        
	        jButton3.setText("Agregar Venta");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed();
	            }
	        });
	        
	        jButton4.setText("Agregar Pago");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton4ActionPerformed();
	            }
	        });
	        
			jComboBox1.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) { 
	            	if (evt.getItem().toString()=="A Cuenta") { jComboBox1ActionPerformed(evt); }
	            }
	        });
			
			jComboBox5.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) { jComboBox5ActionPerformed(evt); }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
	        
	        jButton1.addKeyListener(this);
	        jButton2.addKeyListener(this);
	        jButton3.addKeyListener(this);
	        jButton4.addKeyListener(this);
	        
	        ArmadoPanel1();
	        ArmadoPanel2();
	        ArmadoPanel3();
	        ArmadoPanel4();
	        ArmadoPanel5();
	        ArmadoFinal();
	        pack();
	        setLocationRelativeTo(null);
		}

		private void ArmadoPanel1() {
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
			                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
			                .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))	
			            .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
	                		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                		.addGap(8, 8, 8)
	                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
		}

    	private void ArmadoPanel2() {
	        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	            	.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE,125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
//                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) 
	                .addContainerGap())
	        );
	        jPanel2Layout.setVerticalGroup(
		        jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		        .addGroup(jPanel2Layout.createSequentialGroup()
		            .addContainerGap()
		            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            		.addGroup(jPanel2Layout.createSequentialGroup()
		            				.addComponent(jLabel4)
		            				.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
		            				.addGap(9, 9, 9)
		            				.addComponent(jLabel8)
		            				.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
		            				.addGap(13, 13, 13)
		            				.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
		            				.addGap(13, 13, 13)
		            				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap())
            );
    	}	      
	     
    	private void ArmadoPanel3() {
	        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
           			.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
           			.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,150, GroupLayout.PREFERRED_SIZE)
           			.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
           			.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
         			.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	    	);
	    	jPanel3Layout.setVerticalGroup(
	    	    jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    	    .addGroup(jPanel3Layout.createSequentialGroup()
//	    	        .addContainerGap()
//    	        	.addGap(9, 9, 9)	    	    		
	    	        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING) 
	    	        		.addGroup(jPanel3Layout.createSequentialGroup()
	    	        				.addGap(13, 13, 13)
	    	        				.addComponent(jLabel5))
	    	        		.addGroup(jPanel3Layout.createSequentialGroup()	    	        				
	    	        				.addGap(3, 3, 3)
	    	        				.addComponent(jTextField3, 37, 37, 37))
	    	        		.addGroup(jPanel3Layout.createSequentialGroup()
	    	        				.addGap(13, 13, 13)
	    	        				.addComponent(jLabel9))
	    	        		.addGroup(jPanel3Layout.createSequentialGroup()	    	        				
	    	        				.addGap(12, 12, 12)
	    	        				.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	    	        		.addGroup(jPanel3Layout.createSequentialGroup()
	    	        				.addGap(13, 13, 13)
	    	        				.addComponent(jLabel12)))	    	        
//	    	        .addContainerGap())
    	        	.addGap(4, 4, 4))
	    	);
    	}
    	
    	private void ArmadoPanel4() {	    	
	        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
	        jPanel4.setLayout(jPanel4Layout);
	        jPanel4Layout.setHorizontalGroup(
	            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel4Layout.createSequentialGroup()
	                .addContainerGap()
         			.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	    	);
	    	jPanel4Layout.setVerticalGroup(
	    	    jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    	    .addGroup(jPanel4Layout.createSequentialGroup()
    	        	.addGap(12, 12, 12)	    	    		
    	        	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
    	        	.addGap(12, 12, 12))    	        		
	    	);
    	}
	    
    	private void ArmadoPanel5() {
	        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
	        jPanel5.setLayout(jPanel5Layout);
	        jPanel5Layout.setHorizontalGroup(
	            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel5Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
       					.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
       					.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
       					.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)  
       					.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
               			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
       	                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	    	);
	    	jPanel5Layout.setVerticalGroup(
	    	    jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel5Layout.createSequentialGroup()
		            	.addContainerGap()
		            	.addComponent(jLabel7)
            			.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
            			.addGap(9, 9, 9)
		            	.addComponent(jLabel10)
		            	.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)		            				
		            	.addGap(13, 13, 13)
		            	.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
		            	.addGap(13, 13, 13)
		            	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
		            	.addContainerGap())   	        		
	    	);
    	}
	     
    	private void ArmadoFinal() {
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                		.addGroup(layout.createSequentialGroup()
	                				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                				.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))	                		
	                		.addGroup(layout.createSequentialGroup()
	                				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                				.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                		.addGroup(layout.createSequentialGroup()
	                				.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)               		
	                	.addGroup(layout.createSequentialGroup()
	        	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	                		.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        	                		.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        	                		.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	        	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	                		.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        	                		.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	        	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        	                		.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		}

    	private void jComboBox1ActionPerformed(java.awt.event.ItemEvent evt) {
    		if (jComboBox1.getSelectedIndex()!=0) {
/*    			jComboBox2.setEnabled(false);*/
    			if (jComboBox1.getSelectedIndex()==2 && CodigoCliente==0) {
					if (IngresoCliente == null) {
						IngresoCliente = new VentanaIngresoCliente(this);
						IngresoCliente.setVisible(true);
					}
					else {
						IngresoCliente.CargarClientes();
						IngresoCliente.jComboBox1ActionPerformed();
						IngresoCliente.setVisible(true);
					}
    			}
    		}
    	}
    	
    	private void jComboBox5ActionPerformed(java.awt.event.ItemEvent evt) {
    		if (!jTextField7.getText().isEmpty() && jTextField1.getText().length()==15) { VerificarCodigoIngresado(); }	
    	}
    			   	
		private void jButton1ActionPerformed() {
			CDatos Datos = new CDatos();
			Flag = 0;
//			LinkedList<String> Producto;
			CodigoProductoNuevo = "";
			String PrecioIngresado, Error, Prueba; 
			Prueba = "";
			BigDecimal ValorPrecio;
    	  	ValorPrecio = new BigDecimal(0);
    	  	Error = "";	  	
    	  	jTextField1.setText(jTextField1.getText().toUpperCase());
			PrecioIngresado = jTextField2.getText().replace(",",".");
			Error = VerificarNumero(PrecioIngresado);
			if ((!jTextField1.getText().isEmpty() && jComboBox5.getSelectedItem().toString().compareTo("Sale")==0 && 
					Error.isEmpty()) || (jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) && Error.isEmpty()) {
				ValorPrecio = new BigDecimal(PrecioIngresado);
				ValorPrecio = ValorPrecio.setScale(2, RoundingMode.HALF_UP);
				if (Precio!= null && !PrecioIngresado.isEmpty() && Precio.compareTo(ValorPrecio)!=0 && !jTextField7.getText().isEmpty() && !VerificarProdEspeciales(jTextField7.getText()) 
								  && jComboBox5.getSelectedItem().toString().compareTo("Sale")==0 && jTextField7.getText().compareTo("Este Producto No Existe En El Stock")!=0) {
					Error = Nucleo.ModificoPrecioProducto(jTextField1.getText(),ValorPrecio);
					if (Error.isEmpty()) { jTextField7.setText(jTextField7.getText() + " (Precio Actualizado)"); }
				}
				if (Error.isEmpty()) {					
					if (!jTextField7.getText().isEmpty() && !VerificarProdEspeciales(jTextField7.getText())
						&& jComboBox5.getSelectedItem().toString().compareTo("Sale")==0 ) {
						Productos.add(jTextField1.getText()); // Ingreso Codigo Del Producto Para Actualizar El Stock
					}
					else if (!jTextField7.getText().isEmpty() && jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) {
						String[] DatosProducto = new String[2];
						DatosProducto[0] = jTextField1.getText();
						DatosProducto[1] = jTextField2.getText().replace(",",".");
						ProductosDeEntrada.add(DatosProducto);
					}
//					else if ((jTextField7.getText().compareTo("Este Producto No Existe En El Stock")==0) && jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) {
//						NuevoCodigo = jTextField1.getText();
/*						if (Stock == null) {
							Stock = new VentanaStock();
							Stock.CargarCodigo(CodigoProductoNuevo, ValorPrecio, jComboBox5.getSelectedItem().toString());
							Stock.setVisible(true);
						} else {
							Stock.CargarDatos();
							Stock.CargarCodigo(CodigoProductoNuevo, ValorPrecio, jComboBox5.getSelectedItem().toString());
							Stock.setVisible(true);
						}*/
/*						Producto = Nucleo.BuscarProductoParaVenta(CodigoProductoNuevo);
						if (Producto != null) {
							jTextField1.setText(CodigoProductoNuevo);
							Descripcion = Producto.removeFirst().toString();
							Producto.remove();
							jTextField7.setText(Descripcion);
							PrecioNuevo = new BigDecimal(Producto.removeFirst());
							PrecioNuevo = PrecioNuevo.setScale(2, RoundingMode.HALF_UP);
							Precio = PrecioNuevo;
							jTextField2.setText(PrecioNuevo.toString().replace(".", ","));
						}
						Flag = 1;*/
//					}
					else { Flag = 2; }
					if (Flag != 1) {
						if (jTextField1.getText().compareTo("PAGOCUENTA")==0) { 
							if (Flag2==0) { Flag2 = 2; }
							else if (Flag2==1) { Flag2 = 3; }
							PagoCuenta = PagoCuenta.add(ValorPrecio);
							Prueba = jTextField4.getText() + ") " + jTextField7.getText();
							Flag = 2;
						}
						else if (jTextField1.getText().compareTo("ENTREGASEÑA")==0) {
							int NroSeña = Nucleo.ObtenerNroSeña();
							if (NroSeña>0) {
								Prueba = jTextField4.getText() + ") Entrega Por Seña Número " + Integer.toString(NroSeña) + " -";
								Seña = true;
								Total = ValorPrecio;
								ProdVendidos = 0;									
							}
						}
						else if (jTextField1.getText().compareTo("DESCUENTOCUENTA")==0) { 
							if (Flag2==0) { Flag2 = 2; }
							else if (Flag2==1) { Flag2 = 3; }
							Total = Total.subtract(ValorPrecio);
							Prueba = jTextField4.getText() + ") " + jTextField7.getText();
							Flag = 2;
						}
						else if (jTextField1.getText().compareTo("DEVOLPRODUCTO")==0) { 
							if (Flag2==0) { Flag2 = 2; } // Acá Indica Que Hace Un Pago
							else if (Flag2==1) { Flag2 = 3; } // Acá Indica Que Hace Un Pago Además de Llevar Productos a Cuenta
							PagoCuenta = PagoCuenta.add(ValorPrecio);
							Prueba = jTextField4.getText() + ") " + jTextField7.getText();
							Flag = 2;
						}
						else { Prueba = jTextField4.getText() + ") " + jTextField1.getText().toUpperCase() + " - "; }
						Datos.SetearCodigoProducto(jTextField1.getText().toUpperCase());
						Datos.SetearPrecio(ValorPrecio);
						Datos.SetearProdNro(Integer.parseInt(jTextField4.getText()));
						Datos.SetearStock(jComboBox5.getSelectedItem().toString());
						if (Flag == 2) { Datos.SetearCargadoStock("N");}
						else { 
							Datos.SetearCargadoStock("S");
							if (jTextField7.getText().compareTo("Este Producto No Existe En El Stock")!=0) { Prueba += jTextField7.getText() + " "; }
						}
						if (jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) {
							Prueba += "(Entra al Stock) ";
							if (!Seña) { Total = Total.subtract(ValorPrecio); }
						}
						else if (!Seña) { 
							if (jTextField1.getText().compareTo("DESCUENTOCUENTA")!=0 && jTextField1.getText().compareTo("DEVOLPRODUCTO")!=0) { Total = Total.add(ValorPrecio); }
							if (!VerificarProdEspeciales(jTextField7.getText())) { ProdVendidos++; }
						}
						Prueba += "$" + ValorPrecio.toString().replace(".", ",");
						ColaDatos.Agregar(Datos);
						CantProd++;
						SampleModel1.addElement(Prueba);
						if (Total.compareTo(MontoPagar)>0 && !jButton4.isEnabled()) {
							jTextField5.setText(Total.subtract(MontoPagar).toString().replace(".", ","));
							jButton4.setEnabled(true);
							jTextField5.setEditable(true);
						}
						else { jTextField5.setText(Total.toString().replace(".", ",")); }
						jTextField3.setText("$ " + Total.toString().replace(".", ","));
						jTextField4.setText(Integer.toString(CantProd + 1));
						jComboBox5.setSelectedIndex(0);
						jTextField1.setText("");
						jTextField1.requestFocusInWindow();
						jTextField2.setText("");
						jTextField7.setText("");
						Flag1 = 0;
					}
				}
			}
			else { if (jTextField1.getText().isEmpty()) { Error = "Ingrese El Código Del Producto"; } }
			if (!Error.isEmpty()) { MostrarError(Error,this); }
		}
        
        private void jButton2ActionPerformed() {
        	LimpiarVentana();
	        dispose();
        }
        
        private void jButton3ActionPerformed() {
			int Contador = 0;
			int Resultado;
			BigDecimal Precio = new BigDecimal(0);
			Precio = Precio.setScale(2, RoundingMode.HALF_UP);
			CPagos Pagos;
        	if (!SampleModel1.isEmpty()) {
				if (!SampleModel2.isEmpty()) {
					
					while (Contador < ColaPagos.TamañoCola()) {
						Pagos = ColaPagos.Obtener(Contador);
						Precio = Precio.add(Pagos.ObtenerPrecio());
						if (Pagos.MetodoPago.compareTo("A Cuenta")==0) { MontoCuenta = MontoCuenta.add(Pagos.ObtenerPrecio()); }
						Contador++;
					}
					
					if (Precio.compareTo(Total)==0) {
						
						if (Flag2==0 || (Flag2>0 && CodigoCliente>0)) { // PagoCuenta.compareTo(SaldoCliente.add(MontoCuenta))<=0
							if (jComboBox4.getSelectedIndex()==2) {
								if (vFactura == null) { vFactura = new VentanaFactura(this); }
								vFactura.CargarDatos(1);
								vFactura.setVisible(true);							
							}
							if ((jComboBox4.getSelectedIndex()!=2) || (jComboBox4.getSelectedIndex()==2 && !nFactura.isEmpty())) {
								Resultado = Nucleo.AlmacenoVenta(ColaDatos, ColaPagos, jComboBox3.getSelectedItem().toString(), Total, ProdVendidos, jComboBox4.getSelectedIndex(), Descuento,
										Interes, CodigoCliente, Seña, VentaSeñada, NroSeña, clienteFact, nFactura);
								if (Resultado == 0) {
									if (!Seña) { 
										try { Resultado = Nucleo.ActualizoStockEntrada(ProductosDeEntrada); }
										catch (SQLException sqle) { Resultado = -1; }
									}
									if (Resultado >=0) {
										ProductosDeEntrada.clear();
										if (Resultado > 0) { MostrarAviso("Se Agrego " + Resultado + " Nuevo/s Producto/s a La Base",this); }
										if (!Seña) { 
											try { Resultado = Nucleo.ActualizoStock(Productos); }
											catch (SQLException sqle) { Resultado = -1; }
										}
										if (Resultado >=0) {											
											Productos.clear();
											if (Resultado > 0) { MostrarAviso("Se Agrego " + Resultado + " Nuevo/s Producto/s a La Base",this); }
											if (Flag2!=0) {
												try { 
													Nucleo.ActivarBDCuentas();
													Resultado = Nucleo.IngresoSaldoCliente(CodigoCliente,ColaPagos,Flag2,PagoCuenta,SaldoCliente,MontoCuenta);
													Nucleo.DesactivarBDCuentas();
												} catch (SQLException sqle) { 
													MostrarExcepcion(sqle.toString(),this);
													Resultado = -1;
												}	
											}
											if (Resultado >= 0) {
												LimpiarVentana();
												jTextField9.setText("La Venta Ha Sido Almacenada");
												jTextField1.requestFocusInWindow();
											}
											else { MostrarError("Error al Actualizar Saldo Cliente",this); }
										}
										else { MostrarError("Error al Actualizar Stock (1540)",this); }
									}
									else { MostrarError("Error al Actualizar Stock (1530)",this); }
								}
								else if (Resultado <  0) { MostrarError("Error al Actualizar Stock De Productos",this); }
								else if (Resultado == 1) { MostrarError("Error al Ingresar Datos De Venta (1570)",this); }
								else if (Resultado == 2) { MostrarError("Error al Ingresar Datos De Venta (1580)",this); }
								else if (Resultado == 3) { MostrarError("Error al Ingresar Datos De Venta (1590)",this); }
								else if (Resultado == 4) { MostrarError("Error al Ingresar Datos De Venta (1600)",this); }
								else if (Resultado == 5) { MostrarError("Error al Ingresar Datos De Seña (1620)",this); }
								//		else if (Resultado == 6) { MostrarError("Debe Ingresar Al Menos Un Producto",this); }
								else if (Resultado == 7) { MostrarError("Error al Ingresar Datos De Seña (1630)",this); }
								else { MostrarError("Error al Ingresar Datos De Venta (1610)",this); }
							}
							else {
								MontoCuenta = new BigDecimal(0);
								MontoCuenta = MontoCuenta.setScale(2, RoundingMode.HALF_UP);
							}
						}
						else { 
							if (CodigoCliente==0) { MostrarError("Ingrese Cliente a La Venta",this); }
							else { MostrarError("El Monto a Pagar es Mayor a la Deuda",this); }
						}
						
					}
					else { MostrarError("El Valor a Pagar No Concuerda Con Total",this); }
					
				}
				else { MostrarError("No Se Ingreso Algún Método De Pago",this); }
			} else { MostrarError("No Se Ingresaron Productos En La Venta",this); }
        }
        
        private void jButton4ActionPerformed() {
        	String Error = "";
        	CPagos Pagos = new CPagos();
        	String Pago = jTextField5.getText().replace(",",".");
        	int Contador = 0;
        	int FlagIngreso = 0;
			while (Contador<Pago.length() && FlagIngreso<=1) {
				if (Pago.charAt(Contador)=='.') { FlagIngreso++; }
				else if (FlagIngreso>1 || Pago.charAt(Contador)<'0' || Pago.charAt(Contador)>'9') { FlagIngreso = 2; }
				Contador++;
			}
			if (FlagIngreso<=1 && Contador>0) {
				if (Pago.indexOf(".")==Pago.length()-3 || Pago.indexOf(".") == -1) {
					BigDecimal Valor = new BigDecimal(Pago);
					Valor = Valor.setScale(2, RoundingMode.HALF_UP);
					if (Valor.compareTo(Total.subtract(MontoPagar))<=0) {  // Compara si el Monto Ingresado a Pagar es Menor o Igual al (Total - Monto ya Ingresado a Pagar Anteriormente) 
						MontoPagar = MontoPagar.add(Valor);
						jTextField6.setText("$ " + MontoPagar.toString().replace(".",","));
						String Precio = Valor.toString().replace(".",",") + " - " + jComboBox1.getSelectedItem();
/*						if (jComboBox1.getSelectedIndex()==0 && jComboBox2.getSelectedIndex()>0) { Precio = Precio + ", " + jComboBox2.getSelectedItem(); }*/
						SampleModel2.addElement(Precio);
						Pagos.SetearMetodoPago(jComboBox1.getSelectedItem().toString());
						Pagos.SetearPrecio(Valor);
						if (jComboBox1.getSelectedItem().toString().compareTo("A Cuenta")==0) {
							if (CodigoCliente==0) {
								if (IngresoCliente == null) { IngresoCliente = new VentanaIngresoCliente(this); }
								else {
									IngresoCliente.CargarClientes();
									IngresoCliente.jComboBox1ActionPerformed();
								}
								IngresoCliente.setVisible(true);
							}
							if (Flag2 == 0) { Flag2 = 1; }
							else if (Flag2 == 2) { Flag2 = 3; }
						}
/*						if (jComboBox2.isEnabled()) { Pagos.SetearMoneda(jComboBox2.getSelectedItem().toString()); }
						else { Pagos.SetearMoneda(" - "); }*/
						ColaPagos.Agregar(Pagos);
						if (Total.compareTo(MontoPagar)==0) { 
							jTextField5.setText("");
							jTextField5.setEditable(false);
							jButton4.setEnabled(false);
							jButton3.requestFocusInWindow();
						}
						else if (Total.compareTo(MontoPagar)>0) { jTextField5.setText(Total.subtract(MontoPagar).toString().replace(".", ",")); }
					}
					else { Error = "El Valor a Pagar Es Superior al Total"; }
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else { 
				if (Contador==0) { Error = "Ingrese El Monto a Pagar"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" para Dec."; }
			}
			if (!Error.isEmpty()) { MostrarError(Error,this); }
        }
        
        private void LimpiarVentana() {
			jTextField1.setText("");
			jTextField2.setText("");
    	  	jTextField3.setText("$ 0");
	        jTextField4.setText("1");
			jTextField5.setText("");
	        jTextField6.setText("$ 0");
    	  	jTextField7.setText("");
    	  	jTextField8.setText("Cliente: Consumidor Final");
    	  	jComboBox1.setSelectedIndex(0);
			jComboBox3.setSelectedIndex(0);
			jComboBox4.setSelectedIndex(0);
			jComboBox5.setSelectedIndex(0);
	        SampleModel1.removeAllElements();
            SampleModel2.removeAllElements();
            CantProd = ProdVendidos = Flag = Flag1 = Flag2 = CodigoCliente = 0;
			Total = MontoPagar = Descuento = Interes = PagoCuenta = SaldoCliente = MontoCuenta = new BigDecimal(0);
			Precio = null;
			Total = Total.setScale(2, RoundingMode.HALF_UP);
			MontoPagar = MontoPagar.setScale(2, RoundingMode.HALF_UP);
			Descuento = Descuento.setScale(2, RoundingMode.HALF_UP);
			Interes = Interes.setScale(2, RoundingMode.HALF_UP);
	        PagoCuenta = PagoCuenta.setScale(2, RoundingMode.HALF_UP);
	        SaldoCliente = SaldoCliente.setScale(2, RoundingMode.HALF_UP);
	        MontoCuenta = MontoCuenta.setScale(2, RoundingMode.HALF_UP);
	        nFactura = "";
	        clienteFact = null;
			ColaDatos.Limpiar();
			ColaPagos.Limpiar();
			Productos.clear();
			ProductosDeEntrada.clear();
			jTextField5.setEditable(true);
			jButton4.setEnabled(true);
			if (Seña) { Seña = false; }
			if (VentaSeñada) { 
				VentaSeñada = false;
				NroSeña = 0;
			}
        }       

        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	LimpiarVentana();
        	dispose();
        }
       
		public void keyPressed(KeyEvent e) { }

		public void keyTyped(KeyEvent e) { }   
		
		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (jTextField9.getText().compareTo("La Venta Ha Sido Almacenada")==0) { jTextField9.setText(Nucleo.ObtenerUltimaVenta()); }
			if (e.isActionKey()) {
				if (Tecla.compareTo("F5")==0) { PresionarF5(); }					
				else if (Tecla.compareTo("F6")==0) { PresionarF6(); }					
				else if (Tecla.compareTo("F7")==0) { PresionarF7(); }
				else if (Tecla.compareTo("F1")==0) { PresionarF1(); }
				else if (Tecla.compareTo("F8")==0) { PresionarF8(); }			
				else if (Tecla.compareTo("F4")==0) { PresionarF4(); }
				else if (Tecla.compareTo("F9")==0) { PresionarF9(); }
			}
			else if (e.getComponent()==jTextField1 && Tecla.compareTo("Escape")!=0 && Tecla.compareTo("Introduzca")!=0) { VerificarCodigoIngresado(); }			
			else if (Tecla.compareTo("Introduzca")==0) {
				if (e.getComponent()==jButton1) { jButton1ActionPerformed(); }
				else if (e.getComponent()==jTextField1) { jTextField2.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField2) { jButton1.requestFocusInWindow(); }
				else if (e.getComponent()==jButton2) { jButton2ActionPerformed(); }
				else if (e.getComponent()==jButton3) { jButton3ActionPerformed(); }
				else if (e.getComponent()==jButton4) { 
					jButton4ActionPerformed();
					jComboBox1.requestFocusInWindow();
				}
				else if (e.getComponent()==jComboBox1) { jTextField5.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField5) { jButton4.requestFocusInWindow(); }
				else if (e.getComponent()==jComboBox3) { jComboBox4.requestFocusInWindow(); }
				else if (e.getComponent()==jComboBox4) { jButton3.requestFocusInWindow(); }
			}
			else if (Tecla.compareTo("Escape")==0) {
				if (e.getComponent()==jTextField1 || e.getComponent()==jTextField2 || e.getComponent()==jButton1) { jComboBox1.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField5 || e.getComponent()==jComboBox1 || e.getComponent()==jButton4) { jComboBox3.requestFocusInWindow(); }
			}
		}

		public void VerificarCodigoIngresado() {
			String CodigoProducto = jTextField1.getText();
			String Descripcion = "";
			BigDecimal PrecioNuevo;
			LinkedList<String> Producto = new LinkedList<String>();
			if (CodigoProducto.length()>0) {
				CodigoProducto = CodigoProducto.toUpperCase();
				if (CodigoProducto.compareTo("PAGOCUENTA")==0) {
					jTextField7.setText("Pago De Cuenta Corriente");
					jTextField2.requestFocusInWindow();
					Flag1 = 1;
				}
				else if (CodigoProducto.compareTo("ENTREGASEÑA")==0) {
					jTextField7.setText("Entrega De Seña");
					jTextField2.requestFocusInWindow();
					Flag1 = 1;
				}
				else if (CodigoProducto.compareTo("ADICIONARCAMBIO")==0) {
					jTextField7.setText("Adicionar Cambio a La Caja");
					jTextField2.requestFocusInWindow();
					Flag1 = 1;
				}
				else if (CodigoProducto.compareTo("DESCUENTOCUENTA")==0) {
					jTextField7.setText("Descuento en el Pago del Saldo");
					jTextField2.requestFocusInWindow();
					Flag1 = 1;
				}
				else if (CodigoProducto.compareTo("DEVOLPRODUCTO")==0) {
					jTextField7.setText("Devolución de Producto a Cuenta");
					jTextField2.requestFocusInWindow();
					Flag1 = 1;
				}
				else if (CodigoProducto.length()==15) {
					Producto = Nucleo.BuscarProductoParaVenta(CodigoProducto);
					if (Producto != null) {
						if (Producto.peekLast().compareTo("///ERROR///")!=0) {
							Descripcion = Producto.removeFirst().toString();
							PrecioNuevo = new BigDecimal(Producto.removeFirst());
							PrecioNuevo = PrecioNuevo.setScale(2, RoundingMode.HALF_UP);
							if (Descripcion.compareToIgnoreCase("null")!=0) {
								if (Integer.parseInt(Producto.removeFirst().toString())>0 || jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) { jTextField7.setText(Descripcion); }
								else { jTextField7.setText(Descripcion + " (Stock Negativo)"); }							
							}
							else {
								if (Integer.parseInt(Producto.removeFirst().toString())>0 || jComboBox5.getSelectedItem().toString().compareTo("Entra")==0) { jTextField7.setText("Producto Sin Detalle"); }
								else { jTextField7.setText("Producto Sin Detalle (Stock Negativo)"); }							
							}
							Precio = PrecioNuevo;
							if (PrecioNuevo.compareTo(new BigDecimal(0))>0) { 
								jTextField2.setText(PrecioNuevo.toString().replace(".",","));
								jButton1.requestFocusInWindow();
							}
							else { jTextField2.requestFocusInWindow(); }														
						}
						else { 
							MostrarError("Error En Base De Datos",this);
							Flag1 = 1;
						}
					}
					else { 
						jTextField7.setText("Este Producto No Existe En El Stock");
						Flag1 = 1;
					}					
				}
				else if (!jTextField7.getText().isEmpty()) { jTextField7.setText(""); }
			}
			else if (!jTextField2.getText().isEmpty() || Flag1 == 1) { 
				jTextField2.setText("");
				jTextField7.setText("");
				Precio = null;
				Flag1 = 0;
			}
		}
		
		public void PresionarF5() {
			if (!jTextField5.getText().isEmpty()) {
				BigDecimal Pago = new BigDecimal(jTextField5.getText().replace(",","."));
				Pago = Pago.setScale(2, RoundingMode.HALF_UP);
				if (Descuentos == null) {
					Descuentos = new VentanaDescuento(Pago,this);   	
					Descuentos.setVisible(true);
				}
				else {
					Descuentos.CargarPago(Pago);
					Descuentos.setVisible(true);    		
				} 						
			}
			else { MostrarError("No Se Puede Aplicar Descuento",this); }
		}
		
		public void PresionarF6() {
			if (!jTextField5.getText().isEmpty()) {
				BigDecimal Pago = new BigDecimal(jTextField5.getText().replace(",","."));
				Pago = Pago.setScale(2, RoundingMode.HALF_UP);
				if (Intereses == null) {
					Intereses = new VentanaIntereses(Pago);   	
					Intereses.setVisible(true);
				}
				else {
					Intereses.CargarPago(Pago);
					Intereses.setVisible(true);    		
				} 						
			}
			else { MostrarError("No Se Puede Aplicar Interés",this); }
		}

		public void PresionarF7() {
			if (ProdEspeciales == null) {
				ProdEspeciales = new VentanaProdEspeciales(this);
				ProdEspeciales.setVisible(true);
			}
			else { ProdEspeciales.setVisible(true); }
		}
		
		public void PresionarF8() {
			int Index = jList1.getSelectedIndex();
			int IndexDatos;
			int FlagDtoCuenta = 0;
			if (Index>=0) {
				MostrarConfirmar("¿Desea Eliminar Este Item De La Venta?",this,1);
				if (Aceptar) {
					String Temp = "";
					BigDecimal Valor;
					Temp = SampleModel1.get(Index).toString();
					if (Temp.contains(">) Descuento - $")) {
						Temp = Temp.substring(Temp.indexOf("$")+1,Temp.length()).replace(",",".");
						Valor = new BigDecimal(Temp);
						Total = Total.add(Valor);
						Descuento = Descuento.subtract(Valor);
						SampleModel1.remove(Index);
					}
					else if (Temp.contains(">) Interés - $")) {
						Temp = Temp.substring(Temp.indexOf("$")+1,Temp.length()).replace(",",".");
						Valor = new BigDecimal(Temp);
						Total = Total.subtract(Valor);
						Interes = Interes.subtract(Valor);
						SampleModel1.remove(Index);
					}
					else {
						CDatos Datos = new CDatos();
						int Contador = 1;
						SampleModel1.remove(Index);
						IndexDatos = Integer.parseInt(Temp.substring(0,1))-1;
						Datos = ColaDatos.Obtener(IndexDatos);
						if (Datos.ObtenerCodigoProducto().compareTo("PAGOCUENTA")==0) {
							PagoCuenta = PagoCuenta.subtract(Datos.ObtenerPrecio());
							Total = Total.subtract(Datos.ObtenerPrecio());
							if (PagoCuenta.intValue()==0) {
								if (Flag2 == 3) { Flag2 = 1; }
								else { Flag2 = 0; }
							}
						}
						else if (Datos.ObtenerCodigoProducto().compareTo("DEVOLPRODUCTO")==0) { 
							PagoCuenta = PagoCuenta.subtract(Datos.ObtenerPrecio());
							if (PagoCuenta.intValue()==0) {
								if (Flag2 == 3) { Flag2 = 1; }
								else { Flag2 = 0; }
							}
						}
						else { 
							if (!Temp.contains("(Entra al Stock)")) { Total = Total.subtract(Datos.ObtenerPrecio()); }
							else { Total = Total.add(Datos.ObtenerPrecio()); }
						}
						CantProd--;
						ProdVendidos--;
						ColaDatos.Borrar(IndexDatos);
						if (IndexDatos != ColaDatos.TamañoCola()) {
							for (int i=0;i<ColaDatos.TamañoCola();i++) {
								Datos = ColaDatos.Obtener(i);
								if (Datos.ObtenerProdNro()!=i+1) {
									Datos.SetearProdNro(i+1);
									ColaDatos.Modificar(Datos,i);
								}
							}
						}
						if (Index != SampleModel1.getSize()) {
							for (int j=0;j<SampleModel1.getSize();j++) {
								Temp = SampleModel1.get(j).toString();
								if (Temp.substring(0,1).compareTo(Integer.toString(Contador))!=0 && Temp.substring(0,1).compareTo(">")!=0) {
									Temp = Integer.toString(Contador) + Temp.substring(Temp.indexOf(")"),Temp.length());
									SampleModel1.set(j,Temp);
								}
								if (Temp.substring(0,1).compareTo(">")!=0) { Contador++; }
							}
						}
						jTextField4.setText(Integer.toString(CantProd + 1));
					}
					if (!ColaPagos.EstaVacio() && FlagDtoCuenta == 0) {
				        ColaPagos.Limpiar();
			            SampleModel2.removeAllElements();
			            MontoPagar = new BigDecimal(0);
						MontoPagar = MontoPagar.setScale(2, RoundingMode.HALF_UP);
			            MontoCuenta = new BigDecimal(0);
			            MontoCuenta = MontoCuenta.setScale(2, RoundingMode.HALF_UP);
			            if (!jButton4.isEnabled()) {
			            	jTextField5.setEditable(true);
			            	jButton4.setEnabled(true);
			            }				            
				        jTextField6.setText("$ 0");
					}
					if (Total.intValue()!=0) {jTextField5.setText(Total.toString().replace(".", ",")); }
					else { 
						jTextField5.setText("");
			            if (!jButton4.isEnabled()) {
			            	jTextField5.setEditable(true);
			            	jButton4.setEnabled(true);
			            }
					}
					jTextField3.setText("$ " + Total.toString().replace(".", ","));
					jComboBox5.setSelectedIndex(0);
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField7.setText("");
					jTextField1.requestFocusInWindow();
				}
			}
			else {
				Index = jList2.getSelectedIndex();
				if (Index>=0) {							
					MostrarConfirmar("¿Desea Eliminar Esta Forma de Pago?",this,1);
					if (Aceptar) {
						String Temp = "";
						BigDecimal Valor;
						CPagos Pagos = new CPagos();	
						Pagos = ColaPagos.Obtener(Index);
						Valor = Pagos.ObtenerPrecio();
						Valor = Valor.setScale(2, RoundingMode.HALF_UP);
						Temp = Pagos.ObtenerMetodoPago();
						if (Temp.compareTo("A Cuenta")==0) { 
							SaldoCliente = new BigDecimal(0);
							SaldoCliente = SaldoCliente.setScale(2, RoundingMode.HALF_UP);
							CodigoCliente = 0;
							jTextField8.setText("Cliente: Consumidor Final"); 
							if (Flag2 == 1) { Flag2 = 0; }
							else if (Flag2 == 3) { Flag2 = 2; }
						}
						MontoPagar = MontoPagar.subtract(Valor);
						jTextField6.setText("$ " + MontoPagar.toString().replace(".",","));
						ColaPagos.Borrar(Index);
						SampleModel2.remove(Index);
			            if (!jButton4.isEnabled()) {
			            	jTextField5.setEditable(true);
			            	jButton4.setEnabled(true);
			            }
			            jTextField5.setText(Total.subtract(MontoPagar).toString().replace(".", ","));
					}
				}
				else { MostrarError("Debe Seleccionar Un Producto Para Borrar",this); } 
			}		
		}
		
		public void PresionarF1() {
			if (Ayuda == null) {
				Ayuda = new VentanaAyuda(this);
				Ayuda.setVisible(true);
			} else { Ayuda.setVisible(true); }
		}
		
		public void PresionarF4() {
			if (IngresoCliente == null) { IngresoCliente = new VentanaIngresoCliente(this); }
			else {
				IngresoCliente.CargarClientes();
				IngresoCliente.jComboBox1ActionPerformed();
			}
			IngresoCliente.setVisible(true);
		}
		
		public void PresionarF9() {
			if (IngresoSeña == null) {
				IngresoSeña = new VentanaIngresarSeña(this);
				IngresoSeña.setVisible(true);
			}
			else { 
				IngresoSeña.AbrirVentana();
				IngresoSeña.setVisible(true);
			}
		}
		
		public void CargarCodigo(String Codigo) { CodigoProductoNuevo = Codigo; }
		
		public void AgregarDescuento(BigDecimal Valor, BigDecimal Pago) {
			String AgregoDesc = ">) Descuento - $" + Valor.toString().replace(".",",");
			SampleModel1.addElement(AgregoDesc);
			Total = Total.subtract(Valor);
			jTextField3.setText("$ " + Total.toString().replace(".",","));
			jTextField5.setText(Pago.subtract(Valor).toString().replace(".",","));
			Descuento = Descuento.add(Valor);
		}
		
		public void AgregarInteres(BigDecimal Valor, BigDecimal Pago) {
			String AgregoInt = ">) Interés - $" + Valor.toString().replace(".",",");
			SampleModel1.addElement(AgregoInt);
			Total = Total.add(Valor);
			jTextField3.setText("$ " + Total.toString().replace(".",","));
			jTextField5.setText(Pago.add(Valor).toString().replace(".",","));
			Interes = Interes.add(Valor);
		}

		public void CargarDatos() { jTextField9.setText(Nucleo.ObtenerUltimaVenta()); }

		//	public void jComboBox5 (Hacer un Listen para cambiar si mostrar descripcion o no)
 
	}
	
	// Ventana Mostrar Ventas
	
	public class VentanaMostrarVentas extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
		private JTextField jTextField1, jTextField2, jTextField3;
		private JButton jButton1;
		private JPanel jPanel1;
		private JScrollPane jScrollPane1;
	    private JList jList1;
        public DefaultListModel SampleModel;
        public String Fecha;
		
		public VentanaMostrarVentas() {
	
	        jPanel1 = new JPanel();			 	
	        jLabel1 = new JLabel();			 	// Fecha
	        jLabel2 = new JLabel();			 	// /
	        jLabel3 = new JLabel();          	// /
	        jLabel4 = new JLabel();          	// Día
	        jLabel5 = new JLabel();          	// Mes
	        jLabel6 = new JLabel();          	// Año
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Total de venta
	        jButton1 = new JButton();		 	// Agregar producto a la lista
	        jScrollPane1 = new JScrollPane();
	        jList1 = new JList();
	        
	        setTitle("Mostrar Ventas Realizadas");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");

	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Fecha");
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("/");        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("/");
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("Día");
	        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel5.setText("Mes");
	        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel6.setText("Año");
	        
	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setFont(jLabel1.getFont());
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setFont(jLabel1.getFont());
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField3.setFont(jLabel1.getFont());

     	    CargarFechaCajaAbierta();
	        
	        jScrollPane1.setViewportView(jList1);
	        
	        SampleModel = new DefaultListModel();
	        jList1.setModel(SampleModel);
	        
	        jButton1.setText("Buscar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGap(GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
	                		.addGap(GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	                		.addGap(GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
	                		.addGap(GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
	                	.addGroup(jPanel1Layout.createSequentialGroup()
//	                    	.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
//		                    .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
//	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
//	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
//	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
   			                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
			                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
   			                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)	                        		
			                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
//	                    .addGroup(jPanel1Layout.createSequentialGroup()
/*	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)) */
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                		    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
//	                			.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//	                			.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//	                			.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
/*	                			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))*/
	                		.addGap(8, 8, 8)
	                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	        SampleModel.removeAllElements();
			LinkedList<String> DatosVentas = new LinkedList<String>();
			String SuperVenta;
			String Fecha = "20" + jTextField3.getText() + "/" + jTextField2.getText() + "/" + jTextField1.getText();
			try { 
				if (Nucleo.VerificoClientesEnVentas(Fecha)) { 
					Nucleo.ActivarBDCuentas();
					DatosVentas = Nucleo.ObtenerVentas(Fecha);
					Nucleo.DesactivarBDCuentas();
				}
				else { DatosVentas = Nucleo.ObtenerVentas(Fecha); }
			} catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }		
			if (!DatosVentas.isEmpty() && DatosVentas.peek().compareTo("ERROR///1550///")!=0) {
				while (!DatosVentas.isEmpty()) {
					SuperVenta = DatosVentas.remove();
		    	  	SampleModel.addElement(SuperVenta);
				}
			}
			else if (DatosVentas.isEmpty()) { MostrarError("La Fecha Ingresada No Contiene Ventas",this); }
			else { MostrarError("Error Al Obtener Datos De Ventas (1550)",this); }
        }
		
		public void CargarFechaCajaAbierta() {
	        Fecha = Nucleo.ObtenerFechaCajaAbierta();      
	        if (Fecha!=null) {
		        jTextField1.setText(Fecha.substring(8,10));
		        jTextField2.setText(Fecha.substring(5,7));
		        jTextField3.setText(Fecha.substring(2,4));
	        }
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
	        SampleModel.removeAllElements();
        	dispose();
        }             
	}
	
	public class VentanaCuotas extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9, jTextField10;
		private JTextField jTextField11, jTextField12, jTextField13, jTextField14, jTextField15, jTextField16, jTextField17, jTextField18, jTextField19, jTextField20;
		private JTextField jTextField21;
		private JButton jButton1;
		private JPanel jPanel1;
		private JScrollPane jScrollPane1;
	    private JList jList1;
        public DefaultListModel SampleModel;
        public String Fecha;
		
		public VentanaCuotas() {
		
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Precio
	        jLabel2 = new JLabel();			 	// Moneda
	        jLabel3 = new JLabel();          	// Precio
	        jLabel4 = new JLabel();          	// Precio
	        jLabel5 = new JLabel();          	// Precio
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Total de venta
	        jTextField5 = new JTextField();  	// Total de venta
	        jTextField6 = new JTextField();  	// Total de venta
	        jTextField7 = new JTextField();  	// Total de venta
	        jTextField8 = new JTextField();  	// Total de venta
	        jTextField9 = new JTextField();  	// Total de venta
	        jTextField10= new JTextField();  	// Total de venta
	        jTextField11= new JTextField();  	// Total de venta
	        jTextField12= new JTextField();  	// Total de venta
	        jTextField13= new JTextField();  	// Total de venta
	        jTextField14= new JTextField();  	// Total de venta
	        jTextField15= new JTextField();  	// Total de venta
	        jTextField16= new JTextField();  	// Total de venta
	        jTextField17= new JTextField();  	// Total de venta
	        jTextField18= new JTextField();  	// Total de venta
	        jTextField19= new JTextField();  	// Total de venta
	        jTextField20= new JTextField();  	// Total de venta
	        jTextField21= new JTextField();  	// Total de venta
	        jButton1 = new JButton();		 	// Agregar producto a la lista
	        jScrollPane1 = new JScrollPane();
	        jList1 = new JList();
	        
	        setTitle("Mostrar Ventas Realizadas");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 239, 364, 288));
	
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Precio $");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Cuotas");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Porcentaje");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("Precio Con Recargo");
	        
	        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel5.setText("Precio Por Cuota");
	        
	        Fecha = Nucleo.CrearSoloFecha();
	        
	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setFont(jLabel1.getFont());
//	        jTextField1.setEditable(false);
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setFont(jLabel1.getFont());
     	    jTextField2.setText("2");
	        jTextField2.setEditable(false);
	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField3.setFont(jLabel1.getFont());
     	    jTextField3.setText("1.0327");
//	        jTextField3.setEditable(false);
     	    
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField4.setFont(jLabel1.getFont());
     	    
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField5.setFont(jLabel1.getFont());
     	    
	        jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField6.setFont(jLabel1.getFont());
     	    jTextField6.setText("3");
	        jTextField6.setEditable(false);
     	    
	        jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField7.setFont(jLabel1.getFont());
     	    jTextField7.setText("1.0451");
     	    
	        jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField8.setFont(jLabel1.getFont());
     	    
            jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField9.setFont(jLabel1.getFont());
     	    
	        jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField10.setFont(jLabel1.getFont());
     	    jTextField10.setText("4");
	        jTextField10.setEditable(false);
     	    
	        jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField11.setFont(jLabel1.getFont());
     	    jTextField11.setText("1.0637");
	        
	        jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField12.setFont(jLabel1.getFont());
     	    
	        jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField13.setFont(jLabel1.getFont());

	        jTextField14.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField14.setFont(jLabel1.getFont());
     	    jTextField14.setText("5");
	        jTextField14.setEditable(false);
     	    
	        jTextField15.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField15.setFont(jLabel1.getFont());
     	    jTextField15.setText("1.0777");
	        
	        jTextField16.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField16.setFont(jLabel1.getFont());
     	    
	        jTextField17.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField17.setFont(jLabel1.getFont());
     	    
	        jTextField18.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField18.setFont(jLabel1.getFont());
     	    jTextField18.setText("6");
	        jTextField18.setEditable(false);
     	    
	        jTextField19.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField19.setFont(jLabel1.getFont());
     	    jTextField19.setText("1.0918");
	        
	        jTextField20.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField20.setFont(jLabel1.getFont());
     	    
	        jTextField21.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField21.setFont(jLabel1.getFont());
     	    
	        jScrollPane1.setViewportView(jList1);
	        
	        SampleModel = new DefaultListModel();
	        jList1.setModel(SampleModel);
	        
	        jButton1.setText("Sacar Valores");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
//	                    	.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
//		                    .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
//	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
//	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
//	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
   			                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
//	                    .addGroup(jPanel1Layout.createSequentialGroup()
/*	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)) */
			            .addGroup(jPanel1Layout.createSequentialGroup()
				            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				            .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	   			            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                        		
				            .addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))   
				        .addGroup(jPanel1Layout.createSequentialGroup()
				        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				        .addGroup(jPanel1Layout.createSequentialGroup()
				        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				        .addGroup(jPanel1Layout.createSequentialGroup()
				        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField12, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField13, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE))
				        .addGroup(jPanel1Layout.createSequentialGroup()
				        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField16, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField17, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE))
				        .addGroup(jPanel1Layout.createSequentialGroup()
				        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField19, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField20, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
				        	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        	.addComponent(jTextField21, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)))
/*	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                			.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                			.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                			.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
	            			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
         	                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))*/
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	                		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//	                			.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//	                			.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//	                			.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
/*	                			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))*/
	                		.addGap(8, 8, 8)
	                	    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	    	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                	    .addGap(8, 8, 8)
	                	    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	    	.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                        .addGap(8, 8, 8)
	                	    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	    	.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                        .addGap(8, 8, 8)
	                	    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	    	.addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField17, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                        .addGap(8, 8, 8)
	                	    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	    	.addComponent(jTextField18, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField19, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField20, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                	    	.addComponent(jTextField21, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
/*	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addComponent(jLabel2)
	                		.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                		.addGap(9, 9, 9)
	                		.addComponent(jLabel7)
	                		.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                		.addGap(9, 9, 9)
	                		.addComponent(jLabel5)
	                		.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGap(4, 4, 4)
	                		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)	
                			.addGap(13, 13, 13)
                			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                			.addGap(13, 13, 13)
                			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))*/)
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
		
		public double redondear(double numero, int decimales) {
		    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			double Precio = Double.parseDouble(jTextField1.getText());
			double pordoscuotas = Double.parseDouble(jTextField3.getText());
			double portrescuotas = Double.parseDouble(jTextField7.getText());
			double porcuatrocuotas = Double.parseDouble(jTextField11.getText());
			double porcincocuotas = Double.parseDouble(jTextField15.getText());
			double porseiscuotas = Double.parseDouble(jTextField19.getText());
			jTextField4.setText(Double.toString(redondear((Precio*pordoscuotas),0)));
			jTextField5.setText(Double.toString(redondear(Double.parseDouble(jTextField4.getText())/2,2)));
			jTextField8.setText(Double.toString(redondear((Precio*portrescuotas),0)));
			jTextField9.setText(Double.toString(redondear(Double.parseDouble(jTextField8.getText())/3,2)));
			jTextField12.setText(Double.toString(redondear((Precio*porcuatrocuotas),0)));
			jTextField13.setText(Double.toString(redondear(Double.parseDouble(jTextField12.getText())/4,2)));
			jTextField16.setText(Double.toString(redondear((Precio*porcincocuotas),0)));
			jTextField17.setText(Double.toString(redondear(Double.parseDouble(jTextField16.getText())/5,2)));
			jTextField20.setText(Double.toString(redondear((Precio*porseiscuotas),0)));
			jTextField21.setText(Double.toString(redondear(Double.parseDouble(jTextField20.getText())/6,2)));
        }
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	jTextField1.setText("");
        	jTextField4.setText("");
        	jTextField5.setText("");
        	jTextField8.setText("");
        	jTextField9.setText("");
        	jTextField12.setText("");
        	jTextField13.setText("");
        	jTextField16.setText("");
        	jTextField17.setText("");
        	jTextField20.setText("");  
        	jTextField21.setText("");  
        	dispose();
        }             
	}
	
	public class VentanaRecepciones extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7;
		private JButton jButton1;
		private JPanel jPanel1;
	    private JList jList1;
        public DefaultListModel SampleModel;
        public String Fecha;
		
		public VentanaRecepciones() {
		
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Precio
	        jLabel2 = new JLabel();			 	// Moneda
	        jLabel3 = new JLabel();          	// Precio
	        jLabel4 = new JLabel();          	// Precio
	        jLabel5 = new JLabel();          	// Precio
	        jLabel6 = new JLabel();          	// Precio
	        jLabel7 = new JLabel();          	// Precio
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Total de venta
	        jTextField5 = new JTextField();  	// Total de venta
	        jTextField6 = new JTextField();  	// Total de venta
	        jTextField7 = new JTextField();  	// Total de venta
	        jButton1 = new JButton();		 	// Agregar producto a la lista
	        jList1 = new JList();
	        
	        setTitle("Cargar Datos de Recepciones");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Fecha");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Nro Recepción");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel3.setText("Empresa");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel4.setText("Cantidad de Cajas");
	        
	        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel5.setText("Monto S/IVA");
	        
	        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel6.setText("IVA");
	        
	        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel7.setText("Total");
	        
//	        Fecha = Nucleo.CrearSoloFecha();
	        
	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setFont(jLabel1.getFont());
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setFont(jLabel1.getFont());
	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField3.setFont(jLabel1.getFont());
     	    
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField4.setFont(jLabel1.getFont());
     	    
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField5.setFont(jLabel1.getFont());
     	    
	        jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField6.setFont(jLabel1.getFont());

	        jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField7.setFont(jLabel1.getFont());
     	    jTextField7.setEditable(false);
	        
	        SampleModel = new DefaultListModel();
	        jList1.setModel(SampleModel);
	        
	        jButton1.setText("Ingresar Valores");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
   			                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
			            .addGroup(jPanel1Layout.createSequentialGroup()
				            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				            .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
   			                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
			            .addGroup(jPanel1Layout.createSequentialGroup()
				            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				            .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
   			                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
			            .addGroup(jPanel1Layout.createSequentialGroup()
				            .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				            .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
			            .addGroup(jPanel1Layout.createSequentialGroup()
				            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				            .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))				            
			            .addGroup(jPanel1Layout.createSequentialGroup()				        
				        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                		.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)		                	
		                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty()
					&& !jTextField5.getText().isEmpty() && !jTextField6.getText().isEmpty()) {
				if (Nucleo.CargarDatosRecepcion(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText())==0) {
					MostrarError("Error al Almacenar Datos de Recepción",this);
				}
				else { 
					MostrarAviso("Los Datos Fueron Almacenados",this);
					CerrarVentana(null);
				}
			}
			else { MostrarError("Faltan Rellenar Campos",this); }
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	jTextField1.setText("");
        	jTextField2.setText("");
        	jTextField3.setText("");
        	jTextField4.setText("");
        	jTextField5.setText("");
        	jTextField6.setText("");
        	jTextField1.requestFocusInWindow();
        	dispose();
        }             
	}
	
	// Ventana Cambio de Precio
	
	public class VentanaCambioPrecio extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3;//, jLabel4, jLabel5, jLabel6, jLabel7;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4;
//		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
//		private Largo, Ancho;
		
		public VentanaCambioPrecio() {

	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel2 = new JLabel();			 	// Moneda
	        jLabel3 = new JLabel();			 	// Moneda
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Precio del producto
	        jTextField4 = new JTextField();  	// Precio del producto
	        jButton1 = new JButton();
	        
	        setTitle("Cambiar Precio de un Producto");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Código Producto");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Precio Actual $");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Precio Nuevo $");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setEditable(false);
	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(jLabel1.getFont());
	        
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField4.setFont(jLabel1.getFont());
	        jTextField4.setEditable(false);
	        
	        jTextField1.addKeyListener(this);
	        
	        jButton1.setText("Cambiar Precio");
	        jButton1.setEnabled(false);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
		                    .addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))	
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addGap(49, 49, 49)	
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		            	.addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jLabel3)
			                	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                .addGap(8, 8, 8)
			                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			int Contador, Flag;
			BigDecimal Precio;
			String PrecioIngresado, Error;
			PrecioIngresado = jTextField3.getText();
    	  	Error = "";
			Contador = Flag = 0;
			if (PrecioIngresado.contains(",")) { PrecioIngresado = PrecioIngresado.replace(',', '.'); }
			while (Contador<PrecioIngresado.length() && Flag<=1) {
				if (PrecioIngresado.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || PrecioIngresado.charAt(Contador)<'0' || PrecioIngresado.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {
				if (PrecioIngresado.indexOf(".")==PrecioIngresado.length()-3 || PrecioIngresado.indexOf(".") == -1) {
					Precio = new BigDecimal(PrecioIngresado);
					Precio = Precio.setScale(2, RoundingMode.HALF_UP);
					Error = Nucleo.ModificoPrecioProducto(jTextField1.getText(),Precio);
					if (Error.isEmpty()) { 
						jTextField4.setText("Precio del Código " + jTextField1.getText() + " Actualizado");
				        jButton1.setEnabled(false);
				        jTextField1.setText("");
						jTextField2.setText("");
						jTextField3.setText("");
					}
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else { 
				if (Contador==0) { Error = "Ingrese El Precio Del Producto"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" para Dec."; }
			}
			if (!Error.isEmpty()) { MostrarError(Error,this); }
        }
		
		public void keyPressed(KeyEvent e) {  }

		public void keyTyped(KeyEvent e) {	}
		
		public void keyReleased(KeyEvent e) { 
			String CodigoProducto = jTextField1.getText();
			LinkedList<String> Producto;			
			if (CodigoProducto.length()==10 || CodigoProducto.length()==15) {
		    	Producto = Nucleo.BuscarProducto(CodigoProducto);
				if (Producto != null) {
					jTextField1.setText(jTextField1.getText().toUpperCase());
					jTextField4.setText(Producto.removeFirst());
					jTextField2.setText(Producto.removeFirst().toString());
			        jButton1.setEnabled(true);
				}
			}
			else {
		        jButton1.setEnabled(false);
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
			}
		}		
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
			jTextField1.setText("");
        	jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
	        jButton1.setEnabled(false);
        	dispose();
        }
	} 


//	Ventana Presea

	public class VentanaPresea extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
		private JTextField jTextField1, jTextField2, jTextField3; //, jTextField4;
//		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
//		private JScrollPane jScrollPane1;
//		private int Total, CantProd;
        public DefaultListModel SampleModel;
//		private Largo, Ancho;
		
		public VentanaPresea() {

//	 		Opciones De Ventana "Agregar Aeropuertos"
			
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel2 = new JLabel();			 	// Moneda
//	        jLabel3 = new JLabel();          	// Precio
//	        jLabel4 = new JLabel();          	// Método de Pago
//	        jLabel5 = new JLabel();          	// Total
//	        jLabel6 = new JLabel();          	// Nro
//	        jLabel7 = new JLabel();          	// Vendedora
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Precio del producto
//	        jTextField3 = new JTextField();  	// Total de venta
//	        jTextField4 = new JTextField();  	// Nro de producto a ingresar
	        jButton1 = new JButton();
	        
	        setTitle("Porcentaje Para Utilizar En Presea");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Precio En Presea $");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Precio Deseado $ ");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(jLabel1.getFont());
	        jTextField3.setEditable(false);
	        
//	        jTextField2.setText("$ 0");
//	        jTextField2.setEditable(false);
	        
	        jButton1.setText("Obtener Porcentaje");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))	
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addGap(26, 26, 26)	
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			double PrecioPresea = Double.parseDouble(jTextField1.getText());
			double PrecioDeseado = Double.parseDouble(jTextField2.getText());
			double Porcentaje = 0;
			if (PrecioPresea<=PrecioDeseado) { Porcentaje = ((PrecioDeseado/PrecioPresea)-1)*100; }
			else { Porcentaje = (1-(PrecioDeseado/PrecioPresea))*100; }
			java.text.DecimalFormat df = new java.text.DecimalFormat();
			df.setMaximumFractionDigits(6);
			jTextField3.setText(df.format(Porcentaje));
        }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
			jTextField1.setText("");
        	jTextField2.setText("");
			jTextField3.setText("");
        	dispose();
        }
	} 
	
	// Ventana Cerrar Caja
	
	public class VentanaCerrarCaja extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9, jTextField10, jTextField11, jTextField12, jTextField14, jTextField15, jTextField16, jTextField17;
		private JButton jButton1, jButton2;
		private JPanel jPanel1;
		private JScrollPane jScrollPane1, jScrollPane2;
	    private JList jList1, jList2;
        public DefaultListModel SampleModel, Movimientos;
        public String Fecha;
        public int Flag;
		public boolean Aceptar;
		
		public VentanaCerrarCaja() {
			
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Fecha
	        jLabel2 = new JLabel();			 	// Moneda
	        jLabel3 = new JLabel();          	// Precio
	        jLabel4 = new JLabel();          	
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Cambio Del Día
	        jLabel8 = new JLabel();          	// Total Cuenta Corriente $
	        jLabel9 = new JLabel();          	// Otras Formas de Pago $
	        jLabel10 = new JLabel();          	// Total De Caja $
	        jLabel11 = new JLabel();          	// Gastos Extras
	        jLabel12 = new JLabel();          	
	        jLabel13 = new JLabel();          	// Movimientos
	        jLabel14 = new JLabel();          	// Gastos
	        jLabel15 = new JLabel();          	// Otros Pagos
	        jLabel16 = new JLabel();          	// Total
	        jLabel17 = new JLabel();          	// Cambio Próxima Caja
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Precio del producto
	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	
	        jTextField5 = new JTextField();
	        jTextField6 = new JTextField();
	        jTextField7 = new JTextField();
	        jTextField8 = new JTextField();
	        jTextField9 = new JTextField();
	        jTextField10 = new JTextField();
	        jTextField11 = new JTextField();
	        jTextField12 = new JTextField();
	        jTextField14 = new JTextField();		// Gastos
	        jTextField15 = new JTextField();		// Retiro
	        jTextField16 = new JTextField();		// Total
	        jTextField17 = new JTextField();		// Cambio Próxima Caja
	        jButton1 = new JButton();		 	
	        jButton2 = new JButton();		 	
	        jScrollPane1 = new JScrollPane();
	        jScrollPane2 = new JScrollPane();
	        jList1 = new JList();
	        jList2 = new JList();
	        Flag = 0;
	        Aceptar = false;
	        
	        setTitle("Cierre de Caja");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);        
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y, 364, 288));
	
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Fecha");	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("/");	        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("/");	        
	        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel4.setText("Efectivo $");	        
	        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel5.setText("Ventas En Efectivo $");	        
	        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel6.setText("Ventas Con Tarjeta $");	        
	        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel7.setText("Cambio Del Día $");	        
	        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel8.setText("Cuenta Corriente $");	        
	        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel9.setText("Otras Formas de Pago $");	        
	        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel10.setText("Total De Caja $");	        
	        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel11.setText("Gastos Extras $");	        
	        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel12.setText("Tarjeta $");	        
	        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel13.setText("Movimientos y Gastos (F8 - Borra Una Venta)");	      
	        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel14.setText("Gastos $");       
	        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel15.setText("Otros $");
	        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel16.setText("Total $");	        
	        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel17.setText("Cambio Próxima Caja $");
	        
	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setFont(jLabel1.getFont());
	        jTextField1.setEditable(false);	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setEditable(false);	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField3.setFont(jLabel1.getFont());
	        jTextField3.setEditable(false);	        
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField4.setFont(jLabel1.getFont());
    	    jTextField4.addKeyListener(this);
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField5.setFont(jLabel1.getFont());
	        jTextField5.setEditable(false);	        
	        jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField6.setFont(jLabel1.getFont());
	        jTextField6.setEditable(false);	        
	        jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField7.setFont(jLabel1.getFont());
	        jTextField7.setEditable(false);	        
	        jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField8.setFont(jLabel1.getFont());
	        jTextField8.setEditable(false);	        
	        jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField9.setFont(jLabel1.getFont());
	        jTextField9.setEditable(false);	        
	        jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField10.setFont(jLabel1.getFont());
	        jTextField10.setEditable(false);
	        jTextField10.setBorder(BorderFactory.createLineBorder(Color.blue));	        
	        jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField11.setFont(jLabel1.getFont());
	        jTextField11.setEditable(false);	        
	        jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField12.setFont(jLabel1.getFont());
     	    jTextField12.addKeyListener(this);
     	    jTextField14.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField14.setFont(jLabel1.getFont());
     	    jTextField14.addKeyListener(this);
	        jTextField15.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField15.setFont(jLabel1.getFont());
     	    jTextField15.addKeyListener(this);
	        jTextField16.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField16.setFont(jLabel1.getFont());
     	    jTextField16.setEditable(false);
	        jTextField16.setBorder(BorderFactory.createLineBorder(Color.blue));
	        jTextField16.addKeyListener(this);
	        jTextField17.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField17.setFont(jLabel1.getFont());
     	    jTextField17.addKeyListener(this);
	        
	        jScrollPane1.setViewportView(jList1);
	        jScrollPane2.setViewportView(jList2);
	        
	        SampleModel = new DefaultListModel();
	        Movimientos = new DefaultListModel();
	        jList1.setModel(SampleModel);
	        jList1.addKeyListener(this);
	        jList2.setModel(Movimientos);
	        
	        jButton1.setText("Ver Caja");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        jButton2.setText("Cerrar Caja");
	        jButton2.addKeyListener(this);
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed();
	            }
	        });
	        
/*	        jButton3.setText("Calcular Total");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed();
	            }
	        });*/
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                				.addGroup(jPanel1Layout.createSequentialGroup()
	                						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                						.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
	                						.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                						.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)	                        		
	                						.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                						.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                				.addGroup(jPanel1Layout.createSequentialGroup()
	                						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
	                				.addGroup(jPanel1Layout.createSequentialGroup()																	
											.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
											.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addComponent(jTextField17, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(jPanel1Layout.createSequentialGroup()
									.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))									
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
													.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGroup(jPanel1Layout.createSequentialGroup()
													.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
															.addGroup(jPanel1Layout.createSequentialGroup()
																	.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																	.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))																				
															.addGroup(jPanel1Layout.createSequentialGroup()
																	.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																	.addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel1Layout.createSequentialGroup()
																	.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																	.addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel1Layout.createSequentialGroup()
																	.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																	.addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel1Layout.createSequentialGroup()
																	.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																	.addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
													.addGap(10, 10, 10)													
													.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
															.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))))										
									.addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                		.addGroup(jPanel1Layout.createSequentialGroup()
	                			.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                				.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                				.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	                			.addGap(8, 8, 8)
                				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
                				.addGap(8, 8, 8)
        						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        								.addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jTextField17, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	                		.addGroup(jPanel1Layout.createSequentialGroup()
	                				.addComponent(jLabel13)
	                				.addGap(17, 17, 17)
	                				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGap(8, 8, 8)
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                						.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                						.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)	
	                						.addGroup(jPanel1Layout.createSequentialGroup()
	                								.addGap(8, 8, 8)
	                								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                										.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                										.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                								.addGap(8, 8, 8)
	                								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                										.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                										.addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                								.addGap(8, 8, 8)
	                								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                										.addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                										.addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                								.addGap(8, 8, 8)
	                								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                										.addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                										.addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	                								.addGap(8, 8, 8)
	                								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                										.addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                										.addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	                						.addGroup(jPanel1Layout.createSequentialGroup()
	                								.addGap(8, 8, 8)
	                								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))))
                				.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        jButton1.requestFocusInWindow();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed() { // Muestra la Caja a Cerrar
	        int CajaAbierta = Nucleo.VerCajaAbierta();
	        Movimientos.removeAllElements();
	        if (CajaAbierta > 1) {
				SampleModel.removeAllElements();
				LinkedList<String> DatosVentas = new LinkedList<String>();
				BigDecimal TotalEfectivo, GastosExtras, Cambio, TotalCaja, CuentaCorriente;
				String SuperVenta, FechaCaja;
				FechaCaja = Integer.toString(CajaAbierta);
				FechaCaja = FechaCaja.substring(0,FechaCaja.length()-2);
				jTextField1.setText(FechaCaja.substring(6));
				jTextField2.setText(FechaCaja.substring(4,6));
				jTextField3.setText(FechaCaja.substring(2,4));
				DatosVentas = Nucleo.ObtenerVentasTotales();
				if (!DatosVentas.isEmpty() && DatosVentas.peek().compareTo("ERROR///1560///")!=0) {		
					SuperVenta = DatosVentas.remove();
					while (SuperVenta.compareTo("Totales")!=0) {
						SampleModel.addElement(SuperVenta);
						SuperVenta = DatosVentas.remove();
					}
					TotalEfectivo = new BigDecimal(DatosVentas.remove());
					TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
					jTextField6.setText(DatosVentas.remove().replace(".", ","));
					CuentaCorriente = new BigDecimal(DatosVentas.remove());
					CuentaCorriente = CuentaCorriente.setScale(2, RoundingMode.HALF_UP);
					jTextField8.setText(CuentaCorriente.toString().replace(".", ","));
					jTextField9.setText(DatosVentas.remove().replace(".", ","));
					GastosExtras = new BigDecimal(DatosVentas.remove());
					GastosExtras = GastosExtras.setScale(2, RoundingMode.HALF_UP);
					jTextField11.setText(GastosExtras.toString().replace(".", ","));
					jTextField5.setText(TotalEfectivo.toString().replace(".", ","));
					Cambio = new BigDecimal(DatosVentas.remove());
					Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
					jTextField7.setText(Cambio.toString().replace(".", ","));
					TotalCaja = new BigDecimal(DatosVentas.remove());
					TotalCaja = TotalCaja.setScale(2, RoundingMode.HALF_UP);
//					jTextField4.setText(TotalCaja.toString().replace(".", ","));			
//					jTextField12.setText(TotalEfectivo.subtract(GastosExtras).add(Cambio).toString().replace(".", ","));
					TotalCaja = TotalCaja.add(Cambio);
					TotalCaja = TotalCaja.subtract(CuentaCorriente);	
//					TotalCaja = TotalCaja.add(GastosExtras);
					jTextField10.setText(TotalCaja.toString().replace(".", ","));
					Flag = 1;
//					Cargo Movimientos, Gastos y Modificaciones de Precios
					LinkedList<String> Gastos = Nucleo.ObtenerGastosPorCaja();
					if (!Gastos.isEmpty()) {
						Movimientos.addElement("Gastos De La Caja:");
						while (!Gastos.isEmpty()) {	Movimientos.addElement(Gastos.remove()); }
					}
					LinkedList<String> Mov = Nucleo.ObtenerMovPorFecha();
					if (!Mov.isEmpty()) {
						Movimientos.addElement("Movimientos De Salida De Mercadería:");
						while (!Mov.isEmpty()) { Movimientos.addElement(Mov.remove()); }
					}
					LinkedList<String> Mod = Nucleo.ObtenerModPorFecha();
					if (!Mod.isEmpty()) {
						Movimientos.addElement("Modificaciones De Precios:");
						while (!Mod.isEmpty()) { Movimientos.addElement(Mod.remove()); }
					}
					jTextField14.setText(jTextField11.getText());
//					jTextField15.setText("0,00");
				}
				else if (DatosVentas.isEmpty()) {
		        	Cerrar();
		        	MostrarError("No Se Encuentra Ninguna Caja Abierta",this);
				}
				else {
					Cerrar();
					MostrarError("Error Al Obtener Datos De Ventas (1560)",this);
				}
	        }
	        else {
	        	Cerrar();
	        	if (CajaAbierta == 0) { MostrarError("No Se Encuentra Ninguna Caja Abierta",this); }
	        	else { MostrarError("Error al Buscar Caja Abierta (1480)",this); }	        	
	        }
        }
		
		private void jButton2ActionPerformed() { // Cierra la Caja
			if (Flag == 1) {
				String Fecha = jTextField1.getText()+"/"+jTextField2.getText()+"/"+jTextField3.getText();
				if (!jTextField17.getText().isEmpty()) {
					if (VerificarNumero(jTextField17.getText().replace(",","."))==0) {
						if (GenerarPDF()==0) {
							if (Nucleo.CerrarCaja(jTextField17.getText())==0) {
								Nucleo.ResetearVentaNro();
								Cerrar();
								if (CajaCerrada == null) { CajaCerrada = new VentanaCajaCerrada(Fecha); }
								else { CajaCerrada.CargarFecha(Fecha); }
								CajaCerrada.setVisible(true);
							}
							else {
								Cerrar();
								MostrarError("La Caja Del " + Fecha + " No Se Pudo Cerrar",this);
							}							
						}
						else { MostrarError("Error al Generar Archivo PDF",this); }
					}
					else { MostrarError("El Monto Del Cambio Es Incorrecto",this); }					
				}
				else { MostrarError("Ingrese el Cambio Para La Próxima Caja",this); }
			}
			else { MostrarError("Presione El Botón \"Ver Caja\"",this); }
        }
		
/*		private void jButton3ActionPerformed() { // Calcula Totales
    	  	String Efectivo, Tarjeta, Gastos, Retiro;
    	  	Efectivo = jTextField4.getText().replace(",",".");
    	  	Tarjeta = jTextField12.getText().replace(",",".");
    	  	Gastos = jTextField14.getText().replace(",",".");
    	  	Retiro = jTextField15.getText().replace(",",".");
    	  	if (VerificarNumero(Efectivo)==0 && VerificarNumero(Tarjeta)==0 && VerificarNumero(Gastos)==0 && VerificarNumero(Retiro)==0) {
    	  		BigDecimal TotalEfectivo, TotalTarjeta, TotalGastos, TotalRetiro, TotalCaja;
				TotalEfectivo = new BigDecimal(Efectivo);
				TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
				TotalTarjeta = new BigDecimal(Tarjeta);
				TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
				TotalGastos = new BigDecimal(Gastos);
				TotalGastos = TotalGastos.setScale(2, RoundingMode.HALF_UP);
				TotalRetiro = new BigDecimal(Retiro);
				TotalRetiro = TotalRetiro.setScale(2, RoundingMode.HALF_UP);
				TotalCaja = new BigDecimal(0);
				TotalCaja = TotalCaja.setScale(2, RoundingMode.HALF_UP);
				TotalCaja = TotalCaja.add(TotalEfectivo);
				TotalCaja = TotalCaja.add(TotalTarjeta);
				TotalCaja = TotalCaja.add(TotalGastos);
				TotalCaja = TotalCaja.add(TotalRetiro);
				jTextField16.setText(TotalCaja.toString().replace(".",","));
    	  	}
    	  	else { MostrarError("Datos Ingresados Incorrectos",this); }
        } */
		
		private int GenerarPDF() {
			
			int Error = 0;
			ByteArrayOutputStream iData = new ByteArrayOutputStream();
			Document document = new Document();
			String FechaArchivo = jTextField1.getText()+"-"+jTextField2.getText()+"-"+jTextField3.getText();
			String Local;
			if (Nucleo.ObtenerLocalNro()==1) { Local = "Calcuer"; }
			else if (Nucleo.ObtenerLocalNro()==2) { Local = "BC Bags"; }
			else if (Nucleo.ObtenerLocalNro()==3) { Local = "Prune"; }
			else { Local = "Local de Prueba"; }
			/*					String NombreArchivo = "C:\\Cajas\\Caja " + Local + " " + FechaArchivo;
					if (CodigoCaja.charAt(CodigoCaja.length()-1)!='1') { 
						NombreArchivo += " (" + CodigoCaja.charAt(CodigoCaja.length()-1) + ").pdf";
					}
					else { NombreArchivo += ".pdf"; }*/
			try {
				//						PdfWriter.getInstance(document, new FileOutputStream(NombreArchivo));
				PdfWriter.getInstance(document, iData);
				document.open();
				//						document.addHeader("BC bags", "Glendora Tech");
				float[] widths1 = { 0.7f, 1f, 7.8f, 1.2f, 1.5f, 1.5f };
				PdfPTable table = new PdfPTable(widths1);
				table.setTotalWidth(520f);
				table.setLockedWidth(true);
				PdfPCell cell = new PdfPCell(new Paragraph("Caja de " + Local + " - " + FechaArchivo));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setColspan(3);
				table.addCell(cell);
				cell = new PdfPCell(new Paragraph("Cambio $" + jTextField7.getText()));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setColspan(3);
				table.addCell(cell);
				Phrase ph;
				FontSelector selector = new FontSelector();
				selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 9));
				ph = selector.process("Nro");
				table.addCell(ph);
				ph = selector.process("Hora");
				table.addCell(ph);
				ph = selector.process("Descripción");
				table.addCell(ph);
				ph = selector.process("Total");
				table.addCell(ph);
				ph = selector.process("Método Pago");
				table.addCell(ph);
				ph = selector.process("Tipo Ticket");
				table.addCell(ph);
				String[] ListaVentas = new String[6];
				LinkedList<String[]> DatosVentas = new LinkedList<String[]>();
				try { 
					Nucleo.ActivarBDCuentas();
					DatosVentas = Nucleo.ObtenerVentasPDF();
					Nucleo.DesactivarBDCuentas();
				}
				catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }						
				if (!DatosVentas.isEmpty()/* && DatosVentas.peek().compareTo("ERROR///1550///")!=0*/) {
					while (!DatosVentas.isEmpty()) {
						ListaVentas = DatosVentas.remove();
						for (int i=0;i<6;i++) {
							if (ListaVentas[i]!=null && !ListaVentas[i].isEmpty()) {
								ph = selector.process(ListaVentas[i]);
								table.addCell(ph);
							}
							else { table.addCell("-"); }
							//document.add(new Paragraph(ph));																
						}
					}
					table.setSpacingAfter(15f);
					document.add(table);
					//							TotalNeto = Integer.parseInt(jTextField10.getText())
					BigDecimal TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago, TotalNeto;
					TotalEfectivo = new BigDecimal(jTextField5.getText().replace(",","."));
					TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
					TotalTarjeta = new BigDecimal(jTextField6.getText().replace(",","."));
					TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
					TotalCuentaCorriente = new BigDecimal(jTextField8.getText().replace(",","."));
					TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
					TotalOtroMetodoPago = new BigDecimal(jTextField9.getText().replace(",","."));
					TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
					TotalNeto = new BigDecimal(0);
					TotalNeto = TotalNeto.setScale(2, RoundingMode.HALF_UP);
					TotalNeto = TotalNeto.add(TotalEfectivo);
					TotalNeto = TotalNeto.add(TotalTarjeta);
					TotalNeto = TotalNeto.add(TotalOtroMetodoPago);
					float[] widths2 = { 4f, 4f, 4f }; // Genero La Segunda Tabla Con Totales de Ventas
					PdfPTable table2 = new PdfPTable(widths2);
					table2.setTotalWidth(520f);
					table2.setLockedWidth(true);							
					cell = new PdfPCell(new Paragraph("Total Ventas Neto $" + TotalNeto.toString().replace(".",",")));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setColspan(2);
					table2.addCell(cell);
					cell = new PdfPCell(new Paragraph("Total en Caja $" + jTextField10.getText()));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setColspan(1);
					table2.addCell(cell);
					table2.setSpacingAfter(15f);
					document.add(table2);
				}
				else if (DatosVentas.isEmpty()) { MostrarError("La Fecha Ingresada No Contiene Ventas",this); }
				else { MostrarError("Error al Obtener Datos De Ventas",this); }
				float[] widths3 = { 1.5f, 1.5f }; // Genero La Tercera Tabla Con Totales de Caja
				PdfPTable table3 = new PdfPTable(widths3);
				table3.setTotalWidth(170f);
				table3.setLockedWidth(true);
				PdfPCell cell2 = new PdfPCell(new Paragraph("Datos de la Caja"));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setColspan(2);
				table3.addCell(cell2);
				ph = selector.process("Efectivo");
				table3.addCell(ph);
				ph = selector.process("$" + jTextField4.getText());
				table3.addCell(ph);
				ph = selector.process("Tarjeta");
				table3.addCell(ph);
				ph = selector.process("$" + jTextField12.getText());
				table3.addCell(ph);
				ph = selector.process("Gastos");					
				table3.addCell(ph);
				ph = selector.process("$" + jTextField14.getText());
				table3.addCell(ph);
				ph = selector.process("Otros Pagos");
				table3.addCell(ph);
				ph = selector.process("$" + jTextField15.getText());
				table3.addCell(ph);
				cell = new PdfPCell(new Paragraph("Total en Caja"));
				//						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setColspan(1);
				table3.addCell(cell);
				cell = new PdfPCell(new Paragraph("$" + jTextField16.getText()));
				//						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setColspan(1);
				table3.addCell(cell);
				/*						ph = selector.process("Total en Caja");
						table3.addCell(ph);
						ph = selector.process("$" + jTextField16.getText());
						table3.addCell(ph);*/
				table3.setSpacingAfter(15f);
				document.add(table3);
				ph = selector.process("Cambio Próxima Caja $" + jTextField17.getText().replace(".",",") + "\n" + "Hora Cierre de Caja: " + Nucleo.CrearHora());
				document.add(ph);
			} catch (Exception de) {
				System.err.println(de.getMessage());
				return 1;
			}
			if (Error==0) {
				document.close();
				try { 
					Nucleo.ActivarBDCuentas();
					Error = Nucleo.GrabarPDF(iData.toByteArray()); /* Graba PDF en Base de Datos */
					Nucleo.DesactivarBDCuentas();
				}
				catch (Exception sqle) { 
					MostrarExcepcion(sqle.toString(),this);
					return 1;
				}
			}
			return Error;
			
		}
		
		public int VerificarNumero(String Valor) {
			// Errores: 1) Ingresar El Precio Del Producto - 2) Ingresar Solo Números y \".\" o \",\" para Decimales - 3) Ingresar Dos Decimales
    	  	int Contador = 0;
    	  	int Flag = 0;
			while (Contador<Valor.length() && Flag<=1) { // Verifico que Tenga un Solo Punto o Coma y Que Sean Números
				if (Valor.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || Valor.charAt(Contador)<'0' || Valor.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1) { // Verifico que Si Tiene Decimales Sean de Dos Posiciones
				if (Valor.indexOf(".")!=Valor.length()-3 && Valor.indexOf(".") != -1) { return 3; }
			}
			else { return 2; }
			if (Contador==0) { return 1; }
			return 0;
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
	        SampleModel.removeAllElements();
	        Movimientos.removeAllElements();
	        jTextField1.setText("");
	        jTextField2.setText("");
	        jTextField3.setText("");
	        jTextField4.setText("");
	        jTextField5.setText("");
	        jTextField6.setText("");
	        jTextField7.setText("");
	        jTextField8.setText("");
	        jTextField9.setText("");
	        jTextField10.setText("");
	        jTextField11.setText("");
	        jTextField12.setText("");
	        jTextField14.setText("");
	        jTextField15.setText("");
	        jTextField16.setText("");
	        jTextField17.setText("");
			Flag = 0;
	        Aceptar = false;
        	dispose();        	
        }

		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if ((e.getComponent()==jTextField4 || e.getComponent()==jTextField12 || e.getComponent()==jTextField14 || e.getComponent()==jTextField15) && Tecla.compareTo("Introduzca")!=0) {
	    	  	String Efectivo, Tarjeta, Gastos, Retiro;
	    	  	Efectivo = jTextField4.getText().replace(",",".");
	    	  	Tarjeta = jTextField12.getText().replace(",",".");
	    	  	Gastos = jTextField14.getText().replace(",",".");
	    	  	Retiro = jTextField15.getText().replace(",",".");
	    	  	if (Efectivo.isEmpty()) { Efectivo = "0"; }
	    	  	if (Tarjeta.isEmpty()) { Tarjeta = "0"; }
	    	  	if (Gastos.isEmpty()) { Gastos = "0"; }
	    	  	if (Retiro.isEmpty()) { Retiro = "0"; }
	    	  	if (VerificarNumero(Efectivo)==0 && VerificarNumero(Tarjeta)==0 && VerificarNumero(Gastos)==0 && VerificarNumero(Retiro)==0) {
	    	  		BigDecimal TotalEfectivo, TotalTarjeta, TotalGastos, TotalRetiro, TotalCaja;
					TotalEfectivo = new BigDecimal(Efectivo);
					TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
					TotalTarjeta = new BigDecimal(Tarjeta);
					TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
					TotalGastos = new BigDecimal(Gastos);
					TotalGastos = TotalGastos.setScale(2, RoundingMode.HALF_UP);
					TotalRetiro = new BigDecimal(Retiro);
					TotalRetiro = TotalRetiro.setScale(2, RoundingMode.HALF_UP);
					TotalCaja = new BigDecimal(0);
					TotalCaja = TotalCaja.setScale(2, RoundingMode.HALF_UP);
					TotalCaja = TotalCaja.add(TotalEfectivo);
					TotalCaja = TotalCaja.add(TotalTarjeta);
					TotalCaja = TotalCaja.add(TotalGastos);
					TotalCaja = TotalCaja.add(TotalRetiro);
					jTextField16.setText(TotalCaja.toString().replace(".",","));
	    	  	}
			}
			else if (Tecla.compareTo("Introduzca")==0) {
				if (e.getComponent()==jButton1) {
					jButton1ActionPerformed();
					jTextField4.requestFocusInWindow();
				}
				else if (e.getComponent()==jTextField4) { jTextField12.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField12) { jTextField14.requestFocusInWindow(); } 
				else if (e.getComponent()==jTextField14) { jTextField15.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField15) { jTextField17.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField17) { jButton2.requestFocusInWindow(); }
				else if (e.getComponent()==jButton2) { jButton2ActionPerformed(); }
			}
			else if (Tecla.compareTo("F8")==0) { PresionarF8(); }
		}

		public void keyTyped(KeyEvent e) { }
		
		public void PresionarF8() {
			int Index = jList1.getSelectedIndex();
			int Resultado;
			if (Index>=0) {
				MostrarConfirmar("¿Desea Eliminar Esta Venta De La Caja?",this,2);
				if (Aceptar) {
					if (Clave == null) { Clave = new VentanaClave(this); }
					Clave.setVisible(true);
					if (Clave.ObtenerAcceso()) {
						Index++;
						Resultado = Nucleo.BorrarVenta(Index);
						if (Resultado == 0) {
							MostrarAviso("La Venta Ha Sido Eliminada",this);
							jButton1ActionPerformed();
						}
						else if (Resultado == 1) { MostrarError("Error al Borrar La Venta", this); }
						else if (Resultado == 2) { MostrarAviso("No Se Puede Borrar La Venta De Un Cliente",this); }								 						
					}
					else { MostrarError("Contraseña Incorrecta", this); }
				}		
			}
			else { MostrarError("Debe Seleccionar Una Venta Para Borrar",this); }
		}
	}
	
	public class VentanaErrorCajaNoAbierta extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaErrorCajaNoAbierta() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        
	        setTitle("Aviso");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Abrir Caja Antes de Realizar una Venta");
	        
	        jButton1.setText("OK, Lo Haré");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed() { dispose(); }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) { dispose(); }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
	}
	
	public class VentanaErrores extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaErrores(String Error, JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        
	        setTitle("Error");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 220, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText(Error);
	        
	        jButton1.setText("Perdón");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() { dispose(); }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	dispose();
        }
        
        public void CargarVentana(String Error, JDialog VentanaMadre) {
        	jLabel1.setText(Error);
	        pack();
        	setLocationRelativeTo(VentanaMadre);
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
	}
	
	public class VentanaExcepciones extends JDialog {

		private static final long serialVersionUID = 1L;

		private JTextArea jTextArea1;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaExcepciones(String Error, JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jTextArea1 = new JTextArea();			 	
	        jButton1 = new JButton();
	        
	        setTitle("Error");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 220, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jTextArea1.setText(Error);
	        
	        jButton1.setText("Perdón");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jTextArea1, 400, 400, 400)
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	  	dispose();
        }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	dispose();
        }
        
        public void CargarVentana(String Error, JDialog VentanaMadre) {
        	jTextArea1.setText(Error);
	        pack();
        	setLocationRelativeTo(VentanaMadre);
        }
	}

	public class VentanaAviso extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaAviso(String Texto, JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        
	        setTitle("Aviso");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText(Texto);
	        
	        jButton1.setText("OK");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() { dispose(); }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	dispose();
        }
        
        public void CargarVentana(String Texto, JDialog VentanaMadre) {
        	jLabel1.setText(Texto);
	        pack();
        	setLocationRelativeTo(VentanaMadre);
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
	}
	
	public class VentanaClave extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JButton jButton1;
		private JPanel jPanel1;
		private boolean ClaveOK;
		private JPasswordField jPasswordField1;
		
		public VentanaClave(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        jPasswordField1 = new JPasswordField();
	        ClaveOK = false;
	        
	        setTitle("Acceso");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Ingresar Contraseña");
	        
	        jPasswordField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jPasswordField1.setFont(jLabel1.getFont());
	        jPasswordField1.addKeyListener(this);
	        jPasswordField1.requestFocusInWindow();
	        
	        jButton1.setText("OK");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana();
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                		.addGroup(jPanel1Layout.createSequentialGroup()
	                				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	                				.addGap(GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	                				.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
    	               	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    	               			.addComponent(jLabel1)
    	               			.addComponent(jPasswordField1))
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() {
			String Password = new String(jPasswordField1.getPassword());
			if (Password.compareTo("2085")==0) { ClaveOK = true; }
			else { ClaveOK = false; }
			jPasswordField1.requestFocusInWindow();
			jPasswordField1.setText("");
			dispose();
        }
        
        public void CerrarVentana() {
        	ClaveOK = false;
        	jPasswordField1.requestFocusInWindow();
        	jPasswordField1.setText("");
        	dispose();
        }
        
        public boolean ObtenerAcceso() { return ClaveOK; }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
		
	}

	public class VentanaCajaCerrada extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;// jLabel2;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
//		private JTextField jTextField1;//, jTextField2;// jTextField3, jTextField4;
//		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
		
		public VentanaCajaCerrada(String Fecha) {
			
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        
	        setTitle("Confirmación");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        setBounds(new java.awt.Rectangle(Principal.getBounds().x + 198, Principal.getBounds().y + 239, 364, 288));
       
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

	        jLabel1.setText("La Caja Del Día " + Fecha + " Ha Sido Cerrada Correctamente");
	               
	        jButton1.setText("Buenisimo");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed() { dispose(); }
        
		public void CargarFecha(String Fecha) { jLabel1.setText("La Caja Del Día " + Fecha + " Ha Sido Cerrada Correctamente"); }
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { dispose(); }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
	}
	
//  Ventana Stock
	
	public class VentanaStock extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel23;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9, jTextField10, jTextField11, jTextField12, jTextField13, jTextField14, jTextField15, jTextField16;
		private JRadioButton jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4, jRadioButton5;
		private JComboBox jComboBox2, jComboBox3, jComboBox5, jComboBox6, jComboBox7, jComboBox8, jComboBox9, jComboBox10, jComboBox1, jComboBox4;
		private JButton jButton1, jButton2, jButton3;
		private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
/*      public DefaultListModel SampleModel;
        public JList jList1; */
        public LinkedList<String> Rubro;
        public LinkedList<String> Material;
        public LinkedList<String> Color;
        public LinkedList<String> Talle;
        public LinkedList<String> Marca;
        public LinkedList<String> Temporada;
        public LinkedList<String> Auditor;
        public int Flag, CargaDatos, Local;
        public String Traslado,TipoTalle;
		
		public VentanaStock() {

			jPanel1 = new JPanel();
	        jPanel2 = new JPanel();	
	        jPanel3 = new JPanel();
	        jPanel4 = new JPanel();             // Panel de Botones
	        jLabel1 = new JLabel();			 	// Código del Producto
	        jLabel2 = new JLabel();			 	// Descripción (Ingreso)
	        jLabel3 = new JLabel();          	// Cantidad (Ingreso)
	        jLabel4 = new JLabel();          	// Ingresar Producto al Stock
	        jLabel5 = new JLabel();          	// Precio (Ingreso)        
	        jLabel6 = new JLabel();          	// Rubro 
	        jLabel7 = new JLabel();          	// Salida Mercaderia
	        jLabel8 = new JLabel();          	// Código del Producto (Modificar)
	        jLabel9 = new JLabel();          	// Búsqueda de Productos
	        jLabel10 = new JLabel();          	// Búsqueda de Productos
	        jLabel11 = new JLabel();          	// Búsqueda de Productos
	        jLabel12 = new JLabel();          	// Temporada
	        jLabel13 = new JLabel();          	// Descripción (Modificar)
	        jLabel14 = new JLabel();          	// Cantidad (Modificar)
	        jLabel15 = new JLabel();          	// Precio (Modificar)
	        jLabel16 = new JLabel();          	// Rubro (Modificar)
	        jLabel17 = new JLabel();          	// Temporada (Modificar)
	        jLabel18 = new JLabel();          	// Material (ingresar producto)
	        jLabel19 = new JLabel();          	// Color (ingresar producto)
	        jLabel20 = new JLabel();          	// Talle (ingresar producto)
	        jLabel21 = new JLabel();          	// Marca (ingresar producto)
	        jLabel22 = new JLabel();          	// Autorizado Por (Ingreso)
	        jLabel23 = new JLabel();          	// Motivo de Movimiento de Mercadería
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();  	// Descripcion del producto
	        jTextField3 = new JTextField();  	// Cantidad (Ingreso)
	        jTextField4 = new JTextField();  	// Código para buscar producto
	        jTextField5 = new JTextField();  	// Precio para buscar (desde)
	        jTextField6 = new JTextField();  	// Cantidad para buscar
	        jTextField7 = new JTextField();  	// Precio para buscar (hasta)
	        jTextField8 = new JTextField();  	// Precio (Ingreso)
	        jTextField9 = new JTextField();  	// Código (Modificar)
	        jTextField10 = new JTextField();  	// Descripción (Dar Baja Producto)
	        jTextField11 = new JTextField();  	// Cantidad (Modificar)
	        jTextField12 = new JTextField();  	// Precio (Modificar)
	        jTextField13 = new JTextField();  	// Rubro (Modificar)
	        jTextField14 = new JTextField();  	// Temporada (Modificar)
	        jTextField15 = new JTextField();  	// Carga Producto (Ingreso)
	        jTextField16 = new JTextField();  	// Carga Producto (Ingreso)
	        jComboBox1 = new JComboBox();		// Rubro para buscar
	        jComboBox2 = new JComboBox();  	    // Rubro (Ingreso)
	        jComboBox3 = new JComboBox();  	    // Temporada (Ingreso)
	        jComboBox4 = new JComboBox();  	    // Buscar por Temporada
	        jComboBox5 = new JComboBox();  	    // Material (Ingreso) 
	        jComboBox6 = new JComboBox();  	    // Color (Ingreso) 
	        jComboBox7 = new JComboBox();  	    // Talle (Ingreso) 
	        jComboBox8 = new JComboBox();  	    // Marca (Ingreso)
	        jComboBox9 = new JComboBox();  	    // Autorizado Por (Ingreso)
	        jComboBox10 = new JComboBox();  	// Descripción Movimiento de Stock
	        jButton1 = new JButton();			// Ingresar (ingresar producto)
	        jButton2 = new JButton();			// Buscar
	        jButton3 = new JButton();			// Modificar Datos
	        jScrollPane1 = new JScrollPane();	// Muestra Productos buscados
	        jRadioButton1 = new JRadioButton(); // Buscar Por Código        
	        jRadioButton2 = new JRadioButton(); // Buscar Por Rubro
	        jRadioButton3 = new JRadioButton(); // Buscar Por Precio
	        jRadioButton4 = new JRadioButton(); // Buscar Por Cantidad
	        jRadioButton5 = new JRadioButton();	// Buscar por temporada
//	        jList1 = new JList();				// Lista los productos buscados
	        jTable1 = new JTable();
	        TableModel = new DefaultTableModel();
//	        SampleModel = new DefaultListModel();
	        Rubro = Material = Color = Talle = Marca = Temporada = Auditor = null;
	        Flag = CargaDatos = 0;
	        
	        setTitle("Gestión de Stock");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jPanel2.setBorder(BorderFactory.createEtchedBorder());
	        jPanel2.setName("");
	        
	        jPanel3.setBorder(BorderFactory.createEtchedBorder());
	        jPanel3.setName("");
	        
	        jPanel4.setBorder(BorderFactory.createEtchedBorder());
	        jPanel4.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Código del Producto");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Descripción");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel3.setText("Cantidad");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("Ingresar Producto al Stock");
	        
	        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel5.setText("Precio $");
	        
	        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel6.setText("Rubro");
	        
	        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel7.setText("Movimiento de Mercadería");
	        	        
	        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel8.setText("Código del Producto");
	        
	        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel9.setText("Búsqueda de Productos");
	        
	        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel10.setText("Desde $");
	        
	        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel11.setText("Hasta $");
	        
	        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel12.setText("Temporada");
	        
	        jLabel13.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel13.setText("Cantidad");
	        
	        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel14.setText("Cantidad");
	        
	        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel15.setText("Precio $");
	        
	        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel16.setText("Rubro");
	        
	        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel17.setText("Temporada");
	        
	        jLabel18.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel18.setText("Material");
	        
	        jLabel19.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel19.setText("Color");
	        
	        jLabel20.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel20.setText("Talle/Tamaño");
	        
	        jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel21.setText("Marca");
	        
	        jLabel22.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel22.setText("Auditor");
	        
	        jLabel23.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel23.setText("Motivo De La Salida");
	        	               	        
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());    
	        jTextField1.addKeyListener(this);
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setEditable(false);
	        
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(jLabel1.getFont());
	        jTextField3.setText("1");
	        
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField4.setFont(jLabel1.getFont());
	        
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField5.setFont(jLabel1.getFont());
	        
	        jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField6.setFont(jLabel1.getFont());
	        
	        jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField7.setFont(jLabel1.getFont());
	        
	        jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField8.setFont(jLabel1.getFont());
	        
	        jTextField9.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField9.setFont(jLabel1.getFont());	        
	        jTextField9.addKeyListener(this);
	        
	        jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField10.setFont(jLabel1.getFont());
	        
	        jTextField11.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField11.setFont(jLabel1.getFont());
	        jTextField11.setEditable(false);
	        
	        jTextField12.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField12.setFont(jLabel1.getFont());
	        
	        jTextField13.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField13.setFont(jLabel1.getFont());
	        jTextField13.setEditable(false);
	        
	        jTextField14.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField14.setFont(jLabel1.getFont());
	        jTextField14.setEditable(false);
	        
	        jTextField15.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField15.setFont(jLabel1.getFont());
	        jTextField15.setEditable(false);
	        
	        jTextField16.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField16.setFont(jLabel1.getFont());
	        jTextField16.setEditable(false);
	             
	        jRadioButton1.setHorizontalAlignment(SwingConstants.LEFT);
	        jRadioButton1.setText("Por Código");
	        
	        jRadioButton2.setHorizontalAlignment(SwingConstants.LEFT);
	        jRadioButton2.setText("Por Rubro");
	        
	        jRadioButton3.setHorizontalAlignment(SwingConstants.LEFT);
	        jRadioButton3.setText("Por Precio");
	        
	        jRadioButton4.setHorizontalAlignment(SwingConstants.LEFT);
	        jRadioButton4.setText("Por Cantidad");
	        
	        jRadioButton5.setHorizontalAlignment(SwingConstants.LEFT);
	        jRadioButton5.setText("Por Marca");
	        
//	        TableModel.setRowCount(Filas);
	        TableModel.addColumn("Código");
	        TableModel.addColumn("Descripción");
	        TableModel.addColumn("Precio");
	        TableModel.addColumn("Cantidad");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(120);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(270);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(50);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(3);
			column.setPreferredWidth(60);
			column.setResizable(false);
			column.setCellRenderer(tcr);
	        
	        TipoTalle = "";
	        Local = Nucleo.VerificarLocal();
	        if (Local == 1) { Traslado = "Traslado a BC bags"; }
	        else if (Local == 2) { Traslado = "Traslado a Calcuer"; }
	        else { Traslado = "Traslado"; }
	        
	        jComboBox10.setModel(new DefaultComboBoxModel(new String[] { "Ajuste de Stock", "Devolución Por Falla", "Retiro Sin Cargo", "Otros" }));
	        
			jComboBox2.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) {
	            	jComboBox2ActionPerformed(evt);
	            }
			});
			
			jComboBox8.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) {
	            	jComboBox8ActionPerformed(evt);
	            }
			});

	        Rubro = Nucleo.BuscarRubros();
			for (int i=0;i<Rubro.size();i++) { 
				jComboBox2.addItem(Rubro.get(i)); // Almacena Rubro Para Cargar Productos
				jComboBox1.addItem(Rubro.get(i)); // Almacena Rubro Para Buscar Productos
			}
			Material = Nucleo.BuscarMateriales();
			for (int i=0;i<Material.size();i++) { jComboBox5.addItem(Material.get(i)); }
			Color = Nucleo.BuscarColores();
			for (int i=0;i<Color.size();i++) { jComboBox6.addItem(Color.get(i)); }

			CargaDatos = 1;
			
			Marca = Nucleo.BuscarMarcas();
			for (int i=0;i<Marca.size();i++) { 
				jComboBox8.addItem(Marca.get(i)); // Almacena Marca Para Cargar Productos
				jComboBox4.addItem(Marca.get(i)); // Almacena Marca Para Buscar Productos
			}
//			Talle = Nucleo.BuscarTalles();
//			for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
	        Temporada = Nucleo.BuscarTemporadas();
			for (int i=0;i<Temporada.size();i++) { jComboBox3.addItem(Temporada.get(i)); }
			Auditor = Nucleo.BuscarAuditores();
			for (int i=0;i<Auditor.size();i++) { jComboBox9.addItem(Auditor.get(i)); }
        
/*			TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion((String) jComboBox2.getSelectedItem()));
			Talle = Nucleo.BuscarTalles(TipoTalle);
			for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
			if (Talle.size()<2) { jComboBox7.setEnabled(false); } */
			
//			jScrollPane1.setViewportView(jList1);
//	        jList1.setModel(SampleModel);	        
	        
//	        jTextField2.setText("$ 0");
//	        jTextField2.setEditable(false);
	        
	        jButton1.setText("Ingresar");
	        jButton1.setEnabled(false);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton2.setText("Buscar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        jButton3.setText("Confirmar");
	        jButton3.setEnabled(false);
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed(evt);
	            }
	        });
	        	        
	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jTextField1.requestFocusInWindow();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
/*	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))*/
	                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)    
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                       	.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)    
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)    
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox7, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox8, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addGap(120, 120, 120)	
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
		            	.addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel4))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel1)
			                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				               	.addComponent(jLabel6)
				               	.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel18)
			                	.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel19)
			                	.addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))			                	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel21)
			                	.addComponent(jComboBox8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				            .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel20)
			                	.addComponent(jComboBox7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			                	.addComponent(jLabel22)
			                	.addComponent(jComboBox9, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)			                
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel12)
			                	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))			                	
			                .addGap(8, 8, 8)			                	
			               	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel3)
			                	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			                	.addComponent(jLabel5)
			                	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)			                
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                .addGap(8, 8, 8)
			                .addComponent(jTextField15)))
                	.addContainerGap())
	        );
	        
	        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(jPanel2Layout.createSequentialGroup()
	                		.addGap(GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)	                			
	                		.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGap(GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                    		
	                        .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGap(GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                    		
	                        .addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGap(GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                    		
	                        .addComponent(jRadioButton3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGap(GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                    		
	                        .addComponent(jRadioButton4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGap(GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)	                    		
	                        .addComponent(jRadioButton5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))		                        
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                    	.addGap(200, 200, 200)
	                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))                       
	                .addContainerGap())            
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
		                	.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jLabel9))
		               		.addGap(8, 8, 8)			                	
	                		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jRadioButton1, 21, 21, 21)
	                			.addComponent(jTextField4, 21, 21, 21))
		               		.addGap(8, 8, 8)
		               		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jRadioButton2, 21, 21, 21)
	                			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
		               		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jRadioButton3, 21, 21, 21)
	                			.addComponent(jLabel10)
	                			.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                			.addComponent(jLabel11)
	                			.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
		               		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jRadioButton4, 21, 21, 21)
	                			.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
		               		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jRadioButton5, 21, 21, 21)
	                			.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)		               		
		               		.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
	        
	        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(jPanel3Layout.createSequentialGroup()             			
	                		.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel3Layout.createSequentialGroup()
	                    	.addGap(84,84,84)
		                    .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		                    .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel3Layout.createSequentialGroup()
	                    	.addGap(84,84,84)
		                    .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox10, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
		                .addGroup(jPanel3Layout.createSequentialGroup()
		                	.addGap(84,84,84)		                		
		                    .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
		                    .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		                .addGroup(jPanel3Layout.createSequentialGroup()
		                	.addGap(84,84,84)		                				                    
		                    .addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel3Layout.createSequentialGroup()
		                    .addGap(200, 200, 200)
	                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))	                      
	                .addContainerGap())  
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel3Layout.createSequentialGroup()
		                	.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jLabel7))
		               		.addGap(8, 8, 8)			                	
	                		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel8)
	                			.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	                		.addGap(8, 8, 8)
	                		.addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                		.addGap(8, 8, 8)
	                		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel23)
	                			.addComponent(jComboBox10, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	                			
			                .addGap(8, 8, 8)
			           		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel13)
	                			.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))/*
			                .addGap(8, 8, 8)
			           		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel14)
	                			.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			           		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel15)
	                			.addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			           		.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel16)
	                			.addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel17)
	                			.addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))*/
			                .addGap(8, 8, 8)
			                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))                
                	.addContainerGap())
	        );	        

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
/*	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))*/
	                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*	                	.addGroup(layout.createSequentialGroup()
	                		.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                		.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))*/
	                	.addGroup(layout.createSequentialGroup()
	                		.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                	    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                		.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/*			int Cantidad, Contador, Flag;
			BigDecimal Precio;
			String PrecioIngresado, Error;
			Cantidad = Contador = Flag = 0;
			Error = "";
//			try {
			jTextField1.setText(jTextField1.getText().toUpperCase());
			Cantidad = Integer.parseInt(jTextField3.getText()); 
			PrecioIngresado = jTextField8.getText();
			if (PrecioIngresado.contains(",")) { PrecioIngresado = PrecioIngresado.replace(',', '.'); }
			while (Contador<PrecioIngresado.length() && Flag<=1) {
				if (PrecioIngresado.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || PrecioIngresado.charAt(Contador)<'0' || PrecioIngresado.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {
				if (PrecioIngresado.indexOf(".")==PrecioIngresado.length()-3 || PrecioIngresado.indexOf(".") == -1) {
					Precio = new BigDecimal(PrecioIngresado);
					Precio = Precio.setScale(2, RoundingMode.HALF_UP);
					/*			} catch(NumberFormatException nfe) {
				SampleModel.addElement("No Se Ingresaron Los Datos Correctamente Del Producto");
				// AGREGAR VENTANA DE ERROR
			}*/
/*					int Ingreso = Nucleo.IngresarProducto(jTextField1.getText(), jTextField2.getText(), Cantidad, Precio, 
							jComboBox2.getSelectedItem().toString(), jComboBox3.getSelectedItem().toString(), jComboBox5.getSelectedItem().toString(), 
							jComboBox6.getSelectedItem().toString(), jComboBox7.getSelectedItem().toString(), jComboBox8.getSelectedItem().toString(), 
							jComboBox9.getSelectedItem().toString(), TipoTalle);
					if (Ingreso==1) {
						dispose();
						if (ErrorEnBD == null) {
							ErrorEnBD = new VentanaErrorEnBD();   	
							ErrorEnBD.setVisible(true);
							System.out.println("Ventana ErrorEnBD Size: X:" + ErrorEnBD.getWidth() + " Y:" + ErrorEnBD.getHeight());
						}
						else {
							ErrorEnBD.setLocation(getBounds().x + 332, getBounds().y + 295);
							ErrorEnBD.setVisible(true);    		
						}					
					}
					else {
						jTextField15.setText("Producto Código " + jTextField1.getText() + " Cargado");
						jTextField2.setText("");
						jTextField3.setText("1");
						jTextField3.setEditable(true);
						jTextField8.setText("");
						if (this.Flag==1) { 
							Ventas.CargarCodigo(jTextField1.getText());
							jTextField1.setText("");
							Cerrar();
						}
						else { 
							jTextField1.setText("");
					        jTextField1.requestFocusInWindow();
					    }
					}
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else { 
				if (Contador==0) { Error = "Ingrese El Precio Del Producto"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" para Dec."; }
			}
			if (!Error.isEmpty()) { MostrarError(Error,this); }*/
		}
		      
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			LimpiarTabla();
			int Flag = 0;
			String Codigo, Rubro, Marca;
			String[] Datos = new String[4];
			int y = 0;
			int Precio1, Precio2, Cantidad, Insert;
			Codigo = Rubro = Marca = "";
			Precio1 = Precio2 = Cantidad = Insert = 0;
			LinkedList<String> ListaProd;
			if (jRadioButton1.isSelected()) { 
				Codigo = jTextField4.getText();
				Flag = 1;
			}
			if (jRadioButton2.isSelected()) { 
				Rubro = jComboBox1.getSelectedItem().toString();
				Flag += 10;
			}
			if (jRadioButton3.isSelected()) {
				if (jTextField5.getText().length()!=0) { Precio1 = Integer.parseInt(jTextField5.getText()); }
				else { Insert = 1; }
				if (jTextField7.getText().length()!=0) { Precio2 = Integer.parseInt(jTextField7.getText()); }
				else { Insert = 1; }
				Flag += 100;
			}
			if (jRadioButton4.isSelected()) {
				if (jTextField6.getText().length()!=0) { Cantidad = Integer.parseInt(jTextField6.getText()); }
				else { Insert = 1; }
				Flag += 1000;
			}
			if (jRadioButton5.isSelected()) {
				Marca = jComboBox4.getSelectedItem().toString();
				Flag += 10000;
			}
			ListaProd = Nucleo.BuscarProducto(Flag, Codigo, Rubro, Precio1, Precio2, Cantidad, Marca);
//			ListaProd = Nucleo.BuscarProducto(Flag, Codigo, "", 0, 0, 0, "");
			if (Insert == 1) { 
				Datos[0] = "Faltan Valores En Los Campos Seleccionados";
				TableModel.addRow(Datos);
			}
			else if (ListaProd.isEmpty()) { 
				Datos[0] = "No Se Encontraron Productos";
				TableModel.addRow(Datos);	
			}
			else {
				while (!ListaProd.isEmpty()) {
					Datos[y] = ListaProd.remove();		
					y++;
					if (y==4) {
						TableModel.addRow(Datos);
						y=0;
					}
				}
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
			}
		}
		
		public void LimpiarTabla() {
			int Filas = TableModel.getRowCount();
			for (int x=0;x<Filas;x++) { TableModel.removeRow(0); }
		}
		
		private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
			if (Clave == null) { Clave = new VentanaClave(this); }
			Clave.setVisible(true);
			if (Clave.ObtenerAcceso()) {
				int Baja;
				if (!jTextField16.getText().isEmpty() && jTextField9.getText().length()==15) {
					jTextField9.setText(jTextField9.getText().toUpperCase());
					String CodigoProducto = jTextField9.getText();
					Baja = Nucleo.MovProducto(CodigoProducto,jTextField10.getText());
					if (Baja == 0) { 
						if (Nucleo.AgregarMovimiento(CodigoProducto, 0, Integer.parseInt(jTextField10.getText()), jComboBox10.getSelectedIndex()+1)==0) { MostrarError("Error al Grabar Movimiento Del Producto",this); }
						jTextField16.setText("El Producto " + CodigoProducto + " Fue Actualizado");
						jTextField9.setText("");
						jTextField10.setText("");
						jButton3.setEnabled(false);
					}
					else if (Baja == 1) { MostrarError("Error al Actualizar Stock (1520)",this); }
					else if (Baja == 2) { MostrarError("La Cantidad Ingresada Es Incorrecta",this); }
				}
				else { MostrarError("Este Producto No Existe En El Stock",this); }
			}
			else { MostrarError("Contraseña Incorrecta", this); }
		}
		
		private void jComboBox2ActionPerformed(java.awt.event.ItemEvent evt) {
			if (CargaDatos == 1) {
				String TipoTalle = "";
//				jComboBox7.removeAllItems();
				String Rubro = jComboBox2.getSelectedItem().toString();
				String Marca = jComboBox8.getSelectedItem().toString();
/*				if (Marca.compareTo("Cacharel")==0 && (Rubro.compareTo("Remera")==0 || Rubro.compareTo("Pantalón")==0 || Rubro.compareTo("Polera")==0 || 
						Rubro.compareTo("Sacón")==0 || Rubro.compareTo("Saco")==0 || Rubro.compareTo("Campera")==0 || Rubro.compareTo("Piloto")==0 ||
								Rubro.compareTo("Camisa")==0 || Rubro.compareTo("Falda")==0 || Rubro.compareTo("Chaleco")==0 || 
										Rubro.compareTo("Tapado")==0 || Rubro.compareTo("Jean")==0 || Rubro.compareTo("Sweater")==0 ||
												Rubro.compareTo("Musculosa")==0)) {
					if (Rubro.compareTo("Jean")!=0) { VerificarTalles("H"); }
					else { 
						VerificarTalles("J");
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
					if (Rubro.compareTo("Pantalón")==0) {
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
				}
				else {
					if ((Marca.compareTo("Rafael Garofalo")==0 || Marca.compareTo("Importado")==0) && Rubro.compareTo("Cartera")!=0 && Rubro.compareTo("Cinto")!=0) {
						VerificarTalles("R");
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
					else {
						TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion(Rubro));
						Talle = Nucleo.BuscarTalles(TipoTalle);
						VerificarTalles(TipoTalle);
					}
				}*/
				TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion(Rubro));
				if (TipoTalle.compareTo("1")!=0) { VerificarTalles(TipoTalle,Marca); }
				else { MostrarError("Error al Cargar Talles",this); }
			}
		}
		
		private void jComboBox8ActionPerformed(java.awt.event.ItemEvent evt) {		
			if (CargaDatos == 1) {
				String TipoTalle = "";
//				jComboBox7.removeAllItems();
				String Marca = jComboBox8.getSelectedItem().toString();
				String Rubro = jComboBox2.getSelectedItem().toString();
/*				if (Marca.compareTo("Cacharel")==0 && (Rubro.compareTo("Remera")==0 || Rubro.compareTo("Pantalón")==0 || Rubro.compareTo("Polera")==0 || 
						Rubro.compareTo("Sacón")==0 || Rubro.compareTo("Saco")==0 || Rubro.compareTo("Campera")==0 || Rubro.compareTo("Piloto")==0 ||
								Rubro.compareTo("Camisa")==0 || Rubro.compareTo("Falda")==0 || Rubro.compareTo("Chaleco")==0 || 
										Rubro.compareTo("Tapado")==0 || Rubro.compareTo("Jean")==0 || Rubro.compareTo("Sweater")==0 ||
												Rubro.compareTo("Musculosa")==0)) { 
					if (Rubro.compareTo("Jean")!=0) { VerificarTalles("H"); }
					else { 
						VerificarTalles("J");
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
					if (Rubro.compareTo("Pantalón")==0) {
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
				}
				else {
					if ((Marca.compareTo("Rafael Garofalo")==0 || Marca.compareTo("Importado")==0) && Rubro.compareTo("Cartera")!=0 && Rubro.compareTo("Cinto")!=0) {
						VerificarTalles("R");
						Talle = Nucleo.BuscarTalles("P");
						for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					}
					else {
						TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion(Rubro));
						Talle = Nucleo.BuscarTalles(TipoTalle);
						VerificarTalles(TipoTalle);
					}
				}*/
				TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion(Rubro));
				if (TipoTalle.compareTo("1")!=0) { VerificarTalles(TipoTalle,Marca); }
				else { MostrarError("Error al Cargar Talles",this); }
			}
		}
		
		public void VerificarTalles(String Tipo, String Marca) {
			if (Tipo.compareTo("R")==0) { Tipo = Nucleo.BuscarTallePorMarca(Nucleo.BuscarMarcaPorDescripcion(Marca)); }
			if (Tipo.compareTo("1")!=0) { 
				Talle = Nucleo.BuscarTalles(Tipo);
				if (Talle.getLast()!="///ERROR///") {
					jComboBox7.removeAllItems();
					for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
					if (Talle.size()<2) { jComboBox7.setEnabled(false); }
					else { jComboBox7.setEnabled(true); }
					TipoTalle = Tipo;
				}
				else { MostrarError("Error al Buscar Talles Por Tipo",this); }
			}
			else { MostrarError("Error al Buscar Talle Por Marca",this); }			
		}
				
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
			CargaDatos = 0;
			TipoTalle = ""; 
        	jTextField1.setText("");
        	jTextField2.setText("");
			jTextField3.setText("1");
			jTextField4.setText("");
			jTextField5.setText("");
			jTextField6.setText("");
			jTextField7.setText("");
			jTextField8.setText("");
			jTextField9.setText("");
			jTextField10.setText("");
			jTextField16.setText("");
			jComboBox2.removeAllItems();
			jComboBox3.removeAllItems();
			jComboBox5.removeAllItems();
			jComboBox6.removeAllItems();
			jComboBox8.removeAllItems();
			jComboBox9.removeAllItems();
			jTextField3.setEditable(true);
			jButton1.setEnabled(false);
			jButton3.setEnabled(false);
	        Flag = 0;
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {}

		public void keyReleased(KeyEvent e) {
			String CodigoProducto = "";
			if (e.getComponent()==jTextField1) { CodigoProducto = jTextField1.getText(); }
			else if (e.getComponent()==jTextField9) { CodigoProducto = jTextField9.getText(); }
			String Rubro, Material, Color, Talle, Marca, Temporada, Auditor;
			LinkedList<String> Producto;			
			if (CodigoProducto.length()==15) {
				if (e.getComponent()==jTextField1) { jButton1.setEnabled(true); }
				else { jButton3.setEnabled(true); }
		    	Producto = Nucleo.BuscarProducto(CodigoProducto);
				if (Producto != null) {
					if (e.getComponent()==jTextField1) {
						jTextField2.setText(Producto.removeFirst().toString());
						jTextField8.setText(Producto.removeFirst().toString());
						Rubro = Producto.removeFirst().toString();
						Rubro = Nucleo.BuscarRubroPorCodigo(Rubro);
						jComboBox2.setSelectedItem(Object(Rubro));
						Material = Producto.removeFirst().toString();
						Material = Nucleo.BuscarMaterialPorCodigo(Material);
						jComboBox5.setSelectedItem(Object(Material));
						Color = Producto.removeFirst().toString();
						Color = Nucleo.BuscarColorPorCodigo(Color);
						jComboBox6.setSelectedItem(Object(Color));	
						Talle = Producto.removeFirst().toString();
						Talle = Nucleo.BuscarTallePorCodigo(Talle);
						Marca = Producto.removeFirst().toString();
						Marca = Nucleo.BuscarMarcaPorCodigo(Marca);
						jComboBox8.setSelectedItem(Object(Marca));
						Temporada = Producto.removeFirst().toString();
						Temporada = Nucleo.BuscarTemporadaPorCodigo(Temporada);
						jComboBox3.setSelectedItem(Object(Temporada));
						Auditor = Producto.removeFirst().toString();
						Auditor = Nucleo.BuscarAuditorPorCodigo(Auditor);
						jComboBox9.setSelectedItem(Object(Auditor));
						jComboBox7.setSelectedItem(Object(Talle));
					}
					else { 
						jTextField16.setText(Producto.removeFirst().toString());
						jButton3.setEnabled(true);
					}
				}
			}
			else {
				if (e.getComponent()==jTextField1) { 
					jButton1.setEnabled(false);
			        jTextField15.setText("");
					if (!jTextField2.getText().isEmpty()) {
						jTextField2.setText("");
//						jTextField3.setText("1");
						jTextField8.setText("");
					}
				}
				else if (e.getComponent()==jTextField9) { 
					jButton3.setEnabled(false);
					jTextField16.setText("");
				}
			}		
		}
		
		private Object Object(String Valor) {
			Object Datos = Valor;
			return Datos;
		}

		public void CargarDatos() {
//			String TipoTalle = "";
			Rubro = Nucleo.BuscarRubros();
			for (int i=0;i<Rubro.size();i++) { jComboBox2.addItem(Rubro.get(i)); }
			Material = Nucleo.BuscarMateriales();
			for (int i=0;i<Material.size();i++) { jComboBox5.addItem(Material.get(i)); }
			Color = Nucleo.BuscarColores();
			for (int i=0;i<Color.size();i++) { jComboBox6.addItem(Color.get(i)); }
			CargaDatos = 1;			
			Marca = Nucleo.BuscarMarcas();
			for (int i=0;i<Marca.size();i++) { jComboBox8.addItem(Marca.get(i)); }
	        Temporada = Nucleo.BuscarTemporadas();
			for (int i=0;i<Temporada.size();i++) { jComboBox3.addItem(Temporada.get(i)); }
			Auditor = Nucleo.BuscarAuditores();
			for (int i=0;i<Auditor.size();i++) { jComboBox9.addItem(Auditor.get(i)); }
	        Flag = 0;
	/*		TipoTalle = Nucleo.BuscarTalleRubro(Nucleo.BuscarRubroPorDescripcion((String) jComboBox2.getSelectedItem()));
			Talle = Nucleo.BuscarTalles(TipoTalle);
			for (int i=0;i<Talle.size();i++) { jComboBox7.addItem(Talle.get(i)); }
			if (Talle.size()<2) { jComboBox7.setEnabled(false); } */
		}
		
		public void CargarCodigo(String CodigoProducto, BigDecimal Precio, String Stock) { 
			if (!CodigoProducto.isEmpty()) {
			jTextField1.setText(CodigoProducto);
			jButton1.setEnabled(true);
			}
			if (Precio.toString().compareTo("0")!=0) { jTextField8.setText(Precio.toString().replace(".",",")); }
			if (Stock.compareTo("Entra")==0) { 
				jTextField3.setText("0");
				jTextField3.setEditable(false);
			} 
	        Flag = 1;
		}
	}

	/*public class VentanaMiniStock extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel4, jLabel5, jLabel6, jLabel7, jLabel12;
		private JTextField jTextField1, jTextField2, jTextField8;
		private JComboBox jComboBox2, jComboBox3;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaMiniStock(String CodigoProducto) {

	        jPanel1 = new JPanel();
	        jLabel1 = new JLabel();			 	// Código del Producto
	        jLabel2 = new JLabel();			 	// Descripción
	        jLabel4 = new JLabel();          	// Ingresar Producto al Stock
	        jLabel5 = new JLabel();          	// Precio        
	        jLabel6 = new JLabel();          	// Rubro  
	        jLabel7 = new JLabel();          	// Descripción del Producto
	        jLabel12 = new JLabel();          	// Temporada
	        jTextField1 = new JTextField(CodigoProducto);  	// Código del producto
	        jTextField2 = new JTextField();  	// Descripcion del producto
	        jTextField8 = new JTextField();  	// Precio (ingresar producto)
	        jComboBox2 = new JComboBox();  	    // Rubro (ingresar producto)
	        jComboBox3 = new JComboBox();  	    // Temporada (ingresar producto)
	        jButton1 = new JButton();			// Ingresar
	        
	        setTitle("Gestión de Stock");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        // (MODIF)
	        System.out.println("Centro X: " + getBounds().getCenterX() + "Centro Y: " + getBounds().getCenterY());
	        System.out.println("Punto X: " + getBounds().x + "Punto Y: " + getBounds().y);
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 100, 364, 288));
	        System.out.println("Centro Ventanita X: " + getBounds().getCenterX() + "Centro Ventanita Y: " + getBounds().getCenterY());
	        // (MODIF)
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Código del Producto");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Descripción");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel4.setText("Ingresar Producto al Stock");
	        
	        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel5.setText("Precio");
	        
	        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel6.setText("Rubro");
	        
	        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel7.setText("Descripción del Producto");
	        	        
	        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel12.setText("Temporada");

	        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        
	        jTextField1.addKeyListener(this);
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        	        
	        jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField8.setFont(jLabel1.getFont());
	        
	        jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Carteras", "Zapatos", "Cinturones", "Camperas", "Billeteras", "Llaveros", "Relojes", "Pulseras", "Accesorios", "Pashminas", "Guantes", "Bijouterie", "Perfumes", "Otros" }));
	        
	        jComboBox3.setModel(new DefaultComboBoxModel(new String[] { "Invierno 2009", "Verano 2009", "Invierno 2008", "Verano 2008", "Invierno 2007", "Verano 2007" }));
	        
//	        jTextField2.setText("$ 0");
//	        jTextField2.setEditable(false);
	        
	        jButton1.setText("Ingresar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)    
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)    
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    	.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                    	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))	                    	
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addGap(120, 120, 120)	
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel4))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel1)
			                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel5)
			                	.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel6)
			                	.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))			                	
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			               		.addComponent(jLabel12)
			                	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))			                	
			                .addGap(8, 8, 8)			                
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
	        
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
		        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()	
	            	.addContainerGap()
	        		.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        pack();
		}
		
		public void AgregoProducto(String CodigoProductoNuevo) { jTextField1.setText(CodigoProductoNuevo); }
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			int Cantidad, Precio;
			Cantidad = Precio = 0;
			try {
			Precio = Integer.parseInt(jTextField8.getText());
			} catch(NumberFormatException nfe) {
				jTextField1.setText("No Se Ingresaron Los Datos Correctamente Del Producto");
			}
			int Ingreso = Nucleo.IngresarProducto(jTextField1.getText(), jTextField2.getText(), Cantidad, Precio, jComboBox3.getSelectedItem().toString());
			if (Ingreso==0) {
				dispose();
				if (ErrorEnBD == null) {
					ErrorEnBD = new VentanaErrorEnBD();   	
					ErrorEnBD.setVisible(true);
					System.out.println("Ventana ErrorEnBD Size: X:" + ErrorEnBD.getWidth() + " Y:" + ErrorEnBD.getHeight());
				}
				else {
					ErrorEnBD.setLocation(getBounds().x + 332, getBounds().y + 295);
					ErrorEnBD.setVisible(true);    		
				}					
			}
			else {
				jTextField1.setText("");
	        	jTextField2.setText("");
				jTextField8.setText("");
	        	dispose();
			}
		}
		       		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
			jTextField1.setText("");
        	jTextField2.setText("");
			jTextField8.setText("");
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) {  }

		public void keyTyped(KeyEvent e) {	}

		public void keyReleased(KeyEvent e) {
			String CodigoProducto = jTextField1.getText();
			String Rubro, Temporada;
			LinkedList Producto;
			if (CodigoProducto.length()==10 || CodigoProducto.length()==15) {
		    	Producto = Nucleo.BuscarProducto(CodigoProducto);
				if (Producto != null) { 
					jTextField2.setText(Producto.removeFirst().toString());
					jTextField8.setText(Producto.removeFirst().toString());
					Rubro = Producto.removeFirst().toString();
					if (Rubro.compareTo("Carteras")==0) { jComboBox2.setSelectedIndex(0); }
					else if (Rubro.compareTo("Zapatos")==0) { jComboBox2.setSelectedIndex(1); }
					else if (Rubro.compareTo("Cinturones")==0) { jComboBox2.setSelectedIndex(2); }
					else if (Rubro.compareTo("Camperas")==0) { jComboBox2.setSelectedIndex(3); }
					else if (Rubro.compareTo("Billeteras")==0) { jComboBox2.setSelectedIndex(4); }
					else if (Rubro.compareTo("Llaveros")==0) { jComboBox2.setSelectedIndex(5); }
					else if (Rubro.compareTo("Relojes")==0) { jComboBox2.setSelectedIndex(6); }
					else if (Rubro.compareTo("Pulseras")==0) { jComboBox2.setSelectedIndex(7); }
					else if (Rubro.compareTo("Accesorios")==0) { jComboBox2.setSelectedIndex(8); }
					else if (Rubro.compareTo("Pashminas")==0) { jComboBox2.setSelectedIndex(9); }
					else if (Rubro.compareTo("Guantes")==0) { jComboBox2.setSelectedIndex(10); }
					else if (Rubro.compareTo("Bijouterie")==0) { jComboBox2.setSelectedIndex(11); }
					else if (Rubro.compareTo("Perfumes")==0) { jComboBox2.setSelectedIndex(12); }
					else if (Rubro.compareTo("Otros")==0) { jComboBox2.setSelectedIndex(13); }
					Temporada = Producto.removeFirst().toString();
					if (Temporada.compareTo("Invierno 2009")==0) { jComboBox3.setSelectedIndex(0); }
					else if (Temporada.compareTo("Verano 2009")==0) { jComboBox3.setSelectedIndex(1); }
					else if (Temporada.compareTo("Invierno 2008")==0) { jComboBox3.setSelectedIndex(2); }
					else if (Temporada.compareTo("Verano 2008")==0) { jComboBox3.setSelectedIndex(3); }
					else if (Temporada.compareTo("Invierno 2007")==0) { jComboBox3.setSelectedIndex(4); }
					else if (Temporada.compareTo("Verano 2007")==0) { jComboBox3.setSelectedIndex(5); }
				}
			}
			else if (!jTextField2.getText().isEmpty()) {
				jTextField2.setText("");
				jTextField8.setText("");
			}
		}
	}*/
	
	public class VentanaErrorEnBD extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;// jLabel2;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
//		private JTextField jTextField1;//, jTextField2;// jTextField3, jTextField4;
//		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
//		private JScrollPane jScrollPane1;
//		private int Total, CantProd;
//		public DefaultListModel SampleModel;
//		private Largo, Ancho;

		public VentanaErrorEnBD() {

			jPanel1 = new JPanel();			 
			jLabel1 = new JLabel();			 	// Código Producto
//			jLabel2 = new JLabel();			 	// Moneda
//			jLabel3 = new JLabel();          	// Precio
			/*	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora*/
//			jTextField1 = new JTextField();  	// Código del producto
//			jTextField2 = new JTextField();  	// Precio del producto
			/*	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Nro de producto a ingresar*/
			jButton1 = new JButton();

			setTitle("Aviso");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

			// (MODIF)
			System.out.println("Centro X: " + getBounds().getCenterX() + "Centro Y: " + getBounds().getCenterY());
			System.out.println("Punto X: " + getBounds().x + "Punto Y: " + getBounds().y);
			setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 239, 364, 288));
			System.out.println("Centro Ventanita X: " + getBounds().getCenterX() + "Centro Ventanita Y: " + getBounds().getCenterY());
			// (MODIF)

			jPanel1.setBorder(BorderFactory.createEtchedBorder());
			jPanel1.setName("");

			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel1.setText("Error En La Base De Datos");

			/*	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Cambio: $");

     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.setText(Nucleo.CrearSoloFecha());
	        jTextField1.setEditable(false);

	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());*/
//			jTextField2.setText("$ 0");
//			jTextField2.setEditable(false);

			jButton1.setText("OK, Y Que se le va a Hacer...");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});

			addWindowListener( new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent event) {
					CerrarVentana(event);
				}
			});

			GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1Layout.setHorizontalGroup(
					jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
									.addGroup(jPanel1Layout.createSequentialGroup()
											.addGap(GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
											.addContainerGap())               
			);
			jPanel1Layout.setVerticalGroup(
					jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(jPanel1Layout.createSequentialGroup()
									.addGap(18, 18, 18)
									.addComponent(jLabel1)
									.addGap(18, 18, 18)	
									.addComponent(jButton1)
									.addGap(18, 18, 18))
									.addContainerGap())
			);

			GroupLayout layout = new GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
			);
			layout.setVerticalGroup(
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pack();
	        setLocationRelativeTo(null);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	  	dispose();
        }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	dispose();
        }
	}
	
	public class VentanaGastos extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
		private JTextField jTextField1, jTextField2;// jTextField3, jTextField4;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
		
		public VentanaGastos() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel2 = new JLabel();			 	// Moneda
//	        jLabel3 = new JLabel();          	// Precio
/*	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora*/
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();  	// Precio del producto
/*	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Nro de producto a ingresar*/
	        jButton1 = new JButton();
	        
	        setTitle("Ingresar Gastos");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);        
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 239, 364, 288));
        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Descripción Del Gasto:");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Monto $");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        
	        jButton1.setText("Agregar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        	String Error = "";
			int Resultado;
			String Valor = jTextField2.getText().replace(",",".");
			int Contador, Flag;
			Contador = Flag = 0;
			while (Contador<Valor.length() && Flag<=1) {
				if (Valor.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || Valor.charAt(Contador)<'0' || Valor.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {				
				if (Valor.indexOf(".")==Valor.length()-3 || Valor.indexOf(".") == -1) {
					Resultado = Nucleo.AgregarGastos(jTextField1.getText(),Valor);
					Cerrar();
					if (Resultado == 1) { Error = "Cerrar Caja Abierta y Abrir Nueva Caja"; }
					else if (Resultado == 2) { Error = "Error En La Base De Datos"; }
					else if (Resultado == 3) { Error = "El Valor Supera al Efectivo Total de la Caja"; }	                	
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }				
			}
			else {
				if (Contador==0) { Error = "Ingrese El Valor Del Gasto"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" En Valor"; }
			}
	        if (!Error.isEmpty()) { MostrarError(Error,this); }
        }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	jTextField1.setText("");
        	jTextField2.setText("");
        	dispose();
        }
	}
	
	public class VentanaAccesoBD extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3;// jLabel4, jLabel5, jLabel6, jLabel7;
		private JPasswordField jPasswordField1;
		private JTextField jTextField1, jTextField2;//, jTextField4;
//		private JComboBox jComboBox1;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
        public int Flag;

		public VentanaAccesoBD() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel2 = new JLabel();			 	// Moneda
	        jLabel3 = new JLabel();          	// Local
/*	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora*/
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();
	        jPasswordField1 = new JPasswordField();
/*	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Nro de producto a ingresar*/
	        jButton1 = new JButton();
	        Flag = 0;
	        
	        setTitle("Ingresar al Sistema Fringo");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Usuario");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Clave");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Servidor");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        
     	    jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setText("Local");
	        jTextField2.addKeyListener(this);
	        
//	        jTextField1.setText("prune"); 	        // Sacar
//	        jPasswordField1.setText("prune123"); 	// Sacar
	        
	        jPasswordField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jPasswordField1.setFont(jLabel1.getFont());
	        jPasswordField1.addKeyListener(this);
	        
	        jButton1.setText("Ingresar");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });

	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jTextField1.requestFocusInWindow();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		.addGroup(jPanel1Layout.createSequentialGroup()
	    	                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	    	                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	    	                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))	                		
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel3)
				          		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				            .addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed() {
			String IP = jTextField2.getText();
			String Usuario = jTextField1.getText();
			String Password = new String(jPasswordField1.getPassword());		
			int Acceso;
			if (Usuario.compareTo("prune")!=0 && Usuario.compareTo("test")!=0) {
				MostrarError("El Nombre de Usuario es Incorrecto",this);
				Flag++;
			}
			else if (Password.compareTo("prune123")!=0 && Password.compareTo("cal31990")!=0) { 
				MostrarError("La Clave es Incorrecta",this);
				Flag++;
				}
			else {
				Acceso = Nucleo.ActivarBD(Usuario,Password,IP);
				if (Acceso == 1) { 
					MostrarError("No Se Pudo Inicializar La Base de Datos",this);
		        	Cerrar();
		        	Principal.SalgoAccesoBD();
				}
				else { 
					Cerrar();
					if (Nucleo.NegativosEnStock()) { MostrarAviso("Existen Negativos En El Stock...!!!",this); }
				}
			}
			if (Flag==3) {
				Cerrar();
	        	Principal.SalgoAccesoBD();
			}
		}
		      
        public void CerrarVentana(java.awt.event.WindowEvent event) { 
        	Cerrar();
        	Principal.SalgoAccesoBD();	
        }
        
        public void Cerrar() {
        	jTextField1.setText("");
        	jPasswordField1.setText("");
        	dispose();
        }

        public void keyTyped(KeyEvent e) {}

        public void keyPressed(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {
        	int KeyCode = e.getKeyCode();
        	String Tecla = KeyEvent.getKeyText(KeyCode);
        	if (Tecla.compareTo("Introduzca")==0) {
        		if (e.getComponent()==jTextField1) { jPasswordField1.requestFocusInWindow(); }
        		else if (e.getComponent()==jPasswordField1) { jButton1ActionPerformed(); }
        		else if (e.getComponent()==jButton1) { jButton1ActionPerformed(); }
        	}
        }
    }
	
	public class VentanaDescuento extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
//		private JPasswordField jPasswordField1;
		private JTextField jTextField1;// jTextField3, jTextField4;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
        public int Flag;
        public BigDecimal MontoPagar;
		
		public VentanaDescuento(BigDecimal Pago, JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
//	        jLabel2 = new JLabel();			 	// Moneda
//	        jLabel3 = new JLabel();          	// Precio
/*	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora*/
	        jTextField1 = new JTextField();  	// Código del producto
//	        jTextField2 = new JTextField();  	// Total de venta
//	        jTextField4 = new JTextField();  	// Nro de producto a ingresar
	        jButton1 = new JButton();
	        Flag = 0;
	        MontoPagar = Pago;
	        
	        setTitle("Atención Especial");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//	        setBounds(new java.awt.Rectangle(getBounds().x + 250, getBounds().y + 195, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Descuento $");
	        
/*	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Clave");*/
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        
//	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
//	        jTextField2.setFont(jLabel1.getFont());
	        
	        jButton1.setText("Ingresar");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
/*	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))*/
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
/*		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)*/
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() {
			int Contador, Flag;
			Contador = Flag = 0;
			String Error = "";
			String Descuento = jTextField1.getText().replace(",",".");
			while (Contador<Descuento.length() && Flag<=1) {
				if (Descuento.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || Descuento.charAt(Contador)<'0' || Descuento.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {				
				if (Descuento.indexOf(".")==Descuento.length()-3 || Descuento.indexOf(".") == -1) {
					BigDecimal Valor = new BigDecimal(Descuento);
					Valor = Valor.setScale(2, RoundingMode.HALF_UP);
					if (MontoPagar.compareTo(Valor)>=0) {
						Ventas.AgregarDescuento(Valor,MontoPagar);
						Cerrar();
					}
					else { MostrarError("El Descuento Supera el Total de Venta",this); }
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else {
				if (Contador==0) { Error = "Ingrese El Valor Del Descuento"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" En Valor"; }
			}
	        if (!Error.isEmpty()) { MostrarError(Error,this); }
		}
        
		public void CargarPago(BigDecimal Pago) { MontoPagar = Pago; }
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	jTextField1.setText("");
//        	jTextField2.setText("");
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
	}
	
	public class VentanaIntereses extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
//		private JPasswordField jPasswordField1;
		private JTextField jTextField1;// jTextField3, jTextField4;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public int Flag;
        public BigDecimal MontoPagar;
		
		public VentanaIntereses(BigDecimal Pago) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jTextField1 = new JTextField();  	// Código del producto
	        jButton1 = new JButton();
	        Flag = 0;
	        MontoPagar = Pago;
	        
	        setTitle("Interés En Pago");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        setBounds(new java.awt.Rectangle(getBounds().x + 250, getBounds().y + 195, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Interés $");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        
	        jButton1.setText("Ingresar");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
/*	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))*/
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
/*		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel2)
			                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)*/
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed() {
			int Contador, Flag;
			Contador = Flag = 0;
			String Error = "";
			String Interes = jTextField1.getText().replace(",",".");
			while (Contador<Interes.length() && Flag<=1) {
				if (Interes.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || Interes.charAt(Contador)<'0' || Interes.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {				
				if (Interes.indexOf(".")==Interes.length()-3 || Interes.indexOf(".") == -1) {
					BigDecimal Valor = new BigDecimal(Interes);
					Valor = Valor.setScale(2, RoundingMode.HALF_UP);
					Ventas.AgregarInteres(Valor,MontoPagar);
					Cerrar();
				}
				else { Error = "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else {
				if (Contador==0) { Error = "Ingrese El Valor Del Descuento"; }
				else { Error = "Ingresar Solo Números y \".\" o \",\" En Valor"; }
			}
	        if (!Error.isEmpty()) { MostrarError(Error,this); }
		}
        
		public void CargarPago(BigDecimal Pago) { MontoPagar = Pago; }
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	jTextField1.setText("");
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
        
	}
	
//	Ventana Clientes	
	
	public class VentanaClientes extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2;
		private JTextField jTextField1;
		private JComboBox jComboBox1;
		private JButton jButton1, jButton2;
		private JPanel jPanel1;
        public LinkedList<Object[]> Clientes;
        public String NombreCliente;
    	
//		private Largo, Ancho;
		
		public VentanaClientes() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();          	// Seleccionar Cliente Por Nombre
	        jLabel2 = new JLabel();          	// Seleccionar Cliente Por Nro Doc
	        jTextField1 = new JTextField();  	// Seleccionar Cliente Por Nro Doc
	        jComboBox1 = new JComboBox();		// Seleccionar Cliente Por Nombre
	        jButton1 = new JButton();			// Seleccionar Cliente
	        jButton2 = new JButton();			// Agregar Nuevo Cliente
        
	        setTitle("Buscar Cuenta De Cliente");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 218, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Por Nombre");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Por Código");
	              
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        
	        CargarClientes();
			
			jComboBox1.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) {
	            	if (evt.getStateChange()==ItemEvent.SELECTED) { jComboBox1ActionPerformed(); }	
	            }
			});
			
			jComboBox1ActionPerformed();
	        
	        jButton1.setText("Historial Cliente");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {            	
	            	jButton1ActionPerformed(evt);	            	
	            }
	        });
	        
	        jButton2.setText("Agregar Nuevo");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
//			            	.addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
//			            	.addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		            		.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	               				.addComponent(jLabel2)
			                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel1)
			                	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {				
			String CodigoCliente = jTextField1.getText();
			int Contador = 0;
			int Flag = 0;
			int Resultado = 0;
			int Codigo;
			while (Contador<CodigoCliente.length() && Flag<1) {
				if (CodigoCliente.charAt(Contador)<'0' || CodigoCliente.charAt(Contador)>'9') { Flag = 1; }
				Contador++;
			}
			if (Flag == 0 && Contador !=0) {
				Codigo = Integer.parseInt(CodigoCliente);
				if (HistorialCliente == null) { HistorialCliente = new VentanaHistorialCliente(this); }
				Resultado = HistorialCliente.CargarCliente(Codigo);
				if (Resultado==0) { HistorialCliente.setVisible(true); }
				else if (Resultado==1) { MostrarError("Número de Cliente Incorrecto",this); }
				else { MostrarError("Error Al Obtener Historial (1510)",this); }		
			}
			else if (Flag == 1) { MostrarError("El Nro De Cliente Debe Tener Números",this); }		
		}
	
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			if (AgregarCliente == null) {
				AgregarCliente = new VentanaAgregarCliente(this);
				AgregarCliente.VentanaOrigen(1);
				AgregarCliente.setVisible(true);
			}
			else {
				AgregarCliente.CargarCodigoCliente();
				AgregarCliente.VentanaOrigen(1);
				AgregarCliente.setVisible(true);  
			}
		}
        
		public void jComboBox1ActionPerformed() {
			Object[] datosCliente = new Object[2];
			if (jComboBox1.getItemCount()>0) {
				if (!jButton1.isEnabled()) { jButton1.setEnabled(true); }
				int Seleccion = jComboBox1.getSelectedIndex();
				datosCliente = Clientes.get(Seleccion);
				NombreCliente = datosCliente[0].toString();
				jTextField1.setText(datosCliente[1].toString());
			}
			else { jButton1.setEnabled(false); }
		}
		
		public void keyPressed(KeyEvent e) { }

		public void keyTyped(KeyEvent e) { }
		
		public void keyReleased(KeyEvent e) {
			String CodigoCliente = jTextField1.getText();
			if (CodigoCliente.length()>1) {
				int Contador,Flag, Codigo;
				Contador = Flag = Codigo = 0;
				while (Contador<CodigoCliente.length() && Flag<1) {
					if (CodigoCliente.charAt(Contador)<'0' || CodigoCliente.charAt(Contador)>'9') { Flag = 1; }
					Contador++;
				}
				if (Flag ==0) {
					int x = 0;
					Object[] datosCliente = new Object[2];
					Codigo = Integer.parseInt(CodigoCliente);
					while (x<Clientes.size()) {
						datosCliente = Clientes.get(x);
						if (Codigo == (Integer)datosCliente[1]) {
							NombreCliente = datosCliente[0].toString();
							jTextField1.setText(datosCliente[1].toString());
							jComboBox1.setSelectedIndex(x);
							x = Clientes.size();
						}
						else { x++; }
					}
				}
			}
		}
		
		public void CargarClientes() {
			try { 
				Nucleo.ActivarBDCuentas();
				Clientes = Nucleo.BuscarClientes();
				Nucleo.DesactivarBDCuentas();
			}
			catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
			Object[] datosCliente;			
			for (int i=0;i<Clientes.size();i++) {
				datosCliente = Clientes.get(i);
				NombreCliente = (String) datosCliente[0];
				jComboBox1.addItem(NombreCliente);
			}
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	jTextField1.setText("");
			jComboBox1.removeAllItems();
			dispose();
        }
	}

//	Ventana Agregar Cliente	
	
	public class VentanaAgregarCliente extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9, jTextField10;
		private JComboBox jComboBox1, jComboBox2;
		private JButton jButton1, jButton2;
		private JPanel jPanel1;
        public int CodigoCliente, VentanaOrigen;
		
		public VentanaAgregarCliente(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();          	// Nombre
	        jLabel2 = new JLabel();          	// Apellido
	        jLabel3 = new JLabel();          	// Domicilio
	        jLabel4 = new JLabel();          	// Teléfono
	        jLabel5 = new JLabel();          	// Tipo Responsable
	        jLabel6 = new JLabel();          	// Número de CUIT
	        jLabel7 = new JLabel();          	// Tipo Documento
	        jLabel8 = new JLabel();          	// Nro Documento
	        jLabel9 = new JLabel();          	// Codigo del Cliente
	        jLabel10 = new JLabel();          	// Correo Electrónico
	        jLabel11 = new JLabel();          	// Arroba (@)
	        jLabel12 = new JLabel();          	// Saldo Actual
	        jTextField1 = new JTextField();  	// Nombre
	        jTextField2 = new JTextField();  	// Apellido
	        jTextField3 = new JTextField();  	// Domicilio
	        jTextField4 = new JTextField();  	// Telefono
	        jTextField5 = new JTextField();  	// Numero CUIT
	        jTextField6 = new JTextField();  	// Nro Documento
	        jTextField7 = new JTextField();  	// Codigo del Cliente
	        jTextField8 = new JTextField();  	// Usuario del Correo
	        jTextField9 = new JTextField();  	// Servidor del Correo
	        jTextField10 = new JTextField();  	// Saldo del Cliente
	        jComboBox1 = new JComboBox();		// Tipo Responsable
	        jComboBox2 = new JComboBox();		// Tipo Documento
	        jButton1 = new JButton();			// Agregar
	        jButton2 = new JButton();			// Cancelar
        
	        setTitle("Agregar Cliente");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Nombre");        
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Apellido");
	        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel3.setText("Domicilio");        
	        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel4.setText("Teléfono");
	        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel5.setText("Tipo Responsable");        
	        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel6.setText("Número de CUIT");
	        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel7.setText("Tipo Documento");        
	        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel8.setText("Nro Documento");
	        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel9.setText("Codigo del Cliente");
	        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel10.setText("Correo Electrónico");
	        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel11.setText("@");
	        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel12.setText("Saldo Actual");
	        
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
     	    jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
     	    jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(jLabel1.getFont());
     	    jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField4.setFont(jLabel1.getFont());
     	    jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField5.setFont(jLabel1.getFont());
     	    jTextField6.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField6.setFont(jLabel1.getFont());
     	    jTextField7.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField7.setFont(jLabel1.getFont());
     	    jTextField8.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField8.setFont(jLabel1.getFont());
     	    jTextField9.setHorizontalAlignment(SwingConstants.CENTER);     	    
	        jTextField9.setFont(jLabel1.getFont());
     	    jTextField10.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField10.setFont(jLabel1.getFont());
	        jTextField10.setText("0");
	        
			jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Monotributo", "Resp. Inscripto" }));
			jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "DNI", "LE", "CI" }));

			try {
				Nucleo.ActivarBDCuentas();
				CodigoCliente = Nucleo.BuscarCodigoCliente();
	        	if (CodigoCliente == 0) { CodigoCliente = 10; }
	        	else { CodigoCliente += 5; }
				jTextField7.setText(Integer.toString(CodigoCliente));
				jTextField7.setEditable(false);
				Nucleo.DesactivarBDCuentas();
			} catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
	        
//			Clientes = Nucleo.BuscarClientes();
//			for (int i=0;i<Clientes.size();i++) { jComboBox1.addItem(Clientes.get(i)); }
	        
	        jButton1.setText("Agregar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton2.setText("Cancelar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	    	                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    	                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	    	                .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))	                        
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
		            		.addGap(GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel2)
		                		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)			               		
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel10)
		                		.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		                		.addComponent(jLabel11)
		                		.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)			               		
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel3)
		                		.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		                	.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel4)
		                		.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)			                	
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel5)
		                		.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel6)
		                		.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel7)
		                		.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel8)
		                		.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)			               		
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel9)
			                	.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)			               		
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jLabel12)
			                	.addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))				               
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	        BigDecimal Saldo = null;
        	if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()) {
    			String NroCuit = jTextField5.getText();
    			String NroDoc = jTextField6.getText();
    			int Contador, Flag, Flag1, Cuit, Doc;
    			Contador = Flag = Flag1 = Cuit = Doc = 0;
    			if (NroCuit.length()<=11) {
        			while (Contador<NroCuit.length() && Flag<1) {
        				if (NroCuit.charAt(Contador)<'0' || NroCuit.charAt(Contador)>'9') { Flag = 1; }
        				Contador++;
        			}
        			if (Flag == 0 && Contador !=0) { Cuit = Integer.parseInt(NroCuit); }
        			else if (Flag == 1) { MostrarError("El Nro De CUIT Debe Tener Números",this); }    				
    			}
    			else {
    				MostrarError("El Nro De CUIT Debe Ser Más Corto",this);
    				Flag = 1;
    			}
    			if (Flag == 0) {
        			Contador = 0;
        			if (NroDoc.length()<=8) {
            			while (Contador<NroDoc.length() && Flag1<1) {
            				if (NroDoc.charAt(Contador)<'0' || NroDoc.charAt(Contador)>'9') { Flag1 = 1; }
            				Contador++;
            			}
            			if (Flag1 == 0 && Contador !=0) { Doc = Integer.parseInt(NroDoc); }  
            			else if (Flag1 == 1) { MostrarError("El Nro De Doc. Debe Tener Números",this); }        				
        			}
        			else {
        				MostrarError("El Nro De Doc. Debe Ser Más Corto",this);
        				Flag1 = 1;
        			}
        			Contador = 0;
        			int FlagIngreso = 0;
        			String SaldoIngresado = jTextField10.getText().replace(",",".");
        			while (Contador<SaldoIngresado.length() && FlagIngreso<=1) {
        				if (SaldoIngresado.charAt(Contador)=='.') { FlagIngreso++; }
        				else if (FlagIngreso>1 || SaldoIngresado.charAt(Contador)<'0' || SaldoIngresado.charAt(Contador)>'9') { FlagIngreso = 2; }
        				Contador++;
        			}
        			if (FlagIngreso<=1 && Contador>0) {
        				if (SaldoIngresado.indexOf(".")==SaldoIngresado.length()-3 || SaldoIngresado.indexOf(".") == -1) {
        			        Saldo = new BigDecimal(SaldoIngresado);
        			        Saldo = Saldo.setScale(2, RoundingMode.HALF_UP);
        				}
        				else { 
        					MostrarError("La Cantidad de Decimales Son 2 Unidades",this);
        					Flag1 = 1;
        				}
        			}
        			else {
        				if (Contador==0) { MostrarError("Ingrese el Saldo Actual Del Cliente",this); }
        				else { MostrarError("Ingresar Solo Números y \".\" o \",\" para Dec.",this); }
    					Flag1 = 1;
       				}
        			if (Flag1 == 0) {
        				int Resultado = 0;
        				try {
            				Nucleo.ActivarBDCuentas();
            				Resultado = Nucleo.CargarCliente(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),
            							jComboBox1.getSelectedItem().toString(),Cuit,jComboBox2.getSelectedItem().toString(),Doc,CodigoCliente,
            									jTextField8.getText(),jTextField9.getText(),Saldo);
            				Nucleo.DesactivarBDCuentas();
        				} catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
    					Cerrar(Resultado);
        				if (Resultado == 1) { MostrarError("Error - Cargar Los Datos Nuevamente",this); }
        			}      				
    			}
        	}
        	else { MostrarError("Ingrese Nombre y Apellido Del Cliente",this); }
		}
	
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { Cerrar(1); }
		
		public void Cerrar(int Resultado) {
        	jTextField1.setText("");
        	jTextField2.setText("");
        	jTextField3.setText("");
        	jTextField4.setText("");
        	jTextField5.setText("");
        	jTextField6.setText("");
        	jTextField7.setText("");
        	jTextField8.setText("");
        	jTextField9.setText("");
        	jTextField10.setText("0");
        	jComboBox1.setSelectedIndex(1);
        	jComboBox2.setSelectedIndex(1);
        	if (Resultado == 0) { 
        		if (VentanaOrigen==1) {
        			try {
        				Nucleo.ActivarBDCuentas();
        				Clientes.CargarClientes();
        				Clientes.jTextField1.setText(Integer.toString(CodigoCliente));
        				String Nombre = Nucleo.BuscarClientePorCodigo(CodigoCliente);
        				if (Nombre.compareTo("///ERROR///")!=0) { Clientes.jComboBox1.setSelectedItem(Nombre); }
        				else { MostrarError("Error En Acceso a Base De Datos",this); }
        				Nucleo.DesactivarBDCuentas();
    				} catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
        		}
        		else {
        			try {
        				Nucleo.ActivarBDCuentas();
        				IngresoCliente.CargarClientes();
        				IngresoCliente.jTextField1.setText(Integer.toString(CodigoCliente));
        				String Nombre = Nucleo.BuscarClientePorCodigo(CodigoCliente);
        				if (Nombre.compareTo("///ERROR///")!=0) { IngresoCliente.jComboBox1.setSelectedItem(Nombre); }
        				else { MostrarError("Error En Acceso a Base De Datos",this); }
        				Nucleo.DesactivarBDCuentas();
    				} catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
        		}
        	}
        	dispose();
		}
			
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(1); }
        
        public void VentanaOrigen(int Tipo) { VentanaOrigen = Tipo; }
        
        public void CargarCodigoCliente() { 
        	CodigoCliente = Nucleo.BuscarCodigoCliente();
        	if (CodigoCliente == 0) { CodigoCliente = 10; }
        	else { CodigoCliente += 5; }
        	jTextField7.setText(Integer.toString(CodigoCliente));
        }
	}
		
	public class VentanaAyuda extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
		private JButton jButton1;
		private JPanel jPanel1;
		
		public VentanaAyuda(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();
	        jLabel2 = new JLabel();
	        jLabel3 = new JLabel();
	        jLabel4 = new JLabel();
	        jLabel5 = new JLabel();
	        jLabel6 = new JLabel();
	        jButton1 = new JButton();
	        
	        setTitle("Ayuda");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

//	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 170, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");

	        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel1.setText("  F4 - Agregar Cliente");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel2.setText("  F5 - Agregar Descuento");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel3.setText("  F6 - Agregar Interés Por Tarjeta");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel4.setText("  F7 - Ingresar Productos Especiales");
	        
	        jLabel5.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel5.setText("  F8 - Borrar Un Producto De La Lista");
	        
	        jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
	        jLabel6.setText("  F9 - Cargar Venta Señada");
	        
	        jButton1.setText("Gracias");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
                		.addGap(5, 5, 5)
                		.addComponent(jLabel2)
                		.addGap(5, 5, 5)
                		.addComponent(jLabel3)
                		.addGap(5, 5, 5)
                		.addComponent(jLabel4)
                		.addGap(5, 5, 5)
                		.addComponent(jLabel5)
                		.addGap(5, 5, 5)
                		.addComponent(jLabel6)                		
	               		.addGap(18, 18, 18)	
		                .addComponent(jButton1)
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() { dispose(); }
        
        public void CerrarVentana(java.awt.event.WindowEvent event) { dispose(); }

		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
        
	}
	
	public class VentanaIngresoCliente extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2;
		private JTextField jTextField1;
		private JComboBox jComboBox1;
		private JButton jButton1,jButton2;
		private JPanel jPanel1;
        public LinkedList<Object[]> Clientes;
        public String NombreCliente;
//		private Largo, Ancho;
		
		public VentanaIngresoCliente(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();          	// Seleccionar Cliente Por Nombre
	        jLabel2 = new JLabel();          	// Seleccionar Cliente Por Nro Doc
	        jTextField1 = new JTextField();  	// Seleccionar Cliente Por Nro Doc
	        jComboBox1 = new JComboBox();		// Seleccionar Cliente Por Nombre
	        jButton1 = new JButton();			// Ingresar Cliente
	        jButton2 = new JButton();			// Ingresar Nuevo Cliente

        
	        setTitle("Ingreso Cliente a La Venta");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//	        setBounds(new java.awt.Rectangle(Ventas.getBounds().x + 182, Ventas.getBounds().y + 144, 364, 288));
//	        setLocation(Ventas.getLocation());
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Por Nombre");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Por Código");
	              
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        
	        CargarClientes();
			
			jComboBox1.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) {
	            	if (evt.getStateChange()==ItemEvent.SELECTED) { jComboBox1ActionPerformed(); }	
	            }
			});
			
			jComboBox1ActionPerformed();
	        
	        jButton1.setText("Ingresar Cliente");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton2.setText("Agregar Nuevo"); 
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	               
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
//			            	.addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
//			            	.addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		            		.addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	               				.addComponent(jLabel2)
			                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jLabel1)
			                	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			String CodigoCliente = jTextField1.getText();
			int Contador = 0;
			int Flag = 0;
			int Codigo;
			BigDecimal Saldo;
			while (Contador<CodigoCliente.length() && Flag<1) {
				if (CodigoCliente.charAt(Contador)<'0' || CodigoCliente.charAt(Contador)>'9') { Flag = 1; }
				Contador++;
			}
			if (Flag == 0 && Contador !=0) {
				try { 
					Nucleo.ActivarBDCuentas();
					Codigo = Integer.parseInt(CodigoCliente);
					Saldo = Nucleo.ObtenerSaldoCliente(Codigo);
					if (Saldo!=null) {
						Ventas.SaldoCliente = Saldo;
			        	Ventas.CodigoCliente = Codigo;   	
			        	Ventas.jTextField8.setText(jComboBox1.getSelectedItem().toString() + " - Saldo $" + Saldo.toString().replace(".",","));
						jTextField1.setText("");
						dispose();
					}
					else { MostrarError("El Nro De Cliente Es Incorrecto",this); }
					Nucleo.DesactivarBDCuentas();
				}
				catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
			}
			else if (Flag == 1) { MostrarError("El Nro De Cliente Debe Tener Números",this); }
		}
		
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {					
			if (AgregarCliente == null) {
				AgregarCliente = new VentanaAgregarCliente(this);   
				AgregarCliente.VentanaOrigen(2);
				AgregarCliente.setVisible(true);
			}
			else {
				AgregarCliente.CargarCodigoCliente();
				AgregarCliente.VentanaOrigen(2);
				AgregarCliente.setVisible(true);  
			}
		}
	      
		private void jComboBox1ActionPerformed() {
			Object[] datosCliente = new Object[2];
			if (jComboBox1.getItemCount()>0) {
				if (!jButton1.isEnabled()) { jButton1.setEnabled(true); }
				int Seleccion = jComboBox1.getSelectedIndex();
				datosCliente = Clientes.get(Seleccion);
				NombreCliente = datosCliente[0].toString();
				jTextField1.setText(datosCliente[1].toString());
			}
			else { jButton1.setEnabled(false); }
		}
		
		public void keyPressed(KeyEvent e) { }

		public void keyTyped(KeyEvent e) { }
		
		public void keyReleased(KeyEvent e) {
			String CodigoCliente = jTextField1.getText();
			String Nombre;
			if (CodigoCliente.length()>1) {
				int Contador,Codigo,Flag;
				Contador = Codigo = Flag = 0;
				while (Contador<CodigoCliente.length() && Flag<1) {
					if (CodigoCliente.charAt(Contador)<'0' || CodigoCliente.charAt(Contador)>'9') { Flag = 1; }
					Contador++;
				}
				if (Flag ==0) {
					Codigo = Integer.parseInt(CodigoCliente);
					Nombre = Nucleo.BuscarClientePorCodigo(Codigo);
					if (Nombre.compareTo("///ERROR///")!=0) { jComboBox1.setSelectedItem(Nombre); }
					else { MostrarError("Error En Acceso a Base De Datos",this); }
				}
			}
		}
		
		public void CargarClientes() {
			try { Nucleo.ActivarBDCuentas(); }
			catch (Exception ex) { MostrarExcepcion(ex.getMessage(),this); }
			Object[] datosCliente;
			Clientes = Nucleo.BuscarClientes();
			jComboBox1.removeAllItems();
			for (int i=0;i<Clientes.size();i++) {
				datosCliente = Clientes.get(i);
				NombreCliente = (String) datosCliente[0];
				jComboBox1.addItem(NombreCliente);
			}
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	jTextField1.setText("");
			try { Nucleo.DesactivarBDCuentas(); }
			catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this); }
        	Ventas.jComboBox1.setSelectedIndex(0);
        	dispose();
        }
	}
	
	public class VentanaConfirmar extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JButton jButton1,jButton2;
		private JPanel jPanel1;
		private int VentanaPrincipal;
		
		public VentanaConfirmar(String Texto, JDialog VentanaMadre, int Flag) { 
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	
	        jButton1 = new JButton();
	        jButton2 = new JButton();
	        
	        VentanaPrincipal = Flag; // 1 = Ventana Ventas - 2 = Ventana Cerrar Caja
	        
	        setTitle("Confirmación");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText(Texto);
	        
	        jButton1.setText("Si");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        jButton2.setText("No");
	        jButton2.addKeyListener(this);
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana();
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
    	               	.addGap(18, 18, 18)
                		.addComponent(jLabel1)
	               		.addGap(18, 18, 18)
	               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	               				.addComponent(jButton1)
	               				.addComponent(jButton2))
	               		.addGap(18, 18, 18))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
				
		private void jButton1ActionPerformed() {
			if (VentanaPrincipal == 1) { Ventas.Aceptar = true; }
			else { CerrarCaja.Aceptar = true; }
    	  	dispose();
        }

		private void jButton2ActionPerformed() { CerrarVentana(); }
        
        public void CerrarVentana() {
    		if (VentanaPrincipal == 1) { Ventas.Aceptar = false; }
			else { CerrarCaja.Aceptar = false; }
        	dispose();
        }
        
        public void CargarVentana(String Texto, int Flag) { 
        	jLabel1.setText(Texto);
        	VentanaPrincipal = Flag;
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) {
				if (e.getComponent()==jButton1) { jButton1ActionPerformed(); }
				else if (e.getComponent()==jButton2) { jButton2ActionPerformed(); }
			}
		}

		public void keyTyped(KeyEvent e) { }
	}
	
	public class VentanaHistorialCliente extends JDialog {

		private static final long serialVersionUID = 1L;

		private JScrollPane jScrollPane1;
//      private DefaultListModel SampleModel;
		private DefaultTableModel TableModel;
		private JButton jButton1;
		private JPanel jPanel1;
//		private JList jList1;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5;
		private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
		private JTable jTable1;
		
		public VentanaHistorialCliente(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
//	        SampleModel = new DefaultListModel();
	        jButton1 = new JButton();
	        jTable1 = new JTable();
//	        jList1 = new JList();
	        jTextField1 = new JTextField();
	        jTextField2 = new JTextField();
	        jTextField3 = new JTextField(); // Saldo en Calcuer
	        jTextField4 = new JTextField(); // Saldo en BC
	        jTextField5 = new JTextField(); // Saldo en Prune
	        jLabel1 = new JLabel();
	        jLabel2 = new JLabel(); // Saldo en Calcuer
	        jLabel3 = new JLabel(); // Saldo en BC
	        jLabel4 = new JLabel(); // Saldo en Prune
	        
	        setTitle("Historial del Cliente");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        Font FuenteGrande = new Font("TimesRoman", Font.BOLD, 30);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Saldo Total");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Saldo En Calcuer");
	        
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Saldo En BC Bags");
	        
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("Saldo En Prune");
	        
	        ArmadoTabla();
	        
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(FuenteGrande);
	        jTextField1.setEditable(false);
	        
     	    jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setEditable(false);
	        
     	    jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(FuenteGrande);
	        jTextField3.setEditable(false);
	        
     	    jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField4.setFont(FuenteGrande);
	        jTextField4.setEditable(false);
	        
     	    jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField5.setFont(FuenteGrande);
	        jTextField5.setEditable(false);
	               
	        jButton1.setText("Volver");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 1039, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        	.addGap(GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(470, 470, 470)
                        	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)                       
                        	))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
                		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                		.addGap(11, 11, 11)
                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
	               		.addGap(11, 11, 11)
	               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	               			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
	               		.addGap(11, 11, 11)
	               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	               			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
		
		private void ArmadoTabla() {
//	        TableModel.setRowCount(30);
	        TableModel.addColumn("Fecha");
	        TableModel.addColumn("Hora");
	        TableModel.addColumn("Vta");
	        TableModel.addColumn("Productos");
	        TableModel.addColumn("Efectivo");
	        TableModel.addColumn("Tarjeta");
	        TableModel.addColumn("A Cuenta");
	        TableModel.addColumn("Otro Pago");
	        TableModel.addColumn("Dcto Venta");
	        TableModel.addColumn("Interés");
	        TableModel.addColumn("Vendedora");
	        TableModel.addColumn("Debe");
	        TableModel.addColumn("Haber");
	        TableModel.addColumn("Saldo");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
//			tcr.setSize(15,15);
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(90);
			column.setResizable(false);
//			DefaultTableCellRenderer tcs = column.get
//			tcs.setFont(jLabel1.getFont());
//			tcs.setHorizontalAlignment(SwingConstants.CENTER);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(80);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(25);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(3);
			column.setPreferredWidth(275);
			column.setResizable(false);
			column = jTable1.getColumnModel().getColumn(4);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(5);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(6);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(7);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(8);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(9);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(10);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(11);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(12);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(13);
			column.setPreferredWidth(90);
			column.setResizable(false);
			column.setCellRenderer(tcr);			
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
			LimpiarTabla();
			dispose();
		}
		
		public int CargarCliente(int CodigoCliente) {
			int y;
			int flag = 0;
			y = 0;
			String[] Datos = new String[14];
			String Temp = "";
			LinkedList<String> Historial = null;
			LinkedList<String> Productos = new LinkedList<String>();
			try {
				Nucleo.ActivarBDCuentas();
				Historial = Nucleo.BuscarHistorialCliente(CodigoCliente);
				Nucleo.DesactivarBDCuentas();
			}
			catch (SQLException sqle) { MostrarExcepcion(sqle.toString(),this);	}
			if (Historial.getLast().compareTo("///ERR12///")==0) { return 1; }
			else if (Historial.getLast().compareTo("///ERR15///")==0) { return 2; }
			else { 
				jTextField2.setText(Historial.remove());
				if (Historial.size()!=2) {
					while (Historial.size()>4) {
						Temp = Historial.remove();
						if (Temp.compareTo("----------")!=0) { 
							if (flag<2) {
								Datos[y] = Temp;
								y++;
								if (flag==1) { flag++; }
							}
							else { Productos.add(Temp); }
						}
						else if (flag<2) { flag++; }
						else { flag = 0; }
						if (y>13) { 
							y = 0;
							TableModel.addRow(Datos);
							while (!Productos.isEmpty()) {
								String[] DatosTemp = new String[14];
								DatosTemp[3] = Productos.removeFirst();
								TableModel.addRow(DatosTemp);
							}
						}
					}
				}
				else { jTextField2.setText(jTextField2.getText() + " - " + Historial.remove()); }
				jTextField1.setText(Historial.remove());
				jTextField3.setText(Historial.remove());
				jTextField4.setText(Historial.remove());
				jTextField5.setText(Historial.remove());
			}
			return 0;
		}
        
		public void LimpiarTabla() {
			if (TableModel!=null) {
				int Filas = TableModel.getRowCount();
				for (int x=0;x<Filas;x++) { TableModel.removeRow(0); }		
			}
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
			LimpiarTabla();
        	dispose();
        }       
	}
	
	public class VentanaPedidos extends JDialog {

		private static final long serialVersionUID = 1L;

		private JScrollPane jScrollPane1;
        private DefaultListModel SampleModel;
		private JButton jButton1, jButton2, jButton3;
		private JPanel jPanel1;
		private JList jList1;
		private JTextField jTextField1;
		private JLabel jLabel1;
		
		public VentanaPedidos() {
	
	        jPanel1 = new JPanel();			 
	        jScrollPane1 = new JScrollPane();
	        SampleModel = new DefaultListModel();
	        jButton1 = new JButton();
	        jButton2 = new JButton();
	        jButton3 = new JButton();
	        jList1 = new JList();
	        jTextField1 = new JTextField();
	        jLabel1 = new JLabel();
	        
	        setTitle("Pedidos de Clientes");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 170, 364, 288));
	        
	        Font FuenteGrande = new Font("TimesRoman", Font.BOLD, 30);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Saldo Actual");
	        
			jScrollPane1.setViewportView(jList1);
	        jList1.setModel(SampleModel);
	        
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(FuenteGrande);
	        jTextField1.setEditable(false);
	               
	        jButton1.setText("Agregar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton2.setText("Borrar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        jButton3.setText("Salir");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGap(GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        	.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        	))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
                	.addGroup(jPanel1Layout.createSequentialGroup()
                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
	               		.addGap(11, 11, 11)
	               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	               			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(null);
		}
				
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
//	        SampleModel.removeAllElements();
			dispose();
		}
		
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
//	        SampleModel.removeAllElements();
			dispose();
		}
		
		private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { Cerrar(); }
		
		public void CargarPedidos() {
/*			LinkedList<String> Historial;
			Historial = Nucleo.BuscarHistorialCliente(CodigoCliente);
			if (Historial.getLast().compareTo("///ERR12///")==0) { return 1; }
			else if (Historial.getLast().compareTo("///ERR15///")==0) { return 2; }
			else { 
				while (Historial.size()>1) { SampleModel.addElement(Historial.remove()); }
				jTextField1.setText(Historial.remove());
			}
			return 0;*/
		}
        
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
	        SampleModel.removeAllElements();       	
        	dispose();
        }       
	}
	
	// Ventana Ingresar Seña
	
	public class VentanaIngresarSeña extends JDialog {

		private static final long serialVersionUID = 1L;
		private JLabel jLabel1;
		private JScrollPane jScrollPane1;
        private DefaultListModel SampleModel;       
        private JComboBox jComboBox1;
		private JButton jButton1;
		private JPanel jPanel1;
		private JList jList1;
		public LinkedList<String> Señas, Productos;
		public Object[] Datos;
		public int NroSeña;
		String NumeroSeña;
		
		public VentanaIngresarSeña(JDialog VentanaMadre) {

	        jPanel1 = new JPanel();
	        jLabel1 = new JLabel();			 		// Número de Seña
	        jScrollPane1 = new JScrollPane();
	        jComboBox1 = new JComboBox();			// Nro Seña
	        SampleModel = new DefaultListModel();
	        jList1 = new JList();
	        jButton1 = new JButton();

			jComboBox1.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) {
	            	if (evt.getStateChange()==ItemEvent.SELECTED) { jComboBox1ActionPerformed(); }	
	            }
			});
	        
	        setTitle("Señas");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
			jScrollPane1.setViewportView(jList1);
	        jList1.setModel(SampleModel);
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Número de Seña");       

	        jButton1.setText("Cargar Seña");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton1ActionPerformed(); }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana();
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))	                        
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    		            	.addComponent(jLabel1)
	    			           	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	                		
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))		               		
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
	        AbrirVentana();
		}

//		Agregar la Seña en la Venta.		
		
		private void jButton1ActionPerformed() {
			
			String Prueba;
			BigDecimal Monto;
			
			Monto = new BigDecimal((Double)Datos[3]);
			Monto = Monto.setScale(2, RoundingMode.HALF_UP);
			Prueba = Ventas.jTextField4.getText() + ") " + SampleModel.get(0).toString() + " -";
			CDatos Datos = new CDatos();
			Datos.SetearCodigoProducto(SampleModel.get(0).toString());
			Datos.SetearPrecio(Monto);
			Datos.SetearProdNro(Integer.parseInt(Ventas.jTextField4.getText()));
			Datos.SetearStock("Sale");
			Datos.SetearCargadoStock("N");
			Prueba += " $" + Monto.toString().replace(".", ",");
			//					Ventas.Productos.add(SampleModel.get(0).toString());
			ColaDatos.Agregar(Datos);
			Ventas.ProdVendidos++;
			Ventas.CantProd++;
			Ventas.SampleModel1.addElement(Prueba);
			Ventas.Total = Ventas.Total.subtract(Monto);
			Ventas.jTextField4.setText(Integer.toString(Ventas.CantProd + 1));
			Ventas.jTextField3.setText("$ " + Ventas.Total.toString().replace(".", ","));
			Ventas.jTextField5.setText(Ventas.Total.toString().replace(".", ","));
			Ventas.jTextField1.setText("");
			Ventas.jTextField1.requestFocusInWindow();
			Ventas.NroSeña = NroSeña;
			Ventas.VentaSeñada = true;
			CerrarVentana();
			
		}
		
		private void jComboBox1ActionPerformed() {
			String Fecha = "";
			BigDecimal Monto;
        	SampleModel.removeAllElements();
			NroSeña = Integer.parseInt(jComboBox1.getSelectedItem().toString());
			Datos = Nucleo.BuscarDatosSeña(NroSeña);
			if (Datos!=null) {
				Fecha = Datos[1].toString();
				Fecha = Fecha.substring(6,8) + "/" + Fecha.substring(4,6) + "/" + Fecha.substring(0,4);
				SampleModel.addElement("Seña Realizada el " + Fecha);
				Monto = new BigDecimal((Double)Datos[3]);
				Monto = Monto.setScale(2, RoundingMode.HALF_UP);
 				SampleModel.addElement("Monto Señado $" + Monto);
			}
		}
        
        public void CerrarVentana() {
	        jComboBox1.removeAllItems();
        	SampleModel.removeAllElements();
        	dispose();
        }
        
 		public void AbrirVentana() { 	        
 			Señas = Nucleo.BuscarNrosSeñas();
 			for (int i=0;i<Señas.size();i++) {
 				NumeroSeña = Señas.get(i);
 				jComboBox1.addItem(NumeroSeña);
 			}
		}
	}
	
	public class VentanaIngresoRubro extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1, jLabel2;// jLabel4, jLabel5, jLabel6, jLabel7;
		private JTextField jTextField1;//, jTextField4;
		private JComboBox jComboBox1;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
        public int Flag;

		public VentanaIngresoRubro(JDialog VentanaMadre) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jLabel2 = new JLabel();			 	// Moneda
/*	        jLabel4 = new JLabel();          	// Método de Pago
	        jLabel5 = new JLabel();          	// Total
	        jLabel6 = new JLabel();          	// Nro
	        jLabel7 = new JLabel();          	// Vendedora*/
	        jTextField1 = new JTextField();  	// Código del producto
	        jComboBox1 = new JComboBox();
/*	        jTextField3 = new JTextField();  	// Total de venta
	        jTextField4 = new JTextField();  	// Nro de producto a ingresar*/
	        jButton1 = new JButton();
	        Flag = 0;
	        
	        setTitle("Agregar Rubro");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        CargarTiposTalles();
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Nombre Del Rubro");
	        
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Tipo De Talle");
	           
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	               
	        jButton1.setText("Ingresar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	               
	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jTextField1.requestFocusInWindow();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		.addGroup(jPanel1Layout.createSequentialGroup()
	    	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	    	                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	    	                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))	                		
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
				          		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				            .addGap(8, 8, 8)
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel2)
		                		.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
	
		private void CargarTiposTalles() {
			LinkedList<String> Tipos;
			Tipos = Nucleo.BuscarTiposTalles();
	        for (int i=0;i<Tipos.size();i++) { jComboBox1.addItem(Tipos.get(i)); }
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { Cerrar(); }
		      
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	jTextField1.setText("");
//        	jTextField2.setText("");
        	dispose();
        } 
	}
	
	public class VentanaIngresoOpciones extends JDialog {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JTextField jTextField1;//, jTextField4;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
        public int Flag;
        public String Opcion;

		public VentanaIngresoOpciones(JDialog VentanaMadre, String Valor) {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jTextField1 = new JTextField();  	// Código del producto
	        jButton1 = new JButton();
	        Flag = 0;
	        Opcion = Valor;
	        
	        setTitle("Agregar " + Opcion);
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Nombre " + Opcion);
	                   
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	               
	        jButton1.setText("Ingresar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	               
	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jTextField1.requestFocusInWindow();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		.addGroup(jPanel1Layout.createSequentialGroup()
	    	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	    	                .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	    	                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))	                		
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
				          		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { Cerrar(); }
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	jTextField1.setText("");
        	dispose();
        } 
	}
	
//	Ventana Importar Stock Presea	
	
	public class VentanaImportarStock extends JDialog {

		private static final long serialVersionUID = 1L;

		private JTextField jTextField1;
		private JButton jButton1;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
		
		public VentanaImportarStock() {

	        jPanel1 = new JPanel();
	        jTextField1 = new JTextField();  	// Datos Donde Ubicar Archivos
	        jButton1 = new JButton();
	        
	        setTitle("Importar Stock Presea");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setEditable(false);
	        jTextField1.setText("Ubicar Archivo \"Stock.XLS\" en el C:\\");
	        
	        jButton1.setText("Importar Archivo XLS");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
            ArmadoLayout();
	        ArmadoPanel();
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void ArmadoLayout() {
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)	                		
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		               		.addGap(8, 8, 8)	
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
		}
		
		private void ArmadoPanel() {
			GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			int Fila = 1;
			int Columna = 0;
			String Detalle;
			BigDecimal precio;
			int cantidad;
			try {
				Workbook workbook = Workbook.getWorkbook(new File("C:\\Stock.xls"));
				Sheet sheet = workbook.getSheet(0);
				Cell Celda = sheet.getCell(Columna,Fila);
				String CodigoProducto = Celda.getContents();
				Nucleo.SetearStock();
				while (!CodigoProducto.isEmpty()) {
					Celda = sheet.getCell(3,Fila);
					precio = new BigDecimal(Celda.getContents());
					precio = precio.setScale(2, RoundingMode.HALF_UP);
					Celda = sheet.getCell(4,Fila);
					cantidad = Integer.parseInt(Celda.getContents());
					if (Nucleo.VerificarCodigo(CodigoProducto)) { Nucleo.ActualizarProducto(CodigoProducto, precio, cantidad); }
					else {
						Celda = sheet.getCell(1,Fila);
						Detalle = Celda.getContents();
						Nucleo.IngresarProducto(CodigoProducto, Detalle, precio, cantidad);
					}
					Fila++;
					Columna = 0;
					Celda = sheet.getCell(Columna,Fila);
					CodigoProducto = Celda.getContents();
				}
				workbook.close();
				Fila--;
				jTextField1.setText(Fila + " Productos Importados Con Éxito");
			} catch (Exception Error) {
				Error.printStackTrace();
				Fila--;
				jTextField1.setText(Fila + " Productos Importados Con Éxito");
				MostrarError("Error al Importar Datos a Excel",this);
			}
		}
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
	        jTextField1.setText("Ubicar Archivo \"Stock.XLS\" en el C:\\");
        	dispose();
        }        
	}
//	Ventana Remitos	
	
	public class VentanaRemitos extends JDialog {

		private static final long serialVersionUID = 1L;

		private JTextField jTextField1;
		private JButton jButton1, jButton2;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		private JLabel jLabel1;
		LinkedList<File> Archivos;
		
		public VentanaRemitos() {

	        jPanel1 = new JPanel();
	        jTextField1 = new JTextField();  	// Datos Donde Ubicar Archivos
	        jButton1 = new JButton();			// Cargar Remitos
	        jButton2 = new JButton(); 			// Buscar Archivos
	        jTable1 = new JTable();
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jLabel1 = new JLabel();
	        Archivos = new LinkedList<File>();
	        
	        setTitle("Cargar Remitos");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setEditable(false);
	        jTextField1.setText("");
	        
	        jButton1.setText("Cargar Remitos");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton2.setText("Buscar Archivos");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        ArmadoTabla();
	        ArmadoLayout();
	        ArmadoPanel();
	        pack();
	        setLocationRelativeTo(null);
		}
		
	    private void ArmadoTabla() {
	        TableModel.addColumn("Nombre Archivo");
	        TableModel.addColumn("Líneas Remito");
	        TableModel.addColumn("Estado");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(145);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(95);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(60);
			column.setResizable(false);
			column.setCellRenderer(tcr);
	    }
		
		private void ArmadoLayout() {
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	            		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
		               		.addGap(8, 8, 8)
			                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			                .addGap(8, 8, 8)
			                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
		}
		
		private void ArmadoPanel() {
			GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			int fila;
			int Columna = 0;
			String Detalle;
//			BigDecimal precio;
			int cantidad;
			int archivosCargados = 0;
			int totalFilas = 0;
			LimpiarTabla();
			String[] Datos = new String[3];
//			String precioTemp = "";
			Cell Celda;
			String CodigoProducto;
			String Descripcion;
			try {
				while (!Archivos.isEmpty()) {
					fila = 1;
					File Archivo = Archivos.removeFirst();
					Datos[0] = Archivo.getName();
					Workbook workbook = Workbook.getWorkbook(Archivo);
					Sheet sheet = workbook.getSheet(0);
					totalFilas = sheet.getRows();
					Celda = sheet.getCell(Columna,fila);
					CodigoProducto = Celda.getContents();
					while ((fila < totalFilas) && !CodigoProducto.isEmpty()) {
						Celda = sheet.getCell(1,fila);
						Descripcion = Celda.getContents();
						Celda = sheet.getCell(7,fila);
						cantidad = Integer.parseInt(Celda.getContents());
						if (Nucleo.VerificarCodigo(CodigoProducto)) { 
							if (Nucleo.ActualizarProductoPorRemito(CodigoProducto, Descripcion, cantidad)==0) { MostrarError("Error al Actualizar Producto Por Remito",this); }
							else { if (Nucleo.AgregarMovimiento(CodigoProducto, 1, cantidad, 0)==0) { MostrarError("Error al Grabar Movimiento Del Producto",this); } }
						}
						else {
							Celda = sheet.getCell(1,fila);
							Detalle = Celda.getContents();
							Nucleo.IngresarProducto(CodigoProducto, Detalle, new BigDecimal(0), cantidad);
							if (Nucleo.AgregarMovimiento(CodigoProducto, 1, cantidad, 0)==0) { MostrarError("Error al Grabar Movimiento Del Producto",this); }
						}
						fila++;
						Columna = 0;
						if (fila < totalFilas) {
							Celda = sheet.getCell(Columna,fila);
							CodigoProducto = Celda.getContents();
						}
					}
					fila--;
//					numeroRemito = Integer.parseInt(Archivo.getName().substring(7).replace(".xls",""));
					Nucleo.cargarRemito(Archivo.getName(), fila);
					workbook.close();
					Datos[1] = Integer.toString(fila);
					Datos[2] = "Cargado";
					TableModel.addRow(Datos);
					archivosCargados++;
				}
				jTextField1.setText(archivosCargados + " Archivo(s) Fueron Cargados Con Éxito");
			} catch (Exception Error) {
				Error.printStackTrace();
				Datos[1] = "-";
				Datos[2] = "Error";
				TableModel.addRow(Datos);
				while (!Archivos.isEmpty()) {
					File Archivo = Archivos.removeFirst();
					Datos[0] = Archivo.getName();
					Datos[1] = "-";
					Datos[2] = "Sin Cargar";
					TableModel.addRow(Datos);
				}
				jTextField1.setText(archivosCargados + " Archivo(s) Fueron Cargados Con Éxito");
				MostrarError("Error al Cargar Remitos",this);
			}
		}
        
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			String[] Datos = new String[3];
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(jTextField1);
			if (seleccion == JFileChooser.APPROVE_OPTION)
			{
			   File fichero = fileChooser.getSelectedFile();
			   Archivos.add(fichero);
			   Datos[0] = fichero.getName();
			   Datos[1] = "-";
			   Datos[2] = "-";
			   TableModel.addRow(Datos);
			}
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) {
	        jTextField1.setText("");
	        Archivos = new LinkedList<File>();
	        LimpiarTabla();
        	dispose();
        }
        
		public void LimpiarTabla() {
			int Filas = TableModel.getRowCount();
			for (int x=0;x<Filas;x++) { TableModel.removeRow(0); }
		}
	}

//	Ventana Comparar Stock	
	
	public class VentanaCompararStock extends JDialog {

		private static final long serialVersionUID = 1L;

		private JTextField jTextField1;
//		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;
		private JPanel jPanel1;
		private JLabel jLabel1, jLabel2, jLabel3;
//		private DefaultListModel SampleModel;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		
		public VentanaCompararStock() {

	        jPanel1 = new JPanel();
	        jTextField1 = new JTextField();  	// Codigo
/*	        jTextField2 = new JTextField();  	// Precio
	        jComboBox1 = new JComboBox();
	        jComboBox2 = new JComboBox();
	        jComboBox3 = new JComboBox();*/
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jButton1 = new JButton();
	        jLabel1 = new JLabel();
	        jLabel2 = new JLabel();
	        jLabel3 = new JLabel();
	        jTable1 = new JTable();
	        
	        setTitle("Comparar Stock de Presea Con Fringo");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Artículos Comparados = 0");
	        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel2.setText("Artículos OK = 0");
	        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel3.setText("Artículos Con Diferencias o Negativos = 0");
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setText("");
     	    jTextField1.setEditable(false);

/*     	    jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Nadya", "Marina", "Otro" }));
     	    jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Presea", "Asterisco" }));
     	    jComboBox3.setModel(new DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta" }));*/
	        
	        jButton1.setText("Cargar Stock Presea");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	                
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        ArmadoTabla();
	        ArmadoPanel();
	        ArmadoFinal();
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void ArmadoPanel() {
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                			.addGap(75, 75, 75)
	                			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
	                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
//	                	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
/*	                	.addGroup(jPanel1Layout.createSequentialGroup()	                		                			                		
	                		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))*/
	                	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
/*	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))*/
	                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
		            .addGap(8, 8, 8)
		            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		            .addGap(8, 8, 8)
//		            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
//		            .addGap(8, 8, 8)
		            .addComponent(jLabel1)
		            .addGap(8, 8, 8)
		            .addComponent(jLabel2)
		            .addGap(8, 8, 8)
		            .addComponent(jLabel3)
		            .addGap(8, 8, 8)
		            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)	
                	.addContainerGap())
	        );
		}
		
		private void ArmadoFinal() {
			GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		}
		
	    private void ArmadoTabla() {
	        TableModel.addColumn("Código");
	        TableModel.addColumn("Stock Presea");
	        TableModel.addColumn("Stock Fringo");
	        TableModel.addColumn("Diferencia");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(150);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(3);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
	    }
		
		private void jButton1ActionPerformed() {
			int fila = 1;
			int Columna = 0;
			int cantidad;
			int cantFringo;
			int totalFilas = 0;
			int artComp, artOk, artDif;
			int Index = 0;
			int VerificadosInicio = 0;
			int VerificadosFin = 0;
			boolean imprimir;
			String codFringo;
			artComp = artOk = artDif = 0;
			LimpiarTabla();
			String[] Datos, DatosFringo = null;
			Object[] Faltantes = null;
			Cell Celda;
			String CodigoProducto;		
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(jTextField1);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File fichero = fileChooser.getSelectedFile();				
				try {
					Workbook workbook = Workbook.getWorkbook(fichero);
					Sheet sheet = workbook.getSheet(0);
					totalFilas = sheet.getRows();
					Celda = sheet.getCell(Columna,fila);
					CodigoProducto = Celda.getContents();
					LinkedList<Object[]> Productos = Nucleo.ObtenerCantidades();
					while ((fila < totalFilas) && !CodigoProducto.isEmpty()) {
						imprimir = false;
						Datos = new String[4];
						Celda = sheet.getCell(4,fila); 
						cantidad = Integer.parseInt(Celda.getContents());
						int Flag = 0;
						artComp++;
						Datos[0] = CodigoProducto;
						Datos[1] = Integer.toString(cantidad);
						while (Index<Productos.size() && Flag == 0) {
							codFringo = Productos.get(Index)[0].toString();
							if (CodigoProducto.equalsIgnoreCase(codFringo)) {
								cantFringo = (Integer) Productos.get(Index)[2];
								Datos[2] = Integer.toString(cantFringo);
								Datos[3] = Integer.toString(cantidad-cantFringo);
								if ((cantidad-cantFringo==0) && cantidad>=0 && cantFringo>=0) { artOk++; }
								else { 
									artDif++;
									imprimir = true;
								}
								Flag = 1;
								Index++;
							    VerificadosFin = Index-2;
							}
							else if (CodigoProducto.compareTo(codFringo)<0) { 
								Flag = 2;
								VerificadosFin = Index-1;
//								Index++;
							}
							else {
								VerificadosFin = Index;
								Index++;
							}							
						}
						if (Flag==2) {
							Datos[2] = "No Existe";
							Datos[3] = Integer.toString(cantidad);
							imprimir = true;
							artDif++;
							
						}
						System.out.println("Fila = " + fila);
						fila++;
						Columna = 0;
						if (fila < totalFilas) {
							Celda = sheet.getCell(Columna,fila);
							CodigoProducto = Celda.getContents();
						}						
						for (int y=VerificadosInicio;y<=VerificadosFin;y++) {									
							Faltantes = Productos.get(y);
							if ((Integer)Faltantes[2]!=0) {
								DatosFringo = new String[4];
								DatosFringo[0] = Faltantes[0].toString();
								DatosFringo[1] = "No Existe";
								DatosFringo[2] = Integer.toString((Integer)Faltantes[2]);
								if ((Integer)Faltantes[2]>0) { DatosFringo[3] = "-" + Integer.toString((Integer)Faltantes[2]); }
								else { DatosFringo[3] = Integer.toString((Integer)Faltantes[2]); }
								TableModel.addRow(DatosFringo);
								artComp++;
								artDif++;							
							}
						}
						if (imprimir) { TableModel.addRow(Datos); }
						VerificadosInicio = VerificadosFin = Index;
					}
					jTextField1.setText("Nombre Archivo: " + fichero.getName());
					jLabel1.setText("Artículos Comparados = " + artComp);
					jLabel2.setText("Artículos OK = " + artOk);
					jLabel3.setText("Artículos Con Diferencias o Negativos = " + artDif);
					workbook.close();
				} catch (Exception Error) {
					Error.printStackTrace();
					jTextField1.setText("Error al Realizar Comparación de Stocks");
				}
			}
		}
		
		public void LimpiarTabla() {
			int Filas = TableModel.getRowCount();
			for (int x=0;x<Filas;x++) { TableModel.removeRow(0); }
		}
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
	        jTextField1.setText("");
	        jLabel1.setText("Artículos Comparados = 0");
	        jLabel2.setText("Artículos OK = 0");
	        jLabel3.setText("Artículos Con Diferencias o Negativos = 0");
	        LimpiarTabla();
        	dispose();
        }        
	}
	
//	Ventana Que Sirve De Base Para Crear Otras	
	
	public class VentanaCuaderno extends JDialog {

		private static final long serialVersionUID = 1L;

		private JTextField jTextField1, jTextField2;
		private JComboBox jComboBox1, jComboBox2, jComboBox3;
		private JButton jButton1;
		private JPanel jPanel1;
		private JLabel jLabel1;
//		private DefaultListModel SampleModel;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		
		public VentanaCuaderno() {

	        jPanel1 = new JPanel();
	        jTextField1 = new JTextField();  	// Codigo
	        jTextField2 = new JTextField();  	// Precio
	        jComboBox1 = new JComboBox();
	        jComboBox2 = new JComboBox();
	        jComboBox3 = new JComboBox();
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jButton1 = new JButton();
	        jLabel1 = new JLabel();
	        jTable1 = new JTable();
	        
	        setTitle("Cuaderno Diario");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        setBounds(new java.awt.Rectangle(getBounds().x + 198, getBounds().y + 177, 364, 288));
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField1.setText("Código");
     	    jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
     	    jTextField2.setText("Precio");

     	    jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Nadya", "Marina", "Otro" }));
     	    jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Presea", "Asterisco" }));
     	    jComboBox3.setModel(new DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta" }));
	        
	        jButton1.setText("Agregar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        ArmadoTabla();
	        ArmadoPanel();
	        ArmadoFinal();
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void ArmadoPanel() {
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(jPanel1Layout.createSequentialGroup()	                		
	                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)	                		
	                		.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                		.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
	                	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)	                		
	                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	                	.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		            .addGap(8, 8, 8)
		            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		            .addGap(8, 8, 8)
			        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)	
                	.addContainerGap())
	        );
		}
		
		private void ArmadoFinal() {
			GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		}
		
	    private void ArmadoTabla() {
	        TableModel.addColumn("Código");
	        TableModel.addColumn("Descripción");
	        TableModel.addColumn("Precio");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(120);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(270);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(50);
			column.setResizable(false);
			column.setCellRenderer(tcr);
	    }
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	
		}
        
        public void CerrarVentana(java.awt.event.WindowEvent event) {
	        jTextField1.setText("Código");
	        jTextField1.setText("Precio");
        	dispose();
        }        
	}
	
	public class VentanaProdEspeciales extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JButton jButton1, jButton2, jButton3, jButton4, jButton5;
		private JPanel jPanel2;
        public int Flag, CargaDatos, Local;
        public String Traslado,TipoTalle;
		
		public VentanaProdEspeciales(JDialog VentanaMadre) {

			jPanel2 = new JPanel();
	        jButton1 = new JButton();			// Ingresar (ingresar producto)
	        jButton2 = new JButton();			// Ingresar (ingresar producto)
	        jButton3 = new JButton();			// Ingresar (ingresar producto)
	        jButton4 = new JButton();			// Ingresar (ingresar producto)
	        jButton5 = new JButton();			// Ingresar (ingresar producto)
	        
	        setTitle("Cargar Productos Especiales");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        
//	        Font FuenteGrande = new Font("TimesRoman", Font.BOLD, 30);
	        
	        jPanel2.setBorder(BorderFactory.createEtchedBorder());
	        jPanel2.setName("");
	                         	        
	        jButton1.setText("Pago De Cuenta Corriente");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        jButton2.setText("Entrega De Seña");
	        jButton2.addKeyListener(this);
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed();
	            }
	        });
	        
	        jButton3.setText("Adicionar Cambio a La Caja");
	        jButton3.addKeyListener(this);
	        jButton3.setEnabled(false);
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton3ActionPerformed();
	            }
	        });
	        
	        jButton4.setText("Descuento en el Pago del Saldo");
	        jButton4.addKeyListener(this);
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton4ActionPerformed();
	            }
	        });
	        
	        jButton5.setText("Devolución de Producto a Cuenta");
	        jButton5.addKeyListener(this);
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton5ActionPerformed();
	            }
	        });
               
	        this.addWindowFocusListener(new WindowAdapter() {
	            public void windowGainedFocus(WindowEvent e) {
	                jButton1.requestFocusInWindow();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			     
	        ArmadoPanel2();
	        ArmadoFinal();
	        pack();
	        setLocationRelativeTo(VentanaMadre);
        	jButton1.requestFocusInWindow();
		}
		
		private void ArmadoPanel2() {
			
			GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())            
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addGroup(jPanel2Layout.createSequentialGroup()		               	                	          		
	               			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addGap(8, 8, 8)
	               			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addGap(8, 8, 8)
	               			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	             			.addGap(8, 8, 8)
	               			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	               			.addGap(8, 8, 8)
	               			.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );
			
		}

		private void ArmadoFinal() {
			
			GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                	.addGroup(layout.createSequentialGroup()
	                		.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        
		}		
	
		private void jButton1ActionPerformed() { // Cargar Producto Especial	
			Cerrar();
			Ventas.jTextField1.setText("PagoCuenta");
			Ventas.VerificarCodigoIngresado();
		}
		
		private void jButton2ActionPerformed() { // Cargar Producto Especial	
			Ventas.jTextField1.setText("EntregaSeña");
			Ventas.VerificarCodigoIngresado();
			Cerrar();
		}
		
		private void jButton3ActionPerformed() { // Cargar Producto Especial	
			Ventas.jTextField1.setText("AdicionarCambio");
			Ventas.VerificarCodigoIngresado();
			Cerrar();
		}
		
		private void jButton4ActionPerformed() { // Cargar Producto Especial	
			Ventas.jTextField1.setText("DescuentoCuenta");
			Ventas.VerificarCodigoIngresado();
			Cerrar();
		}
		
		private void jButton5ActionPerformed() { // Cargar Producto Especial	
			Ventas.jTextField1.setText("DevolProducto");
			Ventas.VerificarCodigoIngresado();
			Cerrar();
		}
		      								
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() { 
        	jButton1.requestFocusInWindow();
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {}

		public void keyReleased(KeyEvent e) { 
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (KeyCode==40) {
				if (e.getComponent()==jButton1) { MarcarBoton(jButton2); }
				else if (e.getComponent()==jButton2) { MarcarBoton(jButton3); }
				else if (e.getComponent()==jButton3) { MarcarBoton(jButton4); }
				else if (e.getComponent()==jButton4) { MarcarBoton(jButton5); }
			}
			else if (KeyCode==38) {
				if (e.getComponent()==jButton2) { MarcarBoton(jButton1); }
				else if (e.getComponent()==jButton3) { MarcarBoton(jButton2); }
				else if (e.getComponent()==jButton4) { MarcarBoton(jButton3); }
				else if (e.getComponent()==jButton5) { MarcarBoton(jButton4); }
			}
			else if (Tecla.compareTo("Introduzca")==0 && e.getComponent()==jButton1) { jButton1ActionPerformed(); }
			else if (Tecla.compareTo("Introduzca")==0 && e.getComponent()==jButton2) { jButton2ActionPerformed(); }
			else if (Tecla.compareTo("Introduzca")==0 && e.getComponent()==jButton3) { jButton3ActionPerformed(); }
			else if (Tecla.compareTo("Introduzca")==0 && e.getComponent()==jButton4) { jButton4ActionPerformed(); }
			else if (Tecla.compareTo("Introduzca")==0 && e.getComponent()==jButton5) { jButton5ActionPerformed(); }
		}
	}

//	Métodos de la Ventana Principal	
	
//	Ventana Factura
	
	public class VentanaFactura extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel2, jLabel1, jLabel3, jLabel4, jLabel5, jLabel6;
		private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5;
		private JComboBox jComboBox1;
		private JButton jButton1, jButton2;
		private JPanel jPanel1;
        public DefaultListModel SampleModel;
        public LinkedList<Object[]> Clientes;
        public int CargaDatos;
        public int Modo, Ventana;
		
		public VentanaFactura(JDialog VentanaMadre) {

			jPanel1 = new JPanel();
	        jLabel2 = new JLabel();			 	// Cambio: $
	        jLabel1 = new JLabel();			 	// Cambio: $
	        jLabel2 = new JLabel();			 	// Cambio: $
	        jLabel3 = new JLabel();			 	// Cambio: $
	        jLabel4 = new JLabel();			 	// Cambio: $
	        jLabel5 = new JLabel();			 	// Cambio: $
	        jLabel6 = new JLabel();			 	// Cambio: $
	        jTextField1 = new JTextField();  	// Fecha
	        jTextField2 = new JTextField();  	// Cambio: $
	        jTextField3 = new JTextField();  	// Cambio: $
	        jTextField4 = new JTextField();  	// Cambio: $
	        jTextField5 = new JTextField();  	// Cambio: $
	        jComboBox1 = new JComboBox();
	        jButton1 = new JButton();
	        jButton2 = new JButton();
	        CargaDatos = 0;
	        Modo = 0; // Modo = 0 > Para Ingresar Nuevo CUIT - Modo = 1 > Para Grabar Nuevo CUIT
	        
	        setTitle("Ingesar Datos de Factura A");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);      
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");            
	        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel1.setText("Número de Factura");  
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText("Razón Social");
	        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel3.setText("CUIT");
	        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel4.setText("-");
	        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel5.setText("-");
	        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel6.setText("Búsqueda");
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel2.getFont());
	        jTextField1.addKeyListener(this);
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel2.getFont());
	        jTextField2.addKeyListener(this);
	        jTextField2.setEditable(false);
	        jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField3.setFont(jLabel2.getFont());
	        jTextField3.addKeyListener(this);
	        jTextField3.setEditable(false);
	        jTextField4.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField4.setFont(jLabel2.getFont());
	        jTextField4.addKeyListener(this);
	        jTextField4.setEditable(false);
	        jTextField5.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField5.setFont(jLabel2.getFont());
	        jTextField5.addKeyListener(this);
	        jTextField5.setEditable(false);
	        
	        jComboBox1.addKeyListener(this);
			jComboBox1.addItemListener(new java.awt.event.ItemListener() {
	            public void itemStateChanged(java.awt.event.ItemEvent evt) { jComboBox1ActionPerformed(); }
	        });

	        
	        jButton1.setText("Cargar Datos");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        jButton2.setText("Nuevo CUIT");
	        jButton2.addKeyListener(this);
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton2ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana();
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                		.addGroup(jPanel1Layout.createSequentialGroup()
	    	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	    	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	    	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))	                        
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	                        .addGap(2, 2, 2)
	                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	                        .addGap(2, 2, 2)
	                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
	                        .addGap(2, 2, 2)
	                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	                        .addGap(2, 2, 2)	                        
	                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))	                        
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		            		.addGap(GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
		            		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
			               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				               			.addComponent(jLabel6)
					                	.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				               		.addGap(8, 8, 8)			                	
			                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    		            	.addComponent(jLabel1)
			    			           	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))	
				               		.addGap(8, 8, 8)	
				               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				               			.addComponent(jLabel2)
					                	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					                .addGap(8, 8, 8)	
				               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				               			.addComponent(jLabel3)
					                	.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					                	.addComponent(jLabel4)
					                	.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					                	.addComponent(jLabel5)
					                	.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))			                	
					                .addGap(8, 8, 8)
					                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					                	.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        setLocationRelativeTo(VentanaMadre);
	        jTextField1.requestFocusInWindow();
		}
		
		private void jButton1ActionPerformed() {
			if (VerificarNumeroSinDec(jTextField1.getText())) {
				Ventas.nFactura = jTextField1.getText();
				Ventas.clienteFact = Clientes.get(jComboBox1.getSelectedIndex());
				CerrarVentana();
			}
			else { MostrarError("El Número de Factura No Es Correcto",this); }			
        }
        
		private void jButton2ActionPerformed() {
			if (Modo == 0) {
				jTextField2.setText("");
				jTextField2.setEditable(true);
				jTextField1.setText("");
				jTextField1.setEditable(false);
				jButton1.setEnabled(false);
				jButton2.setText("Agregar");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField3.setEditable(true);
				jTextField4.setEditable(true);
				jTextField5.setEditable(true);
				jComboBox1.setEnabled(false);
				Modo = 1;
			}
			else {
				if (VerificarNumeroSinDec(jTextField3.getText()) && VerificarNumeroSinDec(jTextField4.getText()) && VerificarNumeroSinDec(jTextField5.getText())) {
					int Resultado = Nucleo.IngresarNuevoCUIT(jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText());
					if (Resultado == 0) {
						jTextField2.setEditable(false);
						jTextField1.setEditable(true);
						jButton1.setEnabled(true);
						jButton2.setText("Nuevo CUIT");
						jTextField3.setEditable(false);
						jTextField4.setEditable(false);
						jTextField5.setEditable(false);
						jComboBox1.setEnabled(true);
						CargarDatos(Ventana);
					}
					else { MostrarError("Error al Almacenar Datos",this); }
				}
				else { MostrarError("Los Valores Ingresados Son Incorrectos",this); }				
			}
		}
		
		private void CargarDatos(int TipoVent) { // TipoVent = 1 (Factura A) - TipoVent = 2 (Factura B)
			CargaDatos = 1;
			Ventana = TipoVent;
			jComboBox1.removeAllItems();
			Clientes = Nucleo.BuscarClientesFacturas();
			for (int i=0;i<Clientes.size();i++) {
				Object[] Datos = Clientes.get(i);
				jComboBox1.addItem(Datos[1].toString()); // Almacena Proveedor Para Cargar Productos
			}
			if (Modo==1) {
				for (int i=0;i<Clientes.size();i++) {
					Object[] Datos = Clientes.get(i);
					int id = Nucleo.ObtenerIdUltimoClienteIngresado();
					if ((Integer)Datos[0]==id) {
						jComboBox1.setSelectedIndex(i);
						i = Clientes.size();
					}					
				}
				Modo = 0;				
			}
			CargaDatos = 0;
			jTextField1.setText(Long.toString(Nucleo.ObtenerNroFact(TipoVent)));
			jComboBox1ActionPerformed();
        }
		
		private void jComboBox1ActionPerformed() {
			if (CargaDatos==0) {
				if (!Clientes.isEmpty()) {
					Object[] Datos = Clientes.get(jComboBox1.getSelectedIndex());
					jTextField2.setText(Datos[1].toString());
					String CUIT = Datos[2].toString();
					jTextField3.setText(CUIT.substring(0,2));
					jTextField4.setText(CUIT.substring(2,10));
					jTextField5.setText(CUIT.substring(10,11));					
				}
			}
        }

        public void CerrarVentana() {
        	jTextField1.setText("");
        	jTextField2.setText("");
        	jTextField3.setText("");
        	jTextField4.setText("");
        	jTextField5.setText("");
	        jTextField1.requestFocusInWindow();
        	dispose();
        }

        public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) {
				if (e.getComponent()==jTextField1) { jTextField2.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField2) { jTextField3.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField3) { jTextField4.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField4) { jTextField5.requestFocusInWindow(); }
				else if (e.getComponent()==jTextField5) { jButton1.requestFocusInWindow(); }
				else if (e.getComponent()==jButton1) { jButton1ActionPerformed(); }
			}
			else if (e.getComponent()==jTextField3 && jTextField3.getText().length()==2) { jTextField4.requestFocusInWindow(); }
			else if (e.getComponent()==jTextField4 && jTextField4.getText().length()==8) { jTextField5.requestFocusInWindow(); }
			else if (e.getComponent()==jTextField5 && jTextField5.getText().length()==1) { jButton1.requestFocusInWindow(); }
		}

		public void keyTyped(KeyEvent e) { }

	}
	
//	Ventana Clientes	
	
	public class VentanaFriedman extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		private JTextField jTextField1;
		private JButton jButton1, jButton2;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		private JPanel jPanel1;
        public LinkedList<Object[]> Clientes;
        public String NombreCliente;
    	
//		private Largo, Ancho;
		
		public VentanaFriedman() {
	
	        jPanel1 = new JPanel();			 
	        jTextField1 = new JTextField();  	// Seleccionar Cliente Por Nro Doc
	        jLabel1 = new JLabel();
	        jButton1 = new JButton();			// Seleccionar Cliente
	        jButton2 = new JButton();			// Agregar Nuevo Cliente
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jTable1 = new JTable();
        
	        setTitle("Histórico de Ventas");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");	     
	              
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        jTextField1.setEditable(false);
	        
	        jButton1.setText("Últimos 10 Días");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {            	
	            	jButton1ActionPerformed(evt);	            	
	            }
	        });
	        
	        jButton2.setText("Semana Anterior");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
//	            	jButton2ActionPerformed(evt);
	            }
	        });
	        
	        ArmadoTabla();
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
		                	.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)	
		               		.addGap(8, 8, 8)	
		               	   	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
			                .addGap(8, 8, 8)
			                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        pack();
	        jButton1.requestFocusInWindow();
	        setLocationRelativeTo(null);
		}

		private void ArmadoTabla() {
//	        TableModel.setRowCount(30);
	        TableModel.addColumn("Fecha");
	        TableModel.addColumn("Dia");
	        TableModel.addColumn("Total de Ventas");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
//			tcr.setSize(15,15);
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(95);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(95);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(150);
			column.setResizable(false);
			column.setCellRenderer(tcr);			
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			LimpiarTabla(TableModel);
			String[] Datos = new String[3];
			int y = 0;
			LinkedList<String> ListaProd = Nucleo.BuscarHistoricoVentas(0);
			if (!ListaProd.isEmpty()) {
				jTextField1.setText(ListaProd.remove());
				while (!ListaProd.isEmpty()) {
					Datos[y] = ListaProd.remove();		
					y++;
					if (y==3) {
						TableModel.addRow(Datos);
						y=0;
					}
				}				
			}
			else { jTextField1.setText("No Se Encontraron Datos"); }
		}
	
/*		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			String[] Datos = new String[3];
			int y = 0;
			LinkedList<String> ListaProd = Nucleo.BuscarHistoricoVentas(1);
			if (!ListaProd.isEmpty()) {
				jTextField1.setText(ListaProd.remove());
				while (!ListaProd.isEmpty()) {
					Datos[y] = ListaProd.remove();		
					y++;
					if (y==3) {
						TableModel.addRow(Datos);
						y=0;
					}
				}				
			}
			else { jTextField1.setText("No Se Encontraron Datos"); }
		}*/
        
		public void keyPressed(KeyEvent e) { }

		public void keyTyped(KeyEvent e) { }
		
		public void keyReleased(KeyEvent e) { }
				
        public void CerrarVentana(java.awt.event.WindowEvent event) {
        	LimpiarTabla(TableModel);
        	jTextField1.setText("");
        	jButton1.requestFocusInWindow();
        	dispose();
        }
	}
	
	public class VentanaHistorial extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JLabel jLabel1;// jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
//		private JPasswordField jPasswordField1;
		private JTextField jTextField1, jTextField2;//, jTextField4;
		private JButton jButton1;//, jButton2, jButton3;
		private JPanel jPanel1;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		
		public VentanaHistorial() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jTextField1 = new JTextField();  	// Código del producto
	        jTextField2 = new JTextField();  	// Código del producto
	        jButton1 = new JButton();
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jTable1 = new JTable();	        
	        
	        setTitle("Historial de Productos");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Código Producto");
       
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());
	        jTextField1.addKeyListener(this);
	        
	        jTextField2.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField2.setFont(jLabel1.getFont());
	        jTextField2.setEditable(false);
	        
	        jButton1.setText("Buscar");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
	        
	        ArmadoTabla();
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addGap(94,94,94)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	                        .addGap(GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                    	.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
	                		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                			.addComponent(jLabel1)
		                		.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		                    .addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		               			.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		               		.addGap(8, 8, 8)	
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//		               			.addComponent(jLabel2)
			                	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jTextField1.requestFocusInWindow();
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void ArmadoTabla() {
//	        TableModel.setRowCount(30);
	        TableModel.addColumn("Fecha");
	        TableModel.addColumn("Motivo");
	        TableModel.addColumn("Cantidad");
	        TableModel.addColumn("Saldo Stock");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
//			tcr.setSize(15,15);
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(150);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(3);
			column.setPreferredWidth(100);
			column.setResizable(false);
			column.setCellRenderer(tcr);
		}
		
		private void jButton1ActionPerformed() {
			LimpiarTabla(TableModel);
			String[] Datos = new String[4];
			int y = 0;
			LinkedList<String> ListaProd = Nucleo.BuscarHistoricoProducto(jTextField1.getText());
			if (!ListaProd.isEmpty()) {
				while (!ListaProd.isEmpty()) {
					Datos[y] = ListaProd.remove();		
					y++;
					if (y==4) {
						TableModel.addRow(Datos);
						y=0;
					}
				}				
			}
			else { MostrarAviso("No Hay Datos Sobre El Código Ingresado",this); }
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	LimpiarTabla(TableModel);
        	jTextField1.setText("");
        	jTextField2.setText("");
        	jTextField1.requestFocusInWindow();
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			String CodigoProducto;
			if (Tecla.compareTo("Introduzca")!=0) {
				if (e.getComponent()==jTextField1) { 
					CodigoProducto = jTextField1.getText();
					LinkedList<String> Producto;			
					if (CodigoProducto.length()==15) {
						Producto = Nucleo.BuscarProducto(CodigoProducto);
						if (Producto != null) { jTextField2.setText(Producto.removeFirst().toString()); }
					}
					else if (!jTextField2.getText().isEmpty()) { jTextField2.setText(""); }
				}				
			}
			else { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
        
	}
	
	public class VentanaAsteriscos extends JDialog implements KeyListener {

		private static final long serialVersionUID = 1L;

		private JButton jButton1;//, jButton2, jButton3;
		private JLabel jLabel1;
		private JPanel jPanel1;
		private JScrollPane jScrollPane1;
		private DefaultTableModel TableModel;
		private JTable jTable1;
		public int Flag; // Flag = 0 Muestra Asteriscos , Flag = 1 Da Baja Asteriscos
		
		public VentanaAsteriscos() {
	
	        jPanel1 = new JPanel();			 
	        jLabel1 = new JLabel();			 	// Código Producto
	        jButton1 = new JButton();
	        jScrollPane1 = new JScrollPane();
	        TableModel = new DefaultTableModel();
	        jTable1 = new JTable();
	        Flag = 0;
	        
	        setTitle("Asteriscos Para Dar De Baja En Presea");
			setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
	        setResizable(false);
	        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        jPanel1.setBorder(BorderFactory.createEtchedBorder());
	        jPanel1.setName("");
	        	        
	        jButton1.setText("Ver Asteriscos");
	        jButton1.addKeyListener(this);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed();
	            }
	        });
	        
	        addWindowListener( new java.awt.event.WindowAdapter() {
	        	public void windowClosing(java.awt.event.WindowEvent event) {
	        		CerrarVentana(event);
	        	}
	        });
	        
	        ArmadoTabla();
			
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
		            		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())               
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                	.addGroup(jPanel1Layout.createSequentialGroup()
		               		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			                	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))	
			                .addGap(8, 8, 8)
			                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))	
                	.addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
        	jButton1.requestFocusInWindow();
	        pack();
	        setLocationRelativeTo(null);
		}
		
		private void ArmadoTabla() {
	        TableModel.addColumn("Fecha");
	        TableModel.addColumn("Nro Venta");
	        TableModel.addColumn("Código Producto");
	        TableModel.addColumn("Cantidad");
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(TableModel);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setFont(jLabel1.getFont());
//			tcr.setSize(15,15);
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumn column = null;
			JTableHeader Encabezado = jTable1.getTableHeader();			
			Encabezado.setFont(jLabel1.getFont());
			jTable1.setTableHeader(Encabezado);
			column = jTable1.getColumnModel().getColumn(0);
			column.setPreferredWidth(80);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(1);
			column.setPreferredWidth(62);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(2);
			column.setPreferredWidth(158);
			column.setResizable(false);
			column.setCellRenderer(tcr);
			column = jTable1.getColumnModel().getColumn(3);
			column.setPreferredWidth(55);
			column.setResizable(false);
			column.setCellRenderer(tcr);
		}
		
		private void jButton1ActionPerformed() {
			if (Flag==0) {
				LimpiarTabla(TableModel);
				String[] Datos = new String[4];
				int y = 0;
				LinkedList<String> ListaProd = Nucleo.BuscarAsteriscos();
				if (!ListaProd.isEmpty()) {
					while (!ListaProd.isEmpty()) {
						Datos[y] = ListaProd.remove();		
						y++;
						if (y==4) {
							TableModel.addRow(Datos);
							y=0;
						}
					}
					Flag = 1;
					jButton1.setText("Confirmar Baja Códigos en Presea");
				}
				else { MostrarAviso("No Hay Asteriscos Pendientes Para Presea",this); }				
			}
			else {
				if (Nucleo.BajaAsteriscos()) {
					MostrarAviso("La Baja De Los Códigos Fue Confirmada",this);
					Cerrar();					
				}
			}
		}
		
        public void CerrarVentana(java.awt.event.WindowEvent event) { Cerrar(); }
        
        public void Cerrar() {
        	LimpiarTabla(TableModel);
        	jButton1.requestFocusInWindow();
        	if (Flag==1) {
        		Flag = 0;
        		jButton1.setText("Ver Asteriscos");
        	}
        	dispose();
        }
        
		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			String Tecla = KeyEvent.getKeyText(KeyCode);
			if (Tecla.compareTo("Introduzca")==0) { jButton1ActionPerformed(); }
		}

		public void keyTyped(KeyEvent e) { }
        
	}
	
	public void MostrarError(String Error, JDialog VentanaMadre) {
		if (Errores == null) { Errores = new VentanaErrores(Error, VentanaMadre); }
		else { Errores.CargarVentana(Error, VentanaMadre); }
		Errores.setVisible(true);
	}
	
	public void MostrarAviso(String Texto, JDialog VentanaMadre) {
		if (Aviso == null) { Aviso = new VentanaAviso(Texto, VentanaMadre); }
		else { Aviso.CargarVentana(Texto, VentanaMadre); }
		Aviso.setVisible(true);
	}
	
	public void MostrarConfirmar(String Texto, JDialog VentanaMadre, int Flag) {
		if (Confirmar == null) { Confirmar = new VentanaConfirmar(Texto, VentanaMadre, Flag); }
		else { Confirmar.CargarVentana(Texto, Flag); }
		Confirmar.setVisible(true);
	}
	
	public void MostrarExcepcion(String Excepcion, JDialog VentanaMadre) {
		if (Excepciones == null) { Excepciones = new VentanaExcepciones(Excepcion, VentanaMadre); }
		else { Excepciones.CargarVentana(Excepcion, VentanaMadre); }
		Excepciones.setVisible(true);
	}
	
	public void MarcarBoton(JButton Boton) { Boton.requestFocusInWindow(); }
	
    protected String VerificarNumero(String Valor) {
		int Contador = 0;
		int Flag = 0;
		if (!Valor.isEmpty()) {
			while (Contador<Valor.length() && Flag<=1) {
				if (Valor.charAt(Contador)=='.') { Flag++; }
				else if (Flag>1 || Valor.charAt(Contador)<'0' || Valor.charAt(Contador)>'9') { Flag = 2; }
				Contador++;
			}
			if (Flag<=1 && Contador>0) {
				if (Valor.indexOf(".")==Valor.length()-3 || Valor.indexOf(".")==Valor.length()-2 || Valor.indexOf(".") == -1) { return ""; }
				else { return "La Cantidad de Decimales Son 2 Unidades"; }
			}
			else return "Ingresar Solo Números y \".\" o \",\" para Dec.";
		}
		else return "Ingrese El Precio Del Producto";
	}
    
    protected boolean VerificarProdEspeciales(String Decripcion) {
		if (Decripcion.compareToIgnoreCase("Pago de Cuenta Corriente")==0 ||
			Decripcion.compareToIgnoreCase("Adicionar Cambio a La Caja")==0 ||
			Decripcion.compareToIgnoreCase("Entrega de Seña")==0 ||
			Decripcion.compareTo("Descuento en el Pago del Saldo")==0 ||
			Decripcion.compareToIgnoreCase("Devolución de Producto a Cuenta")==0) { return true; }
		else { return false; }
	}
    
    protected boolean VerificarNumeroSinDec(String Valor) {
		int Contador = 0;
		int Flag = 0;
		if (!Valor.isEmpty()) {
			while (Contador<Valor.length() && Flag==0) {
				if (Valor.charAt(Contador)<'0' || Valor.charAt(Contador)>'9') { Flag = 1; }
				Contador++;
			}
			if (Flag == 1) { return false; }
		}
		else return false;
		return true;
	}
	
	public void LimpiarTabla(DefaultTableModel tableModel) {
		if (tableModel!=null) {
			int Filas = tableModel.getRowCount();
			for (int x=0;x<Filas;x++) { tableModel.removeRow(0); }		
		}
	}
	
}

package Caja;

import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class HoraGUI extends JFrame {

	private static final long serialVersionUID = 1L;

		public HoraGUI() { initComponents(); }

		public JFrame VentanaPrincipal;
		private JButton jButton1; 
		private JPanel jPanel1;
		private JLabel jLabel1;
		private JTextField jTextField1;

		private void initComponents() {

			jButton1 = new JButton();
			jPanel1 = new JPanel();
	        jLabel1 = new JLabel();
	        jTextField1 = new JTextField();

			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			setTitle("Verificar Fecha y Hora");
			setResizable(false);
			jPanel1.setBorder(BorderFactory.createEtchedBorder());
			addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent event) {
					CerrarAplicacion(event);
				}
			});
			
	        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
	        jLabel1.setText("Fecha y Hora");
	        
     	    jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
	        jTextField1.setFont(jLabel1.getFont());

			jButton1.setText("Ver");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
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
                		.addComponent(jTextField1)
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
		}

		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
	    	String FechaTemp, FechaFinal;
	    	FechaTemp = FechaFinal = "";
	    	Date Fecha;
	    	Fecha = new Date(); 	
	    	FechaTemp = Fecha.toString();
	    	FechaFinal = FechaTemp + " - " + FechaTemp.substring(8,10) + "/";
	    	if (FechaTemp.contains("Jan")) {FechaFinal += "01";}
	    	else if (FechaTemp.contains("Feb")) {FechaFinal += "02";}
	    	else if (FechaTemp.contains("Mar")) {FechaFinal += "03";}
	    	else if (FechaTemp.contains("Apr")) {FechaFinal += "04";}
	    	else if (FechaTemp.contains("May")) {FechaFinal += "05";}
	    	else if (FechaTemp.contains("Jun")) {FechaFinal += "06";}
	    	else if (FechaTemp.contains("Jul")) {FechaFinal += "07";}
	    	else if (FechaTemp.contains("Aug")) {FechaFinal += "08";}
	    	else if (FechaTemp.contains("Sep")) {FechaFinal += "09";}
	    	else if (FechaTemp.contains("Oct")) {FechaFinal += "10";}
	    	else if (FechaTemp.contains("Nov")) {FechaFinal += "11";}
	    	else if (FechaTemp.contains("Dec")) {FechaFinal += "12";}
	    	FechaFinal += "/" + FechaTemp.substring(FechaTemp.length()-2,FechaTemp.length()) + " " + FechaTemp.substring(11,19);
	    	jTextField1.setText(FechaFinal);			
		}

		public void CerrarAplicacion(java.awt.event.WindowEvent event) { System.exit(0); }
}

/**
 * Prune POS Ver 0.6.4
 * @author Maurix
**/

package Caja;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class CBaseDatos {

	public String url, qs;
	public Statement stmt;
	public ResultSet rs;
	public Connection connection;
	public Connection bdHosting;
	public int Resultado;
	public CNucleo Nucleo;
	public int VentaNro;
	public int Local = 0;
	public long CVenta = 0;
	public boolean Admin = false;
	
	public CBaseDatos(CNucleo Nucleo) { this.Nucleo = Nucleo; }
	
	public int AccesoBD(String Usuario, String Password, String IP) {
		int Resultado = 0;
		String BaseDatos = Usuario;
		if (Usuario.compareTo("test")!=0) { 
			if (BaseDatos.compareTo("calcuer")==0) { Local = 1; }
			else if (BaseDatos.compareTo("bcbags")==0) {Local = 2; }
			else if (BaseDatos.compareTo("prune")==0) {Local = 3; }
		}
		else {
			BaseDatos = "prune";
//			Password = "cal31990";
			Password = "glendora";
			Local = 3;
		}
		if (IP.compareTo("Local")!=0) { 
			Usuario = "mluisx";
			Admin = true;
		}
		else { 
			Usuario = "root";
			IP = "localhost";		
		}
		try {
			Resultado = ActivarBD(BaseDatos, Usuario, Password, IP);
		} catch (ClassNotFoundException Error1) { return 1;
		} catch (IOException Error2) { return 1; }
		return Resultado;
	}
	
	public int ActivarBD(String BaseDatos, String User, String Pass, String IP) throws ClassNotFoundException,IOException  {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			192.168.1.2   localhost
			url = "jdbc:mysql://" + IP + "/" + BaseDatos + "?user=" + User + "&password=" + Pass;
			connection = DriverManager.getConnection(url);
		} catch (SQLException sqle) { 
			sqle.printStackTrace();
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				sqle.getMessage() + "\n\t\t"+
				"Error code: "+sqle.getErrorCode() + "\n\t\t"+
				"SQLState: "+sqle.getSQLState()+"\n";
				System.out.println(logMessage);
				sqle = sqle.getNextException();
				return 1;
			}
		}
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				qs = "select * from ventas where CodigoCaja = " + rs.getLong("CodigoCaja") + " order by CodigoVenta DESC";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				if (rs.next()) { VentaNro = rs.getInt("VentaNro") + 1; }
				else { VentaNro = 1; }
			}
			else { VentaNro = 1; }		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
	return 0;
	}
	
	public int DesactivarBD() {
		try {
//			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public int ActivarBDHosting() throws ClassNotFoundException,IOException,SQLException  {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			192.168.1.2   localhost			
//			url = "jdbc:mysql://" + IP + "/" + BaseDatos + "?user=" + User + "&password=" + Pass;
			url = "jdbc:mysql://96.9.162.227/glendora_calcuer?user=glendora_calcuer&password=cal31990";
			bdHosting = DriverManager.getConnection(url);
		} catch (SQLException sqle) { 
			sqle.printStackTrace();
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				sqle.getMessage() + "\n\t\t"+
				"Error code: "+sqle.getErrorCode() + "\n\t\t"+
				"SQLState: "+sqle.getSQLState()+"\n";
				System.out.println(logMessage);
				sqle = sqle.getNextException();
				return 1;
			}
		}
		return 0;
	}
	
	public LinkedList<String> ObtenerVentas(String Fecha) {
		LinkedList<String> DatosVentas = new LinkedList<String>();
		ResultSet rs1,rs2,rs3;
		long CodigoCaja = 0;
		int x = 1;
		BigDecimal TotalVenta, TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago;
		String Venta, Producto;
		BigDecimal Precio, Descuento, Interes, Saldo;
		try {
			qs = "select * from cajas where Fecha = \"" + Fecha + "\" order by CodigoCaja ASC";
			stmt = connection.createStatement();
			rs3 = stmt.executeQuery(qs);
			while (rs3.next()) {
/*				if (x>1) {
					Venta = "---------------------------------------------------------";
					DatosVentas.add(Venta);
				}

				Venta = "Datos de la Caja " + x + ":";
				DatosVentas.add(Venta);

				TotalVenta = new BigDecimal(rs3.getDouble("TotalVentas"));
				TotalVenta = TotalVenta.setScale(2, RoundingMode.HALF_UP);
				Venta = "Total de Ventas $" + TotalVenta.toString().replace(".",",");
				DatosVentas.add(Venta);
				
				TotalEfectivo = new BigDecimal(rs3.getDouble("TotalEfectivo"));
				TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
				if (TotalEfectivo.compareTo(new BigDecimal(0))!=0) {
					Venta = "Total de Efectivo $" + TotalEfectivo.toString().replace(".",",");
					DatosVentas.add(Venta);
				}
				
				TotalTarjeta = new BigDecimal(rs3.getDouble("TotalTarjeta"));
				TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
				if (TotalTarjeta.compareTo(new BigDecimal(0))!=0) {
					Venta = "Total de Tarjeta $" + TotalTarjeta.toString().replace(".",",");
					DatosVentas.add(Venta);					
				}
				
				TotalCuentaCorriente = new BigDecimal(rs3.getDouble("TotalCuentaCorriente"));
				TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
				if (TotalCuentaCorriente.compareTo(new BigDecimal(0))!=0) {
					Venta = "Total de Cuenta Corriente $" + TotalCuentaCorriente.toString().replace(".",",");
					DatosVentas.add(Venta);					
				}
				
				TotalOtroMetodoPago = new BigDecimal(rs3.getDouble("TotalOtroMetodoPago"));
				TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
				if (TotalOtroMetodoPago.compareTo(new BigDecimal(0))!=0) {
					Venta = "Total en Otros Pagos $" + TotalOtroMetodoPago.toString().replace(".",",");
					DatosVentas.add(Venta);					
				}
				
				Venta = "Cantidad de Ventas: " + rs3.getInt("CantidadVentas");
				DatosVentas.add(Venta);
				
				Cambio = new BigDecimal(rs3.getDouble("Cambio"));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				Venta = "Cambio $" + Cambio.toString().replace(".",",");
				DatosVentas.add(Venta);
				
				Venta = "---------------------------------------------------------";
				DatosVentas.add(Venta);*/
				
				if (x==1) {
					Venta = "Descripción De Las Ventas:";
					DatosVentas.add(Venta);
					x++;					
				}
				else {
					Venta = "---------------------------------------------------------";
					DatosVentas.add(Venta);
					Venta = "Descripción De Las Ventas De La Caja " + x + ":";
					DatosVentas.add(Venta);
					x++;					
				}
								
				CodigoCaja = rs3.getLong("CodigoCaja");
				qs = "select * from ventas where CodigoCaja = " + CodigoCaja + " order by CodigoVenta ASC";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				while (rs.next()) {
					Fecha = rs.getDate("Fecha").toString();
					Fecha = Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4);
					Venta = new String();
					Venta = Fecha + " - " + rs.getTime("Hora") + " - Venta Nro " + Integer.toString(rs.getInt("VentaNro"));

					// Cargo Nombre Del Cliente

					if (rs.getInt("CodigoCliente")>0) { 
						qs = "select * from clientes where CodigoCliente = " + rs.getInt("CodigoCliente");
						stmt = bdHosting.createStatement();
						rs1 = stmt.executeQuery(qs);
						if (rs1.next()) { Venta += " - " + rs1.getString("Nombre") + " " + rs1.getString("Apellido"); }
						else { Venta += " - (Código de Cliente Desconocido)"; }
					}

					// Indico Si Se Hizo Factura

					if (rs.getString("ticket_fiscal").compareTo("S")!=0) {				
						if (rs.getString("ticket_fiscal").compareTo("N")==0) { Venta += " (Asterisco)"; }
						else { 					
							qs = "select * from facturas where CodigoVenta = " + rs.getLong("CodigoVenta");
							stmt = connection.createStatement();
							rs1 = stmt.executeQuery(qs);
							if (rs1.next()) {
								if (rs.getString("ticket_fiscal").compareTo("A")==0) { Venta += " (Factura \"A\""; }
								else if (rs.getString("ticket_fiscal").compareTo("B")==0) { Venta += " (Factura \"B\""; }
								qs = "select razon_social from clientes where id = " + rs1.getInt("cliente_id");
								stmt = connection.createStatement();
								rs2 = stmt.executeQuery(qs);
								Venta += " Nro " + rs1.getLong("numero_factura");
								if (rs2.next()) { Venta += " - " + rs2.getString(1) + ")"; }
								else { Venta += ")"; }
							}
							else { Venta += " (Factura Sin Datos)"; }
						}				
					}					

					DatosVentas.add(Venta);
					qs = "select * from descripcionventas where CodigoVenta = " + rs.getLong(1);
					stmt = connection.createStatement();
					rs1 = stmt.executeQuery(qs);
					while (rs1.next()) {
						Venta = new String();
						Precio = new BigDecimal(rs1.getDouble(5));
						Precio = Precio.setScale(2, RoundingMode.HALF_UP);
						Producto = rs1.getString(3);
						if (Producto.compareTo("ENTREGASEÑA")==0) { Producto = "Entrega De Seña"; }
						else if (Producto.compareTo("PAGOCUENTA")==0) { Producto = "Pago De Cuenta Corriente"; }
						else if (Producto.compareTo("DESCUENTOCUENTA")==0) { Producto = "Descuento en el Pago del Saldo"; }
						else if (Producto.compareTo("DEVOLPRODUCTO")==0) { Producto = "Devolución de Producto a Cuenta"; }
						Venta = "  >  " + rs1.getInt(4) + ") " + Producto;
						if (rs1.getString(7).compareTo("S")==0) {
							qs = "select Descripcion from productos where CodigoProducto = \"" + rs1.getString(3) + "\"";
							stmt = connection.createStatement();
							rs2 = stmt.executeQuery(qs);																
							if (rs2.next()) { Venta += " - " + rs2.getString(1); }
						}
						Venta += " - $" + Precio.toString().replace(".",",");
						if (rs1.getString(6).compareTo("Entra")==0) { Venta += " (Devolución)"; }
						DatosVentas.add(Venta);
					}
					if (rs.getInt("CodigoCliente")>0) {
						qs = "select * from historialclientes where CodigoCliente = " + rs.getInt("CodigoCliente") + " and CodigoVenta = " + rs.getLong("CodigoVenta");
						stmt = bdHosting.createStatement();
						rs1 = stmt.executeQuery(qs);
						if (rs1.next()) { 					
							Saldo = new BigDecimal(rs1.getDouble("SaldoFinal"));
							Saldo = Saldo.setScale(2, RoundingMode.HALF_UP);
							Venta = "  >  Nuevo Saldo a La Fecha $" + Saldo.toString().replace(".",",");
						}
						else { Venta = "  >  Saldo Del Cliente Desconocido"; }
						DatosVentas.add(Venta);
					}
					if (rs.getDouble("Descuento")>0) {
						Descuento = new BigDecimal(rs.getDouble("Descuento"));
						Descuento = Descuento.setScale(2, RoundingMode.HALF_UP);
						DatosVentas.add("  >  Atención Especial - $" + Descuento.toString().replace(".",","));
					}
					if (rs.getDouble("Interes")>0) {
						Interes = new BigDecimal(rs.getDouble("Interes"));
						Interes = Interes.setScale(2, RoundingMode.HALF_UP);
						DatosVentas.add("  >  Interés En Venta - $" + Interes.toString().replace(".",","));
					}
					if (rs.getDouble("TotalTarjeta")>0) {
						Venta = new String();
						TotalTarjeta = new BigDecimal(rs.getDouble("TotalTarjeta"));
						TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
						Venta = "  >  Método Pago : Tarjeta $" + TotalTarjeta.toString().replace(".",",");
						DatosVentas.add(Venta);
						//					VariosPagos++;
					}
					if (rs.getDouble("TotalEfectivo")>0) {
						Venta = new String();
						TotalEfectivo = new BigDecimal(rs.getDouble("TotalEfectivo"));
						TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
						/*					if (VariosPagos==1) {
						Venta = "               >    Efectivo $" + rs.getInt("TotalEfectivo");
					} else {			*/			
						Venta = "  >  Método Pago : Efectivo $" + TotalEfectivo.toString().replace(".",",");
						//						VariosPagos++;
						//					}
						DatosVentas.add(Venta);
					}
					if (rs.getDouble("TotalCuentaCorriente")>0) {
						Venta = new String();
						TotalCuentaCorriente = new BigDecimal(rs.getDouble("TotalCuentaCorriente"));
						TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
						/*					if (VariosPagos==1) {
						Venta = "               >    Cuenta Corriente $" + rs.getInt("TotalCuentaCorriente");
					} else {*/
						Venta = "  >  Método Pago : Cuenta Corriente $" + TotalCuentaCorriente.toString().replace(".",",");
						//						VariosPagos++;
						//					}
						DatosVentas.add(Venta);
					}
					if (rs.getDouble("TotalOtroMetodoPago")>0) {
						Venta = new String();
						TotalOtroMetodoPago = new BigDecimal(rs.getDouble("TotalOtroMetodoPago"));
						TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
						/*					if (VariosPagos==1) {
						Venta = "  >    Otro Método de Pago $" + rs.getInt("TotalOtroMetodoPago");
					} else {*/
						Venta = "  >  Método Pago: Otro Método de Pago $" + TotalOtroMetodoPago.toString().replace(".",",");
						//					}
						DatosVentas.add(Venta);
					}		
					Venta = new String();
					TotalVenta = new BigDecimal(rs.getDouble("TotalVenta"));
					TotalVenta = TotalVenta.setScale(2, RoundingMode.HALF_UP);
					Venta = "  >  Total de Venta $" + TotalVenta.toString().replace(".",",");
					//				TotalVentas = TotalVentas + rs.getInt("TotalVenta");
					DatosVentas.add(Venta);
					//				VariosPagos = 0;
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			DatosVentas.clear();
			DatosVentas.add("ERROR///1550///");
			DatosVentas.add(sqle.getMessage());
			DatosVentas.add("ERROR///1550///");
			return DatosVentas;
		}
		return DatosVentas;
	}
	
	public LinkedList<String[]> ObtenerVentasPDF() {
		LinkedList<String[]> DatosVentas = new LinkedList<String[]>();
		ResultSet rs1,rs2;
		BigDecimal TotalVenta, TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago;
		String Venta, Producto;
		BigDecimal Precio, Descuento, Interes, Saldo;
		long Caja = 0;
		try {
			qs = "select CodigoCaja from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { Caja = rs.getLong(1); }
			qs = "select * from ventas where CodigoCaja = " + Caja;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) {
				String[] Datos = new String[6];
//				Venta = new String();
//				Venta = rs.getTime("Hora") + " - Venta " + Integer.toString(rs.getInt("VentaNro"));
				Datos[0] = Integer.toString(rs.getInt("VentaNro"));
				Datos[1] = rs.getTime("Hora").toString();
				Venta = "";
				qs = "select * from descripcionventas where CodigoVenta = " + rs.getLong(1);
				stmt = connection.createStatement();
				rs1 = stmt.executeQuery(qs);
				while (rs1.next()) {
					if (!Venta.isEmpty()) { Venta += "\n"; }
					Precio = new BigDecimal(rs1.getDouble(5));
					Precio = Precio.setScale(2, RoundingMode.HALF_UP);
					Producto = rs1.getString(3);
					if (Producto.compareTo("ENTREGASEÑA")==0) { Producto = "Entrega De Seña"; }
					else if (Producto.compareTo("PAGOCUENTA")==0) { Producto = "Pago De Cuenta Corriente"; }
					else if (Producto.compareTo("DESCUENTOCUENTA")==0) { Producto = "Descuento En El Pago Del Saldo"; }
					Venta += rs1.getInt(4) + ") " + Producto;
					if (rs1.getString(7).compareTo("S")==0) { 
						qs = "select Descripcion from productos where CodigoProducto = \"" + rs1.getString(3) + "\"";
						stmt = connection.createStatement();
						rs2 = stmt.executeQuery(qs);																
						if (rs2.next()) { Venta += " - " + rs2.getString(1); }
					}
					Venta += " - $" + Precio.toString().replace(".",",");
					if (rs1.getString(6).compareTo("Entra")==0) { Venta += " (Devolución)"; }
				}
				Datos[2] = Venta;
				if (rs.getDouble("Descuento")>0) {
					Descuento = new BigDecimal(rs.getDouble("Descuento"));
					Descuento = Descuento.setScale(2, RoundingMode.HALF_UP);
					Datos[2] += "\n>) Atención Especial $" + Descuento.toString().replace(".",",");
				}
				if (rs.getDouble("Interes")>0) {
					Interes = new BigDecimal(rs.getDouble("Interes"));
					Interes = Interes.setScale(2, RoundingMode.HALF_UP);
					Datos[2] += "\n>) Interés En Venta $" + Interes.toString().replace(".",",");
				}
				if (rs.getInt("CodigoCliente")>0) {
					qs = "select * from clientes where CodigoCliente = " + rs.getInt("CodigoCliente");
					stmt = bdHosting.createStatement();
					rs1 = stmt.executeQuery(qs);
					if (rs1.next()) { Datos[2] += "\n>) Nombre Cliente: " + rs1.getString("Nombre") + " " + rs1.getString("Apellido"); }
//					else { Venta += " - (Código de Cliente Desconocido)"; }
					qs = "select * from historialclientes where CodigoCliente = " + rs.getInt("CodigoCliente") + " and CodigoVenta = " + rs.getLong("CodigoVenta");
					stmt = bdHosting.createStatement();
					rs1 = stmt.executeQuery(qs);
					if (rs1.next()) { 					
						Saldo = new BigDecimal(rs1.getDouble("SaldoFinal"));
						Saldo = Saldo.setScale(2, RoundingMode.HALF_UP);
						Datos[2] += " - Saldo Actualizado $" + Saldo.toString().replace(".",",");
					}
					else { Datos[2] += " > Saldo Del Cliente, Desconocido"; }
//					DatosVentas.add(Venta);
				}
				TotalVenta = new BigDecimal(rs.getDouble("TotalVenta"));
				TotalVenta = TotalVenta.setScale(2, RoundingMode.HALF_UP);
				Datos[3] = "$" + TotalVenta.toString().replace(".",",");
				Datos[4] = "";
				if (rs.getDouble("TotalTarjeta")>0) {
					TotalTarjeta = new BigDecimal(rs.getDouble("TotalTarjeta"));
					TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
					if (TotalVenta.compareTo(TotalTarjeta)==0) { Datos[4] = "Tarjeta"; }
					else { Datos[4] = "Tarjeta $" + TotalTarjeta.toString().replace(".",","); }
//					DatosVentas.add(Venta);
//					VariosPagos++;
				}
				if (rs.getDouble("TotalEfectivo")>0) {
					TotalEfectivo = new BigDecimal(rs.getDouble("TotalEfectivo"));
					TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
					if (!Datos[4].isEmpty()) { Datos[4] += "\nEfectivo $" + TotalEfectivo.toString().replace(".",","); }
					else if (TotalVenta.compareTo(TotalEfectivo)==0) { Datos[4] = "Efectivo"; }
					else { Datos[4] += "Efectivo $" + TotalEfectivo.toString().replace(".",","); }
//					DatosVentas.add(Venta);
				}
				if (rs.getDouble("TotalCuentaCorriente")>0) {
					TotalCuentaCorriente = new BigDecimal(rs.getDouble("TotalCuentaCorriente"));
					TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
					if (!Datos[4].isEmpty()) { Datos[4] += "\nCuenta Corriente $" + TotalCuentaCorriente.toString().replace(".",","); }
					else if (TotalVenta.compareTo(TotalCuentaCorriente)==0) { Datos[4] = "Cuenta Corriente"; }
					else { Datos[4] += "Cuenta Corriente $" + TotalCuentaCorriente.toString().replace(".",","); }
//					DatosVentas.add(Venta);
				}
				if (rs.getDouble("TotalOtroMetodoPago")>0) {
					TotalOtroMetodoPago = new BigDecimal(rs.getDouble("TotalOtroMetodoPago"));
					TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
					if (!Datos[4].isEmpty()) { Datos[4] += "\nOtro Método de Pago $" + TotalOtroMetodoPago.toString().replace(".",","); }
					else if (TotalVenta.compareTo(TotalOtroMetodoPago)==0) { Datos[4] = "Otro Método de Pago"; }
					else { Datos[4] += "Otro Método de Pago $" + TotalOtroMetodoPago.toString().replace(".",","); }
//					}
//					DatosVentas.add(Venta);
				}
				String Ticket = rs.getString("ticket_fiscal");
				if (Ticket.compareTo("S")==0) { Datos[5] = "Factura B"; }
				else if (Ticket.compareTo("N")==0) { Datos[5] = "Asterisco"; }
				else if (Ticket.compareTo("A")==0) { Datos[5] = "Factura A"; }
				DatosVentas.add(Datos);
//				VariosPagos = 0;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			DatosVentas.clear();
//			DatosVentas.add("ERROR///1550///"); ver esto si lo puedo arreglar
//			DatosVentas.add(sqle.getMessage());
//			DatosVentas.add("ERROR///1550///");
			return DatosVentas;
		}
		return DatosVentas;
	}
	
	public int VerCajaAbierta() {
		try {
			qs = "select CodigoCaja from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getInt(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	public boolean VerificoClientesEnVentas(String Fecha) { // Sirve Para Ver Si Hay Clientes Asociados En Ventas Realizadas Para Entonces Cargar Datos de Clientes y Mostrar
		try {
			qs = "select CodigoCaja from cajas where Fecha = \"" + Fecha + "\" order by CodigoCaja DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) {
				qs = "select sum(CodigoCliente) from ventas where CodigoCaja = " + rs.getLong(1);
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				if (rs.next()) { if (rs.getInt(1)>0) return true; }				
			}		
			return false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}
	
	public LinkedList<String> ObtenerVentasTotales() {
		LinkedList<String> DatosVentas = new LinkedList<String>();
		BigDecimal TotalVenta, TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago, GastosExtras, TotalCaja, Cambio;
		TotalVenta = TotalEfectivo = TotalTarjeta = TotalCuentaCorriente = TotalOtroMetodoPago = GastosExtras = TotalCaja = Cambio = null;
		int CodigoCaja = 0;
		String Venta = new String();
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				CodigoCaja = rs.getInt("CodigoCaja");
				TotalEfectivo = new BigDecimal(rs.getDouble("TotalEfectivo"));
				TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
				TotalTarjeta = new BigDecimal(rs.getDouble("TotalTarjeta"));
				TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
				TotalCuentaCorriente = new BigDecimal(rs.getDouble("TotalCuentaCorriente"));
				TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
				TotalOtroMetodoPago = new BigDecimal(rs.getDouble("TotalOtroMetodoPago"));
				TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
				GastosExtras = new BigDecimal(rs.getDouble("GastosExtras"));
				GastosExtras = GastosExtras.setScale(2, RoundingMode.HALF_UP);
				Cambio = new BigDecimal(rs.getDouble("Cambio"));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				TotalCaja = new BigDecimal(rs.getDouble("TotalVentas"));
				TotalCaja = TotalCaja.setScale(2, RoundingMode.HALF_UP);
			}
			else { return DatosVentas; }
			qs = "select * from ventas where CodigoCaja = " + CodigoCaja ;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			int Contador = 1;
			String Moneda = " $";
			while (rs.next()) {
				TotalVenta = new BigDecimal(rs.getDouble("TotalVenta"));
				TotalVenta = TotalVenta.setScale(2, RoundingMode.HALF_UP);			
				if (Contador<10) { Venta = rs.getString("Hora") + " - Venta Nro 0"; }
				else { Venta = rs.getString("Hora") + " - Venta Nro "; }
				Venta += Integer.toString(rs.getInt("VentaNro")) + Moneda + TotalVenta.toString().replace(".", ",");
				DatosVentas.add(Venta);
				Contador++;
				
			}
			DatosVentas.add("Totales");
			DatosVentas.add(TotalEfectivo.toString());
			DatosVentas.add(TotalTarjeta.toString());
			DatosVentas.add(TotalCuentaCorriente.toString());
			DatosVentas.add(TotalOtroMetodoPago.toString());
			DatosVentas.add(GastosExtras.toString());
			DatosVentas.add(Cambio.toString());
			DatosVentas.add(TotalCaja.toString());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			DatosVentas.clear();
			DatosVentas.add("ERROR///1560///");
			DatosVentas.add(sqle.getMessage());
			DatosVentas.add("ERROR///1560///");
			return DatosVentas;
		}
		return DatosVentas;
	}
	
//	public String BuscoVentas(CDatos Datos) {;}
	
	public int AlmacenoVenta(long CodigoVenta, String Vendedora, BigDecimal Total, String Fecha, String Hora, int ProdVendidos, CColaPagos ColaPagos, int Cobrador, BigDecimal Descuento, BigDecimal Interes, int CodigoCliente) {
		int CantProdVendidos, CantidadVentas, Contador, CodigoCaja;
		String ticketFiscal;
		CantProdVendidos = CantidadVentas = Contador = CodigoCaja = 0;
		BigDecimal TotalTarjeta, TotalEfectivo, TotalCuentaCorriente, TotalOtroMetodoPago, Temporal;
		TotalTarjeta = TotalEfectivo = TotalCuentaCorriente = TotalOtroMetodoPago = Temporal = new BigDecimal(0);
		TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
		TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
		TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
		TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
		Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
		CPagos Pagos;
		if (Cobrador==0) { ticketFiscal = "S"; }
		else if (Cobrador == 1) { ticketFiscal = "N"; }
		else { ticketFiscal = "A"; }
		while (Contador < ColaPagos.TamañoCola()) {
			Pagos = ColaPagos.Obtener(Contador);
			if (Pagos.ObtenerMetodoPago().compareTo("Tarjeta")==0) { TotalTarjeta = TotalTarjeta.add(Pagos.ObtenerPrecio()); }
			else if (Pagos.ObtenerMetodoPago().compareTo("Efectivo")==0) { TotalEfectivo = TotalEfectivo.add(Pagos.ObtenerPrecio()); }
			else if (Pagos.ObtenerMetodoPago().compareTo("A Cuenta")==0) { TotalCuentaCorriente = TotalCuentaCorriente.add(Pagos.ObtenerPrecio()); }
			else if (Pagos.ObtenerMetodoPago().compareTo("Otros")==0) { TotalOtroMetodoPago = TotalOtroMetodoPago.add(Pagos.ObtenerPrecio()); }
			Contador++;
		}
		try {
			qs = "select CodigoCaja from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { CodigoCaja = rs.getInt(1); }
			CVenta = CodigoVenta;
			qs = "insert into ventas values (" + CodigoVenta + ",\"" + Fecha + "\",\"" + Hora + "\"," + VentaNro + ",\"" + Vendedora + "\"," + ProdVendidos + "," +
					Total + "," + TotalTarjeta + "," + TotalEfectivo + "," + TotalCuentaCorriente + "," + TotalOtroMetodoPago + ",\"" + ticketFiscal + "\"," +
							Descuento + "," + Interes + "," + CodigoCliente + "," + CodigoCaja + ")";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) { return 2; }
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				CantProdVendidos = rs.getInt(3) + ProdVendidos;
				Temporal = new BigDecimal(rs.getDouble(4));
				Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
				TotalEfectivo = TotalEfectivo.add(Temporal);
				Temporal = new BigDecimal(rs.getDouble(5));
				Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
				TotalTarjeta = TotalTarjeta.add(Temporal);
				Temporal = new BigDecimal(rs.getDouble(6));
				Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
				TotalCuentaCorriente = TotalCuentaCorriente.add(Temporal);
				Temporal = new BigDecimal(rs.getDouble(7));
				Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
				TotalOtroMetodoPago = TotalOtroMetodoPago.add(Temporal);
				Temporal = new BigDecimal(rs.getDouble(8));
				Temporal = Temporal.setScale(2, RoundingMode.HALF_UP);
				Total = Total.add(Temporal);
				CantidadVentas = rs.getInt(9) + 1;
			}		
			qs = "update cajas set CantProdVendidos = " + CantProdVendidos + ", TotalEfectivo = " + TotalEfectivo + ", TotalTarjeta = " + TotalTarjeta +
				 ", TotalCuentaCorriente = " + TotalCuentaCorriente + ", TotalOtroMetodoPago = " + TotalOtroMetodoPago + ", TotalVentas = " + Total + 
				 ", CantidadVentas = " + CantidadVentas + " where EstadoCaja = \"A\"";
			//" where Fecha = \"" + Fecha + "\" and EstadoCaja = \"A\"";
        	stmt = connection.createStatement();
            Resultado = stmt.executeUpdate(qs);
            if (Resultado != 1 ) {
            	System.out.println("BD : Resultado BD: " + Resultado);            	
            	System.out.println("BD : Error Al Cargar Datos en BD - Tabla \"cajas\"");
            	return 3;
            }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
		VentaNro++;
		return 0;
	}
	
	public int ObtenerVentaNro() { return VentaNro; }
	

	
/*	public void AlmacenoDescripcionVenta(int CodigoVenta, CColaDatos ColaDatos, String Vendedora, int Total, String Fecha, int VentaNro, int CantProd) {
		while (!ColaDatos.EstaVacio()) {
    	  	Datos = null;
			Datos = ColaDatos.Sacar();
    	  	System.out.println("CBaseDatos");
    		System.out.println("Tamaño: " + ColaDatos.TamañoCola());
        	System.out.println("Datos1: " + Datos.ObtenerProdNro());
        	System.out.println("Datos1: " + Datos.ObtenerCodigoProducto());  
        	System.out.println("Datos1: " + Datos.ObtenerPrecio());  
        	System.out.println("Datos1: " + Datos.ObtenerMetodoPago());  
        	System.out.println("Datos1: " + Datos.ObtenerMoneda());  
			try {
				qs = "insert into descripcionventas values (" + CodigoVenta + "," + Datos.ObtenerProdNro() + ",\"" + Datos.ObtenerCodigoProducto() + "\","
				+ Datos.ObtenerPrecio() + ",\"" + Datos.ObtenerMetodoPago() + "\",\"" + Datos.ObtenerMoneda() + "\")";
	        	stmt = connection.createStatement();
	            Resultado = stmt.executeUpdate(qs);
	            if (Resultado != 1 ) {
	            	System.out.println("BD : Resultado BD: " + Resultado);            	
	            	System.out.println("BD : Error Al Cargar Datos en BD - Tabla \"ventas\"");
	            }
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
//		Datos.Limpiar();
	}*/
	
	public int AlmacenoDescripcionVenta(long CodigoDescripcionVenta, long CodigoVenta, CDatos Datos, boolean Seña) {
		int ProductoNro;
		ProductoNro = Datos.ObtenerProdNro();
		//			else { ProductoNro = 1; }
		try {
			qs = "insert into descripcionventas values (" + CodigoDescripcionVenta + "," + CodigoVenta + ",\"" + Datos.ObtenerCodigoProducto() + "\"," + ProductoNro + ","
			+ Datos.ObtenerPrecio() + ",\"" + Datos.ObtenerStock() + "\",\"" + Datos.ObtenerCargadoStock() + "\")";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) {
				System.out.println("BD : Resultado BD: " + Resultado);            	
				System.out.println("BD : Error Al Cargar Datos en BD - Tabla \"ventas\"");
				return 5;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 4;
		}
		return 0;
	}		
	
	public String AbrirCaja(String Cambio) { 
		String Fecha = Nucleo.CrearFechaInverso();
		int CodigoCaja;	
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (!rs.next()) {
				qs = "select * from cajas where Fecha = \"" + Fecha + "\" order by CodigoCaja DESC";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				if (!rs.next()) { CodigoCaja = Integer.parseInt(Fecha.replace("/","") + "01"); }
				else { CodigoCaja = rs.getInt("CodigoCaja") + 1; }
				qs = "insert into cajas values (" + CodigoCaja + ",\"" + Fecha + "\",0,0,0,0,0,0,0," + Cambio + ",0,\"A\",0)";
				stmt = connection.createStatement();
				Resultado = stmt.executeUpdate(qs);
				if (Resultado != 1 ) { return "2"; }
				else { VentaNro = 1; }
			}
			else if (rs.getDate(1).toString().replace("-","/").compareTo(Fecha)==0) { return "1"; }
			else { return rs.getDate(1).toString().replace("-","/"); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return "0";
	}
	
	public String VerificarCajaAbierta() { 
		String Fecha = Nucleo.CrearFechaInverso();
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				if (rs.getDate(1).toString().replace("-","/").compareTo(Fecha)==0) { return "1"; }
				else { return rs.getDate(1).toString().replace("-","/"); }
			}			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return "0";
	}
	
	public int AgregarGastos(String Descripcion, String Monto) { 
		String Fecha = Nucleo.CrearFechaInverso();
		String Hora = Nucleo.CrearHora();
		BigDecimal Gastos, Valor, TotalEfectivo, Cambio;
		int CodigoGasto, CodigoCaja;
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				CodigoCaja = rs.getInt("CodigoCaja");
				TotalEfectivo = new BigDecimal(rs.getDouble("TotalEfectivo"));
				TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
				Cambio = new BigDecimal(rs.getDouble("Cambio"));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				Gastos = new BigDecimal(rs.getDouble("GastosExtras"));
				Gastos = Gastos.setScale(2, RoundingMode.HALF_UP);
				TotalEfectivo = TotalEfectivo.add(Cambio);
				TotalEfectivo = TotalEfectivo.subtract(Gastos);
				Valor = new BigDecimal(Monto);
				Valor = Valor.setScale(2, RoundingMode.HALF_UP);
				if (TotalEfectivo.compareTo(Valor)>=0) {
					Gastos = Gastos.add(Valor);
					qs = "update cajas set GastosExtras = " + Gastos + " where EstadoCaja = \"A\"";
		        	stmt = connection.createStatement();
		            Resultado = stmt.executeUpdate(qs);
		            if (Resultado != 1 ) { return 2; }
					qs = "select * from gastos where CodigoCaja = " + CodigoCaja + " order by CodigoGasto DESC";
					stmt = connection.createStatement();
					rs = stmt.executeQuery(qs);
					if (!rs.next()) { CodigoGasto = Integer.parseInt(Fecha.replace("/","") + "01"); }
					else { CodigoGasto = rs.getInt(1) + 1; }
					qs = "insert into gastos values (" + CodigoGasto + ",\"" + Fecha + "\",\"" + Hora +"\"," + CodigoCaja + ",\"" + Descripcion + "\"," + Valor + ")";
					stmt = connection.createStatement();
					Resultado = stmt.executeUpdate(qs);
		            if (Resultado != 1 ) { return 2; }					
				}
				else { return 3; }
	        }
			else { return 1; }
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return 0;
	}
	
  	public int CerrarCaja(String CambioProxCaja) {
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				BigDecimal Cambio = new BigDecimal(CambioProxCaja.replace(",","."));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				qs = "update cajas set EstadoCaja = \"C\", cambio_prox_caja = " + Cambio + " where EstadoCaja = \"A\"";
	        	stmt = connection.createStatement();
	            Resultado = stmt.executeUpdate(qs);
	            if (Resultado != 1 ) {
	            	System.out.println("BD : Resultado BD: " + Resultado);            	
	            	System.out.println("BD : Error Al Cargar Datos en BD - Tabla \"cajas\"");
	            }
	            else { return 0; }
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 1;
	}
  	
  	// Verifico Si La Caja Se Encuentra Abierta O Cerrada
  	
    public boolean CajaAbierta() { 
//		String Fecha = Nucleo.CrearFechaInverso();
//		qs = "select * from cajas where Fecha = \"" + Fecha + "\" and EstadoCaja = \"A\"";
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return true; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
    }
    
/*    public BigDecimal ObtenerCambio() {
		BigDecimal Cambio;
		try {
			qs = "select Cambio from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				Cambio = new BigDecimal(rs.getDouble(1));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				return Cambio;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
    }*/

/*  public BigDecimal ObtenerGastosExtras() {
		BigDecimal GastosExtras;
		try {
			qs = "select GastosExtras from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				GastosExtras = new BigDecimal(rs.getDouble(1));
				GastosExtras = GastosExtras.setScale(2, RoundingMode.HALF_UP);
				return GastosExtras;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
    }*/    
    
    public int IngresarProducto(String CodigoProducto, String Descripcion, int Cantidad, BigDecimal Precio, String Rubro, String Temporada, String Material, String Color, String Talle, String Marca, String Auditor, String TipoTalle) {
    	String Fecha = Nucleo.CrearFechaInverso();
    	int NuevaCantidad;
    	String Numeracion;
    	Numeracion = CodigoProducto.substring(3,10);
    	if (Talle.compareTo("Único")==0) { Descripcion = Rubro + " " + Material + " " + Color + " - " + Marca; }
    	else { 
    		if (Rubro.compareTo("Bijoux")==0) { Descripcion = Rubro + " " + Material + " " + Color + " Juego " + Talle + " - " + Marca; }
    		else { 
    			if (Local <2) { Descripcion = Rubro + " " + Material + " " + Color + " Talle " + Talle + " - " + Marca; }
    			else {
    				if (Talle.contains("\"")) { Talle = Talle.substring(0, Talle.length()-1) + "\\\""; }
    				if (TipoTalle.compareTo("Z")==0 || TipoTalle.compareTo("C")==0 || TipoTalle.compareTo("R")==0 || TipoTalle.compareTo("G")==0) {
    					Descripcion = Rubro + " " + Material + " " + Color + " Talle " + Talle + " - " + Marca;
    				}
    				else { Descripcion = Rubro + " " + Material + " " + Color + " " + Talle + " - " + Marca; }
    			}
    		}
    	}
    	Rubro = BuscarRubroPorDescripcion(Rubro);
    	Marca = BuscarMarcaPorDescripcion(Marca);
    	Material = BuscarMaterialPorDescripcion(Material);
    	Color = BuscarColorPorDescripcion(Color);
    	Talle = BuscarTallePorDescripcion(Talle,TipoTalle);
    	Temporada = BuscarTemporadaPorDescripcion(Temporada);
    	Auditor = BuscarAuditorPorDescripcion(Auditor);
    	
    	try {
			qs = "select Cantidad from productos where CodigoProducto = \"" + CodigoProducto + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				NuevaCantidad = rs.getInt(1) + Cantidad;
				qs = "update productos set Cantidad = " + NuevaCantidad + ", Precio = " + Precio + ", Temporada = \"" + Temporada + "\", FechaIngreso = \"" + Fecha + "\" where CodigoProducto = \"" + CodigoProducto + "\"";
				stmt = connection.createStatement();
				Resultado = stmt.executeUpdate(qs);
			}
			else {
				qs = "insert into productos values (\"" + CodigoProducto + "\",\"" + Descripcion + "\"," + Precio + "," + Cantidad + ",\"" + Temporada + "\",\"" + Fecha + "\",\"" + Rubro + "\",\"" + Numeracion + "\",\"" + Marca + "\",\"" + Material + "\",\"" + Color + "\",\"" + Talle + "\",\"" + Auditor + "\")";
				stmt = connection.createStatement();
				Resultado = stmt.executeUpdate(qs);				
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}    	
		if (Resultado == 1 ) { return 0; }
		else { return 1; }
    }

    public LinkedList<String> BuscarProducto(String CodigoProducto) {
    	LinkedList<String> Producto = new LinkedList<String>();
    	String Precio, Decimal;
    	try {
    		qs = "select * from productos where CodigoProducto = \"" + CodigoProducto + "\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				Producto.add(rs.getString("Descripcion"));
				Precio = Double.toString(rs.getDouble("Precio"));
				if (Precio.contains(".")) { Precio = Precio.replace('.', ','); }
				Decimal = Precio.substring(Precio.indexOf(',')+1, Precio.length());
				if (Decimal.length()<2) { Precio = Precio.concat("0"); }
				Producto.add(Precio);
				Producto.add(Integer.toString(rs.getInt("Cantidad")));
				return Producto;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
    }
    
    public LinkedList<String> BuscarProductoParaVenta(String CodigoProducto) {
    	LinkedList<String> Producto = new LinkedList<String>();
    	BigDecimal Precio;
    	try {
    		qs = "select * from productos where CodigoProducto = \"" + CodigoProducto + "\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				Precio = new BigDecimal(rs.getDouble("Precio"));
				Precio = Precio.setScale(2, RoundingMode.HALF_UP);
				Producto.add(rs.getString("Descripcion"));
//				Producto.add(Integer.toString(rs.getInt(4)));
				Producto.add(Precio.toString());
				Producto.add(rs.getString("Cantidad"));
//				Producto.add(rs.getString(6));
				return Producto;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
    }
      
    /** 
     * public int ModificoPrecioProducto
     * @param CodigoProducto
     * @param Precio
     * @return 0 = Precio Modificado, return 1 = Error En BD, return 2 = No se Actualizo la Tabla, return 3 = No Existe el Codigo del Producto
     */
    
    public String ModificoPrecioProducto(String CodigoProducto, BigDecimal Precio) {
     	BigDecimal PrecioActual;
    	try {
    		qs = "select Precio from productos where CodigoProducto = \"" + CodigoProducto + "\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {						
				PrecioActual = new BigDecimal(rs.getDouble(1));
				PrecioActual = PrecioActual.setScale(2, RoundingMode.HALF_UP);
				if (Precio.compareTo(PrecioActual)!=0) {
					qs = "update productos set Precio = " + Precio + " where CodigoProducto = \"" + CodigoProducto + "\"";
					stmt = connection.createStatement();
					Resultado = stmt.executeUpdate(qs);
					if (Resultado == 1) {
				     	long CodigoHistorial;
				     	String Fecha = Nucleo.CrearFechaInverso();
						String Hora = Nucleo.CrearHora();
			    		qs = "select * from historialproductos where Fecha = \"" + Fecha + "\" order by CodigoHistorial DESC" ;
						stmt = connection.createStatement();
						rs = stmt.executeQuery(qs);
						if (rs.next()) { CodigoHistorial = rs.getLong("CodigoHistorial") + 1; }
						else {
							String Temp = Fecha.substring(0,4) + Fecha.substring(5,7) + Fecha.substring(8,10) + "0001";
							CodigoHistorial = Long.parseLong(Temp);
						}
						qs = "insert into historialproductos values (" + CodigoHistorial + ",\"" + CodigoProducto + "\",\"" + Fecha + "\",\"" + Hora + "\"," + PrecioActual + "," + Precio + ")";
						stmt = connection.createStatement();
						Resultado = stmt.executeUpdate(qs);
						if (Resultado != 1 ) { return "No Se Ingresó la Modificación del Precio en el Historial"; }
					}
				}
			}
			else { return "No Se Encontró el Producto en la Base de Datos"; }		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return "Error al Actualizar el Precio del Producto (1610)";
		}    	
		if (Resultado == 1 ) { return ""; }
		else { return "No Se Actualizó el Precio del Producto"; }
    }
           
    public int ActualizoStock(LinkedList<String> Productos) throws SQLException {
    	int Cantidad;
		int Nuevos = 0;
    	while (!Productos.isEmpty()) {
    		String CodigoProducto = Productos.remove().toString();
    		if (CodigoProducto.length()==15 && CodigoProducto.startsWith("P")) {
        		try {
            		qs = "select Cantidad from productos where CodigoProducto = \"" + CodigoProducto + "\""; 
        			stmt = connection.createStatement();
        			rs = stmt.executeQuery(qs);
        			if (rs.next()) { 
        				Cantidad = rs.getInt(1) - 1;
       					qs = "update productos set Cantidad = " + Cantidad + " where CodigoProducto = \"" + CodigoProducto + "\"";
      					stmt = connection.createStatement();
        				Resultado = stmt.executeUpdate(qs);
        				if (Resultado==0) { return -1; }
        			}
        			else {
        				qs = "insert into productos values (\"" + CodigoProducto + "\",\"" + null + "\",0,-1,now())";
        				stmt = connection.createStatement();
        				Resultado = stmt.executeUpdate(qs);
       					if (Resultado==0) { return -1; }
       					else if (Resultado==1) { Nuevos++; }        				
        			}
        		} catch (SQLException sqle) {
        			sqle.printStackTrace();
        			return -1;
        		}    			
    		}
    	}
    	return Nuevos;
    }
    
    public int ActualizoStockEntrada(LinkedList<String[]> Productos) throws SQLException {
		int Cantidad;
		int Nuevos = 0;
    	while (!Productos.isEmpty()) {
			String[] DatosProducto = Productos.remove();    		 
    		if (DatosProducto[0].length()==15 && DatosProducto[0].startsWith("P")) {
        		try {
            		qs = "select Cantidad from productos where CodigoProducto = \"" + DatosProducto[0] + "\""; 
        			stmt = connection.createStatement();
        			rs = stmt.executeQuery(qs);
        			if (rs.next()) { 
        				Cantidad = rs.getInt(1) + 1;
       					qs = "update productos set Cantidad = " + Cantidad + " where CodigoProducto = \"" + DatosProducto[0] + "\"";
       					stmt = connection.createStatement();
       					Resultado = stmt.executeUpdate(qs);
       					if (Resultado==0) { return -1; }
        			}
        			else {
        				BigDecimal Precio = new BigDecimal(DatosProducto[1]);
        				Precio = Precio.setScale(2, RoundingMode.HALF_UP);
        				qs = "insert into productos values (\"" + DatosProducto[0] + "\",\"" + null + "\"," + Precio + "," + 1 + ",now())";
        				stmt = connection.createStatement();
        				Resultado = stmt.executeUpdate(qs);
       					if (Resultado==0) { return -1; }
       					else if (Resultado==1) { Nuevos++; }
        			}
        		} catch (SQLException sqle) {
        			sqle.printStackTrace();
        			return -1;
        		}    			
    		}
    	}
    	return Nuevos;
    }
    
    public void ReingresoProducto(String Producto) throws SQLException {
    	int Cantidad;
    	if (Producto.length()==15) {
    		try {
    			qs = "select Cantidad from productos where CodigoProducto = \"" + Producto + "\""; 
    			stmt = connection.createStatement();
    			rs = stmt.executeQuery(qs);
    			if (rs.next()) { 
    				Cantidad = rs.getInt(1) + 1;
    				qs = "update productos set Cantidad = " + Cantidad + " where CodigoProducto = \"" + Producto + "\"";
    				stmt = connection.createStatement();
    				Resultado = stmt.executeUpdate(qs);    					
    			}
    		} catch (SQLException sqle) {
    			sqle.printStackTrace();
    		}    			
    	}
    }
    
    public LinkedList<String> BuscarProducto(int Flag, String Prod, String Rubro, int Precio1, int Precio2, int Cantidad, String Marca) {
		LinkedList<String> ListaProd = new LinkedList<String>();
		if (!Rubro.isEmpty() || !Marca.isEmpty()) {
			try {
				if (!Rubro.isEmpty()) {
					qs = "select Codigo from Rubros where Descripcion = \"" + Rubro + "\"";
					stmt = connection.createStatement();
					rs = stmt.executeQuery(qs);
					if (rs.next()) { Rubro = rs.getString(1); } 
				}
				if (!Marca.isEmpty()) {
					qs = "select Codigo from Marcas where Descripcion = \"" + Marca + "\"";
					stmt = connection.createStatement();
					rs = stmt.executeQuery(qs);
					if (rs.next()) { Marca = rs.getString(1); } 
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}			
		}
		qs = "";
		BigDecimal Precio;
		if (Prod.length()==0) { Prod = ""; }
		else { Prod = Prod.toUpperCase(); }
		if (Flag == 1 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%'"; }
		else if (Flag == 10) { qs = "select * from productos where Rubro = \"" + Rubro + "\""; }
		else if (Flag == 11 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Rubro = \"" + Rubro + "\""; }
		else if (Flag == 100) { qs = "select * from productos where Precio >= " + Precio1 + " and Precio <= " + Precio2; }
		else if (Flag == 101 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Precio >= " + Precio1 + " and Precio <= " + Precio2; }
		else if (Flag == 110) { qs = "select * from productos where Rubro = \"" + Rubro + "\" and Precio >= " + Precio1 + " and Precio <= " + Precio2; } 
		else if (Flag == 111 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Rubro = \"" + Rubro + "\" and Precio >= " + Precio1 + " and Precio <= " + Precio2; }
		else if (Flag == 1000) { qs = "select * from productos where Cantidad = " + Cantidad; }
		else if (Flag == 1001 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and CodigoProducto like '%" + Prod + "%'"; }
		else if (Flag == 1010) { qs = "select * from productos where Cantidad = " + Cantidad + " and Rubro = \"" + Rubro + "\""; }
	    else if (Flag == 1011 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Rubro = \"" + Rubro + "\" and CodigoProducto like '%" + Prod + "%'"; }
		else if (Flag == 1100) { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2; }
		else if (Flag == 1101 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and CodigoProducto like '%" + Prod + "%'"; }
		else if (Flag == 1110) { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Rubro = \"" + Rubro + "\""; }
		else if (Flag == 1111 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Rubro = \"" + Rubro + "\" and CodigoProducto like '%" + Prod + "%'"; }
		else if (Flag == 10000) { qs = "select * from productos where Marca = \"" + Marca + "\""; }
		else if (Flag == 10001 && Prod != "") {  qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Marca = \"" + Marca + "\""; }
		else if (Flag == 10010) { qs = "select * from productos where Rubro = \"" + Rubro + "\" and Marca = \"" + Marca + "\""; }
		else if (Flag == 10011 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Rubro = \"" + Rubro + "\" and Marca = \"" + Marca + "\""; }
		else if (Flag == 10100) { qs = "select * from productos where Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Marca = \"" + Marca + "\""; }
		else if (Flag == 10101 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Marca = \"" + Marca + "\""; }		
		else if (Flag == 10110) { qs = "select * from productos where Rubro = \"" + Rubro + "\" and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Marca = \"" + Marca + "\""; }
		else if (Flag == 10111 && Prod != "") { qs = "select * from productos where CodigoProducto like '%" + Prod + "%' and Rubro = \"" + Rubro + "\" and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Marca = \"" + Marca + "\""; }
		else if (Flag == 11000) { qs = "select * from productos where Cantidad = " + Cantidad + " and Marca = \"" + Marca + "\""; }
		else if (Flag == 11001 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and CodigoProducto like '%" + Prod + "%' and Marca = \"" + Marca + "\""; }
		else if (Flag == 11010) { qs = "select * from productos where Cantidad = " + Cantidad + " and Rubro = \"" + Rubro + "\" and Marca = \"" + Marca + "\""; }
		else if (Flag == 11011 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Rubro = \"" + Rubro + "\" and CodigoProducto like '%" + Prod + "%' and Marca = \"" + Marca + "\""; }
		else if (Flag == 11100) { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Marca = \"" + Marca + "\""; }
		else if (Flag == 11101 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and CodigoProducto like '%" + Prod + "%' and Marca = \"" + Marca + "\""; }
		else if (Flag == 11110) { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Rubro = \"" + Rubro + "\" and Marca = \"" + Marca + "\""; }
		else if (Flag == 11111 && Prod != "") { qs = "select * from productos where Cantidad = " + Cantidad + " and Precio >= " + Precio1 + " and Precio <= " + Precio2 + " and Rubro = \"" + Rubro + "\" and CodigoProducto like '%" + Prod + "%' and Marca = \"" + Marca + "\""; }
		if (qs!="") {
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				while (rs.next()) { 
//					String Datos;
					Precio = new BigDecimal(rs.getDouble(3));
					Precio = Precio.setScale(2, RoundingMode.HALF_UP);
					ListaProd.add(rs.getString(1));
					ListaProd.add(rs.getString("Descripcion"));
					ListaProd.add("$" + Precio.toString().replace(".",","));
					ListaProd.add(Integer.toString(rs.getInt(4)));
//					Datos = rs.getString(1) + " - " + rs.getString("Descripcion") + " - $ " + Precio.toString().replace(".",",")  + " - Cant: " + rs.getInt(4);
//					Datos = rs.getString(1) + " - $ " + Precio.toString().replace(".",",")  + " - Cant: " + rs.getInt(4) + " - " + rs.getString(5) + " - " + rs.getString(2) + " - Temporada: " + rs.getString(6) + " - Fecha Ingreso: " + rs.getString(7);
//					ListaProd.add(Datos);
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}	
		}
		return ListaProd;
	}
    
    public LinkedList<String> BuscarRubros() {
    	LinkedList<String> Rubro = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from rubros order by Descripcion ASC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Rubro.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Rubro;
    }
    
    public LinkedList<String> BuscarMateriales() {
    	LinkedList<String> Material = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from materiales order by Descripcion ASC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Material.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Material;
    }
    
    public LinkedList<String> BuscarColores() {
    	LinkedList<String> Color = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from colores order by Descripcion ASC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Color.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Color;
    }
    
    public LinkedList<String> BuscarTalles(String TipoTalle) {
    	LinkedList<String> Talle = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from talles where left(Codigo,1) = \"" + TipoTalle + "\" order by Codigo ASC";
//    		qs = "select Descripcion from talles where Codigo like '%" + TipoTalle + "%'";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Talle.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Talle.add("///ERROR///");
			return Talle;
		}
		return Talle;
    }
    
    public LinkedList<String> BuscarMarcas() {
    	LinkedList<String> Marca = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from marcas";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Marca.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Marca;
    }
    
    public LinkedList<String> BuscarTemporadas() {
    	LinkedList<String> Temporada = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from temporadas order by Codigo Desc;";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Temporada.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Temporada;
    }
    
    public LinkedList<String> BuscarAuditores() {
    	LinkedList<String> Auditores = new LinkedList<String>();
    	try {
    		qs = "select Descripcion from auditores;";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Auditores.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Auditores;
    }
    
    public LinkedList<Object[]> BuscarClientes() { // MODIF 16-11-10
    	LinkedList<Object[]> Clientes = new LinkedList<Object[]>();

    	String Nombre = "";
    	try {
    		qs = "select * from clientes order by Nombre ASC;";
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) {
		    	Object Datos[] = new Object[2];
				Nombre = rs.getString(2) + " " + rs.getString(3);
				Datos[0] = (String) Nombre;
				Datos[1] = (int) rs.getInt("CodigoCliente");
				Clientes.add(Datos);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Clientes;
    }
    
    public LinkedList<String> BuscarVendedoras() {
    	LinkedList<String> Rubro = new LinkedList<String>();
    	try {
    		qs = "select * from vendedoras";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Rubro.add(rs.getString("Nombre") + " " + rs.getString("Apellido")); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Rubro;
    }
    
    public LinkedList<String> BuscarTiposTalles() {
    	LinkedList<String> Tipos = new LinkedList<String>();
    	try {
    		qs = "select LEFT(Codigo,1) from talles group by LEFT(Codigo,1)";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Tipos.add(rs.getString(1)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Tipos;
    }
    
    public String BuscarRubroPorCodigo(String CodigoRubro) {
    	String Rubro = "";
    	try {
    		qs = "select Descripcion from rubros where Codigo = \"" + CodigoRubro + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Rubro = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Rubro;
    }
    
    public String BuscarRubroPorDescripcion(String Descripcion) {
    	String Rubro = "";
    	try {
    		qs = "select Codigo from rubros where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Rubro = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Rubro;
    }
    
    public String BuscarMaterialPorCodigo(String CodigoMaterial) {
    	String Material = "";
    	try {
    		qs = "select Descripcion from materiales where Codigo = \"" + CodigoMaterial + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Material = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Material;
    }
    
    public String BuscarMaterialPorDescripcion(String Descripcion) {
    	String Material = "";
    	try {
    		qs = "select Codigo from materiales where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Material = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Material;
    }
   
    public String BuscarColorPorCodigo(String CodigoColor) {
    	String Color = "";
    	try {
    		qs = "select Descripcion from colores where Codigo = \"" + CodigoColor + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Color = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Color;
    }
    
    public String BuscarColorPorDescripcion(String Descripcion) {
    	String Color = "";
    	try {
    		qs = "select Codigo from colores where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Color = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Color;
    }
    
    public String BuscarMarcaPorCodigo(String CodigoMarca) {
    	String Marca = "";
    	try {
    		qs = "select Descripcion from marcas where Codigo = \"" + CodigoMarca + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Marca = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Marca;
    }
    
    public String BuscarMarcaPorDescripcion(String Descripcion) {
    	String Marca = "";
    	try {
    		qs = "select Codigo from marcas where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Marca = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Marca;
    }
    
    public String BuscarTallePorCodigo(String CodigoTalle) {
    	String Talle = "";
    	try {
    		qs = "select Descripcion from talles where Codigo = \"" + CodigoTalle + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { Talle = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Talle;
    }
    
    public String BuscarTallePorDescripcion(String Descripcion, String Tipo) {
    	String Talle = "";    	
    	try {
    		qs = "select Codigo from talles where left(Codigo,1) = \"" + Tipo + "\" and Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Talle = rs.getString(1); }
		} catch (SQLException sqle) { sqle.printStackTrace(); }    	
    	return Talle;
    }
    
    public String BuscarTemporadaPorCodigo(String CodigoTemporada) {
    	String Temporada = "";
    	try {
    		qs = "select Descripcion from temporadas where Codigo = \"" + CodigoTemporada + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Temporada = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Temporada;
    }
    
    public String BuscarTemporadaPorDescripcion(String Descripcion) {
    	String Temporada = "";
    	try {
    		qs = "select Codigo from temporadas where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Temporada = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Temporada;
    }
    
    public String BuscarAuditorPorCodigo(String CodigoAuditor) {
    	String Auditor = "";
    	try {
    		qs = "select Descripcion from auditores where Codigo = \"" + CodigoAuditor + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Auditor = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Auditor;
    }
    
    public String BuscarAuditorPorDescripcion(String Descripcion) {
    	String Auditor = "";
    	try {
    		qs = "select Codigo from auditores where Descripcion = \"" + Descripcion + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Auditor = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}    	
    	return Auditor;
    }
    
    public String BuscarTalleRubro(String CodigoRubro) {
    	String Talle = "";
    	try {
    		qs = "select Talle from rubros where Codigo = \"" + CodigoRubro + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { Talle = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Talle = "1";
		}    	
    	return Talle;
    }
    
    public int CargarCliente(String Nombre, String Apellido, String Domicilio, String Telefono, String TipoResp, int NroCUIT, String TipoDoc, int Doc, int Codigo, String Usuario, String Servidor, BigDecimal Saldo) {
		String Fecha = Nucleo.CrearFechaInverso();
		String Email = Usuario + "@" + Servidor;
    	try {
			qs = "insert into clientes values (" + Codigo + ",\"" + Nombre + "\",\"" + Apellido + "\",\"" + Domicilio + "\",\"" + Telefono + "\",\"" +
					TipoResp + "\"," + NroCUIT + ",\"" + TipoDoc + "\"," + Doc + ",\"" + Email + "\",\"" + Fecha + "\"," + Saldo + ")"; 
			stmt = bdHosting.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) { return 1; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
    	return 0;
    }
    
    public int BuscarCodigoCliente() {
    	try {
    		qs = "select CodigoCliente from clientes order by CodigoCliente DESC";
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getInt(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 0;
    }
    
    public int MovProducto(String CodigoProducto, String Valor) {    	
    	int Cantidad;
    	try {
    		Cantidad = Integer.parseInt(Valor);
    		qs = "select Cantidad from productos where CodigoProducto = \"" + CodigoProducto + "\""; 
    		stmt = connection.createStatement();
    		rs = stmt.executeQuery(qs);
    		if (rs.next()) {
       			Cantidad = rs.getInt(1) + Cantidad;
       			qs = "update productos set Cantidad = " + Cantidad + " where CodigoProducto = \"" + CodigoProducto + "\"";
       			stmt = connection.createStatement();
       			Resultado = stmt.executeUpdate(qs);    					  				
    		}
    	} catch (SQLException sqle) {
    		sqle.printStackTrace();
    		return 1;
    	} catch (NumberFormatException nbr) {
    		nbr.printStackTrace();
    		return 2;
    	}    	
    	return 0;	
    }
    
	public int AgregarMovimiento(String CodigoProducto, int idRemito, int Cantidad, int TipoMov) {  // Flag = 0 Movimiento Interno - Flag = 1 Entrada Por Remito
		try {
			if (idRemito>0) {
				qs = "select * from remitos order by id DESC";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				if (rs.next()) { idRemito = rs.getInt("id") + 1; }				
			}
			qs = "insert into movimientos values (null,\"" + CodigoProducto + "\"," + idRemito + "," + Cantidad + ",now()," + TipoMov + ")";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) { return 0; }					
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public LinkedList<String> ObtenerGastosPorCaja() {
		LinkedList<String> Gastos = new LinkedList<String>();
//		BigDecimal TotalVenta, TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago, GastosExtras, TotalCaja, Cambio;
//		TotalVenta = TotalEfectivo = TotalTarjeta = TotalCuentaCorriente = TotalOtroMetodoPago = GastosExtras = TotalCaja = Cambio = null;
		int CodigoCaja = 0;
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				CodigoCaja = rs.getInt("CodigoCaja");
				qs = "select * from gastos where CodigoCaja = " + CodigoCaja;
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				while (rs.next()) { Gastos.add(rs.getTime(3) + " - " + rs.getString(5) + " - $" + rs.getDouble(6)); }
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Gastos;
	}
	
	public LinkedList<String> ObtenerMovPorFecha() {
		LinkedList<String> Mov = new LinkedList<String>();
		String Fecha = Nucleo.CrearFechaInverso();
		try {
			qs = "select * from movimientos where Fecha = \"" + Fecha + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Mov.add(rs.getTime(3) + " - " + rs.getString(4) + " - " + rs.getString(5)); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Mov;
	}
	
	public LinkedList<String> ObtenerModPorFecha() {
		LinkedList<String> Mod = new LinkedList<String>();
		String Fecha = Nucleo.CrearFechaInverso();
		try {
			qs = "select * from historialproductos where Fecha = \"" + Fecha + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Mod.add(rs.getTime("Hora") + " - " + rs.getString("CodigoProducto") + " - Precio Anterior $" + rs.getDouble("PrecioAnterior") + " - Precio Nuevo $" + rs.getDouble("PrecioNuevo")); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Mod;
	}
	
	public String BuscarTallePorMarca(String Marca) {
    	String Talle = "";
    	try {
    		qs = "select Talle from marcas where Codigo = \"" + Marca + "\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { Talle = rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Talle = "1";
		}
		return Talle;
    }
	
    public String BuscarClientePorCodigo(int Codigo) {
    	String Nombre = "";
    	try {
    		qs = "select * from clientes where CodigoCliente = " + Codigo;
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { Nombre = rs.getString(2) + " " + rs.getString(3); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return "///ERROR///";
		}    	
    	return Nombre;
    }

    // 0 = Nada, 1 = A Cuenta, 2 = Paga Saldo, 3 = Ambos
	public int IngresoSaldoCliente(int CodigoCliente, CColaPagos ColaPagos, int Flag2, BigDecimal Pago, BigDecimal Saldo, BigDecimal Deuda) {
    	int TipoAccion = Flag2;
     	long CodigoHistorial;
     	String Fecha, Hora;
		if (TipoAccion==1 || TipoAccion==3) { Saldo = Saldo.add(Deuda); }
		if (TipoAccion==2 || TipoAccion==3) { Saldo = Saldo.subtract(Pago); }
     	try {
			qs = "update clientes set Saldo = " + Saldo + " where CodigoCliente = " + CodigoCliente;
			stmt = bdHosting.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) { return -1; }
			Fecha = Nucleo.Fecha;
			Hora = Nucleo.Hora;
    		qs = "select * from historialclientes where Fecha = \"" + Fecha + "\" order by CodigoHistorial DESC" ;
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { CodigoHistorial = rs.getLong("CodigoHistorial") + 1; }
			else {
				String Temp = Fecha.substring(0,4) + Fecha.substring(5,7) + Fecha.substring(8,10) + "0001";
				CodigoHistorial = Long.parseLong(Temp);
			}
			qs = "insert into historialclientes values (" + CodigoHistorial + "," + CodigoCliente + ",\"" + Fecha + "\",\"" + Hora + "\"," + CVenta + "," + Pago + "," + Deuda + "," + Saldo + "," + Local + ")";
			stmt = bdHosting.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado != 1 ) { return -1; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return -1;
		}
    	return 0;
	}
	
	public BigDecimal ObtenerSaldoCliente(int CodigoCliente) {
		BigDecimal Saldo;
		try {
    		qs = "select Saldo from clientes where CodigoCliente = " + CodigoCliente;
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				Saldo = new BigDecimal(rs.getDouble(1));
				Saldo = Saldo.setScale(2, RoundingMode.HALF_UP);
				return Saldo;		
			}
			else { return null; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}    	
	}
	
	public LinkedList<String> BuscarHistorialCliente(int CodigoCliente) { // 1 = Calcuer, 2 = BC, 3 = Prune
	  	LinkedList<String> Historial = new LinkedList<String>();
    	String Nombre, CodigoProducto, Fecha;
    	BigDecimal Saldo, Saldo1, Saldo2, Saldo3, PrecioProducto, TotalEfectivo, TotalTarjeta, TotalCuentaCorriente, TotalOtroMetodoPago, Descuento, Interes, TotalPago, TotalDeuda, SaldoFinal;
		ResultSet rs1, rs2;
		int Flag = 0;
		int LocalTrx;
		Saldo1 = new BigDecimal(0);
		Saldo1 = Saldo1.setScale(2, RoundingMode.HALF_UP);
		Saldo2 = new BigDecimal(0);
		Saldo2 = Saldo2.setScale(2, RoundingMode.HALF_UP);
		Saldo3 = new BigDecimal(0);
		Saldo3 = Saldo3.setScale(2, RoundingMode.HALF_UP);
    	try {
    		qs = "select * from clientes where CodigoCliente = " + CodigoCliente;
			stmt = bdHosting.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				Nombre = rs.getString("Nombre") + " " + rs.getString("Apellido");
				Saldo = new BigDecimal(rs.getDouble("Saldo"));
				Saldo = Saldo.setScale(2, RoundingMode.HALF_UP);
				Historial.add("Cliente Nro " + CodigoCliente + " - " + Nombre);
	    		qs = "select * from historialclientes where CodigoCliente = " + CodigoCliente + " order by CodigoHistorial DESC";
				stmt = bdHosting.createStatement();
				rs = stmt.executeQuery(qs);
				while (rs.next()) {
					Fecha = rs.getDate("Fecha").toString();
					Historial.add(Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4));
					Historial.add(rs.getTime("Hora").toString());
					long CodigoVenta = rs.getLong("CodigoVenta");
					LocalTrx = rs.getInt("local_trx");
					if ((Local == LocalTrx) && CodigoVenta!=0) {
			    		qs = "select * from descripcionventas where CodigoVenta = " + CodigoVenta;
						stmt = connection.createStatement();
						rs1 = stmt.executeQuery(qs);
			    		qs = "select * from ventas where CodigoVenta = " + CodigoVenta;
						stmt = connection.createStatement();
						rs2 = stmt.executeQuery(qs);
						if (rs2.next()) { 
							Historial.add(Integer.toString(rs2.getInt("VentaNro")));
							Flag = 1;
						}
						Historial.add("----------");
						while (rs1.next()) { 
							if (rs1.getString("CodigoProducto").compareTo("PAGOCUENTA")==0) { CodigoProducto = "Pago De Cuenta"; }
							else if (rs1.getString("CodigoProducto").compareTo("ENTREGASEÑA")==0) { CodigoProducto = "Entrega de Seña"; }
							else { CodigoProducto = rs1.getString("CodigoProducto"); }
							PrecioProducto = new BigDecimal(rs1.getDouble("PrecioProducto"));
							PrecioProducto = PrecioProducto.setScale(2, RoundingMode.HALF_UP);
							Historial.add(rs1.getInt("ProdNro") + ") " + CodigoProducto + " $" + PrecioProducto + " ");
						}
						Historial.add("----------");	
						if (Flag==1) {
							if (rs2.getDouble("TotalEfectivo")>0) { 
								TotalEfectivo = new BigDecimal(rs2.getDouble("TotalEfectivo"));
								TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
								Historial.add("$" + TotalEfectivo);
							}
							else { Historial.add("$0"); }
							if (rs2.getDouble("TotalTarjeta")>0) {
								TotalTarjeta = new BigDecimal(rs2.getDouble("TotalTarjeta"));
								TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
								Historial.add("$" + TotalTarjeta);
							}
							else { Historial.add("$0"); }
							if (rs2.getDouble("TotalCuentaCorriente")>0) {
								TotalCuentaCorriente = new BigDecimal(rs2.getDouble("TotalCuentaCorriente"));
								TotalCuentaCorriente = TotalCuentaCorriente.setScale(2, RoundingMode.HALF_UP);
								Historial.add("$" + TotalCuentaCorriente);
							}
							else { Historial.add("$0"); }
							if (rs2.getDouble("TotalOtroMetodoPago")>0) { // arreglar
								TotalOtroMetodoPago = new BigDecimal(rs2.getDouble("TotalOtroMetodoPago"));
								TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
								Historial.add("$" + TotalOtroMetodoPago);
							}
							else { Historial.add("$0"); }
							if (rs2.getDouble("Descuento")>0) { 
								Descuento = new BigDecimal(rs2.getDouble("Descuento"));
								Descuento = Descuento.setScale(2, RoundingMode.HALF_UP);
								Historial.add(Descuento.toString());
							}
							else { Historial.add("0"); }
							if (rs2.getDouble("Interes")>0) {
								Interes = new BigDecimal(rs2.getDouble("Interes"));
								Interes = Interes.setScale(2, RoundingMode.HALF_UP);					
								Historial.add(Interes.toString());
							}
							else { Historial.add("$0"); }							
							Historial.add(rs2.getString("Vendedora"));				
						}						
					}
					else {
						Historial.add("-");
						Historial.add("----------");
						if (CodigoVenta!=0) {
							if (LocalTrx==1) { Historial.add("Transacción Realizada En Calcuer"); }
							else if (LocalTrx==2) { Historial.add("Transacción Realizada En BC"); }
							else { Historial.add("Transacción Realizada En Prune"); }							
						}
						else { Historial.add("Transacción Sin Registro de Venta"); }
						Historial.add("----------");	
						Historial.add("-");
						Historial.add("-");
						Historial.add("-");
						Historial.add("-");
						Historial.add("-");
						Historial.add("-");
						Historial.add("-");	
					}
								
					TotalDeuda = new BigDecimal(rs.getDouble("Deuda"));
					TotalDeuda = TotalDeuda.setScale(2, RoundingMode.HALF_UP);
					Historial.add(TotalDeuda.toString().replace(".",","));
					TotalPago = new BigDecimal(rs.getDouble("Pago"));
					TotalPago = TotalPago.setScale(2, RoundingMode.HALF_UP);
					Historial.add(TotalPago.toString().replace(".",","));										
					SaldoFinal = new BigDecimal(rs.getDouble("SaldoFinal"));
					SaldoFinal = SaldoFinal.setScale(2, RoundingMode.HALF_UP);	
					Historial.add(SaldoFinal.toString().replace(".",","));
					
					if (LocalTrx == 1) { Saldo1 = Saldo1.subtract(TotalPago).add(TotalDeuda); }
					else if (LocalTrx == 2) { Saldo2 = Saldo2.subtract(TotalPago).add(TotalDeuda); }
					else if (LocalTrx == 3) { Saldo3 = Saldo3.subtract(TotalPago).add(TotalDeuda); }
					
				}
				
				if (Historial.size()==1) { Historial.add("El Cliente No Tiene Registrados Tanto Compras Como Pagos En Su Cuenta"); }
				Historial.add("$ " + Saldo.toString().replace(".",","));
				Historial.add("$ " + Saldo1.toString().replace(".",","));
				Historial.add("$ " + Saldo2.toString().replace(".",","));
				Historial.add("$ " + Saldo3.toString().replace(".",","));
			}
			else {
				Historial.add("///ERR12///");
				return Historial;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Historial.add("///ERR15///");
			return Historial;
		}
		return Historial;
	}
	
	public int ObtenerNroSeña() {
    	try {
    		qs = "select id_seña from señas order by id_seña DESC"; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getInt(1) + 1; }
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public LinkedList<String> BuscarNrosSeñas() {
		LinkedList<String> Señas = new LinkedList<String>();
    	try {
    		qs = "select id_seña from señas where pago_saldo = \"N\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { Señas.add(Integer.toString(rs.getInt(1))); }
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
			Señas.add("///ERROR///");
			return Señas;
		}
		return Señas;		
	}

    public int AlmacenoSeña(CColaDatos ColaDatos, long CodigoVenta) {
    	int Flag = 0;
    	String CodigoProducto;
    	BigDecimal Precio;
    	CColaDatos DatosProductos = new CColaDatos(ColaDatos);
		while (Flag!=1) {
			CDatos Datos = DatosProductos.ObtenerPrimero();
			CodigoProducto = Datos.ObtenerCodigoProducto();
			Precio = Datos.ObtenerPrecio();
			if (CodigoProducto.compareTo("ENTREGASEÑA")==0) {
				Flag = 1;
				try {
		    		qs = "insert into señas values (null," + CodigoVenta + ",0," + Precio + ",\"N\")";
					stmt = connection.createStatement();
					Resultado = stmt.executeUpdate(qs);
					if (Resultado != 1 ) { return 5; }
					else { Flag = 1; }
		       	} catch (SQLException sqle) {
		        	sqle.printStackTrace();
		        	return 5;
		       	}				
			}
		}
		return 0;
    }
    
	public Object[] BuscarDatosSeña(int NroSeña) {
		Object Datos[] = new Object[5];
		try {
    		qs = "select * from señas where id_seña = " + NroSeña;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				Datos[0] = rs.getInt("id_seña");
				Datos[1] = rs.getLong("id_venta_entrada");
				Datos[2] = rs.getLong("id_venta_salida");
				Datos[3] = rs.getDouble("monto");
				Datos[4] = rs.getString("pago_saldo");
			}
/*			qs = "select TotalVenta from ventas where CodigoVenta = " + idVentaEntrada;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				Fecha = Long.toString(idVentaEntrada);
				Productos.add(Fecha.substring(6,8) + "/" + Fecha.substring(4,6) + "/" + Fecha.substring(0,4));
				Productos.add(Double.toString(rs.getDouble(1)));
			}*/
       	} catch (SQLException sqle) {
        	sqle.printStackTrace();
        	return null;
        }
       	return Datos;
	}
    
/*	public String ObtenerDescripcionProd(String Codigo) {
		try {
			qs = "select Descripcion from productos where CodigoProducto = " + Codigo;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getString(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		return null;
	}*/
	
	public int FinalizarSeña(long CodigoVenta, int SeñaCierre) {
		try {
			qs = "update señas set id_venta_salida = " + CodigoVenta + ", pago_saldo = \"S\" where id_seña = " + SeñaCierre; 
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
			if (Resultado == 0 ) { return 7; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 7;
		}
		return 0;
	}
	
    public String ObtenerFechaCajaAbierta() {
		try {
			qs = "select Fecha from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getDate(1).toString(); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
    }
    
    public int ObtenerIdCajaAbierta() {
		try {
			qs = "select CodigoCaja from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getInt(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 0;
    }
    
  	public void ResetearVentaNro() { VentaNro = 1; }
  	
  	public int ObtenerLocalNro() { return Local; }

	public void SetearStock() throws SQLException {
		try {
    		qs = "update productos set Cantidad = 0"; 
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
  	
  	public boolean VerificarCodigo(String codigoProducto) throws SQLException {
    	try {
    		qs = "select * from productos where CodigoProducto = \"" + codigoProducto + "\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return true; }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

	public void ActualizarProducto(String codigoProducto, BigDecimal precio, int cantidad) throws SQLException {
    	try {
    		qs = "update productos set Precio = " + precio + ", Cantidad = " + cantidad + " where CodigoProducto = \"" + codigoProducto + "\"";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public int ActualizarProductoPorRemito(String codigoProducto, String Descripcion, int cantidad) throws SQLException {
    	int stock = 0;
		try {
    		qs = "select * from productos where CodigoProducto = \"" + codigoProducto + "\""; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				stock = rs.getInt("Cantidad");
				stock += cantidad;
	    		qs = "update productos set Cantidad = " + stock + " where CodigoProducto = \"" + codigoProducto + "\"";
				stmt = connection.createStatement();
				Resultado = stmt.executeUpdate(qs);
				if (rs.getString("Descripcion").compareTo("null")==0) {
		    		qs = "update productos set Descripcion = \"" + Descripcion + "\" where CodigoProducto = \"" + codigoProducto + "\"";
					stmt = connection.createStatement();
					Resultado = stmt.executeUpdate(qs);					
				}
				return Resultado;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 0;
	}
	
	public LinkedList<Object[]> ObtenerCantidades() throws SQLException {
		Object[] Datos = null;
		LinkedList<Object[]> Productos = new LinkedList<Object[]>();
		try {
			qs = "select * from productos order by codigoproducto asc"; 
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) { 
				Datos = new Object[3];
				Datos[0] = rs.getString("CodigoProducto");
				Datos[1] = rs.getDouble("Precio");
				Datos[2] = rs.getInt("Cantidad");
				Productos.add(Datos);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Productos;
	}			


	public void IngresarProducto(String codigoProducto, String detalle, BigDecimal precio, int cantidad) throws SQLException {
		try {
			qs = "insert into productos values (\"" + codigoProducto + "\",\"" + detalle + "\"," + precio + "," + cantidad + ",now())";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}   
	}
	
	public void cargarRemito(String nombreArchivo, int lineas) throws SQLException {
		try {
			qs = "insert into remitos values (null,\"" + nombreArchivo + "\"," + lineas + ",now())";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}   
	}
	
  	public void ActivarBDCuentas() throws SQLException {
  		try {
  			url = "jdbc:mysql://96.9.162.227/glendora_calcuer?user=glendora_calcuer&password=cal31990";
  			bdHosting = DriverManager.getConnection(url);
  		} catch (SQLException sqle) { 
  			sqle.printStackTrace();
  			while (sqle != null) {
  				String logMessage = "\n SQL Error: "+
  				sqle.getMessage() + "\n\t\t"+
  				"Error code: "+sqle.getErrorCode() + "\n\t\t"+
  				"SQLState: "+sqle.getSQLState()+"\n";
  				System.out.println(logMessage);
  				sqle = sqle.getNextException();
  			}
  		}
  	}

	public void DesactivarBDCuentas() throws SQLException {
		try {
			bdHosting.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}		
	}
	
	public String ObtenerUltimaVenta() {
		String Venta = "";
		String Fecha = null;
		BigDecimal Total;
		try {
			qs = "select * from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				qs = "select * from ventas where CodigoCaja = " + rs.getLong("CodigoCaja") + " order by CodigoVenta DESC";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				if (rs.next()) {
					Fecha = rs.getDate("Fecha").toString();
					Fecha = Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4);
					Total = new BigDecimal(rs.getDouble("TotalVenta"));
					Total = Total.setScale(2, RoundingMode.HALF_UP);
					Venta = "Última Venta: " + Fecha + " " + rs.getTime("Hora").toString() + " Hs - Venta Nro " + rs.getInt("VentaNro") + " - Total $" + Total.toString().replace(".",",");
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		return Venta;
	}

	public int AlmacenoFactura(String fecha, long codigoVenta, BigDecimal total, Object[] Datos, String nFactura, int Cobrador) {
		String TipoFact = "";
		if (Cobrador==2) { TipoFact = "A"; }
		else { TipoFact = "B"; }
		try {
			
			qs = "insert into facturas values (null,\"" + fecha + "\"," + codigoVenta + "," + total + "," + Datos[0] + ",\"" + nFactura + "\"," +
            "\"" + TipoFact + "\")";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 0;
	}

	public String ObtenerCambioCaja() {
		try {
			qs = "select cambio_prox_caja from cajas order by CodigoCaja desc";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				BigDecimal Cambio = new BigDecimal(rs.getDouble(1));
				Cambio = Cambio.setScale(2, RoundingMode.HALF_UP);
				return Cambio.toString().replace(".",",");
			}				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return "";
		}
		return "";
	}

	public String FechaCajaAbierta() {
		try {
			
			qs = "select Fecha from cajas where EstadoCaja = \"A\"";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getDate("Fecha").toString(); }
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return "";
		}
		return "";
	}

	public int GrabarPDF(byte[] byteArray) {
		String Fecha = FechaCajaAbierta();
		InputStream streamEntrada = new ByteArrayInputStream(byteArray);
		int CodigoCaja = VerCajaAbierta();
    	try {
			PreparedStatement pstmt = bdHosting.prepareStatement("insert into cajas values (null,\"" + Fecha + "\"," + Local + "," + CodigoCaja + ",?)");
			pstmt.setBlob(1,streamEntrada);
			pstmt.execute();
			streamEntrada.close();
			pstmt.close();
			return 0;				
		} catch (SQLException sqle) { sqle.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
    	return 0;
	}
	
	public int BorrarVenta(int index) {
		
		int idCaja = ObtenerIdCajaAbierta();
		long CodigoVenta = 0;
		BigDecimal TotalVenta, TotalEfectivo, TotalTarjeta, TotalOtroMetodoPago;
		BigDecimal TotalVentaCaja, TotalEfectivoCaja, TotalTarjetaCaja, TotalOtroMetodoPagoCaja;
		int CodigoCliente, CantidadVentasCaja, CantidadProductos, Nro;
		long NuevoCodigoVenta, CodigoVentaTmp, NuevoCodigoDescVenta, CodigoDescVentaTmp;
		String CodigoProducto;
		
		try {
			
			qs = "select * from ventas where CodigoCaja = " + idCaja + " and VentaNro = " + index;
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { 
				CodigoVenta = rs.getLong("CodigoVenta");
				CodigoCliente = rs.getInt("CodigoCliente");
				TotalVenta = new BigDecimal(rs.getDouble("TotalVenta"));
				TotalVenta = TotalVenta.setScale(2, RoundingMode.HALF_UP);
				TotalEfectivo = new BigDecimal(rs.getDouble("TotalEfectivo"));
				TotalEfectivo = TotalEfectivo.setScale(2, RoundingMode.HALF_UP);
				TotalTarjeta = new BigDecimal(rs.getDouble("TotalTarjeta"));
				TotalTarjeta = TotalTarjeta.setScale(2, RoundingMode.HALF_UP);
				TotalOtroMetodoPago = new BigDecimal(rs.getDouble("TotalOtroMetodoPago"));
				TotalOtroMetodoPago = TotalOtroMetodoPago.setScale(2, RoundingMode.HALF_UP);
				if (CodigoCliente == 0) {
					qs = "delete from ventas where CodigoCaja = " + idCaja + " and VentaNro = " + index;
					stmt = connection.createStatement();
					if (stmt.executeUpdate(qs) == 1) {
						
						qs = "select * from descripcionventas where CodigoVenta = " + CodigoVenta;
						stmt = connection.createStatement();
						rs = stmt.executeQuery(qs);
						int Flag = 0; // Pongo Este Flag Por Si Hay Más de Una Entrega De Seña, Entonces No Intenta Borrar Nuevamente En La Tabla "señas".
						while (rs.next() && Flag == 0) {
							CodigoProducto = rs.getString("CodigoProducto");
							ReingresoProducto(CodigoProducto);
							if (CodigoProducto.compareToIgnoreCase("ENTREGASEÑA")==0) {
								qs = "delete from señas where id_venta_entrada = " + CodigoVenta;
								stmt = connection.createStatement();
								if (stmt.executeUpdate(qs) == 0) { return 1; }
								else { Flag = 1; }
							}
						}
											
						qs = "delete from descripcionventas where CodigoVenta = " + CodigoVenta;
						stmt = connection.createStatement();
						CantidadProductos = stmt.executeUpdate(qs);
						if (CantidadProductos >= 1) {
							qs = "select * from cajas where CodigoCaja = " + idCaja;
							stmt = connection.createStatement();
							rs = stmt.executeQuery(qs);
							if (rs.next()) {
								CantidadVentasCaja = rs.getInt("CantidadVentas");
								CantidadProductos = rs.getInt("CantProdVendidos") - CantidadProductos;
								TotalVentaCaja = new BigDecimal(rs.getDouble("TotalVentas"));
								TotalVentaCaja = TotalVentaCaja.setScale(2, RoundingMode.HALF_UP);
								TotalEfectivoCaja = new BigDecimal(rs.getDouble("TotalEfectivo"));
								TotalEfectivoCaja = TotalEfectivoCaja.setScale(2, RoundingMode.HALF_UP);
								TotalTarjetaCaja = new BigDecimal(rs.getDouble("TotalTarjeta"));
								TotalTarjetaCaja = TotalTarjetaCaja.setScale(2, RoundingMode.HALF_UP);
								TotalOtroMetodoPagoCaja = new BigDecimal(rs.getDouble("TotalOtroMetodoPago"));
								TotalOtroMetodoPagoCaja = TotalOtroMetodoPagoCaja.setScale(2, RoundingMode.HALF_UP);
								
								TotalVentaCaja = TotalVentaCaja.subtract(TotalVenta);
								if (TotalEfectivo.compareTo(new BigDecimal(0))>0) { TotalEfectivoCaja = TotalEfectivoCaja.subtract(TotalEfectivo); }
								if (TotalTarjeta.compareTo(new BigDecimal(0))>0) { TotalTarjetaCaja = TotalTarjetaCaja.subtract(TotalTarjeta); }
								if (TotalOtroMetodoPago.compareTo(new BigDecimal(0))>0) { TotalOtroMetodoPagoCaja = TotalOtroMetodoPagoCaja.subtract(TotalOtroMetodoPago); }
								CantidadVentasCaja--;
								
								qs = "update cajas set CantidadVentas = " + CantidadVentasCaja + ", CantProdVendidos = " + CantidadProductos +
									 ", TotalVentas = " + TotalVentaCaja + ", TotalEfectivo = " + TotalEfectivoCaja + ", TotalTarjeta = " + TotalTarjetaCaja +
									 ", TotalOtroMetodoPago = " + TotalOtroMetodoPagoCaja + " where CodigoCaja = " + idCaja;
								stmt = connection.createStatement();
								Resultado = stmt.executeUpdate(qs);		
								if (Resultado == 1) { 
									qs = "select * from ventas where CodigoCaja = " + idCaja + " and CodigoVenta > " + CodigoVenta + " order by CodigoVenta ASC";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(qs);
									while (rs.next()) {
										CodigoVentaTmp = rs.getLong("CodigoVenta");
										NuevoCodigoVenta = CodigoVentaTmp - 1;
										Nro = rs.getInt("VentaNro") - 1;
										qs = "update ventas set CodigoVenta = " + NuevoCodigoVenta + ", VentaNro = " + Nro + " where CodigoVenta = " + CodigoVentaTmp;
										stmt = connection.createStatement();
										Resultado = stmt.executeUpdate(qs);
										if (Resultado==0) { return 1; }										
									}
									qs = "select * from descripcionventas where CodigoVenta > " + CodigoVenta + " order by CodigoDescripcionVenta ASC";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(qs);
									while (rs.next()) {								
										CodigoVentaTmp = rs.getLong("CodigoVenta");
										NuevoCodigoVenta = CodigoVentaTmp - 1;
										CodigoDescVentaTmp = rs.getLong("CodigoDescripcionVenta");
										NuevoCodigoDescVenta = CodigoDescVentaTmp - 1000;
										qs = "update descripcionventas set CodigoVenta = " + NuevoCodigoVenta + ", CodigoDescripcionVenta = " + NuevoCodigoDescVenta + " where CodigoDescripcionVenta = " + CodigoDescVentaTmp;
										stmt = connection.createStatement();
										Resultado = stmt.executeUpdate(qs);
										if (Resultado==0) { return 1; }										
									}
									VentaNro--;
									return 0;
								}
							}							
						}						
					}								
				}
				else return 2; // No Borra Ventas Con Clientes Asociados
			}
			else return 1;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}				
		return 1;		
	}

	public LinkedList<String> BuscarHistoricoVentas(int i) {
    	LinkedList<String> Datos = new LinkedList<String>();
    	String dia = Nucleo.ObtenerNombreDiaActual();
    	String FechaActual = Nucleo.CrearSoloFecha();
    	String Fecha = "";
    	String Titulo = "";
    	BigDecimal TotalVentas;
//    	int Dif = 0;
//    	int Flag = 0;
    	int filas = 1;
    	try {
    		qs = "select * from cajas order by CodigoCaja DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			Titulo = "Histórico Hasta la Fecha " + FechaActual;
			FechaActual = Nucleo.CrearFechaInverso();
	    	FechaActual = FechaActual.substring(0,4) + FechaActual.substring(5,7) + FechaActual.substring(8,10); 
			Datos.add(Titulo);
			while (rs.next() && filas<11) {
				Fecha = rs.getDate("Fecha").toString(); 
//				Fecha = Fecha.substring(0,4) + Fecha.substring(5,7) + Fecha.substring(8,10);
//				Dif = Integer.parseInt(FechaActual) - Integer.parseInt(Fecha);
//				Fecha = rs.getDate("Fecha").toString(); 
//				Fecha = Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4);
				try {
					String Formato = "yyyy-MM-dd";
					SimpleDateFormat DateFormat = new SimpleDateFormat(Formato);
					Date Fecha1 = DateFormat.parse(Fecha);
					Formato = "EEE";
					DateFormat = new SimpleDateFormat(Formato);
					dia = DateFormat.format(Fecha1);
				} catch (ParseException e) { e.printStackTrace(); }	
				Datos.add(Fecha);
				if (dia.compareTo("lun")==0) { dia = "Lunes"; }
				else if (dia.compareTo("mar")==0) { dia = "Martes"; }
				else if (dia.compareTo("mié")==0) { dia = "Miércoles"; }
				else if (dia.compareTo("jue")==0) { dia = "Jueves"; }
				else if (dia.compareTo("vie")==0) { dia = "Viernes"; }
				else if (dia.compareTo("sáb")==0) { dia = "Sábado"; }				
				else if (dia.compareTo("dom")==0) { dia = "Domingo"; }
/*					Datos.add(dia);
					if (dia.compareTo("Lunes")==0) { filas = 7; }
					else if (dia.compareTo("Martes")==0) { 
						filas = 6;
						dia = "Lunes";
				    }
				    else if (dia.compareTo("Miércoles")==0) { 
				    	filas = 5;
				    	dia = "Martes";
				    }
				    else if (dia.compareTo("Jueves")==0) { 
				    	filas = 4;
				    	dia = "Miércoles";
				    }
					else if (dia.compareTo("Viernes")==0) { 
						filas = 3;
						dia = "Jueves";
					}
					else if (dia.compareTo("Sabado")==0) { 
						filas = 2;
						dia = "Viernes";
					}*/					
					//Flag = 1;
//				}
//				else {
//					if (Flag==1) { Datos.add(dia); }
//					else { Datos.add("-"); }
				Datos.add(dia);
//				}
				TotalVentas = new BigDecimal(rs.getDouble("TotalVentas"));
				TotalVentas = TotalVentas.setScale(2, RoundingMode.HALF_UP);
				Datos.add("$" + TotalVentas.toString().replace(".",","));
				filas++;
			}
			Datos.add(Titulo);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Datos;
	}

	public int IngresarNuevoCUIT(String RazonSocial, String CUIT1, String CUIT2, String CUIT3) {
		try {			
			qs = "insert into clientes values (null,\"" + RazonSocial + "\"," + CUIT1 + CUIT2 + CUIT3 + ");";
			stmt = connection.createStatement();
			Resultado = stmt.executeUpdate(qs);		
			if (Resultado==1) { return 0; }			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 1;
		}
		return 1;
	}

    public LinkedList<Object[]> BuscarClientesFacturas() { // MODIF 16-11-10
    	LinkedList<Object[]> Clientes = new LinkedList<Object[]>();
    	try {    		
    		qs = "select * from clientes order by razon_social ASC;";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) {
		    	Object Datos[] = new Object[3];
				Datos[0] = rs.getInt("id");
				Datos[1] = rs.getString("razon_social");
				Datos[2] = rs.getLong("cuit_nro");
				Clientes.add(Datos);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Clientes;
    }

	public int ObtenerIdUltimoClienteIngresado() {
		try {
			qs = "select id from clientes order by id DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getInt(1); }
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		return 0;
	}

	public long ObtenerNroFact(int tipoVent) {
		String tipoFact = "";
		if (tipoVent==1) { tipoFact = "A"; }
		else { tipoFact = "B"; }
		try {			
			qs = "select numero_factura from facturas where tipo_fact = \"" + tipoFact + "\" order by id DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return rs.getLong(1)+1; }			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		return 0;
	}

	public LinkedList<String> BuscarHistoricoProducto(String Codigo) {
    	LinkedList<String> Datos = new LinkedList<String>();
    	String Fecha = "";
    	String Fecha2 = "";
    	String TimeStamp1 = "";
    	String TimeStamp2 = "";
    	ResultSet rs1,rs2;
    	int StockTotal = 0;
    	try {
    		qs = "select * from descripcionventas where CodigoProducto = \"" + Codigo + "\" order by CodigoDescripcionVenta DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			while (rs.next()) {
				qs = "select * from ventas where CodigoVenta = " + rs.getLong("CodigoVenta");
				stmt = connection.createStatement();
				rs1 = stmt.executeQuery(qs);
				if (rs1.next()) {
					Fecha = rs1.getDate("Fecha").toString();
					
					TimeStamp2 = Fecha + " " + rs1.getTime("Hora").toString();
					if (TimeStamp1.isEmpty()) { qs = "select * from movimientos where CodigoProducto = \"" + Codigo + "\" and fecha > \"" + TimeStamp2 + "\" order by fecha DESC, id_remito DESC"; }
					else { qs = "select * from movimientos where CodigoProducto = \"" + Codigo + "\" and fecha < \"" + TimeStamp1 + "\" and fecha > \"" + TimeStamp2 + "\" order by fecha DESC, id_remito DESC"; }
					stmt = connection.createStatement();
					rs2 = stmt.executeQuery(qs);
					while (rs2.next()) {
						Fecha2 = rs2.getDate("fecha").toString();
						Fecha2 = Fecha2.substring(8,10) + "/" + Fecha2.substring(5,7) + "/" + Fecha2.substring(0,4);
						Datos.add(Fecha2);
						if (rs2.getInt("id_remito")>0) { Datos.add("Recepción Mercadería"); }
						else if (rs2.getInt("mov_tipo")==1) { Datos.add("Ajuste de Stock"); }
						else if (rs2.getInt("mov_tipo")==2) { Datos.add("Devolución Por Falla"); }
						else if (rs2.getInt("mov_tipo")==3) { Datos.add("Retiro Sin Cargo"); }
						else { Datos.add("Movimientos Varios"); }
						Datos.add(Integer.toString(rs2.getInt("cantidad")));
						Datos.add("");
					}
					TimeStamp1 = TimeStamp2;
					
					Fecha = Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4);
					Datos.add(Fecha);
					Datos.add("Venta Nro " + Integer.toString(rs1.getInt("VentaNro")));
					if (rs.getString("Stock").compareTo("Sale")==0) { Datos.add("-1"); }
					else { Datos.add("1"); }
					Datos.add("");
				}
			}
			if (!TimeStamp2.isEmpty()) { qs = "select * from movimientos where CodigoProducto = \"" + Codigo + "\" and fecha < \"" + TimeStamp2 + "\" order by fecha DESC, id_remito DESC"; } 
			else { qs = "select * from movimientos where CodigoProducto = \"" + Codigo + "\" order by fecha DESC, id_remito DESC"; } 
			stmt = connection.createStatement();
			rs2 = stmt.executeQuery(qs);
			while (rs2.next()) {
				Fecha2 = rs2.getDate("fecha").toString();
				Fecha2 = Fecha2.substring(8,10) + "/" + Fecha2.substring(5,7) + "/" + Fecha2.substring(0,4);
				Datos.add(Fecha2);
				if (rs2.getInt("id_remito")>0) { Datos.add("Recepción Mercadería"); }
				else if (rs2.getInt("mov_tipo")==1) { Datos.add("Ajuste de Stock"); }
				else if (rs2.getInt("mov_tipo")==2) { Datos.add("Devolución Por Falla"); }
				else if (rs2.getInt("mov_tipo")==3) { Datos.add("Retiro Sin Cargo"); }
				else { Datos.add("Movimientos Varios"); }
				Datos.add(Integer.toString(rs2.getInt("cantidad")));
				Datos.add("");
			}			
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
    	if (Datos.size()>1) {
        	StockTotal = Integer.parseInt(Datos.get(Datos.size()-2));
        	Datos.set(Datos.size()-1, Integer.toString(StockTotal));
        	for (int i=Datos.size()-6;i>0;i--) {
        		StockTotal += Integer.parseInt(Datos.get(i));
        		Datos.set(i+1, Integer.toString(StockTotal));
        		i = i-3;   		
        	}    		
    	}
		return Datos;
	}

	public boolean NegativosEnStock() {
		try {
    		qs = "select * from productos where Cantidad < 0";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) { return true; }
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		return false;
	}

	public LinkedList<String> BuscarAsteriscos() {
    	LinkedList<String> Datos = new LinkedList<String>();
    	String Fecha = "";
    	ResultSet rs1;
    	int Flag = 0;
    	try {
    		qs = "select valor from sistema where id = 1";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
	    		qs = "select * from ventas where ticket_fiscal = \"N\" and CodigoVenta > " + rs.getLong(1);
				stmt = connection.createStatement();
				rs = stmt.executeQuery(qs);
				while (rs.next()) {
					qs = "select * from descripcionventas where CodigoVenta = " + rs.getLong("CodigoVenta");
					stmt = connection.createStatement();
					rs1 = stmt.executeQuery(qs);
					while (rs1.next()) {
						if (rs1.getString("CodigoProducto").compareTo("PAGOCUENTA")!=0 && rs1.getString("CodigoProducto").compareTo("ENTREGASEÑA")!=0 &&
								rs1.getString("CodigoProducto").compareTo("DESCUENTOCUENTA")!=0 && rs1.getString("CodigoProducto").compareTo("DEVOLPRODUCTO")!=0) {
							if (Flag==0) {
								Fecha = rs.getDate("Fecha").toString();
								Fecha = Fecha.substring(8,10) + "/" + Fecha.substring(5,7) + "/" + Fecha.substring(0,4);
								Datos.add(Fecha);
								Datos.add(Integer.toString(rs.getInt("VentaNro")));
								Flag = 1;
							}
							else {
								Datos.add("");
								Datos.add("");
							}
							Datos.add(rs1.getString("CodigoProducto"));
							if (rs1.getString("Stock").compareTo("Sale")==0) { Datos.add("-1"); }
							else { Datos.add("1"); }							
						}
					}
					Flag = 0;
				}	
			}    		
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Datos;
	}

	public boolean BajaAsteriscos() {
		try {
    		qs = "select * from ventas where ticket_fiscal = \"N\" order by CodigoVenta DESC";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(qs);
			if (rs.next()) {
				qs = "update sistema set valor = " + rs.getLong("CodigoVenta") + " where id = 1";
				stmt = connection.createStatement();
				Resultado = stmt.executeUpdate(qs);		
				if (Resultado==1) { return true; }			
			}    		
    	} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
    	return false;
	}

	public int CargarDatosRecepcion(String text, String text2, String text3, String text4, String text5, String text6) {
		return 1;
	}
	
}
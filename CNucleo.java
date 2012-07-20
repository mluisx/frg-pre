/**
 * Prune POS Ver 0.6.4
 * @author Maurix
**/
package Caja;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.math.BigDecimal;

public class CNucleo {
	
	public CNucleo(CColaDatos ColaDatos) { 
		BD = new CBaseDatos(this);
		this.ColaDatos = ColaDatos;
	}
	
	public CBaseDatos BD;
	public String Fecha;
	public String Hora;
	public long CodigoVenta;
	public CColaDatos ColaDatos;
	public int VentaNro;

	public int ActivarBD(String Usuario, String Password, String IP) {
		int Resultado = BD.AccesoBD(Usuario,Password,IP);
		if (Resultado == 0) { VentaNro = BD.ObtenerVentaNro(); }
		return Resultado;
	}
	
	public int AlmacenoVenta(CColaDatos ColaDatos, CColaPagos ColaPagos, String Vendedora, BigDecimal Total, int ProdVendidos, int Cobrador, BigDecimal Descuento, BigDecimal Interes,
								int CodigoCliente, boolean Seña, boolean VentaSeñada, int SeñaCierre, Object[] Datos, String nFactura) {
		Fecha = CrearFechaInverso();
		Hora = CrearHora();
		VentaNro = BD.ObtenerVentaNro();
		String CodigoCaja = Integer.toString(BD.ObtenerIdCajaAbierta());
		long CodigoDescripcionVenta;
		int Resultado = 0;
		String Temp = CodigoCaja + "00";
		CodigoVenta = Long.parseLong(Temp);
		CodigoVenta += VentaNro;
		CodigoDescripcionVenta = CodigoVenta*1000;
		if (Seña) {	Resultado = BD.AlmacenoSeña(ColaDatos,CodigoVenta); }
		if (Resultado == 0) {
			Resultado = BD.AlmacenoVenta(CodigoVenta, Vendedora, Total, Fecha, Hora, ProdVendidos, ColaPagos, Cobrador, Descuento, Interes, CodigoCliente);
			if (Resultado == 0) {
				while (!ColaDatos.EstaVacio() && Resultado == 0) {
					CodigoDescripcionVenta++;
					Resultado = BD.AlmacenoDescripcionVenta(CodigoDescripcionVenta, CodigoVenta, ColaDatos.Sacar(), Seña);
				}
				if (Resultado == 0 && Cobrador==2) { Resultado = BD.AlmacenoFactura(Fecha, CodigoVenta, Total, Datos, nFactura, Cobrador); }
				if (Resultado == 0) { return Resultado; }
			}
			if (VentaSeñada) { Resultado = BD.FinalizarSeña(CodigoVenta,SeñaCierre); } // Cargar Datos de la Venta en Tabla Señas.
		}
		return Resultado;
	}
	
    public String ObtenerNombreDiaActual() { // Genera La Fecha En Tipo (NombreDia NumeroDia de NombreMes de Año)					
    	String FechaTemp;
    	FechaTemp = "";
    	Date Fecha;
    	Fecha = new Date();
    	FechaTemp = Fecha.toString();
    	FechaTemp = FechaTemp.substring(0,3);  	
    	if (FechaTemp.compareTo("Mon")==0) {FechaTemp = "Lunes";}
    	else if (FechaTemp.compareTo("Tue")==0) {FechaTemp = "Martes";}
    	else if (FechaTemp.compareTo("Wed")==0) {FechaTemp = "Miércoles";}
    	else if (FechaTemp.compareTo("Thu")==0) {FechaTemp = "Jueves";}
    	else if (FechaTemp.compareTo("Fri")==0) {FechaTemp = "Viernes";}
    	else if (FechaTemp.compareTo("Sat")==0) {FechaTemp = "Sabado";}
    	else if (FechaTemp.compareTo("Sun")==0) {FechaTemp = "Domingo";}
    	return FechaTemp;
    }
	
    public String CrearFechaConNombres() { // Genera La Fecha En Tipo (NombreDia NumeroDia de NombreMes de Año)					
    	String FechaTemp, FechaFinal;
    	FechaTemp = FechaFinal = "";
    	Date Fecha;
    	Fecha = new Date(); 	
    	FechaTemp = Fecha.toString();
    	FechaFinal = FechaTemp.substring(0,3);  	
    	if (FechaFinal.compareTo("Mon")==0) {FechaFinal = "Lunes ";}
    	else if (FechaFinal.compareTo("Tue")==0) {FechaFinal = "Martes ";}
    	else if (FechaFinal.compareTo("Wed")==0) {FechaFinal = "Miércoles ";}
    	else if (FechaFinal.compareTo("Thu")==0) {FechaFinal = "Jueves ";}
    	else if (FechaFinal.compareTo("Fri")==0) {FechaFinal = "Viernes ";}
    	else if (FechaFinal.compareTo("Sat")==0) {FechaFinal = "Sabado ";}
    	else if (FechaFinal.compareTo("Sun")==0) {FechaFinal = "Domingo ";}
    	FechaFinal += FechaTemp.substring(8,10);
    	if (FechaFinal.charAt(FechaFinal.length()-2)=='0') {FechaFinal = FechaFinal.substring(0,FechaFinal.length()-3) + " " + FechaFinal.charAt(FechaFinal.length()-1) + " de ";}
    	else { FechaFinal += " de "; }
    	if (FechaTemp.contains("Jan")) {FechaFinal += "Enero";}
    	else if (FechaTemp.contains("Feb")) {FechaFinal += "Febrero";}
    	else if (FechaTemp.contains("Mar")) {FechaFinal += "Marzo";}
    	else if (FechaTemp.contains("Apr")) {FechaFinal += "Abril";}
    	else if (FechaTemp.contains("May")) {FechaFinal += "Mayo";}
    	else if (FechaTemp.contains("Jun")) {FechaFinal += "Junio";}
    	else if (FechaTemp.contains("Jul")) {FechaFinal += "Julio";}
    	else if (FechaTemp.contains("Aug")) {FechaFinal += "Agosto";}
    	else if (FechaTemp.contains("Sep")) {FechaFinal += "Septiembre";}
    	else if (FechaTemp.contains("Oct")) {FechaFinal += "Octubre";}
    	else if (FechaTemp.contains("Nov")) {FechaFinal += "Noviembre";}
    	else if (FechaTemp.contains("Dec")) {FechaFinal += "Diciembre";}
    	FechaFinal += " de " + FechaTemp.substring(FechaTemp.length()-2,FechaTemp.length());
    	return FechaFinal;
    }
	
    public String CrearFechaConHora() { // Genera La Fecha y Hora En Tipo (DD/MM/AA HH:MM:SS)					
    	String FechaTemp, FechaFinal;
    	FechaTemp = FechaFinal = "";
    	Date Fecha;
    	Fecha = new Date(); 	
    	FechaTemp = Fecha.toString();
    	FechaFinal = FechaTemp.substring(8,10) + "/";
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
    	return FechaFinal;
    }
    
    public String CrearSoloFecha() { // Genera La Fecha En Tipo (DD/MM/AA)				
    	String FechaTemp, FechaFinal;
    	FechaTemp = FechaFinal = "";
    	Date Fecha;
    	Fecha = new Date();
    	FechaTemp = Fecha.toString();
    	FechaFinal = FechaTemp.substring(8,10) + "/";
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
    	FechaFinal += "/" + FechaTemp.substring(FechaTemp.length()-2,FechaTemp.length());
    	return FechaFinal;
    }
    
    public String CrearFechaInverso() {	// Genera La Fecha En Tipo (AAAA/MM/DD)				
    	String FechaTemp, FechaFinal;
    	FechaTemp = FechaFinal = "";
    	Date Fecha;
    	Fecha = new Date();
    	System.out.println(Fecha);
    	FechaTemp = Fecha.toString();
    	System.out.println("Fecha DEL DIA: " + FechaTemp);
    	FechaFinal += FechaTemp.substring(FechaTemp.length()-4,FechaTemp.length()) + "/";
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
    	FechaFinal += "/" + FechaTemp.substring(8,10);
    	System.out.println(FechaFinal);
    	return FechaFinal;
    }
    
    public String CrearHora() { // Genera La Hora En Tipo (HH:MM:SS)					
    	String Hora = "";
    	Date Fecha;
    	Fecha = new Date(); 	
    	Hora = Fecha.toString();
    	Hora = Hora.substring(11,19);
    	return Hora;
    }
    
	public LinkedList<String> ObtenerVentas(String Fecha) {
		LinkedList<String> DatosVentas = new LinkedList<String>();
		DatosVentas = BD.ObtenerVentas(Fecha);
		return DatosVentas;
	}
	
	public LinkedList<String[]> ObtenerVentasPDF() {
		LinkedList<String[]> DatosVentas = new LinkedList<String[]>();
		DatosVentas = BD.ObtenerVentasPDF();
		return DatosVentas;
	}
	
	public LinkedList<String> ObtenerVentasTotales() {
		LinkedList<String> DatosVentas = new LinkedList<String>();
		DatosVentas = BD.ObtenerVentasTotales();
		return DatosVentas;
	}

	public LinkedList<String> ObtenerGastosPorCaja() { 
		LinkedList<String> Gastos = new LinkedList<String>();
		Gastos = BD.ObtenerGastosPorCaja();
		return Gastos;
	}
	
	public LinkedList<String> ObtenerMovPorFecha() { 
		LinkedList<String> Mov = new LinkedList<String>();
		Mov = BD.ObtenerMovPorFecha();
		return Mov;
	}
	
	public LinkedList<String> ObtenerModPorFecha() { 
		LinkedList<String> Mod = new LinkedList<String>();
		Mod = BD.ObtenerModPorFecha();
		return Mod;
	}
	
/*	public int AlmacenoSeña(LinkedList<String> Productos) { 
		int NroSeña = BD.ObtenerNroSeña();
//		BD.AlmacenoSeña(Productos);
		return NroSeña;
	}*/
	
	public int ObtenerNroSeña() { return BD.ObtenerNroSeña(); }
	
	public Object[] BuscarDatosSeña(int NroSeña) { return BD.BuscarDatosSeña(NroSeña); }
	
	public LinkedList<String> BuscarNrosSeñas() { return BD.BuscarNrosSeñas(); }
	
  	public String AbrirCaja(String Cambio) { return BD.AbrirCaja(Cambio); }
  	
  	public int VerCajaAbierta() {return BD.VerCajaAbierta(); }
  	
  	public int AgregarGastos(String Descripcion, String Monto) { return BD.AgregarGastos(Descripcion, Monto); }
  	
  	public int CerrarCaja(String CambioProxCaja) { return BD.CerrarCaja(CambioProxCaja); }
  	
  	public void ResetearVentaNro() { BD.ResetearVentaNro(); }
  	
// 	public BigDecimal ObtenerCambio() { return BD.ObtenerCambio(); }
  	
  	public int IngresarProducto(String CodigoProducto, String Descripcion, int Cantidad, BigDecimal Precio, String Rubro, String Temporada, String Material, String Color, String Talle, String Marca, String Auditor, String TipoTalle) { 
  		return BD.IngresarProducto(CodigoProducto, Descripcion, Cantidad, Precio, Rubro, Temporada, Material, Color, Talle, Marca, Auditor, TipoTalle); }
  	
  	public LinkedList<String> BuscarProducto(int Flag, String Prod, String Rubro, int Precio1, int Precio2, int Cantidad, String Tempo) { 
  		return BD.BuscarProducto(Flag, Prod, Rubro, Precio1, Precio2, Cantidad, Tempo);
	}
  	
  	public LinkedList<String> BuscarProducto(String CodigoProducto) { return BD.BuscarProducto(CodigoProducto); }
  	
  	public LinkedList<String> BuscarProductoParaVenta(String CodigoProducto) { return BD.BuscarProductoParaVenta(CodigoProducto); }
  		
	public String ModificoPrecioProducto(String CodigoProducto, BigDecimal Precio) { return BD.ModificoPrecioProducto(CodigoProducto, Precio); }
  	
	public int ActualizoStock(LinkedList<String> Productos) throws SQLException { return BD.ActualizoStock(Productos); }
	
	public int ActualizoStockEntrada(LinkedList<String[]> Productos) throws SQLException { return BD.ActualizoStockEntrada(Productos); }
	      	
    public int DesactivarBD() {
    	int Resultado = BD.DesactivarBD();
    	if (Resultado==1) { System.out.println("No se pudo cerrar la base de datos"); }
    	else { System.out.println("La base de datos se cerró correctamente"); }
    	return Resultado;
    }
    
    public boolean CajaAbierta() { return BD.CajaAbierta(); }
    
    public LinkedList<String> BuscarRubros() { return BD.BuscarRubros(); }
    public LinkedList<String> BuscarMateriales() { return BD.BuscarMateriales(); }
    public LinkedList<String> BuscarColores() { return BD.BuscarColores(); }
    public LinkedList<String> BuscarTalles(String TipoTalle) { return BD.BuscarTalles(TipoTalle); }
    public LinkedList<String> BuscarMarcas() { return BD.BuscarMarcas(); }
    public LinkedList<String> BuscarTemporadas() { return BD.BuscarTemporadas(); }
    public LinkedList<String> BuscarAuditores() { return BD.BuscarAuditores(); }
    public LinkedList<Object[]> BuscarClientes() { return BD.BuscarClientes(); }
    public LinkedList<String> BuscarVendedoras() { return BD.BuscarVendedoras(); }
    public LinkedList<String> BuscarTiposTalles() { return BD.BuscarTiposTalles(); }
    
    public String BuscarRubroPorCodigo(String CodigoRubro) { return BD.BuscarRubroPorCodigo(CodigoRubro); }
    public String BuscarRubroPorDescripcion(String Descripcion) { return BD.BuscarRubroPorDescripcion(Descripcion); }
    
    public String BuscarMaterialPorCodigo(String CodigoMaterial) { return BD.BuscarMaterialPorCodigo(CodigoMaterial); }
    public String BuscarMaterialPorDescripcion(String Descripcion) { return BD.BuscarMaterialPorDescripcion(Descripcion); }
    
    public String BuscarColorPorCodigo(String CodigoColor) { return BD.BuscarColorPorCodigo(CodigoColor); }
    public String BuscarColorPorDescripcion(String Descripcion) { return BD.BuscarColorPorDescripcion(Descripcion); }
    
    public String BuscarTallePorCodigo(String CodigoTalle) { return BD.BuscarTallePorCodigo(CodigoTalle); }
    public String BuscarTallePorDescripcion(String Descripcion, String Tipo) { return BD.BuscarTallePorDescripcion(Descripcion,Tipo); }
    
    public String BuscarMarcaPorCodigo(String CodigoMarca) { return BD.BuscarMarcaPorCodigo(CodigoMarca); }
    public String BuscarMarcaPorDescripcion(String Descripcion) { return BD.BuscarMarcaPorDescripcion(Descripcion); }
    
    public String BuscarTemporadaPorCodigo(String CodigoTemporada) { return BD.BuscarTemporadaPorCodigo(CodigoTemporada); }
    public String BuscarTemporadaPorDescripcion(String Descripcion) { return BD.BuscarTemporadaPorDescripcion(Descripcion); }
    
    public String BuscarAuditorPorCodigo(String CodigoAuditor) { return BD.BuscarAuditorPorCodigo(CodigoAuditor); }
    public String BuscarAuditorPorDescripcion(String Descripcion) { return BD.BuscarAuditorPorDescripcion(Descripcion); }
    
    public String BuscarTalleRubro(String Rubro) { return BD.BuscarTalleRubro(Rubro); }
    
    public int CargarCliente(String Nombre,String Apellido, String Domicilio, String Telefono, String TipoResp, int NroCUIT, String TipoDoc, int Doc, int Codigo, String Usuario, String Servidor, BigDecimal Saldo) {
    	return BD.CargarCliente(Nombre, Apellido, Domicilio, Telefono, TipoResp, NroCUIT, TipoDoc, Doc, Codigo, Usuario, Servidor, Saldo);
    }
    
    public int BuscarCodigoCliente() { return BD.BuscarCodigoCliente(); }
    
    public int MovProducto(String CodigoProducto, String Cantidad) { return BD.MovProducto(CodigoProducto, Cantidad); }
    
  	public int AgregarMovimiento(String CodigoProducto, int Flag, int Cantidad, int TipoMov) { return BD.AgregarMovimiento(CodigoProducto, Flag, Cantidad, TipoMov); }
  	
  	public int VerificarLocal() { return BD.Local; }
  	
	public String BuscarTallePorMarca(String Marca) { return BD.BuscarTallePorMarca(Marca); }
	
	public String BuscarClientePorCodigo(int Codigo) { return BD.BuscarClientePorCodigo(Codigo); }
	
	public int IngresoSaldoCliente(int CodigoCliente, CColaPagos ColaPagos, int Flag2, BigDecimal Pago, BigDecimal Saldo, BigDecimal Deuda) { return BD.IngresoSaldoCliente(CodigoCliente,ColaPagos,Flag2,Pago,Saldo,Deuda); }
	
	public BigDecimal ObtenerSaldoCliente(int CodigoCliente) { return BD.ObtenerSaldoCliente(CodigoCliente); }
	
	public LinkedList<String> BuscarHistorialCliente(int CodigoCliente) { return BD.BuscarHistorialCliente(CodigoCliente); }
	
  	public int ObtenerLocalNro() { return BD.ObtenerLocalNro(); }

	public boolean VerificarCodigo(String codigoProducto) throws SQLException {	return BD.VerificarCodigo(codigoProducto); }

	public void SetearStock() throws SQLException { BD.SetearStock(); }

	public void ActualizarProducto(String codigoProducto, BigDecimal precio, int cantidad) throws SQLException { BD.ActualizarProducto(codigoProducto, precio, cantidad); }

	public void IngresarProducto(String codigoProducto, String detalle, BigDecimal precio, int cantidad) throws SQLException { BD.IngresarProducto(codigoProducto, detalle, precio, cantidad); }

	public int ActualizarProductoPorRemito(String codigoProducto, String Descripcion, int cantidad) throws SQLException { return BD.ActualizarProductoPorRemito(codigoProducto, Descripcion, cantidad); }

	public void cargarRemito(String nombreArchivo, int lineas) throws SQLException { BD.cargarRemito(nombreArchivo, lineas); }
	
	public LinkedList<Object[]> ObtenerCantidades() throws SQLException { return BD.ObtenerCantidades(); }
	
	public void ActivarBDCuentas() throws SQLException { try { BD.ActivarBDCuentas(); } catch (SQLException sqle) {} }

	public void DesactivarBDCuentas() throws SQLException { try { BD.DesactivarBDCuentas(); } catch (SQLException sqle) {} }
	
	public String ObtenerFechaCajaAbierta() { return BD.ObtenerFechaCajaAbierta(); }
	
	public String ObtenerUltimaVenta() { return BD.ObtenerUltimaVenta(); }

	public String ObtenerCambioCaja() { return BD.ObtenerCambioCaja(); }

	public int GrabarPDF(byte[] byteArray) { return BD.GrabarPDF(byteArray); }

	public int BorrarVenta(int index) { return BD.BorrarVenta(index); }
	
	public boolean VerificoClientesEnVentas(String Fecha) { return BD.VerificoClientesEnVentas(Fecha); }
	
	public String VerificarCajaAbierta() { return BD.VerificarCajaAbierta(); }

	public LinkedList<String> BuscarHistoricoVentas(int i) { return BD.BuscarHistoricoVentas(i); }

	public int IngresarNuevoCUIT(String text, String text2, String text3, String text4) { return BD.IngresarNuevoCUIT(text, text2, text3, text4); }

	public LinkedList<Object[]> BuscarClientesFacturas() { return BD.BuscarClientesFacturas(); }

	public int ObtenerIdUltimoClienteIngresado() { return BD.ObtenerIdUltimoClienteIngresado(); }

	public long ObtenerNroFact(int tipoVent) { return BD.ObtenerNroFact(tipoVent); }

	public LinkedList<String> BuscarHistoricoProducto(String Codigo) { return BD.BuscarHistoricoProducto(Codigo); }

	public boolean NegativosEnStock() { return BD.NegativosEnStock(); }

	public LinkedList<String> BuscarAsteriscos() { return BD.BuscarAsteriscos(); }

	public boolean BajaAsteriscos() { return BD.BajaAsteriscos(); }

	public int CargarDatosRecepcion(String text, String text2, String text3, String text4, String text5, String text6) { 
		return BD.CargarDatosRecepcion(text,text2,text3,text4,text5,text6);
	}

}
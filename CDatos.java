package Caja;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CDatos {
	
	public String CodigoProducto, Stock;
	public int ProdNro;
	public BigDecimal Precio;
	public String CargadoStock;
	public boolean CambioBD;
	
	public CDatos() {
		CodigoProducto = Stock = CargadoStock = "";
		ProdNro = 0;
		Precio = new BigDecimal(0);
		Precio = Precio.setScale(2, RoundingMode.HALF_UP);
		CambioBD = false;
	}
	
	public CDatos(CDatos Datos) {
		CodigoProducto = Datos.ObtenerCodigoProducto(); 
		ProdNro = Datos.ObtenerProdNro(); 
		Precio = Datos.ObtenerPrecio();
		Stock = Datos.ObtenerStock();
		CargadoStock = Datos.ObtenerCargadoStock();
	}
	
	public void Limpiar() {
		CodigoProducto = Stock = CargadoStock = "";
		ProdNro = 0;
		Precio = new BigDecimal(0);
		Precio = Precio.setScale(2, RoundingMode.HALF_UP);;
	}
	
	public void SetearCodigoProducto(String A1) { CodigoProducto = A1; }
	public void SetearStock(String A1) { Stock = A1; }
	public void SetearCargadoStock(String A1) { CargadoStock = A1; }
	public void SetearProdNro(int A1) { ProdNro = A1; }
	public void SetearPrecio(BigDecimal A1) { Precio = A1; }
	public void SetearBD(boolean CambioBD) { this.CambioBD = CambioBD; }
	
	public String ObtenerCodigoProducto() { return CodigoProducto; }
	public String ObtenerStock() { return Stock; }
	public String ObtenerCargadoStock() { return CargadoStock; }
	public int ObtenerProdNro() { return ProdNro; }
	public BigDecimal ObtenerPrecio() { return Precio; }
	public boolean ObtenerCambioBD() { return CambioBD; }
	
}
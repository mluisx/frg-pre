package Caja;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class CPagos {
	
	public String MetodoPago, Moneda;
	public BigDecimal Precio;

	public CPagos() {
		MetodoPago = Moneda = "";
		Precio = new BigDecimal(0);
		Precio = Precio.setScale(2, RoundingMode.HALF_UP);
	}

	public CPagos(CPagos Pagos) {
		MetodoPago = Pagos.ObtenerMetodoPago();
		Moneda = Pagos.ObtenerMoneda();
		Precio = Pagos.ObtenerPrecio();
	}

	public void Limpiar() {
		MetodoPago = Moneda = "";
		Precio = new BigDecimal(0);
		Precio = Precio.setScale(2, RoundingMode.HALF_UP);
	}

	public void SetearMetodoPago(String A1) { MetodoPago = A1; }
	public void SetearMoneda(String A1) { Moneda = A1; }
	public void SetearPrecio(BigDecimal A1) { Precio = A1; }

	public String ObtenerMetodoPago() { return MetodoPago; }
	public String ObtenerMoneda() { return Moneda; }
	public BigDecimal ObtenerPrecio() { return Precio; }

}


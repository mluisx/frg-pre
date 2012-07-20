package Caja;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pruebas {

	public static void main(String[] args) {
//		BigDecimal amount = new BigDecimal("100.05");
//		double numero = 125;
//		String Numeraso = Double.toString(numero);
		BigDecimal Numerito = new BigDecimal("");
		System.out.println("Numerito : " + Numerito);
		Numerito = Numerito.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Numerito (Redondeo) : " + Numerito);
		String Numerin  = "1.2";
		double aver = Double.parseDouble(Numerin);
		System.out.println("Numerin : " + aver);
		BigDecimal uno = new BigDecimal(-5);
		uno = uno.setScale(2, RoundingMode.HALF_UP);
		BigDecimal dos = new BigDecimal(-7.215);
		dos = dos.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Son Iguales! :" + uno + " " + dos);
		System.out.println("RESTAMOS :" + uno.subtract(dos));
		System.out.println("SUMAMOS :" + uno.add(dos));
		if (uno.compareTo(dos)==0) { 
			System.out.println("Son Iguales! :" + uno.doubleValue() + " " + dos.doubleValue());
		}
/*		BigDecimal discountPercent = new BigDecimal("0.10");
		BigDecimal discount = amount.multiply(discountPercent);
		discount = discount.setScale(2, RoundingMode.HALF_UP);
		BigDecimal total = amount.subtract(discount);
		total = total.setScale(2, RoundingMode.HALF_UP);
		BigDecimal taxPercent = new BigDecimal("0.05");
		BigDecimal tax = total.multiply(taxPercent);
		tax = tax.setScale(2, RoundingMode.HALF_UP);
		BigDecimal taxedTotal = total.add(tax);
		taxedTotal = taxedTotal.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Subtotal : " + amount);
		System.out.println("Discount(HALF UP) : " + discount);
		System.out.println("Total : " + total);
		System.out.println("Tax (HALF UP) : " + tax);
		System.out.println("Tax+Total: " + taxedTotal);*/
	}
}

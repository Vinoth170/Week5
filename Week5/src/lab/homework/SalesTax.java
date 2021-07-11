package lab.homework;

public class SalesTax {
	public static void main(String[] args) {
		double price=Double.parseDouble(args[0]);
		double tax=(new SalesTax()).tax(price);
		double totalPrice=price+tax;
		System.out.printf("Price of the Product:\t%f\nTax:\t%f\nTotal Price:\t%f",price,tax,totalPrice);
	}
	
	public double tax(double price) {
		final double tax=0.0525;
		double taxValue=tax*price;
		return taxValue;
	}
}
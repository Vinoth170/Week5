package lab.homework;

public class SalesTax2 {
	public static void main(String[] args) {
		float price=0f;
		for(String i: args) {
			System.out.println("Price:\t"+i);
			price+=Float.parseFloat(i);
		}
		float tax=(new SalesTax2().tax(price));
		float totalPrice=price+tax;
			System.out.printf("Price sum:\t%f\nTax:\t%f\nTotal Price:\t%f",price,tax,totalPrice);
	}
	public float tax(float price) {
		final float tax=.0525f;
		float taxValue=tax*price;
		return taxValue;
	}
}

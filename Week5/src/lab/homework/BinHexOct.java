package lab.homework;

import java.util.Scanner;

public class BinHexOct {
	static Type t;
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the value: ");
		int a=Integer.parseInt(scan.nextLine());
		BinHexOct obj=new BinHexOct();
		
		System.out.println("To what you would like to convert:\nBinary\tHexadecimal\tOctal");
		t=(Type)Class.forName("lab.homework."+scan.nextLine()).getDeclaredConstructor().newInstance();
		
		System.out.println("The converted value is "+obj.type(t, a));
	}
	public String type(Type obj, int a) {
		return obj.convert(a);
	}
}

abstract class Type{
	abstract public String convert(int a);
}

class Binary extends Type{
	public Binary() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String convert(int a) {
		return Integer.toBinaryString(a);
	}
}

class Hexadecimal extends Type{
	public Hexadecimal() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String convert(int a) {
		return Integer.toHexString(a);
	}
}

class Octal extends Type{
	public Octal() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String convert(int a) {
		return Integer.toOctalString(a);
	}
}
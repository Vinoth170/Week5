package lab.homework;

class A{}
public class B extends A{
	public static void main(String[] args) {
		A myA=new B();
		m2(myA);
	}
	public static void m2(A a) {
		if(a instanceof B) 
			((B)a).doBStuff();//Downcasting an A reference to a B reference
	}
	public static void doBStuff() {
		System.out.println("'a' refers to B");
	}
}

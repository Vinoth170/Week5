package lab.homework;


public class StringBufferDemo extends Thread{
	StringBuffer str;
	public StringBufferDemo(StringBuffer str) {
		this.str=str.append(str);
	}
	
	@Override
	public void run() {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("A");
		StringBufferDemo t1=new StringBufferDemo(str);
		StringBufferDemo t2=new StringBufferDemo(str);
		StringBufferDemo t3=new StringBufferDemo(str);
		t1.start();
		t2.start();
		t3.start();
	}
}

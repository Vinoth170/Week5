package lab;

public class ThreadDemo1 {
	public static void main(String[] args)throws Exception {
		Thread t= Thread.currentThread();
		t.setName("This is my main thread...");
		t.setPriority(10);
		System.out.println("Now thread will sleep for 5 seconds...");
		met();
		System.out.println(t);
	}
	static void met()throws Exception {
		System.out.println("Method called...");
		Thread.sleep(5000);
	}
}

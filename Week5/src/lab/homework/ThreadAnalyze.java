package lab.homework;

public class ThreadAnalyze {
	public static void main(String[] args) {
		Thread t=new Thread(()->{System.out.println("Child thread is executed....");});
		t.start();
		t.start();//When try to start a thread multiple time "IllegalThreadStateException" exception is thrown.
	}
}
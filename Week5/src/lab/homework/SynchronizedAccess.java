package lab.homework;
//Synchronized access to multiple threads to print different message.
public class SynchronizedAccess {
	public static void main(String[] args) {
		PrintMessage show=new PrintMessage();
		Runnable msg=new Runnable() {
			
			@Override
			public void run() {
				synchronized (show) {
					show.greetingMessage();
					show.thankMessage();
				}
			}
		};
		new Thread(msg,"P1").start();
		new Thread(msg,"P2").start();
		new Thread(msg,"P3").start();
		new Thread(msg,"P4").start();
	}
}

class PrintMessage{
	String name;
	public void greetingMessage() {
		name=Thread.currentThread().getName();
		System.out.println("---"+name+", welcome to threads---");
	}
	
	public void thankMessage() {
		System.out.println("---"+name+", thank you for visiting---");
	}
}
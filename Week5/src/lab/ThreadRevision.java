package lab;

public class ThreadRevision {
	public ThreadRevision() {
		Thread child=new Thread(new ThreadJob());
		child.start();
	}
	public static void main(String[] args) {
		new ThreadRevision();
//		Thread t=Thread.currentThread();
//		System.out.println(t);
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
//				Thread.sleep(1000);
			}catch(Exception ex) {}
		}
	}
}

class ThreadJob implements Runnable{
	@Override
	public void run() {
		System.out.println("Child thread is executed...");
	}
}

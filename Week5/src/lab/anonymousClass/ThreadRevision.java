package lab.anonymousClass;

public class ThreadRevision {
	public ThreadRevision() {
		Thread child=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Child Thread is runned...");
			}
		});
		child.start();
	}
	
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		System.out.println(t.getName());
		new ThreadRevision();
		for(int i=0;i<5;i++) {
			
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {}
			System.out.println(i);
		}
	}
}

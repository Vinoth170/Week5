package lab.lambda;

public class ThreadRevision {
	public ThreadRevision() {
		Runnable threadLogic=()->{
			System.out.println("Child Thread is runned...");
		};
		
		Thread child=new Thread(threadLogic);
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

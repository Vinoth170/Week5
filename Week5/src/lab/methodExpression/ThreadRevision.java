package lab.methodExpression;

public class ThreadRevision {
	public ThreadRevision() {
		Runnable threadLogic=ThreadRevision::thread;//if we use non static method, we need to use new which will leads to stack over flow.
		//Because, when new instance occur, object will be created.
		//Since we are using constructor and for thread, and if we use like that, it will invoke new instance continuous. Hence stack over flow occurs
		
		Thread child=new Thread(threadLogic);
		child.start();
	}
	
	public static void thread() {
		System.out.println("Child Thread is runned...");
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

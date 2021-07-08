package lab.methodExpression;

public class CanonDemo {
	Canon canon=new Canon();
	public void task() {
		Thread t=Thread.currentThread();
		if(t.getName().equals("Shooter")) {
			for(int i=0;i<5;i++)
				canon.fireCanon();
		}
		else if(t.getName().equals("Filler")) {
			for(int i=0;i<5;i++)
				canon.fillCanon();
		}
	}
	
	public static void main(String[] args) {
		Runnable execute=new CanonDemo()::task;
		new Thread(execute,"Filler").start();
		new Thread(execute,"Shooter").start();
	}
}

class Canon{
	boolean flag;
	synchronized public void fillCanon(){
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(flag) {
			try {wait();}catch(Exception ex) {}
		}
		System.out.println(name+" fills the canon....");
		flag=true;
		notify();
	}
	
	synchronized public void fireCanon(){
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(!flag) {
			try {wait();}catch(Exception ex) {}
		}
		System.out.println(name+" fires the canon....");
		flag=false;
		notify();
	}
}
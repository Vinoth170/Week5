package lab;

public class CanonDemo {
	public static void main(String[] args) {
		Canon task=new Canon();
		CanonTask operator=new CanonTask(task);
		Thread shooter=new Thread(operator ,"shooter");
		Thread filler=new Thread(operator,"filler");
		shooter.start();
		filler.start();
	}
}

class CanonTask implements Runnable{
	Canon task;
	
	public CanonTask(Canon task) {
		this.task=task;
	}
	
	@Override
	public void run() {
		Thread t=Thread.currentThread();
		if(t.getName().equals("shooter")) {
			for(int i=0;i<5;i++)
				task.fireCanon();
		}
		else if(t.getName().equals("filler")) {
			for(int i=0;i<5;i++)
				task.fillCanon();
		}
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
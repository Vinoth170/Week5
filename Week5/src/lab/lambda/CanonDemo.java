package lab.lambda;

public class CanonDemo {
	public static void main(String[] args) {
		Canon task=new Canon();
		Runnable person=()->{
			Thread t=Thread.currentThread();
			if(t.getName().equalsIgnoreCase("Sam"))
				for(int i=0;i<5;i++)
					task.fillCanon();
			else if(t.getName().equalsIgnoreCase("Jack"))
				for(int i=0;i<5;i++)
					task.fireCanon();
		};

		Thread sam=new Thread(person,"Sam");
		Thread jack=new Thread(person,"Jack");
		sam.start();
		jack.start();
	}
}

class Canon{
	boolean flag;
	synchronized public void fillCanon(){
		Thread t=Thread.currentThread();
		if(flag)
			try {wait();}catch(Exception ex) {}
		System.out.println(t.getName()+" fills the canon");
		flag=true;
		notify();
	}
	
	synchronized public void fireCanon(){
		Thread t=Thread.currentThread();
		if(!flag)
			try {wait();}catch(Exception ex) {}
		System.out.println(t.getName()+" fires the canon");
		flag=false;
		notify();
	}
}
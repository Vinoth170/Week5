package lab.anonymousClass;

public class CanonDemo {
	public static void main(String[] args) {
		Canon task=new Canon();
//		Runnable p=new Runnable(){
//			@Override
//			public void run() {
//				Thread t=Thread.currentThread();
//				if(t.getName().equalsIgnoreCase("Sam"))
//					for(int i=0;i<5;i++)
//						task.fillCanon();
//				else if(t.getName().equalsIgnoreCase("Jack"))
//					for(int i=0;i<5;i++)
//						task.fireCanon();
//			}
//		};
//
//		Thread sam=new Thread(p,"Sam");
//		Thread jack=new Thread(p,"Jack");
//		sam.start();
//		jack.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++)
					task.fillCanon();
			}
		},"Sam").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++)
					task.fireCanon();
			}
		},"Jack").start();
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
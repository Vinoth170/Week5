package lab.anonymousClass;

public class DeadLockDemo {
	public static void main(String[] args) {
		Crane crane=new Crane();
		Frog frog=new Frog();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				crane.eatFrog(frog);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				frog.escape(crane);
			}
		}).start();
	}
}

class Crane{
	synchronized public void eatFrog(Frog frog) {
		System.out.println("Crane tries to eat frog");
		frog.leaveCallByCrane();
	}
	
	synchronized public void leaveCallByFrog() {
		
	}
}

class Frog{
	synchronized public void escape(Crane crane) {
		System.out.println("Frog tries to escape");
		crane.leaveCallByFrog();
	}
	
	synchronized public void leaveCallByCrane() {
		
	}
}
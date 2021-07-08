package lab.methodExpression;

public class DeadLockDemo {
	Crane crane=new Crane();
	Frog frog=new Frog();
	public static void main(String[] args) {
		DeadLockDemo deadlock=new DeadLockDemo();
		Runnable eat=deadlock::eatFrog;
		Runnable escape=deadlock::escape;
		Thread c=new Thread(eat,"Crane");
		Thread f=new Thread(escape,"Frog");
		c.start();
		f.start();
	}
	
	public void eatFrog(){
		crane.eatFrog(frog);
	}
	
	public void escape() {
		frog.escape(crane);
	}
}

class Crane{
	synchronized public void eatFrog(Frog frog){
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
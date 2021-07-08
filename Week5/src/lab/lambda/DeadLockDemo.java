package lab.lambda;

public class DeadLockDemo {
	public static void main(String[] args) {
		Crane crane=new Crane();
		Frog frog=new Frog();
		Runnable eat=()->{crane.eatFrog(frog);};
		Runnable escape=()->{frog.escape(crane);};
		Thread c=new Thread(eat,"Crane");
		Thread f=new Thread(escape,"Frog");
		c.start();
		f.start();
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
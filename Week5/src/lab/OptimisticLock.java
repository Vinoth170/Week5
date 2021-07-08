package lab;

public class OptimisticLock {
	public static void main(String[] args) {
		CounsellingJob interview=new CounsellingJob(new CounsellingHall());
		Thread rishi=new Thread(interview, "Rishi");
		Thread kumar=new Thread(interview,"Kumar");
		rishi.setPriority(1);
		rishi.start();
		kumar.start();
	}
}

class CounsellingJob implements Runnable{
	CounsellingHall hall;
	public CounsellingJob(CounsellingHall hall) {
		this.hall=hall;
	}
	
	@Override
	public void run() {
		String name =Thread.currentThread().getName();
		if(name.equalsIgnoreCase("Kumar")) {
			hall.table1();hall.table2();
		}
		else if(name.equalsIgnoreCase("Rishi")){
			hall.water();
		}
	}
}

class CounsellingHall{
	synchronized public void table1() {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" entered the table1");
	}
	synchronized public void table2() {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" entered the table2");
	}
	public void water() {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" drinks water");
	}
}
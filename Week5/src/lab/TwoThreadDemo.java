package lab;

public class TwoThreadDemo {
	public static void main(String[] args) {
		ReservationCounter1 ticket=new ReservationCounter1();
		Thread krish=new Thread(new BookTicket(ticket,500), "Krish");
		Thread prem=new Thread(new BookTicket(ticket,1000), "Prem");
		krish.start();
		prem.start();
	}
}

class BookTicket implements Runnable{
	ReservationCounter1 ticket;int amt;
	public BookTicket(ReservationCounter1 ticket,int amt) {
		this.amt=amt;
		this.ticket=ticket;
	}
	@Override
	public void run() {
		synchronized (ticket) {
			ticket.giveTicket(amt);
			ticket.giveChange();
		}
	}
}

class ReservationCounter1{
	String name;int amt;
	void giveTicket(int amt) {
		Thread t=Thread.currentThread();
		this.amt=amt;
		name=t.getName();
		System.out.println("Ticket booked for "+ name);
		System.out.println(name+" gives " +amt);
	}
	
	void giveChange() {
		System.out.println("Change given to "+name+" is "+(amt-100));
	}
}
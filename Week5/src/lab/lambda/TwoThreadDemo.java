package lab.lambda;

import java.util.Scanner;

public class TwoThreadDemo {
	public static void main(String[] args) {
		ReservationCenter ticket=new ReservationCenter();
		Runnable book=()->{ticket.getTicket();ticket.giveChange();};
		Thread karan=new Thread(book,"Karan");
		Thread priya=new Thread(book,"Priya");
		karan.start();
		priya.start();
	}
}

class ReservationCenter{
	int amt;String name;
	synchronized void getTicket() {
		this.amt=amount();
		name =Thread.currentThread().getName();
		System.out.println("Ticket booked for "+name);
		System.out.println(name+ " gives "+amt);
	}
	
	synchronized void giveChange() {
		System.out.println(name+" got change: "+(amt-100));
	}
	synchronized int amount() {
		System.out.print("Enter the amount: ");
		int amt=(new Scanner(System.in)).nextInt();
		return amt;
	}
}
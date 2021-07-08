package lab.methodExpression;

import java.util.Scanner;

public class TwoThreadDemo {
	ReservationCenter ticket=new ReservationCenter();
	public void counter() {
		ticket.getTicket();
		ticket.giveChange();
	}
	
	public static void main(String[] args) {
		Runnable book=new TwoThreadDemo()::counter;
		Thread karan=new Thread(book,"Karan");
		Thread priya=new Thread(book,"Priya");
		karan.start();
		priya.start();
	}
}

class ReservationCenter{
	int amt;String name;
	synchronized public int amount() {
		System.out.print("Enter the amount: ");
		int amt=(new Scanner(System.in)).nextInt();
		return amt;
	}
	synchronized public void getTicket() {
		this.amt=amount();
		name =Thread.currentThread().getName();
		System.out.println("Ticket booked for "+name);
		System.out.println(name+ " gives "+amt);
	}
	
	synchronized public void giveChange() {
		System.out.println(name+" got change: "+(amt-100));
	}
}
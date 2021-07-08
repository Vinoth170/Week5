package lab.anonymousClass;

import java.util.Scanner;

public class TwoThreadDemo {
	public static void main(String[] args) {
		ReservationCenter ticket=new ReservationCenter();
		Thread karan=new Thread(new Runnable() {
			
			@Override
			public void run() {
				ticket.getTicket();ticket.giveChange();
			}
		},"Karan");
		Thread priya=new Thread(new Runnable() {
			
			@Override
			public void run() {
				ticket.getTicket();ticket.giveChange();
			}
		},"Priya");
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
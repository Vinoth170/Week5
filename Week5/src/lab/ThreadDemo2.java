package lab;

import java.util.Date;

public class ThreadDemo2 {
	public static void main(String[] args) throws Exception{
		GrossaryShop grossary=new GrossaryShop();
		Thread t=Thread.currentThread();
		t.setName("Karthick");
		Thread ramu=new Thread(new ToServant(grossary), "Ramu");
		System.out.println("Time: "+new Date());
//		grossary.buyGrossary();
		ramu.start();
		System.out.println(t.getName()+" entered meeting at "+new Date());
		
	}
}

class ToServant implements Runnable{
	
	GrossaryShop grossary;
	public ToServant(GrossaryShop grossary) {
		this.grossary=grossary;
	}
	
	@Override
	public void run(){
		try {
			grossary.buyGrossary();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GrossaryShop{
	void buyGrossary() throws Exception{
		Thread t=Thread.currentThread();
		for(int i=0; i<5;i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println(t.getName()+ " wait at grossary shop for 5 secs...");
		System.out.println(t.getName()+" went to grossary shop");
	}
}
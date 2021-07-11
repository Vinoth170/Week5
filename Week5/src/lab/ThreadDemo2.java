package lab;

import java.util.Date;

public class ThreadDemo2 {
	public static void main(String[] args) throws Exception{
		GroceryShop grocery=new GroceryShop();
		Thread t=Thread.currentThread();
		t.setName("Karthick");
		Thread ramu=new Thread(new ToServant(grocery), "Ramu");
		System.out.println("Time: "+new Date());
//		grocery.buyGrocery();
		ramu.start();
		System.out.println(t.getName()+" entered meeting at "+new Date());
		
	}
}

class ToServant implements Runnable{
	
	GroceryShop grocery;
	public ToServant(GroceryShop grocery) {
		this.grocery=grocery;
	}
	
	@Override
	public void run(){
		try {
			grocery.buyGrocery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GroceryShop{
	void buyGrocery() throws Exception{
		Thread t=Thread.currentThread();
		for(int i=0; i<5;i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println(t.getName()+ " wait at grocery shop for 5 secs...");
		System.out.println(t.getName()+" went to grocery shop");
	}
}

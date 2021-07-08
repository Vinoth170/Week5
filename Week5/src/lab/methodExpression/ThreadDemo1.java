package lab.methodExpression;

import java.util.Date;

public class ThreadDemo1 {
	GrossaryShop grossary=new GrossaryShop();
	public static void main(String[] args) {
		System.out.println("Time: "+new Date());
		Runnable servant=new ThreadDemo1()::doJob;
		Thread t=Thread.currentThread();
		t.setName("Vishnu");
		Thread hari=new Thread(servant,"Hari");
//		grossary.buyGrossary();
		System.out.println(t.getName()+" entered meeting at"+ new Date());
		hari.start();
	}
	public void doJob() {
		grossary.buyGrossary();
	}
}

class GrossaryShop{
	void buyGrossary(){
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" went to grossary shop");
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try{
				t.sleep(1000);
			}catch(Exception ex) {}
		}
		System.out.println(t.getName()+" bought the grossaries");
	}
}

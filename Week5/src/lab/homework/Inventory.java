package lab.homework;

public class Inventory {
	public static void main(String[] args) {
		Product task=new Product(new People());
		Thread customer=new Thread(task,"Consumer");
		Thread producer=new Thread(task,"Producer");
		customer.start();
		producer.start();
	}
}

class Product implements Runnable{
	People p;
	public Product(People p) {
		this.p=p;
	}
	
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		if(name.equals("Producer"))
			p.producer();
		else if(name.equals("Consumer"))
			p.consumer();
	}
}

class People{
	boolean flag;int product;
	synchronized public void producer() {
		if(flag)
			try {wait();}catch(Exception e) {}
		System.out.println("Product added to the inventory by "+Thread.currentThread().getName());
		product+=1;
		System.out.println("No. of product in the inventory: "+product);
		flag=true;
		notify();
	}
	
	synchronized public void consumer() {
		if(!flag)
			try {wait();}catch(Exception e) {}
		System.out.println("Product bought from the inventory by "+Thread.currentThread().getName());
		product-=1;
		System.out.println("No. of product in the inventory: "+product);
		flag=false;
		notify();
	}
}
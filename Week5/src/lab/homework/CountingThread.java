package lab.homework;

public class CountingThread {
	public static void main(String[] args) {
		Count count=new Count();
		int num=100;
		new Thread(()->{for(int i=0;i<num/10;i++)count.msg();}).start();
		new Thread(()->{for(int i=1;i<=num;i++)count.countNum(i);}).start();
	}
}

class Count{
	
	boolean flag;
	public synchronized void countNum(int num){
		if(flag)
			try{wait();}catch(Exception e) {}
		try{Thread.sleep(1000);}catch(Exception e) {}
		System.out.println(num);
		if(num%10==0) {
			flag=true;
			notify();
		}
	}
	
	public synchronized void msg() {
		if(!flag)
			try{wait();}catch(Exception e) {}
		System.out.println("Remainder after 10 counts...");
		flag=false;
		notify();
	}
}
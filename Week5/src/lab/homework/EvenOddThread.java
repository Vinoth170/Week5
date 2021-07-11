package lab.homework;
/*
 * Program to print odd and even number with different threads, one for odd and another for even.
 */
public class EvenOddThread {
	public static void main(String[] args) {
		Numbers number=new Numbers();
		
		//Thread logic with lambda method
		new Thread(()->{for(int i=1;i<=100;i++)number.oddNum(i);},"Odd").start();
		new Thread(()->{for(int i=1;i<=100;i++)number.evenNum(i);},"Even").start();
		
	}
}

class Numbers {
	boolean flag;
	
	synchronized public void oddNum(int num) {
		if(!flag)
			try {wait();}catch(Exception e) {}
		if(num%2!=0)
			System.out.println(Thread.currentThread().getName()+":\t"+num);
		flag=false;
		notify();
	}
	
	synchronized public void evenNum(int num) {
		if(flag)
			try {wait();}catch(Exception e) {}
		if(num%2==0)
			System.out.println(Thread.currentThread().getName()+":\t"+num);
		flag=true;
		notify();
	}
}
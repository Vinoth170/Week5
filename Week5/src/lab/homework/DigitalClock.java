package lab.homework;

import java.util.Date;
//The program for digital clock.
public class DigitalClock {
	public static void main(String[] args)throws Exception {
		while(true) {
			Thread.sleep(1000);
			System.out.printf("%s %2$tr\n","Time: ",new Date());//This statement prints time for each 1 sec.
		}
	}
}

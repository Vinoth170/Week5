package lab.homework;

public class ArgUpper {
	public static void main(String[] args) {//Command line arguments given
		for(String i: args)
			System.out.println(i.toUpperCase());//prints command line string arguments in upper case
	}
}

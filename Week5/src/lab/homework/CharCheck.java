package lab.homework;

import java.util.Scanner;

public class CharCheck {
	static char ch;
	public static void main(String[] args)throws Exception{
		
		System.out.println("Enter a character: ");
		ch=((new Scanner(System.in)).nextLine()).charAt(0);
		
		System.out.print("The character is alphabet: ");
		System.out.println(Character.isAlphabetic(ch));
		System.out.print("The character is digit: ");
		System.out.println(Character.isDigit(ch));
		System.out.print("The character is blank space: ");
		System.out.println(Character.isSpaceChar(ch));
	}
}

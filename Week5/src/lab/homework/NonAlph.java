package lab.homework;
/*
 * To execute a process until a non-alphabetic value occurs
 */

public class NonAlph {
	static int len;
	public static void main(String[] args){//args value is given as Vin*oth 170 MCA
		NonAlph alph=new NonAlph();
		outer: for(String i:args)
			for(char j:i.toCharArray())
				if(Character.isAlphabetic(j))
					alph.execute(j);//The execute method will be called until a non-alphabetic value occurs for the first time
				else {
					alph.execute();
					break outer;//The nested loop will break when facing a non-alphabetic value
				}
	}
	public void execute() {
		try {
			throw new NonAlphException("Non-alphabetic letter is occured....");
		}catch(NonAlphException e) {
			System.out.println(e);
		}
	}
	public void execute(char ch) {
		System.out.printf("Program is executing....\n The character is %c\n",ch);
		
	}
}

class NonAlphException extends Exception{
	String msg;
	public NonAlphException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}
}

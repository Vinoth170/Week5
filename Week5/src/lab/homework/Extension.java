package lab.homework;

public class Extension {
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer(args[0]);
		System.out.println("Given file: "+str);
		str.replace(str.lastIndexOf(".")+1, str.length(), "pdf");
		System.out.println("After Conversion into pdf...");
		System.out.println("Converted file: "+str);
	}
}

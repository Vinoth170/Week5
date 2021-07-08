package lab;

import java.util.StringJoiner;
public class GarbageDemo {
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Free Memory...:"+r.freeMemory());
		GrandFather daddu=new GrandFather();
		System.out.println("After Daddu is born..Free Memory..:"+r.freeMemory());
		
		String s="hello";
		String temp=s;
		s=s+"world";
		
		System.out.println(temp);
		
		StringBuffer sb=new StringBuffer("hello");
		StringBuffer sbtemp=sb;
		sb.append("world");
		System.out.println(sbtemp);
	}
}
class GrandFather{
//	StringBuilder age=new StringBuilder();
//	String age;
	StringJoiner age=new StringJoiner(",");
	public GrandFather() {
		for(int i=0;i<100000;i++) {
//			age.append("aaaa"+i);
//			age=new String("aaa"+i);
			age.add("aa"+i);
		}
	}
}
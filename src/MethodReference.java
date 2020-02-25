import java.util.Arrays;
import java.util.List;

interface Aa{
//	public abstract void m1();
//	public abstract void m1(String s);
	public void m3();
//	public void m4(String s);
}

class Ba {
//	Ba(){
//		System.out.println("constructor Ba");
//	}
//	public static void m2(){
//		System.out.println("static Ba");
//	}
	public void m3(){
		System.out.println("non-static Ba");
	}
	
	public void m4(String s){
		System.out.println(s);
	}
}
public class MethodReference {
	
	public static void main(String[] args){
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		
		//prinln is method of System.out
//		list.forEach(System.out::println);
		
		//constructor reference
//		Aa a=Ba::new;
		
		//static method
//		Aa a=Ba::m2;
		
		//non static method 
//		Ba b =  new Ba();
//		Aa a=b::m3;
		//or
		Aa a=new Ba()::m3;
		a.m3();
		
//		Aa a=new Ba()::m4;
		
		//with argument
//		a.m1("jhdgsfa");
		
		//without argument
//		a.m1();
		
		
		
	}
}

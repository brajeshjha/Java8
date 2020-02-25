import java.util.function.Consumer;

interface I{
	//public void m(int x);
	//public void m(int x,int y);
	public int m(String s);
}
 /*
  *We don't need this class if we are using inner class or lambda  
  */
//class A implements I{
//	@Override
//	public void m(int x) {
//		System.out.println("abcd");
//	}	
//}

/*
 * Lambda expressions are implementation of interface
 */
public class Lambda {
	
	public static void main(String[] args) {

		I obj;
		
		//obj = new A();
		/*
		 * Anonymous inner class-since there is no name of the class and implements method
		 * class file is created naming Lambda$1.java
		 */
//		obj = new I()
//		{
//			public void m(int x)
//			{
//				System.out.println("Hello "+x);
//			}
//		};
		
//		obj=(int x) -> 
//		{
//			System.out.println("HAkuna matata, "+x+"baara kehta hu");
//			System.out.println("jahjhvaj");
//		};
		
//		obj=(x) -> System.out.println("HAkuna matata, "+x+"baara kehta hu");
		
//		obj= x -> System.out.println("HAkuna matata, "+x+"baara kehta hu");//for single parameter () not required
		
//		obj=(x,y) -> System.out.println("HAkuna matata, "+x+y+"baara kehta hu");
		
//		obj.m(2);
//		obj.m(2,3);
		
		
		/*
		 * Type inference
		 */
//		obj=x -> x.length();
//		print(obj);
			
		print(obj=x -> x.length());
		 
	}
	
	public static void print(I o)
	{
		System.out.println(o.m("hiiii"));
	}
	
}

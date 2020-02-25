
/*
 * "Anonymous doesn't require Function Interface" for its implementation,
 * but, "Lambda necessarily requires Functional interface."
 * Functional interface can not contain more than one method.
 * 
 * "@FunctionalInterface makes interface purely functional interface, can't add more thane one method "
 * 
 * "Functional interface can contain any number of default methods."
 * Functional interface can contain variables but implementation can not use those variables
 * Anonymous class does not have any name,
 * but it "creates a class file" with name as LambdaVsAnonymous$1
 * Lambda Expression does not create any class file
 * default method can be accessed by implementing both Lambda and anonymous
 */

@FunctionalInterface
interface Interface{
	
	int x=10;
	
	public void m1();
	
//	public void m2();
	
	default void m3(){
		System.out.println("default 1");
	}
	
	default void m4(){
		System.out.println("default 2");
	}
	
	
}


public class LambdaVsAnonymous {

	public static void main(String[] args) {
		
		Interface i;
		
		i=new Interface()
		{
			public void m1() {
				System.out.println("inner class-m1-"+x);
			}

//			@Override
//			public void m2() {
//				System.out.println("inner class-m2-"+x);
//				
//			}	
		};
		
		i.m1();
//		i.m2();
		i.m3();
		i.m4();
		
		
		i=() -> System.out.println("lambda expression");	
		i.m1();
		i.m3();
		i.m4();
		
	}

}

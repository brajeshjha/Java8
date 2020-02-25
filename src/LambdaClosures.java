
/*
 * Closures in Lambda
 * before java 8 compiler will strictly ask to make final local variable(which is used) 
 * but since java 8 compiler will allow without final but will ask compiler to skip the violation of changing the value
 */

interface Process{
	void process(int i);
}

public class LambdaClosures {

	public static void main(String[] args) {
		
		int a=10;
		int b=20;
		
//		Process p=new Process(){
//
//			@Override
//			public void process(int i) {
				/*
				 * this will create error and will ask to make b final, since value can not be changed in this case
				 */
				//b=40;
//				System.out.println(i+b);
//			}
//			
//		};
//		doProcess(a,p);
		
//		Process p=i -> System.out.println(i);
//		doProcess(a,p);
		
		
		doProcess(a,i -> {
			/*
			 * Local variable b defined in an enclosing scope must be final or effectively final
			 */
			//b=40;
			System.out.println(i+b);
		});

	}

	/*
	 * look properly and see that b is passed to this method without explicitly passing it
	 */
	private static void doProcess(int a,Process p) {
		p.process(a);
	}

}

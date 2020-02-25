
public class LambdaThisReference {

	public void doProcess(int i,Process p){
		p.process(i);
	}
	
	private void execute() {
		//this 
		doProcess(10, i -> {
			System.out.println("Value of this is "+i);
			
			System.out.println(this);
			/*
			 * here lambda-this works because it calls 'this' which should be outside of doProcess() method call
			 * execute-this refers to 'execute()' which refers 'thisReference' instance
			 */
		}
		);
		
	}
	public static void main(String[] args) {
		
		LambdaThisReference thisReference = new LambdaThisReference();
		
		thisReference.doProcess(10, new Process(){
			@Override
			public void process(int i) {
				System.out.println("Value of this is "+i);
				
				System.out.println(this);
				/*
				 * this will work here because its inner class
				 */
			}
			public String toString() {
				return "Anonymous inner class of (Process)";
			}
			
		});
		
		//this
//		thisReference.doProcess(10,  i -> {
//							System.out.println("Value of this is "+i);
//							
//							//System.out.println(this);
//							/*
//							 * 'this' will not work here because its lambda
//							 * lambda-this refers to psvm-this which is not allowed in lambda
//							 * but in case of inner class 'this' will work because it overrides psvm-this
//							 * innerclass-this refers to inner class
//							*/
//						}
//							
//		);
		
//		thisReference.execute();
	}

	@Override
	public String toString() {
		return "LambdaThisReference Class";
	}
	
}

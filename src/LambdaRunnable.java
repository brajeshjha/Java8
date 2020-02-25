

public class LambdaRunnable {

	public static void main(String[] args) {
		
		Thread t;
		t=new Thread( new Runnable(){

			@Override
			public void run() {
				System.out.println("anonymous runnable");
			}
			
		});
		t.run();//start();
		
		t=new Thread(() -> System.out.println("lambda runnable"));
		t.run();
		
	}

}

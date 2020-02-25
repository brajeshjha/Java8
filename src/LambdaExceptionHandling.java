import java.util.function.BiConsumer;

public class LambdaExceptionHandling {

	public static void main(String[] args) {
		
		int[] x = {10,20,30,40};
		int y=0;
		
		try{
		divide(x,y,(i,j) -> System.out.println(i/j));
		}
		catch(ArithmeticException e){
			System.out.println("Divide by 0, please provide correct input!");
		}

	}

	private static void divide(int[] x, int y, BiConsumer<Integer,Integer> biconsumer) {
		for(int a: x){
			biconsumer.accept(a, y);
		}
		
	}

}

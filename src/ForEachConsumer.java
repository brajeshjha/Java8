import java.util.Arrays;
import java.util.List;
//import java.util.function.Consumer;

//class ConsumerImpl implements Consumer<Integer> {
//	@Override
//	public void accept(Integer t) {
//		System.out.println(t);
//	}
//}


public class ForEachConsumer {
	
	public static void main(String[] args){
		
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		
//		Consumer<Integer> c= new Consumer<Integer>()
//				{
//					public void accept(Integer t){
//						System.out.println(t);
//					}
//				};
//		list.forEach(c);
		
//		Consumer<Integer> c= (Integer t) -> 
//			{
//				System.out.println(t);
//			};
//		list.forEach(c);
		
//		Consumer<Integer> c= t -> System.out.println(t);
//		list.forEach(c);
		
		/*
		 * final statement for forEach() is below
		 */
		list.forEach(t -> System.out.println(t));
	}
}

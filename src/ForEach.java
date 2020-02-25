import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * forEach is method of collection
 * forEach is different from for-loop and enhanced-for-loop in the context of runtime
 * forEach will be executed at the run time for each of its values on which collection it is applied
 * both for-loop and enhanced-for-loop is sequential
 * forEach achieves parallelism and multithreading easily 
 * because some values of the forEach contents can be executed first again something else can be executed 
 * and again some values of the forEach contents can be executed
 * difference between for-loop and enhanced-for-loop is user provides values in for-loop but in enhanced-for-loop externally values are given
 * 
 * "both for-loop and enhanced-for-loop is sequential but forEach is not sequential"
 */

public class ForEach {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(1,2,3,4,5);
//		for(int i=1;i<=list.size();i++){
//			System.out.println(i);
//		}
//		
//		for(int i:list){
//			System.out.println(i);
//		}
		
		/*
		 * forEach loop
		 * contains lambda expression and consumer interface
		 */
		/*
		 * the original list stay unaffected that is the reason 
		 * even after incrementing the values output is same as earlier in thelist 
		 */
		list.forEach( i -> i++);
		
		list.forEach(System.out::print);
	
	}
			
}


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Stream has ""Source", "Intermediate Operation", "Terminal Operation"
 * Source is list
 * Intermediate Operation is filter,sort, map, etc. Can be 0 or more
 * Terminal Operation is forEach, count, etc. Returns stream or void
 * Use ParallelStream for multi-threading
 */

public class StreamApi {
	public static void main(String[] args){
		List<Person> list = Arrays.asList(
				new Person("hfg","cd",10),
				new Person("jhgk","ab",15),
				new Person("hd","ch",18),
				new Person("dhd","ef",20),
				new Person("dhd","ck",24)
				);
		
		list.stream()
		.filter(p -> p.getLn().startsWith("c"))
		.forEach(System.out::println);
		
//		Stream<Person> stream = list.stream();
		
		long count=list.stream()
		.filter(p -> p.getLn().startsWith("c"))
		.count();
		
		System.out.println("Count="+count);
		
	}
}

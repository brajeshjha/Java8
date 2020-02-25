import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


/*
 * We don't require interface Condition since we have predefined Function Interface "Predicate"
 * many more are there look at oracle docs
 */
//interface Condition{
//	boolean test(Person p);
//}

public class LambdaFunctionInterface {

	public static void main(String[] args) {
		List<Person> list2 = Arrays.asList(
				new Person("hfg", "cd", 10), 
				new Person("jhgk", "ab", 15),
				new Person("hd", "ch", 18), 
				new Person("dhd", "ef", 20), 
				new Person("dhd", "ck", 24)
		);
		
		Collections.sort(list2, (o1, o2) -> o1.getLn().compareTo(o2.getLn()));
		System.out.println("PrintAll");

		//list2.forEach(i -> System.out.println(i));

		System.out.println("---------------\nPrintWithCondition");
		printWithCondition(list2, (p) -> p.getLn().startsWith("c"),p->System.out.println(p));

	}


	private static void printWithCondition(List<Person> list2, Predicate<Person> predicate,Consumer<Person> consumer) {

		list2.forEach(i -> {
			if (predicate.test(i)) {
				//System.out.println(i);
				//consumer generic interface replaces above line
				consumer.accept(i);
			}
		});

	}
}

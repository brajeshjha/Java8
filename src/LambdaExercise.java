import java.util.Arrays;
import java.util.Collections;
import java.util.List;


 class Person{

	String fn;
	String ln;
	int age;
	
	public Person(String fn, String ln, int age) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.age = age;
	}
	
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [fn=" + fn + ", ln=" + ln + ", age=" + age + "]";
	}

}

interface Condition{
	boolean test(Person p);
}

public class LambdaExercise {

	public static void main(String[] args) {
	
		List<Person> list2=Arrays.asList(
				new Person("hfg","cd",10),
				new Person("jhgk","ab",15),
				new Person("hd","ch",18),
				new Person("dhd","ef",20),
				new Person("dhd","ck",24)
			//	p,q
				);
		
//		Collections.sort(list2, new Comparator<Person>(){
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				
//				return o1.getLn().compareTo(o2.getLn());
//			}
//			
//		});
		
		Collections.sort(list2, (o1, o2) ->  o1.getLn().compareTo(o2.getLn()));
			
		System.out.println("printAll");
		
		//printAll(list2);
		list2.forEach(i -> System.out.println(i) );
		
		System.out.println("---------------------------");
		System.out.println("printWithCondition");
		
		printWithCondition(list2, (p) ->  p.getLn().startsWith("c"));
		

	}

//	private static void printAll(List<Person> list2) {
		
//		for(Person p:list2){
//			System.out.println(p);
//		}
		//lambda-forEach
//		list2.forEach((i) -> System.out.println(i) );
//	}

	private static void printWithCondition(List<Person> list2, Condition condition) {
		 
//		for(Person p:list2){
//			if(condition.test(p)){	
//				System.out.println(p);
//			}
//		}
		list2.forEach(i->{
				if(condition.test(i)){
					System.out.println(i);
				}
			});
	

	}

}

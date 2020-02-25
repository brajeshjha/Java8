import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.*;

public class StreamExamples {
	public static void main(String[] args) throws IOException{
		
		Predicate<String> pred=(i)->i.equals("Ambika");
		System.out.println("\n1.IntStream");
		
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		
		System.out.println("\n2.IntStream with skip");
		
		IntStream
			.range(1, 10)
			.skip(4)
			.forEach(System.out::print);
		
		System.out.println("\n3.IntStream with sum");
		
		System.out.println(
		IntStream
			.range(1, 10)
			.sum()
		);

		System.out.println("\n4.Stream.of, sorted, findFirst-ifPresent");
		
		Stream.of("Deepesh","Brajesh","Heemesh","Ambika", "Ankita")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		
		System.out.println("\n5.Stream of Arrays, sort,filter");
		
		String[] names={"Deepesh","Brajesh","Heemesh","Ambika", "Ankita"};
		Arrays.stream(names)
			.filter(x -> x.startsWith("A"))
//			.anyMatch(predicate)
			.sorted()
			.forEach(System.out::println);
	
		System.out.println("\n5.1.Stream of Arrays, map, average-ifPresent");
		
		int[] numbers={7,2,5,4,7,8,4};
		Arrays.stream(numbers)
			.map(x -> x*x)
			.average()
			.ifPresent(System.out::print);
		
		System.out.println("\n6.Stream from list, map, forEach");
		
		List<String> list = Arrays.asList("Deepesh","Brajesh","Heemesh","Ambika", "Ankita");
		list.stream()
			.map(String::toLowerCase)//String::toLowerCase === x->x.toLowerCase()
			.forEach(System.out::println);
		
		System.out.println("\n7.Stream from list, map, sort, filter,forEach");
		
		list.stream()
			.sorted()
			.map(String::toLowerCase)//String::toLowerCase === x->x.toLowerCase()
			.filter(x -> x.startsWith("a"))
			.forEach(System.out::println);
		
		System.out.println("\n8.Stream rows from text \"file\", sort, filter, forEach, close");
		
		Stream<String> bands = Files.lines(Paths.get("C:/Users/736933/Files/bands.txt"));// throws exception
		bands
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("\n8.Stream rows from text \"file\", filter and convert to list forEach, close");
		
		List<String> bands1 = Files.lines(Paths.get("C:/Users/736933/Files/bands.txt"))
			.filter(x -> x.contains("ey"))
			.collect(Collectors.toList());//collect() converts any Stream to Collections, here to List
		bands1.forEach(System.out::println);
		
		
//		System.out.println("List of files in current directory");
//		Files.list(Paths.get("."))
//    	.forEach(System.out::println);
		
		/*
		System.out.println("\n*Read lines from file using List*");
		List<String> result = Files.readAllLines(Paths.get("C:/Users/736933/Files/bands.txt"));
		result.forEach(System.out::println);
		*/
		System.out.println("\n*Read lines from file using Stream*");
		Stream<String> rows = Files.lines(Paths.get("C:/Users/736933/Files/bands2.txt"));
		rows.forEach(System.out::println);
		
		
		System.out.println("\n8.1 Stream from list of rows from text \"file\", filter, forEach, close");
		
		List<String> result1 = Files.readAllLines(Paths.get("C:/Users/736933/Files/bands.txt"));
		result1
			.stream()
			.filter(x -> x.startsWith("J"))
			.forEach(x -> System.out.print("name-"+x));//can't be done this using method reference 
		
		System.out.println("\n9.Stream of rows from csv file and count");
		
		Stream<String> rows1 = Files.lines(Paths.get("C:/Users/736933/Files/bands2.txt"));
		System.out.print(
		rows1
			.map(x -> x.split(","))
			.filter(x -> x.length>2)
			.count()
		);
		
		System.out.println("\n11.Stream of rows from csv file and print sepeartely with filter");
		
		Stream<String> rows2 = Files.lines(Paths.get("C:/Users/736933/Files/bands2.txt"));
		rows2
			.map(x -> x.split(","))
			.filter(x -> x.length==4)
			.filter(x -> Integer.parseInt(x[0])>12)  //">12" to convert int to boolean bcz filter returns boolean 
			.forEach(x -> System.out.println(x[0]+" : "+x[1]+" : "+x[2]+" : "+x[3]));
		
		System.out.println("\n12.\"reduce()\"");
		
		System.out.println(
				Stream.of(4,5,3,6,3)
				.reduce(0, (a,b) -> a+b)
		);
		
		System.out.println("\n13.IntSummaryStatistics, IntStream.of(...) summaryStatistics(),");
		
		IntSummaryStatistics summary=IntStream.of(4,5,3,6,3)
				.summaryStatistics();
		System.out.println(summary);
		
		System.out.println("\n14.Collector.toMap() and print map using BiConsumer");
		
		Stream<String> rows3 = Files.lines(Paths.get("C:/Users/736933/Files/bands2.txt"));
		
		HashMap<String, String>	hm= (HashMap<String, String>) rows3
			.map(x -> x.split(","))
			.filter(x -> x.length==4)
			.filter(x -> Integer.parseInt(x[0])>12)  //">12" to convert int to boolean bcz filter returns boolean 
			.collect(Collectors.toMap(
					x -> x[0],
					x -> x[1])
			);
		hm.forEach((x,y) -> System.out.println(x+" : "+y));
			
	}
}

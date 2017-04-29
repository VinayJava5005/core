package concepts.mapreduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MapReduceDemo1 {

	public static List<String> friends = new ArrayList<String>(Arrays.asList(
			"BRIAN", "NATE", "NEAL", "RAJU", "SARA", "SCOTT"));

	public static void main(String[] args) {
		friends.stream().filter(nameStartWith("N")).map(String::toLowerCase)
				.forEach(System.out::println);

		friends.stream().filter(startWithLetter.apply("S"))
				.forEach(System.out::println);

		System.out.println("First Name Start With S : "
				+ friends.stream().filter(startWithLetter.apply("S"))
						.findFirst().get());
	}

	static Predicate<String> nameStartWith(String prefix) {
		return (name) -> name.startsWith(prefix);
	}

	final static Function<String, Predicate<String>> startWithLetter = (
			String prefix) -> name -> name.startsWith(prefix);

}

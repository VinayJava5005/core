package concepts.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;

public class StringDemo1 {

	public static String str = "HelloWorldThisIsJava8";

	public static List<String> splitStr = new ArrayList<String>(Arrays.asList(
			"Hello", "World", "This", "Ts", "Java8"));

	public static void main(String[] args) {

		for (char c : str.toCharArray()) {
			System.out.print(c + " ");
		}
		System.out.println();

		str.chars().mapToObj(ch -> Character.valueOf((char) ch))
				.forEach(System.out::print);

		System.out.println();

		System.out.println(splitStr.stream().filter(startWith.apply("T"))
				.collect(joining(", ")));

	}

	public static Function<String, Predicate<String>> startWith = (String prefix) -> name -> name
			.startsWith(prefix);
}

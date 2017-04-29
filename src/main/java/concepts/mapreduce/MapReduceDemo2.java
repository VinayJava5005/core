package concepts.mapreduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapReduceDemo2 {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("Hello", "World");
		System.out.println(words.stream().map(word -> word.split(""))
				.distinct().collect(Collectors.toList()));

		System.out.println(words.stream().map(word -> word.split(""))
				.flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList()));

		/*
		 * Given a list of numbers, how would you return a list of the square of
		 * each number? For example, given [1, 2, 3, 4, 5] you should return [1,
		 * 4, 9, 16, 25].
		 */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(numbers.stream().map(number -> number * number)
				.collect(Collectors.toList()));

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		numbers1.stream()
				.flatMap(
						number1 -> numbers2.stream().map(
								number2 -> new int[] { number1, number2 }))
				.collect(Collectors.toList()).forEach(System.out::println);
	}
}
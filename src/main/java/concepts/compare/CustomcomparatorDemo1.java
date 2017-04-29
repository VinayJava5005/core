package concepts.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomcomparatorDemo1 {

	final static List<Person> people = Arrays.asList(new Person("John", 23),
			new Person("Sara", 21), new Person("Jane", 50), new Person("Greg",
					35));

	static Comparator<Person> compareAsc = (person1, person2) -> person1
			.ageDifference(person2);

	static Comparator<Person> compareDsc = compareAsc.reversed();

	static Function<Person, String> byName = (person) -> person.getName();

	public static void main(String[] args) {

		/*
		 * people.stream() .sorted((person1, person2) ->
		 * person1.ageDifference(person2)) .forEach(person ->
		 * System.out.println(person.name));
		 */

		/*
		 * people.stream().sorted(Person::ageDifference) .forEach(person ->
		 * System.out.println(person.name));
		 */

		/*
		 * people.stream().min(compareAsc) .ifPresent(person ->
		 * System.out.println(person.name)); people.stream().min(compareDsc)
		 * .ifPresent(person -> System.out.println(person.name));
		 */

		/*
		 * people.stream().sorted(comparing(byName)) .forEach(person ->
		 * System.out.println(person.getName()));
		 */

		List<Person> filteredPeople = people.stream()
				.filter(person -> person.getAge() > 22)
				.collect(Collectors.toList());
		System.out.println("Person age greater than 22 : "
				+ filteredPeople.size());

	}
}

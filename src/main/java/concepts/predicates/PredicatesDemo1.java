package concepts.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Human {
	int age;

	public Human(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class PredicatesDemo1 {

	public static Predicate<Human> isAdult() {
		return h -> h.getAge() > 21;
	}

	public static Predicate<Human> isAgeMoreThan(int age) {
		return h -> h.getAge() > age;
	}

	public static void main(String[] args) {

		Human human1 = new Human(18);
		Human human2 = new Human(19);
		Human human3 = new Human(20);
		Human human4 = new Human(50);
		Human human5 = new Human(24);
		Human human6 = new Human(21);
		Human human7 = new Human(15);

		List<Human> humans = new ArrayList<Human>(Arrays.asList(human1, human2,
				human3, human4, human5, human6, human7));

		System.out.print("Adult Human : ");
		System.out.println(humans.stream().filter(isAdult()).count());

		int age = 20;
		System.out.print("Adult Human age greater than : " + age + " is ");
		System.out.println(humans.stream().filter(isAgeMoreThan(age)).count());

	}
}

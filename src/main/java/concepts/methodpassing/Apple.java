package concepts.methodpassing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Apple {

	public static final int LIGHT_WEIGHT_UPPER_LIMIT = 80;
	public static final int HEAVY_WEIGHT_LOWER_LIMIT = 150;

	public enum Color {
		GREEN, RED, YELLOW;
	}

	Apple(int weight, Color color, String name) {
		this.weight = weight;
		this.color = color;
		this.name = name;
	}

	int weight;
	Color color;
	String name;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Boolean isGreenApple(Apple apple) {
		return Color.GREEN.equals(apple.getColor());
	}

	public static Boolean isRedApple(Apple apple) {
		return Color.RED.equals(apple.getColor());
	}

	public static Boolean isLightWeight(Apple apple) {
		return apple.getWeight() <= LIGHT_WEIGHT_UPPER_LIMIT;
	}

	public static Boolean isHeavyWeight(Apple apple) {
		return apple.getWeight() <= HEAVY_WEIGHT_LOWER_LIMIT;
	}

	public static void printApple(List<Apple> appleList,
			Predicate<Apple> predicate) {
		for (Apple apple : appleList) {
			if (predicate.test(apple)) {
				System.out.print(apple.getName() + " ");
			}
		}
		System.out.println("-----------------------------------------------");
	}

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>(Arrays.asList(new Apple(
				40, Color.RED, "Apple1"), new Apple(180, Color.RED, "Apple2"),
				new Apple(80, Color.GREEN, "Apple3"), new Apple(81, Color.RED,
						"Apple4"), new Apple(79, Color.YELLOW, "Apple5"),
				new Apple(200, Color.GREEN, "Apple6")));
		System.out.println("Red Apple");
		printApple(appleList, Apple::isRedApple);

		System.out.println("Green Apple");
		printApple(appleList, Apple::isGreenApple);

		System.out.println("Heavy Apple");
		printApple(appleList, Apple::isHeavyWeight);

		System.out.println("Light Apple");
		printApple(appleList, Apple::isLightWeight);
	}
}

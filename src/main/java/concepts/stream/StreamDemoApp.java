package concepts.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamDemoApp {

	public static void main(String[] args) {

		List<Product> productList = Arrays.asList(new Product("A", 1),
				new Product("B", 2), new Product("C", 13),
				new Product("D", 41), new Product("E", 19),
				new Product("H", 16), new Product("I", 51), new Product("F",
						100), new Product("G", 101), new Product("J", 71));

		List<String> names = productList.stream()
				.filter(calorieGreaterThan10()).limit(2).map(Product::getName)
				.collect(toList());

		System.out.println("Calories Greater Than 10 : " + names);

		names = productList.stream().filter(caloriesGreaterThan50())
				.map(Product::getName).skip(4).collect(toList());

		System.out.println("Calories Greater Than 50 : " + names);

		System.out.println(productList.stream().anyMatch(calorieGreaterThan10()));

		/*
		 * names = productList.stream().filter(p -> {
		 * System.out.println(p.getCalorie()); return p.getCalorie() > 100;
		 * }).map(p -> { System.out.println(p.getName()); return p.getName();
		 * }).collect(toList());
		 * 
		 * System.out.println("Calories Greater Than 100 : " + names);
		 */

	}

	public static Predicate<Product> calorieGreaterThan10() {
		return p -> p.getCalorie() > 10;
	}

	public static Predicate<Product> caloriesGreaterThan50() {
		return p -> p.getCalorie() > 50;
	}
}

class Product {
	String name;
	Integer calorie;

	public Product(String name, Integer calorie) {
		super();
		this.name = name;
		this.calorie = calorie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCalorie() {
		return calorie;
	}

	public void setCalorie(Integer calorie) {
		this.calorie = calorie;
	}

}

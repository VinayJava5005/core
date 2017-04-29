package concepts.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionDemo1 {
	static List<String> cities = new ArrayList<String>(Arrays.asList(
			"New Delhi", "Gurgaon", "Noida", "Bengaluru", "Pune"));

	public static void main(String[] args) {

		findCityByImperativeWay("Bengaluru"); // How to do
		findCityByDecalrativeWay("Bengaluru"); // What to do

		cities.stream().filter(p -> p.contains("d"))
				.forEach(System.out::println);
	}

	private static void findCityByDecalrativeWay(String cityToFound) {
		System.out.print("Decalrative Way : ");
		Boolean isCityPresent = false;
		for (String city : cities) {
			if (city.equals(cityToFound)) {
				isCityPresent = true;
				break;
			}
		}

		System.out.println("City " + cityToFound + " is " + isCityPresent);
	}

	private static void findCityByImperativeWay(String cityToFound) {
		System.out.println("Imperative Way : City " + cityToFound + " is "
				+ cities.contains(cityToFound));

	}

}

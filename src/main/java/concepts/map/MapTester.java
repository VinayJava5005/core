package concepts.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTester {

	public Map<Object, Object> map1;

	public void createMap() {

		map1 = new HashMap<Object, Object>();
		map1.put(1, "One");
		map1.put(2, "Two");
		map1.put(3, "Three");
		map1.put(4, "Four");
		map1.put(5, "Five");

	}

	public void printMap() {
		Set<Entry<Object, Object>> set = map1.entrySet();
		set.forEach(System.out::println);
		System.out.println("Map Size : " + map1.size());

	}

	public static void main(String[] args) {
		/*
		 * System.out.println("Map Tester......................."); MapTester
		 * mapTester = new MapTester(); mapTester.createMap();
		 * mapTester.printMap();
		 */

		Map<Dealer, List<String>> dealersMap = new TreeMap<Dealer, List<String>>();
		dealersMap.put(new Dealer(1, "A"), Arrays.asList("dealer1", "dealer2"));
		dealersMap.put(new Dealer(2, "B"), Arrays.asList("dealer3", "dealer4"));
		Map<Person, List<String>> personsMap = new TreeMap<Person, List<String>>();
		personsMap.put(new Person(3, "C"), Arrays.asList("person1", "person2"));
		personsMap.put(new Person(4, "D"), Arrays.asList("person3", "person4"));

		Map<Object, List<String>> concatMap = new LinkedHashMap<Object, List<String>>();
		concatMap.putAll(personsMap);
		concatMap.putAll(dealersMap);

		Set<Entry<Object, List<String>>> concatEntries = concatMap.entrySet();
		for (Entry<Object, List<String>> concatEntry : concatEntries) {
			System.out.println("key : " + concatEntry.getKey());
			System.out.println("value : " + concatEntry.getValue());
		}

	}

}

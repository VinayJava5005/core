package concepts.set;

import java.util.HashSet;
import java.util.Set;

public class SetTester {

	public Set<Integer> set;

	public void createSet() {
		set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(null);
	}

	public void printSet() {
		set.forEach(System.out::println);
	}

	public static void main(String[] args) {
		SetTester setTester = new SetTester();
		setTester.createSet();
		setTester.printSet();
	}
}

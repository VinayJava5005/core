package concepts.compare;

public class Person {

	int age;
	String name;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int ageDifference(Person person) {
		return this.getAge() - person.getAge();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

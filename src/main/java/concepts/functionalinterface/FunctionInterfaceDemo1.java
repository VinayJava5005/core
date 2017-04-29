package concepts.functionalinterface;

@FunctionalInterface
interface ArithmeticOperation {
	Long opertation(Long a, Long b);
}

interface vehicle {
	default void print() {
		System.out.println("i am vehicle");
	}

	static void drive() {
		System.out.println("driving....");
	}
}

interface fourWheeler {
	default void print() {
		System.out.println("i am four wheeler");
	}
}

class Car implements vehicle, fourWheeler {

	@Override
	public void print() {
		// System.out.println("i am vehicle with four wheels");
		vehicle.super.print();
		fourWheeler.super.print();
		vehicle.drive();
		System.out.println("this is car");
	}
}

public class FunctionInterfaceDemo1 {

	public static void operations(Long a, Long b, ArithmeticOperation ao) {
		System.out.println(ao.opertation(a, b));
	}

	public static void main(String[] args) {

		ArithmeticOperation additions = (a, b) -> (a + b);
		ArithmeticOperation subtraction = (a, b) -> (a - b);
		ArithmeticOperation multiplication = (a, b) -> (a * b);

		operations(1L, 2L, additions);
		operations(1L, 2L, subtraction);
		operations(2L, 2L, multiplication);

		Car car = new Car();
		car.print();

	}
}

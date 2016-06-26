package programs;

public class TrapeziumPattern {

	public static void main(String[] args) {
		printTrapeziumPattern(6);
	}

	private static void printTrapeziumPattern(int n) {

		int number = 1;
		int nextNumber = n * (n - 1) + 1 + n + n;
		for (int row = 0; row < n; row++) {
			int count = 1;
			int nextHalfNumber = nextNumber = nextNumber - (n - row);
			for (int col1 = 1; col1 <= (2 * n) - row; col1++) {
				if (col1 <= row) {
					System.out.print("* ");
				} else {
					if (count <= n) {
						System.out.print(number + " ");
						number++;
					} else {
						if (count == n + 1) {
							System.out.print(" | ");
						}
						System.out.print(nextHalfNumber + " ");
						nextHalfNumber++;
					}
				}
				count++;
			}
			System.out.println();
		}

	}
}

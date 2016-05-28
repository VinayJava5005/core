package programs;

public class Knapsack {

	public static int[] numbers = { 11, 8, 7, 6, 5 };

	public static boolean applyCheck(int startIndex, int limit, int lastIndex,
			int resultSum) {
		boolean result = false;
		int total = 0;

		if (lastIndex >= numbers.length) {
			return result;
		}
		System.out.print("Checking..... indexs : ");
		int index = startIndex;
		int count = 0;
		while (count < limit - 1) {
			System.out.print(index);
			total = total + numbers[index];
			count++;
			index++;
		}
		total = total + numbers[lastIndex];
		System.out.println(lastIndex);
		if (total == resultSum) {
			System.out.println("Result Found......");
			result = true;
		} else {
			lastIndex++;
			result = applyCheck(startIndex, limit, lastIndex, resultSum);
		}
		return result;
	}

	public static void main(String[] args) {

		int limit = 3;
		for (int index = 0; index < numbers.length; index++) {
			System.out.println("Checking for : " + numbers[index]);
			if (applyCheck(index, limit, (index + limit) - 1, 20)) {
				break;
			}
		}
	}

}

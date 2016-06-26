package programs;

public class MergeSort {

	public static int[] unsortedNumbers = { 1, 4, 3, 10, 3, 4, 11, 20, 15, 6 };
	public static int[] arrayForCopy = new int[10];

	public static void mergeSort(int lowerBound, int upperBound) {

		if (lowerBound == upperBound) {
			return;
		}

		int mid = (lowerBound + upperBound) / 2;
		mergeSort(lowerBound, mid);
		mergeSort(mid + 1, upperBound);

		doMerge(lowerBound, mid, upperBound);

	}

	public static void doMerge(int lowerBound, int mid, int upperBound) {
		int lowerIndex = lowerBound;
		int newIndex = lowerBound;
		int midIndex = mid + 1;
		while ((lowerBound <= mid) && (midIndex <= upperBound)) {
			if (unsortedNumbers[lowerBound] <= unsortedNumbers[midIndex]) {
				arrayForCopy[newIndex] = unsortedNumbers[lowerBound];
				lowerBound++;
			} else {
				arrayForCopy[newIndex] = unsortedNumbers[midIndex];
				midIndex++;
			}
			newIndex++;
		}

		while (lowerBound <= mid) {
			arrayForCopy[newIndex] = unsortedNumbers[lowerBound];
			lowerBound++;
		}
		while (midIndex <= upperBound) {
			arrayForCopy[newIndex] = unsortedNumbers[midIndex];
			midIndex++;
		}

		for (int index = lowerIndex; index <= upperBound; index++) {
			unsortedNumbers[index] = arrayForCopy[index];
		}

	}

	public static void main(String[] args) {
		mergeSort(0, unsortedNumbers.length - 1);

		for (int index = 0; index < unsortedNumbers.length; index++) {
			System.out.println(unsortedNumbers[index]);
		}
	}

}

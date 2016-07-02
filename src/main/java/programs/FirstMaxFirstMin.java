package programs;

/**
 * Created by pradeep on 2/7/16.
 */
public class FirstMaxFirstMin {

    public static void main(String[] args) {

        int[] inputArray1 = {1, 2, 3, 4, 5, 6, 7};
        populateMaxMinCombination(inputArray1);

        int[] inputArray2 = {1, 3, 2, 7, 6, 8, 5, 9, 3};
        System.out.println();
        populateMaxMinCombination(inputArray2);
    }

    private static void populateMaxMinCombination(int[] inputArray) {
        for (int row = 0; row < inputArray.length; row += 2) {
            int min = inputArray[row];
            int max = inputArray[row];
            int minIndex = row;
            int maxIndex = row;
            for (int index = row; index < inputArray.length; index++) {
                if (min > inputArray[index]) {
                    min = inputArray[index];
                    minIndex = index;
                } else if (max < inputArray[index]) {
                    max = inputArray[index];
                    maxIndex = index;
                }
            }

            if (maxIndex != minIndex) {
                if (row == minIndex) {
                    inputArray[maxIndex] = inputArray[row + 1];
                    inputArray[row + 1] = min;
                    inputArray[row] = max;

                } else {
                    inputArray[maxIndex] = inputArray[row];
                    inputArray[row] = max;

                    inputArray[minIndex] = inputArray[row + 1];
                    inputArray[row + 1] = min;
                }
            }

        }

        print(inputArray);
    }

    private static void print(int[] inputArray) {
        for (int index = 0; index < inputArray.length; index++) {
            System.out.print(inputArray[index] + " ");
        }
    }
}

package programs;

/**
 * Created by parya on 6/30/2016.
 */
public class ContigousSubarraySum {

    private static boolean isSumAvailable(int[] inputArray, int sum) {
        boolean isAvailable = false;

        int totalSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < inputArray.length) {
            if (totalSum + inputArray[endIndex] <= sum) {
                totalSum += inputArray[endIndex++];
            } else {
                sum -= inputArray[startIndex++];
            }
            if (totalSum == sum) {
                isAvailable = true;
            }
            if (endIndex < startIndex) {
                endIndex = startIndex;
                totalSum = 0;
            }
        }
        return isAvailable;
    }

    public static void main(String[] args) {

        int[] inputArray = new int[]{1, 3, 5, 18};
        System.out.println(isSumAvailable(inputArray, 8));
        System.out.println(isSumAvailable(inputArray, 9));
        System.out.println(isSumAvailable(inputArray, 10));
        System.out.println(isSumAvailable(inputArray, 40));
        System.out.println(isSumAvailable(inputArray, 18));
        System.out.println(isSumAvailable(inputArray, 0));
    }
}

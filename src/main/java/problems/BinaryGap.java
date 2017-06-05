package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pradeep on 3/6/17.
 */
public class BinaryGap {

    private static List<Integer> getBinary(int number) {
        List<Integer> binary = new LinkedList<>();

        while (number != 0) {
            binary.add(0, number % 2);
            number = number / 2;
        }

        return binary;
    }

    public static void main(String[] args) {

        List<Integer> binaryNumber = getBinary(1041);

        int maxGapCount = 0;
        int currentGapCount = 0;
        boolean start = false;
        for (Integer character : binaryNumber) {

            if (character == 1) {

                if (start) {
                    maxGapCount = maxGapCount >= currentGapCount ? maxGapCount : currentGapCount;
                    currentGapCount = 0;
                } else {
                    start = !start;
                }
            }

            if (character == 0) {
                if (start) {
                    currentGapCount++;
                }
            }
        }

        System.out.println(maxGapCount);
    }
}

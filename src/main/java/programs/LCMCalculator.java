package programs;

import java.util.Scanner;

/**
 * Created by parya on 6/21/2016.
 */
public class LCMCalculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first number to find LCM");
        int number1 = scanner.nextInt();
        System.out.println("Please enter second number to find LCM");
        int number2 = scanner.nextInt();
        System.out.println("LCM of two numbers " + number1 + " and " + number2 + " is :" + findLCM(number1, number2));
    }

    private static int findLCM(int number1, int number2) {
        int largestNumber = (number1 > number2) ? number1 : number2;
        while (true) {
            if (largestNumber % number1 == 0 && largestNumber % number2 == 0)
                return largestNumber;
            ++largestNumber;
        }
    }
}

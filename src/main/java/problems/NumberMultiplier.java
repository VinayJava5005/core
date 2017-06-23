package problems;

import java.util.Scanner;
import java.lang.Math;

/**
 * Created by pradeep on 25/5/17.
 */
public class NumberMultiplier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first Number : ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second Number : ");
        int secondNumber = scanner.nextInt();

        boolean isNegative = firstNumber < 0 && secondNumber < 0 ? false : (firstNumber < 0 || secondNumber < 0 ? true : false);
        int result = multiply(Math.abs(firstNumber), Math.abs(firstNumber), Math.abs(secondNumber));
        System.out.println(
                firstNumber +
                        " X " +
                        secondNumber +
                        " = " +
                        ((isNegative) ? -result : result)
        );
    }

    private static int multiply(int firstNumber, int result, int secondNumber) {

        if (firstNumber == 0 || secondNumber == 0) {
            return 0;
        } else if (secondNumber == 1) {
            return result;
        }
        return multiply(firstNumber, firstNumber + result, --secondNumber);
    }
}



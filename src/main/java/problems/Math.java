package problems;

/**
 * Created by pradeep on 25/5/17.
 */
public class Math {

    public static void main(String[] args) {
        System.out.println(addWithoutPlusOperator(1,1));
    }

    private static int addWithoutPlusOperator(int firstNumber, int secondNumber) {

        String secondBinary = Integer.toBinaryString(secondNumber);
        String firstBinary = Integer.toBinaryString(firstNumber);

        if (secondBinary.length() > firstBinary.length()) {
            firstBinary = appendLeadingZero(firstBinary, secondBinary.length() - firstBinary.length());
        } else if (secondBinary.length() < firstBinary.length()) {
            secondBinary = appendLeadingZero(secondBinary, firstBinary.length() - secondBinary.length());
        }


        int length = firstBinary.length() - 1;

        String result = "";
        boolean carry = false;
        while (length >= 0) {

            char firstChar = firstBinary.charAt(length);
            char secondChar = secondBinary.charAt(length);

            char sum;
            if (carry) {
                if (firstChar == '1') {
                    firstChar = '0';
                    carry = true;
                } else {
                    firstChar = '1';
                    carry = false;
                }
            }

            if (firstChar == '1' && secondChar == '1') {
                sum = '0';
                carry = true;
            } else if (firstChar == '1' || secondChar == '1') {
                sum = '1';
            } else {
                sum = '0';
            }

            result = sum + result;

            length--;
        }

        if (carry) {
            result = '1' + result;
        }

        return Integer.parseInt(result, 2);

    }

    private static String appendLeadingZero(String firstBinary, int i) {

        while (i > 0) {
            firstBinary = 0 + firstBinary;
            i--;
        }

        return firstBinary;
    }
}

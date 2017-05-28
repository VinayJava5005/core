package problems;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pradeep on 28/5/17.
 */
public class TwoStackQueue {

    private static Stack<String> firstStack = new Stack<>();
    private static Stack<String> secondStack = new Stack<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases > 0) {

            String[] inputs = scanner.nextLine().split(" ");

            switch (inputs[0]) {
                case "1":
                    push(inputs[1]);
                    break;
                case "2":
                    pop();
                    break;
                case "3":
                    System.out.println(peek());
                    break;
            }

            testCases--;
        }

    }

    private static String peek() {
        if (secondStack.isEmpty()) {
            moveElements();
        }

        return secondStack.peek();
    }

    private static void pop() {

        if (secondStack.isEmpty()) {
            moveElements();
        }
        secondStack.pop();
    }

    private static void moveElements() {

        while (!firstStack.isEmpty()){
            secondStack.push(firstStack.pop());
        }

    }

    private static void push(String input) {
        firstStack.push(input);
    }


}

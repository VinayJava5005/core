package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Stack;

/**
 * Created by pradeep on 28/5/17.
 */
public class TwoStackGame {

    private static Stack<Integer> firstStack;
    private static Stack<Integer> secondStack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {

            String[] inputs = br.readLine().split(" ");
            int maxSum = Integer.parseInt(inputs[2]);
            firstStack = getStack(br.readLine().split(" "), maxSum);
            secondStack = getStack(br.readLine().split(" "), maxSum);

            int fStackMoves = firstStack.size();
            int sStackMoves = secondStack.size();

            System.out.println(fStackMoves + " - " + sStackMoves);
            System.out.println(Math.max(fStackMoves, Math.max(sStackMoves, minOfTwo(maxSum))));

            System.out.println("------------------------------");
            testCases--;
        }
    }

    private static int minOfTwo(int maxSum) {
        int moveCount = 0;
        int sum = 0;

        Stack<Integer> fStack = new Stack<>();
        Stack<Integer> sStack = new Stack<>();

        getOriginalStack(fStack, firstStack);
        getOriginalStack(sStack, secondStack);

        while (sum < maxSum) {

            if (fStack.isEmpty() && sStack.isEmpty()) {
                break;
            } else if (fStack.isEmpty()) {
                sum += sStack.pop();
            } else if (sStack.isEmpty()) {
                sum += fStack.pop();
            } else if (fStack.peek() < sStack.peek()) {
                sum += fStack.pop();
            } else {
                sum += sStack.pop();
            }

            moveCount++;
        }

        moveCount = moveCount == 0 ? moveCount : --moveCount;
        System.out.println(moveCount);
        return moveCount;
    }

    private static void getOriginalStack(Stack<Integer> originalStack, Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int topElement = stack.pop();

            originalStack.push(topElement - (stack.isEmpty() ? 0 : stack.peek()));
        }
    }

    private static Stack<Integer> getStack(String[] stackElements, int maxSum) {

        Stack<Integer> stack = new Stack<>();
        for (String element : stackElements) {
            if (stack.isEmpty()) {
                stack.push(Integer.parseInt(element));
            } else {
                int peek = stack.peek();
                stack.push(Integer.parseInt(element) + peek);
            }

            if (stack.peek() > maxSum) {
                stack.pop();
                break;
            }
        }
        return stack;
    }
}

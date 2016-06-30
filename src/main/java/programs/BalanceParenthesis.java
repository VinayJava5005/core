package programs;

import java.util.Stack;

/**
 * Created by pradeep on 30/6/16.
 */
public class BalanceParenthesis {

    private static StringBuffer balanceParenthesis(String unBalancedParenthesis) {
        StringBuffer balancedParenthesis = new StringBuffer();
        System.out.println("UnBalanced Parenthesis : " + unBalancedParenthesis);

        Stack<Character> stack = new Stack<>();
        char[] chars = unBalancedParenthesis.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            char item = chars[index];

            if (item == '(') {
                stack.push(item);
                balancedParenthesis.append(item);
            } else if (item == ')') {
                if (!stack.isEmpty()) {
                    balancedParenthesis.append(')');
                    balancedParenthesis.append(stack.pop());
                } else {
                    break;
                }
            } else {
                if (balancedParenthesis.charAt(balancedParenthesis.length() - 1) != ')' && balancedParenthesis.charAt(balancedParenthesis.length() - 1) != '(') {
                    balancedParenthesis.append(')');
                    stack.pop();
                }
                balancedParenthesis.append(item);
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            balancedParenthesis.append(')');
        }


        return balancedParenthesis;
    }

    public static void main(String[] args) {

        System.out.println("Balanced Parenthesis : " + balanceParenthesis("(a(b(c)de"));

        System.out.println("Balanced Parenthesis : " + balanceParenthesis("(a(b(c)de(f(g)(h"));
    }
}

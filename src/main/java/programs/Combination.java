package programs;

/**
 * Created by pradeep on 26/6/16.
 */
public class Combination {

    public static void get(String string) {
        doCombination("", string);
    }

    private static void doCombination(String combination, String string) {
        int length = string.length();

        if (combination.length() > 0) {
            System.out.println(combination);
        }
        for (int index = 0; index < length; index++) {
            doCombination(combination + string.charAt(index), string.substring(index + 1, length));
        }

    }

    public static void main(String[] args) {
        get("wxyz");
    }
}

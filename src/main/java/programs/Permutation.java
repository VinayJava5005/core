package programs;

/**
 * Created by pradeep on 25/6/16.
 */
public class Permutation {

    public static void get(String string) {
        permute("", string);
    }

    private static void permute(String permutation, String string) {

        int length = string.length();
        if (length == 0) {
            System.out.println(permutation);
        }

        for (int index = 0; index < length; index++) {
            permute(permutation + string.charAt(index), string.substring(0, index) + string.substring(index + 1, length));
        }
    }


    public static void main(String[] args) {
        get("abc");
    }
}

package programs;

/**
 * Created by pradeep on 25/6/16.
 */
public class StringToInteger {

    public static Integer parse(String string) {
        int result = 0;
        int index = 0;
        int lenght = string.length();
        if (string == null) {
            result = -1;
        } else {
            while (index < lenght) {
                char character = string.charAt(index++);
                result *= 10;
                result += (character - '0');
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int intValue = parse("123");
        System.out.println(intValue);
    }
}

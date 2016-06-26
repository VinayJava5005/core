package concepts.java7;

/**
 * Created by parya on 5/16/2016.
 */
public class StringExample {

    public static void testStringInSwitch(String param) {
        final String JAVA7 = "Java 7";
        switch (param) {
            case "Java 5":
                System.out.println(param);
                break;
            case "Java 6":
                System.out.println(param);
                break;
            case JAVA7:
                System.out.println(param);
                break;
        }
    }

    public static void main(String[] args) {
        testStringInSwitch("Java 7");
    }
}

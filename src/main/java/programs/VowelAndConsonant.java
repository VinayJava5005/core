package programs;

/**
 * Created by pradeep on 3/7/16.
 */
public class VowelAndConsonant {

    public static void get(String string) {
        doCombination("", string);
    }

    private static void doCombination(String combination, String string) {
        int length = string.length();

        if (combination.length() > 1) {
            if (isVowel(combination.charAt(0)) && isConsonant(combination.charAt(combination.length() - 1)))
                System.out.println(combination);
        }
        for (int index = 0; index < length; index++) {
            doCombination(combination + string.charAt(index), string.substring(index + 1, length));
        }

    }

    private static boolean isVowel(char c) {

        return "aeiou".indexOf(c) == -1 ? false : true;
    }

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) == -1 ? false : true;
    }

    public static void main(String[] args) {
        get("abc");
//        System.out.println("......................................");
//        get("utyrulqaeuouiecodjlmjeaummaoqkexylwaaopnfvlbiiiidyckzfh");
        System.out.println("......................................");
        get("aab");
        System.out.println("......................................");
        get("aaaaa");
        System.out.println("......................................");
        get("nhhhnnn");
        System.out.println("......................................");
        get("aba");
//        System.out.println("......................................");
//        get("rejhiuecumovsutyrulqaeuouiecodjlmjeaummaoqkexylwaaopnfvlbiiiidyckzfhe");

    }
}

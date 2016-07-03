package programs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradeep on 2/7/16.
 */
public class PalindromeCreator {


    public static void main(String[] args) {
        System.out.println("First Sample Word");
        String sampleWord1 = "pototp";
        createPalindrome(sampleWord1);

        System.out.println(".......................................");
        System.out.println("Second Sample Word");
        String sampleWord2 = "oto maym oto";
        createPalindrome(sampleWord2);

        System.out.println(".......................................");
        System.out.println("Third Sample Word");
        String sampleWord3 = "a lazy fox jumps overy a lazy";
        createPalindrome(sampleWord3);
    }

    private static void createPalindrome(String sampleWord1) {
        System.out.println(sampleWord1);
        int startIndex = 0;
        int endIndex = sampleWord1.length() - 1;
        int count = 0;
        int insertIndex = 0;
        List<Character> characterList = new ArrayList<>();
        while (startIndex <= endIndex) {

            if (startIndex == endIndex) {
                characterList.add(insertIndex++, sampleWord1.charAt(startIndex));
                break;
            }

            if (sampleWord1.charAt(startIndex) == sampleWord1.charAt(endIndex)) {
                characterList.add(insertIndex++, sampleWord1.charAt(startIndex));
                characterList.add(insertIndex, sampleWord1.charAt(endIndex));
                startIndex++;
                endIndex--;
            } else {
                if (sampleWord1.charAt(startIndex) == sampleWord1.charAt(endIndex - 1)) {
                    characterList.add(insertIndex++, sampleWord1.charAt(endIndex));
                    characterList.add(insertIndex, sampleWord1.charAt(endIndex));
                    endIndex--;
                    count++;

                } else if (sampleWord1.charAt(endIndex) == sampleWord1.charAt(startIndex + 1)) {
                    characterList.add(insertIndex++, sampleWord1.charAt(startIndex));
                    characterList.add(insertIndex, sampleWord1.charAt(startIndex));
                    startIndex++;
                    count++;
                } else {
                    //TODO need to write logic for third sample word here
                    startIndex++;
                    endIndex--;
                }
            }
        }
        System.out.println("Number of char inserted : " + count);
        System.out.println(characterList);
    }
}

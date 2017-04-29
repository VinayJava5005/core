package problems;

import java.util.Scanner;

/**
 * Created by pradeep on 17/4/17.
 */
public class SubstringOccurrences {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String C = s.nextLine();
//        String S = s.nextLine();

        String C = "abc";
        String S = "abcabdabc";

        char[] string = S.toCharArray();
        char[] subString = C.toCharArray();

        int subIndex = 0;
        int counter = 0;
        for (int index = 0; index < string.length;) {

            if(string[index] == subString[subIndex]){
                index++;
                subIndex++;
            }else{
                subIndex=0;
                index++;
            }

            if(subIndex == subString.length){
                counter++;
                subIndex=0;
            }

            if(index == string.length){
                break;
            }
        }

        System.out.println(counter);
    }
}

package problems;

import java.util.Scanner;

/**
 * Created by pradeep on 14/1/17.
 */
public class PrefPref {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        char[] firstStringChars = first.toCharArray();

        int maxlength = 0;
        int indexOf = 0;
        for (int index = 0; index < firstStringChars.length; index++) {

            indexOf = second.indexOf(firstStringChars[index], indexOf+1);
            if(indexOf == -1){
                break;
            }else{
                maxlength++;
            }

        }

        System.out.println(maxlength);
    }
}

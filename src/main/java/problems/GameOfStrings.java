package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by pradeep on 13/1/17.
 */
public class GameOfStrings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        List<String> ghissiStrings = new ArrayList<>();
        IntStream.range(0, N).forEach(index -> {
            ghissiStrings.add(scanner.nextLine());
        });

        ghissiStrings.stream().forEach(item -> {

            String[] items = item.split(" ");
            String ghissiString = items[0];
            int K = Integer.parseInt(items[1]);

            int endSIndex = -1;

            boolean isExist = true;

            int currentIndex = 1;
            while (isExist) {

                int lastIndexOf = ghissiString.lastIndexOf(ghissiString.substring(0, currentIndex));

                if (lastIndexOf != 0 && lastIndexOf > currentIndex) {
                    endSIndex = lastIndexOf;
                    currentIndex++;
                } else {
                    isExist = false;
                }

            }
            if (endSIndex != -1) {
                int startEIndex = currentIndex - 1;
                int subStringLen = ghissiString.substring(0, startEIndex).length();
                int endEIndex = endSIndex + subStringLen;
                int midSIndex = ghissiString.indexOf(ghissiString.substring(endSIndex, endEIndex), startEIndex);

                if ((midSIndex != -1)) {

                    int midEIndex = midSIndex + subStringLen;
                    if (midEIndex <= K) {

                        int startIndex;
                        int endIndex;

                        if (midEIndex == endSIndex && endEIndex <= K) {
                            startIndex = midSIndex;
                            endIndex = endEIndex;
                        } else {
                            startIndex = midSIndex;
                            endIndex = midEIndex;
                        }
                        System.out.println(ghissiString.substring(startIndex, endIndex));
                    } else {
                        System.out.println("Puchi is a cheat!");
                    }

                } else {
                    System.out.println("Puchi is a cheat!");
                }
            } else {
                System.out.println("Puchi is a cheat!");
            }

        });

    }


}

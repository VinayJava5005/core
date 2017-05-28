package problems;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by pradeep on 27/5/17.
 */
public class CookiesSweetner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] testCases = scanner.nextLine().split(" ");

        int k = Integer.parseInt(testCases[1]);

        List<Integer> cookies = Arrays.stream(scanner.nextLine().split(" "))
                .map(cookie -> Integer.parseInt(cookie))
                .sorted()
                .collect(Collectors.toList());

        if (Integer.parseInt(testCases[0]) == cookies.size()) {

            boolean isSweeter = checkSweetness(cookies, k);

            int count = 0;
            while (!isSweeter && cookies.size() > 1) {

                int sweetness = 1 * cookies.get(0) + 2 * cookies.get(1);
                cookies.remove(0);
                cookies.remove(0);
                insertNewCookie(cookies, sweetness);
                count++;
                isSweeter = checkSweetness(cookies, k);

                if(cookies.size() == 1){
                    if(!(cookies.get(0) >= k)){
                        count = -1;
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static void insertNewCookie(List<Integer> cookies, int sweetness) {

        OptionalInt first = IntStream.range(0, cookies.size())
                .filter(index -> cookies.get(index) >= sweetness)
                .findFirst();

        if (first.isPresent()) {
            cookies.add(first.getAsInt(), sweetness);
        } else {
            cookies.add(sweetness);
        }
    }

    private static boolean checkSweetness(List<Integer> cookies, int k) {
        return !cookies.stream().anyMatch(cookie -> cookie < k);
    }
}

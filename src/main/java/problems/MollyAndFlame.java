package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 13/2/17
 * Time: 10:58 PM
 */
public class MollyAndFlame {

    public static void main(String[] args) throws IOException {

        String game = "FLAME";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        List<String> strings = new ArrayList<>();
        IntStream.range(0, testCases).forEach(index -> {
            try {
                strings.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println(strings);

        List<Integer> x_rems = new ArrayList<>();
        strings.stream().forEach(string -> {
            x_rems.add(fetchUniqueCount(string));
        });

        System.out.println(x_rems);

        x_rems.stream().forEach(count -> {
            int gameLength = game.length();
            int resultIndex = count % gameLength;
            System.out.println(swap(game, 1, resultIndex == 0 ? 0 : resultIndex - 1));
        });

    }

    private static String swap(String game, int lIndex, int rIndex) {

        char[] charArray = game.toCharArray();
        char temp = charArray[lIndex];
        charArray[lIndex] = charArray[rIndex];
        charArray[rIndex] = temp;
        return new String(charArray);
    }

    private static Integer fetchUniqueCount(String string) {
        String[] names = string.split(" ");

        Map<Integer, Integer> uniqueChar = new HashMap<>();
        names[0].chars().forEach(character -> {
            Integer count = uniqueChar.get(character);

            if (count == null) {
                uniqueChar.put(character, 1);
            } else {
                uniqueChar.put(character, count + 1);
            }
        });

        char[] secondName = names[1].toCharArray();
        int uniqueCount = 0;
        for(int index = 0; index < secondName.length; index++){
            Integer count = uniqueChar.get((int)secondName[index]);
            if (count == null) {
                uniqueCount++;
            }else{
                uniqueChar.remove((int)secondName[index]);
            }
        }
        int count = uniqueChar.entrySet().stream().mapToInt(entrySet -> entrySet.getValue()).sum();

        return count + uniqueCount;

    }
}

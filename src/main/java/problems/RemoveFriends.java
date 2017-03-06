package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 7/3/17
 * Time: 12:20 AM
 */
public class RemoveFriends {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer testCases = Integer.parseInt(reader.readLine());

        while (testCases > 0) {
            String[] testCase = reader.readLine().split(" ");
            processInput(Integer.parseInt(testCase[1]), reader.readLine().split(" "));
            testCases--;
        }
    }

    private static void processInput(Integer K, String[] popularity) {

//        List<Integer> friendsPopularities = Arrays.asList(popularity).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> friendsPopularities = new LinkedList<>();
        for (String aPopularity : popularity) {
            friendsPopularities.add(Integer.parseInt(aPopularity));
        }

        for (int index = 0; index < friendsPopularities.size() - 1; ) {

            if (friendsPopularities.get(index) < friendsPopularities.get(index + 1)) {
                friendsPopularities.remove(index);
                if (index > 0) {
                    index--;
                }
                K--;
            } else {
                index++;
            }

            if (K == 0) {
                break;
            }
        }

        friendsPopularities = friendsPopularities.subList(0, friendsPopularities.size() - K);

        for (Integer element : friendsPopularities) {
            System.out.print(element + " ");
        }
        System.out.println();

    }
}

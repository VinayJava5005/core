package problems;

import java.util.*;

/**
 * Created by pradeep on 23/5/17.
 */
public class NumberSplitter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        Map<Integer, List<String>> numberSplittersMap = generateNumbersSplitterMap(number);

        System.out.println(numberSplittersMap);

        int startIndex = 0;
        boolean isSplitted = true;
        List<String> splitters = new ArrayList<>();
        while (isSplitted) {
            int length = splitters.size();
            isSplitted = splitNumbers(number, numberSplittersMap, startIndex, splitters);

            if (isSplitted) {
                startIndex = length;
            }
        }
        Set<String> result = new HashSet<>(splitters);
        System.out.println(result);

        verifyOutput(result);
    }

    private static Map<Integer, List<String>> generateNumbersSplitterMap(int number) {
        Map<Integer, List<String>> numbersSplittersMap = new HashMap<>();
        while (number > 1) {
            numbersSplittersMap.put(number, splitter(number));
            number--;
        }

        return numbersSplittersMap;
    }

    private static void verifyOutput(Set<String> output) {
        for (String element : output) {
            String[] values = element.split(",");

            int sum = 0;
            for (String value : values) {
                sum = sum + Integer.parseInt(value);
            }

            System.out.println(element + " sum : " + sum);
        }
    }

    private static boolean splitNumbers(int number, Map<Integer, List<String>> numberSplittersMap, int startIndex, List<String> splitters) {
        boolean result = false;
        List<String> newList = new ArrayList<>();
        if (splitters.size() > 0) {

            for (int index = startIndex; index < splitters.size(); index++) {
                String[] splitStr = splitters.get(index).split(",");

                for (int splitIndex = 0; splitIndex < splitStr.length; splitIndex++) {

                    List<String> split = numberSplittersMap.get(Integer.parseInt(splitStr[splitIndex]));

                    if (split != null) {
                        for (int indexj = 0; indexj < split.size(); indexj++) {
                            String joindString = joinSplitter(splitIndex, splitters.get(index), split.get(indexj));
                            newList.add(joindString);
                        }
                    }
                }
            }

        } else {
            splitters.addAll(numberSplittersMap.get(number));
            result = true;
        }

        if (newList.size() > 0) {
            splitters.addAll(newList);
            result = true;
        }

        return result;
    }

    private static String joinSplitter(int splitIndex, String s, String s2) {
        String joinedString = "";
        String[] s1 = s.split(",");
        for (int index = 0; index < s1.length; index++) {
            if (index == splitIndex) {
                joinedString = joinedString + s2 + ",";
            } else {
                joinedString = joinedString + s1[index] + ",";
            }
        }


        return joinedString.substring(0, joinedString.length() - 1);
    }


    private static List<String> splitter(int number) {

        List<String> numberSplitters = new ArrayList<>();

        int start = 1;
        int end = number - 1;

        while (start <= end) {
            numberSplitters.add(start + "," + end);
            start++;
            end--;
        }
        return numberSplitters;
    }
}

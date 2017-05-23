package problems;

import java.util.*;

/**
 * Created by pradeep on 23/5/17.
 */
public class NumberSplitter {

    private static Map<Integer, List<String>> numbersSplittersMap;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        numbersSplittersMap = generateNumbersSplitterMap(number);

        System.out.println(numbersSplittersMap);

        int startIndex = 0;
        boolean isSplitted = true;
        List<String> numberSplitters = new ArrayList<>();
        while (isSplitted) {
            int length = numberSplitters.size();
            isSplitted = splitNumber(number, startIndex, numberSplitters);

            if (isSplitted) {
                startIndex = length;
            }
        }
        Set<String> result = new HashSet<>(numberSplitters);
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

        System.out.println("Verifying output : ");
        for (String element : output) {
            String[] values = element.split(",");

            int sum = 0;
            for (String value : values) {
                sum = sum + Integer.parseInt(value);
            }

            System.out.println(element + " sum : " + sum);
        }
    }

    private static boolean splitNumber(int number, int startIndex, List<String> splitters) {
        boolean isSplitted = false;
        List<String> subSplitters = new ArrayList<>();
        if (splitters.size() > 0) {

            splitters.stream().skip(startIndex).forEach(element -> {
                String[] numbers = element.split(",");

                for (int splitIndex = 0; splitIndex < numbers.length; splitIndex++) {

                    List<String> numberSplitters = numbersSplittersMap.get(Integer.parseInt(numbers[splitIndex]));

                    if (numberSplitters != null) {
                        for (String numberSplit : numberSplitters) {
                            String joinedString = joinSplitter(splitIndex, element, numberSplit);
                            subSplitters.add(joinedString);
                        }
                    }
                }

            });

        } else {
            splitters.addAll(numbersSplittersMap.get(number));
            isSplitted = true;
        }

        if (subSplitters.size() > 0) {
            splitters.addAll(subSplitters);
            isSplitted = true;
        }

        return isSplitted;
    }

    private static String joinSplitter(int splitIndex, String element, String subSplit) {
        String joinedString = "";
        String[] numbers = element.split(",");

        for (int index = 0; index < numbers.length; index++) {
            if (index == splitIndex) {
                joinedString = joinedString + subSplit + ",";
            } else {
                joinedString = joinedString + numbers[index] + ",";
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

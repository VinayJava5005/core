package programs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by pradeep on 8/6/17.
 */

class Element {
    private int index;
    private int value;

    Element(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public void decrementIndex() {
        this.index--;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

public class PartnerKiller {

    public static void main(String[] args) {

        int n = 101;
        List<Integer> numbers = IntStream
                .range(1, n)
                .mapToObj(number -> number)
                .collect(Collectors.toList());
        System.out.println(numbers);

        int index = 0;
        while (numbers.size() != 1) {

            int nextIndex = index + 1;

            if (nextIndex > numbers.size() - 1) {
                nextIndex = 0;
                index = 0;
            } else {
                index++;
            }
            numbers.remove(nextIndex);

        }
        System.out.println(numbers);
    }
}

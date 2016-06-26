package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by parya on 4/17/2016.
 */
public class OneLiners {

    static <E> List<E> getNewList(List<E> oldList) {
        List<E> newList = new ArrayList<>(new LinkedHashSet<E>(oldList));
        return newList;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("spam", "sausage", "spam", "spam", "bacon", "spam", "tomato", "spam");
        System.out.println(getNewList(stringList));

    }
}

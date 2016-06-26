package concepts.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by parya on 5/17/2016.
 */
public class GenericClass<T> {

    List<T> list;

    public GenericClass(List<T> list) {
        this.list = list;
    }

    public void printList() {
        for (T item : list) {
            System.out.println(item);
        }
    }

    public T getElement(int index) {
        return list.get(index);
    }

    public static <T> T addElement(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }

    public T addElement(T element) {
        list.add(element);
        return element;
    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        GenericClass<Integer> integerGenericClass = new GenericClass<>(integerList);
        integerGenericClass.printList();
        System.out.println("Element at index 2 : " + integerGenericClass.getElement(2));

        System.out.println("...............................................");
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        GenericClass<String> stringGenericClass = new GenericClass<>(stringList);
        stringGenericClass.printList();
        System.out.println("Element at index 2 : " + stringGenericClass.getElement(2));
    }
}

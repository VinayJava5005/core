package concepts.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parya on 5/23/2016.
 */

class Animal {
    public void checkUp() {
        System.out.println("Animal checkUp");
    }
}

class Dog extends Animal {
    @Override
    public void checkUp() {
        System.out.println("Dog checkUp");
    }
}

public class GenricList {


    public static void functionOne(List list) {
        list.add(new Dog());
        System.out.println(list);
    }

    public static void functionTwo(List<?> list) {
//        list.add(new Dog()); // cannot add element to List<?>
        System.out.println(list);
    }

    public static void functionThree(List<? extends Animal> list) {
//        list.add(new Dog()); // cannot add PECS
        System.out.println(list.get(0));
        System.out.println(list);
    }

    public static void functionFour(List<? super Animal> list) {
        list.add(new Dog());
//        list.add(new Integer(1)); // cannot add subtype of Object class not of Animal
        Object object = list.get(0);
        Animal animal = (Animal) list.get(0); // may cause classcast exception
//        Animal animal = list.get(0); // cannot get as we don't resolve whether its a Animal object or super of Animal
        System.out.println(list.get(0));
        System.out.println(list);
    }

    public static void functionFive(List<Object> list) {
        list.add(new Dog());
        System.out.println(list.get(0));
        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        functionOne(dogs);
        functionTwo(dogs);
        functionThree(dogs);
        functionFour(animals);
//        functionFive(animals);
//        functionFive(dogs);

    }
}

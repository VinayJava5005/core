package concepts.supplier;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Created by pradeep on 3/5/17.
 */
public class SupplierTest {

    public static void main(String[] args) {

        for (int index = 0; index < 10; index++) {
            Supplier<Book> bookSupplier = BookFactory::produceBook_1;
            System.out.println(bookSupplier.get());
        }

    }
}

class BookFactory {
    public static Book produceBook_1() {
//        BiFunction<Random, Long, IntStream> randomLongIntStreamBiFunction = Random::ints;
//        int number = randomLongIntStreamBiFunction.apply(new Random(), 1l).findFirst().getAsInt();

        Random r = new Random();
        int number = r.ints(0, (99 + 1)).findFirst().getAsInt();

        return new Book("Book" + number, number);
    }

    public Book produceBook_2() {
        BiFunction<Random, Long, IntStream> randomLongIntStreamBiFunction = Random::ints;
        int number = randomLongIntStreamBiFunction.apply(new Random(), 1l).findFirst().getAsInt();

        return new Book("Book" + number, number);
    }
}

class Book {
    private String name;
    private int id;

    Book(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

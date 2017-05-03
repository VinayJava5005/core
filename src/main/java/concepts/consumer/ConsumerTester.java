package concepts.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by pradeep on 29/4/17.
 */
public class ConsumerTester {

    public static void main(String[] args) {
        List<String> breadTypes = Arrays.asList("French", "Sourdough", "Whole-wheat", "Rye", "Italian", "Multigrain", "Pumpernickel", "Challah/egg bread");

        breadTypes.stream().forEach(BreadConsumer::consume);

        List<Integer> quantity = Arrays.asList(1, 2, 3, 6, 9, 7, 100);
        quantity.stream().forEach(ConsumerHelper.consumer::consume);

        final Mechanic mechanic = new Mechanic();
        Car car = new Car();

        execute(car, mechanic::fix);
        Consumer<Car> carConsumer = mechanic::fix;


        execute(car, new Consumer<Car>() {
            public void accept(Car c) {
                mechanic.fix(c);
            }
        });

        execute(car, c -> mechanic.fix(c));


    }

    public static void execute(Car car, Consumer<Car> c) {
        c.accept(car);
    }
}

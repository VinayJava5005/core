package concepts.functionalinterface;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by pradeep on 3/5/17.
 */
public class SupplierConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<User> usersQueue = new LinkedBlockingQueue<>();

        Supplier<User> userSupplier = new Supplier<User>() {
            @Override
            public User get() {
                try {
                    return usersQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Consumer<User> userConsumer = new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("Processing user " + user);
            }
        };

        new SupplierConsumer<>(userSupplier, userConsumer).start();

        for (int i = 0; i < 100; i++) {
            usersQueue.put(new User(i, "user" + i));
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class SupplierConsumer<T> extends Thread {

    private Supplier<T> supplier;
    private Consumer<T> consumer;
    private boolean shouldRun = true;

    public SupplierConsumer(Supplier<T> supplier, Consumer<T> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (shouldRun) {
            T item = supplier.get();
            consumer.accept(item);
        }
    }

}

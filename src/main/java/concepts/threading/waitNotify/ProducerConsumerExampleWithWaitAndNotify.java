package concepts.threading.waitNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parya on 5/16/2016.
 */
public class ProducerConsumerExampleWithWaitAndNotify {
    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Consumer1");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer2");
        tProducer.start();
        tConsumer.start();
        tProducer.start();
    }
}
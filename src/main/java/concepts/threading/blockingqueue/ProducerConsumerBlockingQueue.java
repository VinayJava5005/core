package concepts.threading.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by parya on 5/16/2016.
 */
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue(5);
        Producer producer = new Producer(queue, "Consumer1");
        Consumer consumer = new Consumer(queue, "Consumer2");

        producer.start();
        consumer.start();
    }
}

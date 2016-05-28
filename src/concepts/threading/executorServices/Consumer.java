package concepts.threading.executorServices;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by parya on 5/17/2016.
 */
public class Consumer implements Callable {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (queue.isEmpty())
                break;
        }

        return true;
    }

    private void consume() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Consumer2 consume : " + queue.take());
    }
}

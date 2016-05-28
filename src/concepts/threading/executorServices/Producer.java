package concepts.threading.executorServices;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by parya on 5/17/2016.
 */
public class Producer implements Callable {

    BlockingQueue<Integer> queue;
    int product;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        this.product = 0;
    }


    private void produce(int product) throws InterruptedException {
        Thread.sleep(1000);
        queue.put(product);
        System.out.println("Consumer1 produce : " + product);
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                produce(++product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (product == 5)
                break;
        }

        return true;
    }
}

package concepts.threading.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by parya on 5/16/2016.
 */
public class Producer extends Thread {

    BlockingQueue<Integer> queue;
    int product;

    public Producer(BlockingQueue<Integer> queue, String threadName) {
        super(threadName);
        this.queue = queue;
        this.product = 0;
    }

    @Override
    public void run() {

        while (true) {
            try {
                produce(++product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        Thread.sleep(1000);
        queue.put(i);
        System.out.println(Thread.currentThread().getName() + " produce : " + i);
        queue.put(++i);
        System.out.println(Thread.currentThread().getName() + " produce : " + i);
    }
}

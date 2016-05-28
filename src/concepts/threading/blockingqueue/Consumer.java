package concepts.threading.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by parya on 5/16/2016.
 */
public class Consumer extends Thread {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue, String threadName) {
        super(threadName);
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        Thread.sleep(1000);
        Integer product = queue.take();
        System.out.println(Thread.currentThread().getName() + " consume : " + product);
    }
}

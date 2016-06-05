package concepts.threading.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pradeep on 5/6/16.
 */
public class Consumer implements Runnable {

    private CountDownLatch countDownLatch;

    public Consumer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        }
    }

    private void doWork() {
        System.out.println("Consumer " + Thread.currentThread().getName() + " performing its task");
    }
}

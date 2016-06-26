package concepts.threading.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pradeep on 5/6/16.
 */
public class Producer implements Runnable {

    private CountDownLatch countDownLatch;

    public Producer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        synchronized (this) {
            doWork();
            countDownLatch.countDown();
        }
    }

    private void doWork() {
        System.out.println("Producer : " + Thread.currentThread().getName() + " performing its task");
    }
}

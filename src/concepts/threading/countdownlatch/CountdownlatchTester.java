package concepts.threading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pradeep on 5/6/16.
 */
public class CountdownlatchTester {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Producer producer1 = new Producer(countDownLatch);
        Producer producer2 = new Producer(countDownLatch);
        Consumer consumer1 = new Consumer(countDownLatch);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(consumer1);
        executorService.execute(producer1);
        executorService.execute(producer2);

        executorService.shutdown();

    }
}

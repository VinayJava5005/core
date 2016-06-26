package concepts.threading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pradeep on 6/6/16.
 */

class Runner implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running...............");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int thread = 0; thread < 3; thread++) {
            System.out.println(thread);
            executorService.submit(new Runner());
            executorService.shutdown(); //RejectedExecutionException
        }
    }
}

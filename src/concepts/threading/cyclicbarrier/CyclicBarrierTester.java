package concepts.threading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by parya on 6/5/2016.
 */

class Task implements Runnable {

    CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Task : " + Thread.currentThread().getName() + " waiting for barrier");
        }
        try {
            cyclicBarrier.await();
            System.out.println("Task : " + Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierTester {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All parties are arrived at barrier, lets play"));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int index = 0; index < 3; index++) {
            executorService.execute(new Task(cyclicBarrier));
        }
        executorService.shutdown();

    }
}

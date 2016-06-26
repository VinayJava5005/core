package concepts.threading.executorServices;

import java.util.concurrent.*;

/**
 * Created by parya on 5/17/2016.
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Future taskOne = executorService.submit(producer);
        Future taskTwo = executorService.submit(consumer);

        try {
            System.out.println("taskOne : " + taskOne.isDone() + " : " + taskOne.get());
            System.out.println("taskTwo : " + taskTwo.isDone() + " : " + taskTwo.get());
            Thread.sleep(1000);
            System.out.println("taskOne : " + taskOne.isDone() + " : " + taskOne.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

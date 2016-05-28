package concepts.threading.problem;

import java.util.List;

/**
 * Created by parya on 5/16/2016.
 */

class Consumer1 implements Runnable {
    private final List<Integer> taskQueue;
    private Boolean isConsumerOne;

    public Consumer1(List<Integer> sharedQueue, Boolean isConsumerOne) {
        this.taskQueue = sharedQueue;
        this.isConsumerOne = isConsumerOne;
    }

    @Override
    public void run() {
        while (!taskQueue.isEmpty()) {
            try {
                consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (!isConsumerOne) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }
            isConsumerOne = false;

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " : " + taskQueue.get(taskQueue.size() - 1));
            taskQueue.notifyAll();
        }
    }
}

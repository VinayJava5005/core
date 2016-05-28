package concepts.threading.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parya on 5/24/2016.
 */

class MyThread extends Thread {

    List<Integer> taskQueue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static int counter = 9;

    private void getElement() {
        synchronized (MyThread.class) {
            if (counter >= 0) {
                System.out.println(Thread.currentThread().getName() + " : " + taskQueue.get(counter--));
            }
        }
    }

    @Override
    public void run() {

        while (counter >= 0) {
            getElement();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class SequentialAccess {

    public static void main(String[] args) {
//        List<Integer> taskQueue = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        Boolean isConsumerOne = true;
//        Thread tConsumer1 = new Thread(new Consumer1(taskQueue, isConsumerOne), "Consumer1");
//        Thread tConsumer2 = new Thread(new Consumer2(taskQueue, isConsumerOne), "Consumer2");
//
//        tConsumer1.start();
//        tConsumer2.start();

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
    }
}

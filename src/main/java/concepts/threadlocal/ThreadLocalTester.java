package concepts.threadlocal;

/**
 * Created by pradeep on 7/6/16.
 */

class Task implements Runnable {

    private ThreadLocal<Integer> threadLocal =
            new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
    }
}

public class ThreadLocalTester {
    public static void main(String[] args) {
        Task task = new Task();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

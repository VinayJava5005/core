package concepts.threading.deadlock;

/**
 * Created by pradeep on 2/6/16.
 */
public class DeadlockTest {

    private static Object resourceOne = new Object();
    private static Object resourceTwo = new Object();

    public static void main(String[] args) {
        FirstConsumer firstConsumer = new FirstConsumer(resourceOne, resourceTwo);
        SecondConsumer secondConsumer = new SecondConsumer(resourceOne, resourceTwo);

        firstConsumer.start();
        secondConsumer.start();
    }
}

class FirstConsumer extends Thread {

    private static Object resourceOne;
    private static Object resourceTwo;

    public FirstConsumer(Object resourceOne, Object resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }

    @Override
    public void run() {
        synchronized (resourceOne) {
            System.out.println("FirstConsumer got resourceOne");

            System.out.println("FirstConsumer waiting for resourceTwo");
            synchronized (resourceTwo) {
                System.out.println("FirstConsumer got resourceTwo");
            }
        }
    }
}

class SecondConsumer extends Thread {
    private static Object resourceOne;
    private static Object resourceTwo;

    public SecondConsumer(Object resourceOne, Object resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }

    @Override
    public void run() {
        synchronized (resourceTwo) {
            System.out.println("SecondConsumer got resourceTwo");

            System.out.println("SecondConsumer waiting for resourceOne");
            synchronized (resourceOne) {
                System.out.println("SecondConsumer got resourceOne");
            }
        }
    }
}

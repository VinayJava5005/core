package concepts.threading.basic;

/**
 * Created by pradeep on 4/6/16.
 */

class Resource {
    private int data = 0;

    public synchronized void incrementData() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
            data++;
        }
    }

    public synchronized int getData() {
        return data;
    }
}

class Task extends Thread {
    private Resource resource;

    public Task(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        this.resource.incrementData();
    }
}

public class YieldTest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Task task1 = new Task(resource);
        Task task2 = new Task(resource);
        task2.setPriority(10);

        task1.start();
        task2.start();
    }
}

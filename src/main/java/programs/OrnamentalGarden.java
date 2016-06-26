package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pradeep on 4/6/16.
 */

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {

    private static Counter counter = new Counter();
    private static List<Entrance> noOfEntrance = new ArrayList<>();
    private int id;
    private int noOfPeople;
    private static volatile boolean isCanceled = false;

    public static void cancel() {
        isCanceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        this.noOfPeople = 0;
        //adding entrance gate
        noOfEntrance.add(this);
    }

    @Override
    public void run() {
        while (!isCanceled) {
            synchronized (this) {
                ++this.noOfPeople;
                System.out.println("Number of people in garden(" + this.id + ") : " + this.noOfPeople);
            }
            counter.increment();
        }
    }

    public static int getTotalCount() {
        return counter.value();
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.print("Enter number of gate in garden : ");
        Scanner scanner = new Scanner(System.in);
        int noOfGates = scanner.nextInt();
        for (int gateNumber = 1; gateNumber <= noOfGates; gateNumber++) {
            executor.execute(new Entrance(gateNumber));
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            Entrance.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Total number of people in garden : " + Entrance.getTotalCount());

    }
}
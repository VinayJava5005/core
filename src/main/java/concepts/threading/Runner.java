package concepts.threading;

/**
 * Created by pradeep on 16/7/17.
 */
public class Runner {

    public static void main(String[] args) {

        LiftOff liftOff = new LiftOff();
        Thread thread1 = new Thread(liftOff);
        Thread thread2 = new Thread(liftOff);
        thread1.start();
        thread2.start();
        System.out.println("Waiting for LiftOff");
    }
}

package concepts.threading.UncaughtException;

import java.util.concurrent.*;

/**
 * Created by pradeep on 6/6/16.
 */

class CallableTask implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("CallableTask running..........");
        throw new RuntimeException();
    }
}


public class CaptureUncaughtExceptionCallable {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(1);

        Future futureTask = exec.submit(new CallableTask());

        exec.shutdown();
        try {
            futureTask.get();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException : ");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException : ");
            e.printStackTrace();
        }
    }
}

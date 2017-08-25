package concepts.threading;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by pradeep on 16/7/17.
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results)
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }

        Callable callable = Executors.callable(new LiftOff());
        System.out.println(callable.call());
    }
}

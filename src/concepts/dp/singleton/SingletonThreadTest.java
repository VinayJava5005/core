package concepts.dp.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by parya on 5/19/2016.
 */
public class SingletonThreadTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable firstRunnable = new Runner();
        Callable secondRunnable = new Runner();

        executorService.submit(firstRunnable);
        executorService.submit(secondRunnable);

    }
}

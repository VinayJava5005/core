package concepts.dp.singleton;

import java.util.concurrent.Callable;

/**
 * Created by parya on 5/19/2016.
 */
public class Runner implements Callable {

    @Override
    public Object call() throws Exception {
        Singleton firstInstance = Singleton.getInstance();
        System.out.println("Instance HashCode : " + firstInstance.hashCode());
        return true;
    }
}

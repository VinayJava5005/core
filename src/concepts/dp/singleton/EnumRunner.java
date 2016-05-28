package concepts.dp.singleton;

/**
 * Created by parya on 5/21/2016.
 */
public class EnumRunner implements Runnable {
    @Override
    public void run() {
        System.out.println(EnumSingleton.INSTANCE.hashCode());
    }
}

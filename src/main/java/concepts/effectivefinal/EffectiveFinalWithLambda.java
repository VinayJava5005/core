package concepts.effectivefinal;

/**
 * Created by pradeep on 15/6/16.
 */
public class EffectiveFinalWithLambda {
    public static void main(String[] args) {
        String effectiveFinal = "I am effective final variable";
        Runnable r = () -> {
            System.out.println("Value of effective variable : " + effectiveFinal);
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}

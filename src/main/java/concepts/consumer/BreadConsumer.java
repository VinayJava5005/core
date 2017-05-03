package concepts.consumer;

/**
 * Created by pradeep on 29/4/17.
 */
public class BreadConsumer {

    public static void consume(String breadType) {
        System.out.println("Consumer consume " + breadType + " bread");
    }

    public void consume(int quantity) {
        System.out.println("Consumer consume " + quantity + " breads");
    }
}

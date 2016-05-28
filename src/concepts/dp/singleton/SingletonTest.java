package concepts.dp.singleton;

/**
 * Created by parya on 5/19/2016.
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();
        System.out.println("First Instance HashCode : " + firstInstance.hashCode());
        System.out.println("First Instance Letters : " + firstInstance.getLetters());
        System.out.println("First Instance Get 4 Tiles : " + firstInstance.getTiles(4));
        System.out.println("Letters Left " + firstInstance.getLetters().size() + " : " + firstInstance.getLetters());

        System.out.println("..........................................................");

        Singleton secondInstance = Singleton.getInstance();
        System.out.println("Second Instance HashCode : " + secondInstance.hashCode());
        System.out.println("Second Instance Letters : " + secondInstance.getLetters());
        System.out.println("Second Instance Get 7 Tiles : " + firstInstance.getTiles(7));
        System.out.println("Letters Left " + secondInstance.getLetters().size() + " : " + secondInstance.getLetters());

        System.out.println("..........................................................");
        Thread thread1 = new Thread(new EnumRunner());
        Thread thread2 = new Thread(new EnumRunner());
        thread1.start();
        thread2.start();
    }
}

package concepts.dp.singleton;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by parya on 5/19/2016.
 */

public class Singleton {

    private static Singleton instance = null;

    String[] scrabbleLetters = {"a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c", "c", "c", "d", "d", "d", "e", "e", "e", "f", "f", "f", "p", "p", "p", "s", "s", "s"};

    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(scrabbleLetters));

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public LinkedList<String> getLetters() {
        Collections.shuffle(instance.letterList);
        return instance.letterList;
    }

    public LinkedList<String> getTiles(int howManyTiles) {
        LinkedList<String> tileToSend = new LinkedList<>();
        for (int index = 0; index < howManyTiles; index++) {
            tileToSend.add(instance.letterList.remove(0));
        }
        return tileToSend;
    }
}
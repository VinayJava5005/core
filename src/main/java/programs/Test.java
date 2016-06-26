package programs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by parya on 4/17/2016.
 */

class Confusing {
    public Confusing(Object object) {
        System.out.println("Confusing(Object object)");
    }

    public Confusing(double[] val) {
        System.out.println("Confusing(double[] val)");
    }

    public Confusing(int[] val) {
        System.out.println("Confusing(int[] val)");
    }
}

interface FirstContract {
    void A();

    static void B() {

    }
}

class Base {
    public void baseFunction() {
        System.out.println("baseFunction");
    }
}

class Derived extends Base {
    public void derivedFunction() {
        System.out.println("derivedFunction");
    }
}

interface SecondContract {
    void A();
}

public class Test implements FirstContract, SecondContract {
    public static void main(String[] args) throws IOException {

        new Confusing((int[]) null);

        FirstContract firstContract = new Test();
        SecondContract secondContract = new Test();

        firstContract.A();
        secondContract.A();

        URL url = new URL("http://121.242.92.173:8888/KioskServices/content/getPectabs");
        System.out.println(url.getContent() != null);

        Base base = new Derived();
        Derived derived = (Derived) new Base();
        Base base1 = new Base();
    }

    @Override
    public void A() {
        System.out.println("Implementation of A() inside Test");
    }
}

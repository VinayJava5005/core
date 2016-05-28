package concepts.hashCode;

import java.util.HashMap;

/**
 * Created by parya on 5/15/2016.
 */
public class Apple {

    private String color;

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Apple))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Apple) obj).color);
    }

    @Override
    public int hashCode() {
        return this.color.hashCode();
    }

    public static void main(String[] args) {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("red");
        Apple a3 = new Apple("neerg");

        System.out.println("a1 : " + a1.color.hashCode());
        System.out.println("a2 : " + a2.color.hashCode());
        System.out.println("a3 : " + a3.color.hashCode());

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        m.put(a3, 30);
        System.out.println(m.get(new Apple("neerg")));
    }
}

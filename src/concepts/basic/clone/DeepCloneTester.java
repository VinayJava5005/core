package concepts.basic.clone;

/**
 * Created by parya on 6/8/2016.
 */

public class DeepCloneTester {

    public static void main(String[] args) {
        Developer firstDeveloper = new Developer();
        Developer cloneDeveloper = null;
        try {
            cloneDeveloper = firstDeveloper.clone();
            cloneDeveloper.setfName("Deepu");
            cloneDeveloper.getKnownLanguages().add(0, "C");
            System.out.println("cloneDeveloper : " + cloneDeveloper);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("firstDeveloper : " + firstDeveloper);

        System.out.println(".....................................");
        System.out.println("firstDeveloper != cloneDeveloper : " + (firstDeveloper != cloneDeveloper));
        System.out.println("firstDeveloper.getClass() == cloneDeveloper.getClass() : " + (firstDeveloper.getClass() == cloneDeveloper.getClass()));
        System.out.println("firstDeveloper.equals(cloneDeveloper) : " + (firstDeveloper.equals(cloneDeveloper)));
    }
}

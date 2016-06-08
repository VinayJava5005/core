package concepts.basic.clone;

/**
 * Created by parya on 6/8/2016.
 */

public class ShallowCloneTester {

    public static void main(String[] args) {
        Person firstPerson = new Person();
        Person clonePerson = null;
        try {
            clonePerson = (Person) firstPerson.clone();
            clonePerson.setfName("Deepu");
            clonePerson.getQualifications().add(0, "12th-Non medical");
            System.out.println("clonePerson : " + clonePerson);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("firstPerson : " + firstPerson);

        System.out.println(".....................................");
        System.out.println("firstPerson != clonePerson : " + (firstPerson != clonePerson));
        System.out.println("firstPerson.getClass() == clonePerson.getClass() : " + (firstPerson.getClass() == clonePerson.getClass()));
        System.out.println("firstPerson.equals(clonePerson) : " + (firstPerson.equals(clonePerson)));
    }
}

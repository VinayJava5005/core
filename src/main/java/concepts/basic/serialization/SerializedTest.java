package concepts.basic.serialization;

import java.io.*;

/**
 * Created by parya on 5/21/2016.
 */

class Credential implements Serializable {

    public static String CLASS_NAME;

    public Credential() {
        System.out.println("Default Credential");
        CLASS_NAME= "Credential";
    }

    public Credential(String userName, String password) {
        System.out.println("Credential");
        CLASS_NAME= "Credential";
        this.userName = userName;
        this.password = password;
    }

    String userName;
    String password;

    @Override
    public String toString() {
        return "Username : " + userName + ", Password : " + password;
    }

}

class Person extends Credential implements Serializable {

    public static String CLASS_NAME = "ShallowCloneTester";

    public Person() {
        System.out.println("Default ShallowCloneTester");
    }

    public Person(String userName, String password, String name, int id) {
        super(userName, password);
        System.out.println("ShallowCloneTester");
        this.name = name;
        this.id = id;
    }

    String name;
    transient int id;

    @Override
    public String toString() {
        return super.toString() + ", Name : " + name + ", Id : " + id;
    }
}

public class SerializedTest {

    public static void main(String[] args) {
        Person person = new Person("userName", "pwd", "user", 10);
        System.out.println("Before Serialization : " + person);
        Person.CLASS_NAME = "ShallowCloneTester.class";
        System.out.println("Credential Static field : " + Credential.CLASS_NAME);
        System.out.println("ShallowCloneTester Static field : " + Person.CLASS_NAME);
        try {
            System.out.println("Serialization......................");
            SerializationUtil.serialize(person, "person.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
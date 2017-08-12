package concepts.basic.serialization;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by parya on 5/21/2016.
 */

class Reference {
    private String data;

    public Reference(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class Credential implements Serializable {

    public static String CLASS_NAME;
//    private Reference reference;

    public Credential() {
        System.out.println("Default Credential");
        CLASS_NAME = "Credential";
    }

    public Credential(String userName, String password) {
        System.out.println("Credential");
        CLASS_NAME = "Credential";
        this.userName = userName;
        this.password = password;
//        this.reference = new Reference(this.userName);
    }

    String userName;
    String password;

    @Override
    public String toString() {
        return "Username : " + userName + ", Password : " + password + " reference data : " /*+ this.reference.getData()*/;
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
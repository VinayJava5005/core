package concepts.basic.serialization;

import java.io.IOException;

/**
 * Created by parya on 5/21/2016.
 */
public class DeserializedTest {

    public static void main(String[] args) {
        System.out.println("Deserialization....................");
        try {
            System.out.println("After Serialization : " + SerializationUtil.deserialize("person.ser"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Credential Static field : " + Credential.CLASS_NAME);
        System.out.println("ShallowCloneTester Static field : " + Person.CLASS_NAME);
    }
}

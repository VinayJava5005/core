package concepts.innerclass;

import java.util.Date;

/**
 * Created by pradeep on 6/6/16.
 */

class Parcel {
    String id;
    Date date;

    class Content {
        private /*static*/ String content;

        public /*static*/ void displayContent() {
            System.out.println(content);
        }

    }

    static class Destination {
        private static String destination;

        public static String getDestination() {
            return destination;
        }
    }

}

public class InnerClassTester {
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Parcel.Content content = parcel.new Content();
        Parcel.Destination destination = new Parcel.Destination();
    }
}

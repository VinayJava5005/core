package concepts.basic.serialization;

/**
 * Created by parya on 5/21/2016.
 */
public class Base {
    void baseFunction() {
        System.out.println("baseFunction");
    }
}

class Derived extends Base {
    void derivedFunction() {
        System.out.println("derivedFunction");
    }
}

class DerivedSubclass extends Derived {
    void derivedSubclassFunction() {
        System.out.println("derivedSubclassFunction");
    }

    void function(Base base) {
        System.out.println("base");
    }

//    void function(Derived derived) {
//        System.out.println("derived");
//    }

//    void function(DerivedSubclass derivedSubclass) {
//        System.out.println("derivedSubclass");
//    }

    void function(Object object) {
        System.out.println("object");
    }


    public static void main(String[] args) {

        DerivedSubclass derivedSubclass = new DerivedSubclass();
        derivedSubclass.function(derivedSubclass);
    }
}



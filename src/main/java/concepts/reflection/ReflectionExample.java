package concepts.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parya on 5/17/2016.
 */
public class ReflectionExample {

    List<String> dataList;

    public ReflectionExample() {
        System.out.println("ReflectionExample()");
        this.dataList = new ArrayList<>();
    }

    public void printData(String data) {
        System.out.println("Printing....................");
        System.out.println(data);
    }

    public void writeData(String data) {
        this.dataList.add(data);
    }

    public static void main(String[] args) {
        Method[] methodArray = ReflectionExample.class.getMethods();

        System.out.println(methodArray.length + " Method Names : ");
        for (Method method : methodArray) {
            System.out.println(method.getName());
        }

        try {
            Class aClass = Class.forName("concepts.reflection.ReflectionExample");
            System.out.println("Full name : " + aClass.getName());
            System.out.println("Without package : " + aClass.getSimpleName());
            int modifier = aClass.getModifiers();
            System.out.println("Class modifier : " + modifier);
            System.out.println("Static class : " + Modifier.isStatic(modifier));
            System.out.println("Public class : " + Modifier.isPublic(modifier));
            System.out.println("Package name : " + aClass.getPackage());
            System.out.println("Super class : " + aClass.getSuperclass());

//            Field[] fields = aClass.getFields();
            Field[] fields = aClass.getDeclaredFields();
            System.out.println(fields.length + " Fields Name : ");
            for (Field field : fields) {
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("....Creating Construction Through Reflection....");
        try {
            Class aClass = Class.forName("concepts.reflection.ReflectionExample");
            ReflectionExample reflectionExample = (ReflectionExample) (aClass.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

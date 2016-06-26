package concepts.basic.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parya on 6/8/2016.
 */
public class Person implements Cloneable {
    private String fName;
    private String lName;

    private List<String> qualifications;

    public Person() {
        this.fName = "Pradeep";
        this.lName = "Arya";
        this.qualifications = new ArrayList<>(Arrays.asList("B.sc(H)C.S.", "MCA"));
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    protected Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public String toString() {
        return this.fName + " " + this.lName + ", Qualification : " + this.qualifications;
    }
}

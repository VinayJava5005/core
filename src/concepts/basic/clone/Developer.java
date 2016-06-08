package concepts.basic.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parya on 6/8/2016.
 */
public class Developer implements Cloneable {
    private String fName;
    private String lName;

    private List<String> knownLanguages;

    public Developer() {
        this.fName = "Pradeep";
        this.lName = "Arya";
        this.knownLanguages = new ArrayList<>(Arrays.asList("C++", "Java"));
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

    public List<String> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(List<String> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    @Override
    protected Developer clone() {
        Developer developer = null;

        try {
            developer = (Developer) super.clone();
            developer.setKnownLanguages(new ArrayList<>(this.knownLanguages));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return developer;
    }

    @Override
    public String toString() {
        return this.fName + " " + this.lName + ", Qualification : " + this.knownLanguages;
    }
}

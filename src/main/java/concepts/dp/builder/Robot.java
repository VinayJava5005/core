package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public class Robot {

    private String head;
    private String torso;
    private String arms;
    private String legs;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTorso() {
        return torso;
    }

    public void setTorso(String torso) {
        this.torso = torso;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Head : " + this.head + ", Torso : " + this.torso + ", Arms : " + this.arms + ", Legs : " + this.legs;
    }
}

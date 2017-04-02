package problems.robot.product;

/**
 * Created by pradeep on 31/3/17.
 */
public class Robot {

    private Battery battery;
    private String torsoMessage;

    public Robot(Battery battery) {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public String getTorsoMessage() {
        return torsoMessage;
    }

    public void setTorsoMessage(String torsoMessage) {
        this.torsoMessage = torsoMessage;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "battery = " + battery +
                ", torsoMessage = '" + torsoMessage + '\'' +
                '}';
    }
}
package problems.robot.product;

/**
 * Created by pradeep on 31/3/17.
 */
public class Battery {

    public enum LEVEL {
        DISCHARGED,
        LOW,
        AVERAGE,
        FULL
    }

    public Battery() {
        this.power = 100;
        this.level = LEVEL.FULL;
    }

    private double power;
    private LEVEL level;

    public double power() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public LEVEL level() {
        return level;
    }

    public void setLevel(LEVEL level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "power = " + Math.round(power) +
                ", level = " + level.name() +
                '}';
    }
}

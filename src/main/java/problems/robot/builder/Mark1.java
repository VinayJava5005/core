package problems.robot.builder;

import problems.robot.product.Battery;
import problems.robot.product.Robot;

/**
 * Created by pradeep on 31/3/17.
 */
public class Mark1 implements RobotBuilder {

    private Robot robot;
    private double maxWalkDistance;
    private int batteryLow;
    private double maxWaitCarry;

    private double waitCarry;

    public RobotBuilder build() {
        this.maxWalkDistance = 5;
        this.batteryLow = 15;
        this.maxWaitCarry = 10;
        this.robot = new Robot(new Battery());
        return this;
    }

    public RobotBuilder carryObject(double waitCarry){
        this.waitCarry = waitCarry;
        return this;
    }

    public void walk(double distance) {

        if (robot != null) {

            if(waitCarry <= maxWaitCarry) {
                double batteryRemaining = startWalk(distance);

                robot.getBattery().setPower(batteryRemaining);
                if(batteryRemaining < 1){
                    robot.getBattery().setLevel(Battery.LEVEL.DISCHARGED);
                }
                else if (batteryRemaining < batteryLow) {
                    robot.getBattery().setLevel(Battery.LEVEL.LOW);
                } else {
                    robot.getBattery().setLevel(Battery.LEVEL.AVERAGE);
                }
            }else{
                robot.setTorsoMessage("Overweight");
            }
        }
    }

    private double startWalk(double distance) {
        double batteryRemaining = (1 - ((distance) / maxWalkDistance)) * 100;
        return batteryRemaining > 0 ? (batteryRemaining - (waitCarry * 2 * batteryRemaining) / 100) : 0;
    }

    public Robot getRobot(){
        return robot;
    }
}

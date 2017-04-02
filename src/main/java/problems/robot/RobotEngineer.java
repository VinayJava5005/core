package problems.robot;

import problems.robot.builder.Mark1;
import problems.robot.builder.RobotBuilder;

/**
 * Created by pradeep on 31/3/17.
 */
public class RobotEngineer {

    public static void main(String[] args) {

        double distance = 3;
        double waitCarry = 5;

        RobotBuilder robotBuilder = new Mark1();
        robotBuilder.build();
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km "  +robotBuilder.getRobot());

        distance = 4.5;
        robotBuilder = new Mark1();
        robotBuilder.build().carryObject(waitCarry);
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km " +robotBuilder.getRobot());

        distance = 4.5;
        waitCarry = 11;
        robotBuilder = new Mark1();
        robotBuilder.build().carryObject(waitCarry);
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km " +robotBuilder.getRobot());

        distance = 4.5;
        waitCarry = 10;
        robotBuilder = new Mark1();
        robotBuilder.build().carryObject(waitCarry);
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km " +robotBuilder.getRobot());

        distance = 5;
        waitCarry = 10;
        robotBuilder = new Mark1();
        robotBuilder.build().carryObject(waitCarry);
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km " +robotBuilder.getRobot());

        distance = 10;
        waitCarry = 10;
        robotBuilder = new Mark1();
        robotBuilder.build().carryObject(waitCarry);
        robotBuilder.walk(distance);

        System.out.println("After walking " +  distance + " km " +robotBuilder.getRobot());

    }
}

package problems.robot.builder;

import problems.robot.product.Robot;

/**
 * Created by pradeep on 31/3/17.
 */
public interface RobotBuilder {

    void walk(double distance);

    RobotBuilder carryObject(double waitCarry);

    RobotBuilder build();

    Robot getRobot();
}

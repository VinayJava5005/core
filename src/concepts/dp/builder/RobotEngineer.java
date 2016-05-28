package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public class RobotEngineer {

    private RobotBuilder robotBuilder;


    public void setRobotBuilder(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    public Robot getRobot() {
        return robotBuilder.getRobot();
    }

    public void makeRobot() {
        robotBuilder.buildRobotHead();
        robotBuilder.buildRobotTorso();
        robotBuilder.buildRobotArms();
        robotBuilder.buildRobotLegs();
    }
}

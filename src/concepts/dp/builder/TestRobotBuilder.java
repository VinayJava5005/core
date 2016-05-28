package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public class TestRobotBuilder {

    public static void main(String[] args) {
        RobotBuilder robotBuilder = new OldRobotBuilder();
        RobotEngineer robotEngineer = new RobotEngineer();
        robotEngineer.setRobotBuilder(robotBuilder);
        robotEngineer.makeRobot();
        System.out.println(robotEngineer.getRobot());

        System.out.println(".................................................");
        robotBuilder = new NewRobotBuilder();
        robotEngineer.setRobotBuilder(robotBuilder);
        robotEngineer.makeRobot();
        System.out.println(robotEngineer.getRobot());
    }
}

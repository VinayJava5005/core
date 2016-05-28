package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public interface RobotBuilder {

    void buildRobotHead();

    void buildRobotTorso();

    void buildRobotArms();

    void buildRobotLegs();

    Robot getRobot();
}

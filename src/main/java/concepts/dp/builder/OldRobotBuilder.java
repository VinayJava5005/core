package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public class OldRobotBuilder implements RobotBuilder {

    private Robot robot;

    public OldRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildRobotHead() {
        this.robot.setHead("Square Head");
    }

    @Override
    public void buildRobotTorso() {
        this.robot.setTorso("Rectangle Torso");
    }

    @Override
    public void buildRobotArms() {
        this.robot.setArms("Blowtorch Arms");
    }

    @Override
    public void buildRobotLegs() {
        this.robot.setLegs("Roller Skates");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}

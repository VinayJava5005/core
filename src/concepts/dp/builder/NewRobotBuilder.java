package concepts.dp.builder;

/**
 * Created by pradeep on 28/5/16.
 */
public class NewRobotBuilder implements RobotBuilder {

    private Robot robot;

    public NewRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildRobotHead() {
        this.robot.setHead("Oval Head");
    }

    @Override
    public void buildRobotTorso() {
        this.robot.setTorso("Rounded Torso");
    }

    @Override
    public void buildRobotArms() {
        this.robot.setArms("Blowtorch Arms");
    }

    @Override
    public void buildRobotLegs() {
        this.robot.setLegs("Natural Legs Movements");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}

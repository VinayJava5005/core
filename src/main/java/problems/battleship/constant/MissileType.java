package problems.battleship.constant;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 9/2/17
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public enum MissileType {
    ALPHA("alpha"), BETA("beta"), GAMMA("gamma");

    private String type;

    MissileType(String type) {
        this.type = type;
    }


    public static MissileType fromString(String type) {
        for (MissileType missileType : MissileType.values()) {
            if (missileType.type.equalsIgnoreCase(type)) {
                return missileType;
            }
        }
        return null;
    }
}

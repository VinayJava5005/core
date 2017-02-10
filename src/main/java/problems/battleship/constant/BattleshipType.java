package problems.battleship.constant;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/2/17
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BattleshipType {
    P('p'),Q('q');

    private char type;

    BattleshipType(char type) {
        this.type = type;
    }


    public static BattleshipType fromChar(char type) {
        for (BattleshipType battleshipType : BattleshipType.values()) {
            if (battleshipType.type == Character.toLowerCase(type)) {
                return battleshipType;
            }
        }
        return null;
    }
}

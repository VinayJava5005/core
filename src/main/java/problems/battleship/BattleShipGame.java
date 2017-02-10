package problems.battleship;

import problems.battleship.model.Player;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/2/17
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class BattleShipGame {

    private Player player1;
    private Player player2;

    public BattleShipGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {

        while (true) {

            boolean isHit = player1.fire(player2);

            if (!isHit) {
                Player player = player1;
                player1 = player2;
                player2 = player;
            }

            if (!player1.hasShipLeft()) {
                System.out.println(player2.getName() + " won the battle");
                break;
            }
            if (!player2.hasShipLeft()) {
                System.out.println(player1.getName() + " won the battle");
                break;
            }
            if (!player1.hasTargetLeft() && !player2.hasTargetLeft()) {
                break;
            }
        }
    }


}

package problems.battleship;

import problems.battleship.model.Battleship;
import problems.battleship.model.Player;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/2/17
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameLauncher {

    public static void main(String[] args) {

        List<String> input = Arrays.asList("5 E", "Q", "1 1", "A1", "B2", "P", "2 1", "D4", "C3", "A1 B2 B2 B3", "A1 B2 B3 A1 D1 E1 D4 D4 D5 D5");

        System.out.print("Enter area boundaries : ");
        String boundaries = input.get(0);

        System.out.print("Type for battleship 1 : ");
        char type = input.get(1).charAt(0);

        System.out.print("Dimension for battleship 1 : ");
        String dimension = input.get(2);

        System.out.print("Location of battleship 1 for player A : ");
        String aLocation = input.get(3);

        System.out.print("Location of battleship 1 for player B : ");
        String bLocation = input.get(4);

       /*Setting battleship 1 for player 1 and 2*/
        Battleship aBattleship = new Battleship().setType(type).setDimension(dimension).setArea(aLocation);
        Player player1 = new Player().setName("Player 1").addBattleship(aBattleship);

        Battleship bBattleship = new Battleship().setType(type).setDimension(dimension).setArea(bLocation);
        Player player2 = new Player().setName("Player 2").addBattleship(bBattleship);


        System.out.print("Type for battleship 2 : ");
        type = input.get(5).charAt(0);

        System.out.print("Dimension for battleship 2 : ");
        dimension = input.get(6);

        System.out.print("Location of battleship 2 for player A : ");
        aLocation = input.get(7);

        System.out.print("Location of battleship 2 for player B : ");
        bLocation = input.get(8);

        System.out.print("Missile targets for player A : ");
        String playerOneTargets = input.get(9);
        System.out.print("Missile targets for player B : ");
        String playerTwoTargets = input.get(10);

       /*Setting battleship 2 for player 1 and 2*/
        aBattleship = new Battleship().setType(type).setDimension(dimension).setArea(aLocation);
        player1 = player1.addBattleship(aBattleship).setTargets(playerOneTargets);

        bBattleship = new Battleship().setType(type).setDimension(dimension).setArea(bLocation);
        player2 = player2.addBattleship(bBattleship).setTargets(playerTwoTargets);

        BattleShipGame battleShipGame = new BattleShipGame(player1, player2);
        battleShipGame.start();

    }
}

package concepts.dp.factory;

import java.util.Scanner;

/**
 * Created by pradeep on 29/5/16.
 */
public class EnemyShipTesting {
    public static void main(String[] args) {

        EnemyShipFactory enemyShipFactory = new EnemyShipFactory();

        String shipType = null;

        System.out.print("What is the type of ship (U / R / B) : ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            shipType = scanner.nextLine();
        }

        EnemyShip enemyShip = enemyShipFactory.makeShip(shipType);

        if (enemyShip != null) {
            doStuff(enemyShip);
        }

    }


    private static void doStuff(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShots();
    }
}

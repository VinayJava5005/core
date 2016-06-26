package concepts.dp.factory;

/**
 * Created by pradeep on 29/5/16.
 */
public class EnemyShipFactory {

    public EnemyShip makeShip(String shipType) {

        if (shipType != null) {
            if (shipType.equalsIgnoreCase("U")) {
                return new UFOEnemyShip();
            } else if (shipType.equalsIgnoreCase("R")) {
                return new RocketEnemyShip();
            } else if (shipType.equalsIgnoreCase("B")) {
                return new BigUFOEnemyShip();
            }
        }
        return null;
    }
}

package concepts.dp.factory;

/**
 * Created by pradeep on 29/5/16.
 */
public abstract class EnemyShip {

    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is following hero ship");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on screen");
    }

    public void enemyShipShots() {
        System.out.println(getName() + " attack and does " + getAmtDamage() + "% damage");
    }
}

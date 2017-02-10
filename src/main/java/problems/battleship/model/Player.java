package problems.battleship.model;

import problems.battleship.constant.MissileType;
import problems.battleship.constant.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/2/17
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    private String name;
    private List<Battleship> battleships;
    private List<String> targets;
    private int targetFired;
    private MissileType missileType;

    public String getName() {
        return this.name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public List<Battleship> getBattleships() {
        return battleships;
    }

    public Player addBattleship(Battleship battleship) {
        if (this.battleships == null) {
            this.battleships = new ArrayList<Battleship>();
        }
        this.battleships.add(battleship);

        return this;
    }

    public Player setTargets(String targets) {

        if (this.targets == null) {
            this.targets = new ArrayList<String>();
        }

        for (String target : targets.split(" ")) {
            this.targets.add(target);
        }
        this.targetFired = 1;
        return this;
    }

    public Player setMissileType(String type) {
        this.missileType = MissileType.fromString(type);
        return this;
    }

    public boolean hasTargetLeft() {
        return !(this.targets.size() < this.targetFired);
    }

    public List<String> targets() {
        return this.targets;
    }

    public boolean isHit(String dimension) {

        boolean isHit = false;

        if (battleships != null) {
            for (Battleship battleship : battleships) {
                if (battleship.hit(dimension)) {
                    isHit = true;
                    break;
                }
            }
        }
        return isHit;

    }

    public boolean fire(Player player2) {
        boolean isHit = false;

        if (this.hasTargetLeft()) {
            String dimension = this.targets().get(this.targetFired - 1);

            List<String> targets = Utility.getMissileTargets(missileType, dimension);

            for (String target : targets) {
                isHit = player2.isHit(target);
                if (isHit) {
                    System.out.println(this.name + " fires a missile with target " + dimension + " which hit");
                } else {
                    System.out.println(this.name + " fires a missile with target " + dimension + " which missed");
                }
            }
        } else {
            System.out.println(this.name + " has no more missiles left");
        }
        this.targetFired++;
        return isHit;
    }

    public boolean hasShipLeft() {
        boolean hasShipLeft = false;
        for (Battleship battleship : this.battleships) {
            if (battleship.isAlive()) {
                hasShipLeft = true;
            }
        }
        return hasShipLeft;
    }
}

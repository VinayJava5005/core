package problems.battleship.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 9/2/17
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utility {

    private Utility(){

    }

    public static List<String> getMissileTargets(MissileType missileType, String dimension){
        List<String> targets = new ArrayList<String>();

        String[] coordinates = dimension.split("");
        int x = Integer.parseInt(coordinates[1]);
        int y = (int)coordinates[0].charAt(0);

        if(missileType != null){
            switch (missileType){

                case ALPHA:
                    populateTargets(targets, x - 1, (char)(y - 1), x + 1, (char)(y + 1));
                    break;

                case BETA:
                    break;

                case GAMMA:
                    break;

            }
        }else{
            targets.add(dimension);
        }

        return targets;
    }

    private static void populateTargets(List<String> targets, int startX, char startY, int endX, char endY){

        for(char row = startY; row < endY; row++){
            for(int column = startX; column < endX; column++){
                targets.add(row + "" + column);
            }
        }
    }
}

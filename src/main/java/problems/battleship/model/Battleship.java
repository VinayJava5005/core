package problems.battleship.model;

import problems.battleship.constant.BattleshipType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/2/17
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Battleship {

    private BattleshipType type;
    private int dimensionX;
    private int dimensionY;
    private Map<String, Integer> area;

    public Battleship setType(char type) {
        this.type = BattleshipType.fromChar(type);
        return this;
    }

    public Battleship setDimension(String dimension){
        if(dimension != null){
            String[] dimensions = dimension.split(" ");
            dimensionX = Integer.parseInt(dimensions[0]);
            dimensionY = Integer.parseInt(dimensions[1]);
        }

        return this;
    }

    public Map<String, Integer> getArea() {
        return area;
    }

    public Battleship setArea(String areaPoint) {
        if(area == null){
            area = new HashMap<String, Integer>();
        }
        if(areaPoint != null){

            String[] startAreaPoints = areaPoint.split("");
            int x = Integer.parseInt(startAreaPoints[1]);
            char yPosition = startAreaPoints[0].charAt(0);

            int xPosition = x;
            for(int row = 0; row < dimensionY; row++){
                for(int column = 0; column < dimensionX; column++){

                    String key = yPosition + "" + xPosition;
                    xPosition++;
                    if(type == BattleshipType.P){
                        area.put(key, 1);
                    }else if(type == BattleshipType.Q){
                        area.put(key, 2);
                    }

                }
                yPosition++;
                xPosition = x;
            }
        }
        return this;
    }

    public boolean hit(String dimension){

        boolean isHit = false;

        Integer shipCondition = this.area.get(dimension);
        if(shipCondition != null){
            shipCondition--;
            if(shipCondition == 0){
                this.area.remove(dimension);
            }else{
                this.area.put(dimension, shipCondition);
            }
            isHit = true;
        }

        return isHit;
    }

    public boolean isAlive(){
        return this.area.size() > 0;
    }
}

package programs;

public class TowerOfHanoi {

    private int noOfMoves;
    private static TowerOfHanoi instance = new TowerOfHanoi();

    private TowerOfHanoi() {

    }

    public static TowerOfHanoi getInstance() {
        instance.noOfMoves = 0;
        return instance;
    }

    public void play(int diskNumber, int from, int to, int intermediate) {
        if (diskNumber == 1) {
            System.out.println("Moving Disk : " + diskNumber + " from pole : " + from + " to pole : " + to);
            noOfMoves++;
        } else {
            play(diskNumber - 1, from, intermediate, to);
            System.out.println("Moving Disk : " + diskNumber + " from pole : " + from + " to pole : " + to);
            noOfMoves++;
            play(diskNumber - 1, intermediate, to, from);
        }
    }

    public int getNoOfMoves() {
        return noOfMoves;
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = TowerOfHanoi.getInstance();
        towerOfHanoi.play(5, 1, 2, 3);
        System.out.println("Number of moves : " + towerOfHanoi.getNoOfMoves());
    }

}

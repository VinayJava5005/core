package programs;

/**
 * Created by pradeep on 31/5/16.
 */
public class RatMaze {

    public static RatMaze instance = new RatMaze();

    private RatMaze() {

    }

    public static RatMaze getInstance() {
        return instance;
    }

    public int[][] start(int maze[][], int startX, int startY, int nX, int nY, int endX, int endY) {

        if (startX < 0 || startY < 0 || startX > nX - 1 || startY > nY - 1) {
            System.out.println("Source index is out of bound");
            return null;
        }

        if (endX < 0 || endY < 0 || endX > nX - 1 || endY > nY - 1) {
            System.out.println("Destination index is out of bound");
            return null;
        }

        int[][] mazeMap = new int[nX][nY];

        if (doMove(maze, startX, startY, endX, endY, mazeMap)) {
            return mazeMap;
        } else {
            return null;
        }

    }

    private boolean doMove(int maze[][], int startX, int startY, int endX, int endY, int mazeMap[][]) {
        boolean isAbleToMove = false;

        if (startX == endX && startY == endY) {
            isAbleToMove = true;
        } else if (isMoveAllowed(maze, startX, startY)) {
            if (maze[startX][startY + 1] == 1) {
                isAbleToMove = doMove(maze, startX, startY + 1, endX, endY, mazeMap);
            } else if (maze[startX + 1][startY] == 1) {
                isAbleToMove = doMove(maze, startX + 1, startY, endX, endY, mazeMap);
            }

            if (isAbleToMove) {
                mazeMap[startX][startY] = 1;
            }
        }

        return isAbleToMove;
    }

    private boolean isMoveAllowed(int[][] maze, int startX, int startY) {

        return maze[startX][startY + 1] == 1 || maze[startX + 1][startY] == 1;

    }


    public static void main(String[] args) {
        RatMaze ratMaze = RatMaze.getInstance();
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] mazeMap = ratMaze.start(maze, 0, 0, 4, 4, 3, 3);

        /*Original maze*/
        System.out.println("Original maze........................");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(" " + maze[i][j] +
                        " ");
            System.out.println();
        }

        if (mazeMap != null) {
        /*Solve maze*/
            System.out.println("Solved maze......................");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++)
                    System.out.print(" " + mazeMap[i][j] +
                            " ");
                System.out.println();
            }
        }

    }
}

package programs;

import java.util.*;

/**
 * Created by pradeep on 23/6/17.
 */
public class TicTacToeRunner {

    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(3, true);
        System.out.println(ticTacToe.start().result());

    }
}

class TicTacToe {

    private int type;
    private Map<Integer, String> board;
    private String gameResult;
    private Scanner scanner;
    private Map<Integer, List<String>> winnerCheck;
    private int currentMoveLocation;
    private String currentPlayer;
    private boolean singlePlayer;
    private Random random;

    public TicTacToe(int type, boolean singlePlayer) {
        this.type = type;
        this.singlePlayer = singlePlayer;
        this.random = new Random();
        this.board = new HashMap<>();

        for (int keyIndex = 1; keyIndex <= (type * type); keyIndex++) {
            this.board.put(keyIndex, String.valueOf(keyIndex));
        }
        this.scanner = new Scanner(System.in);

        this.winnerCheck = new HashMap<>();
        this.winnerCheck.put(1, Arrays.asList("1,2,3", "1,5,9", "1,4,7"));
        this.winnerCheck.put(2, Arrays.asList("1,2,3", "2,5,8"));
        this.winnerCheck.put(3, Arrays.asList("1,2,3", "3,6,9"));
        this.winnerCheck.put(4, Arrays.asList("4,5,6", "1,4,7"));
        this.winnerCheck.put(5, Arrays.asList("1,5,9", "4,5,6", "2,5,8"));
        this.winnerCheck.put(6, Arrays.asList("4,5,6", "3,6,9"));
        this.winnerCheck.put(7, Arrays.asList("1,4,7", "7,8,9"));
        this.winnerCheck.put(8, Arrays.asList("7,8,9", "2,5,8"));
        this.winnerCheck.put(9, Arrays.asList("1,5,9", "3,6,9"));

        this.currentMoveLocation = 0;
    }

    public TicTacToe display() {

        int rowIndex = 0;
        while (rowIndex < (type * type)) {

            int key = 0;
            for (int columnIndex = 1; columnIndex <= type; columnIndex++) {
                key = rowIndex + columnIndex;
                System.out.print(" " + board.get(key) + " ");
                if (columnIndex != type) {
                    System.out.print("|");
                }
            }
            rowIndex = key;
            System.out.println();

            if (rowIndex != (type * type)) {
                for (int columnIndex = 0; columnIndex < type; columnIndex++) {
                    System.out.print("----");
                }
                System.out.println();
            }
        }

        System.out.println("\n\n\n");

        return this;
    }


    public TicTacToe start() {

        display();
        do {
            System.out.println("Player 1");
            currentPlayer = "X";
            userMove();

            display();
            if (!isGameOver()) {

                if (isSinglePlayer()) {
                    System.out.println("Computers");
                    currentPlayer = "0";
                    computerMove();
                } else {
                    System.out.println("Player 2");
                    currentPlayer = "0";
                    userMove();
                }
            }
            display();
        } while (!isGameOver());

        return this;
    }

    private void computerMove() {

        int max = type * type;
        int min = 1;
        int number = random.nextInt(max - min + 1) + min;

        while (board.get(number) == "X" || board.get(number) == "0") {
            number = random.nextInt(max - min + 1) + min;
        }
        currentMoveLocation = number;
        board.put(number, currentPlayer);
    }

    private void userMove() {
        currentMoveLocation = scanner.nextInt();
        board.put(currentMoveLocation, currentPlayer);
    }

    private boolean isGameOver() {

        boolean isGameOver = false;
        if (currentMoveLocation != 0) {

            for (String locationCombination : winnerCheck.get(currentMoveLocation)) {
                String[] locations = locationCombination.split(",");

                boolean result = true;
                for (String location : locations) {
                    if (!currentPlayer.equals(board.get(Integer.parseInt(location)))) {
                        result = false;
                        break;
                    }
                }

                if (result) {
                    isGameOver = result;
                    gameResult = "Player " + currentPlayer + " won";
                    break;
                }

            }

        }
        return isGameOver;
    }

    public String result() {
        return gameResult;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

}

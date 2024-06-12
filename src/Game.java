import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);

    private Grid grid;
    private Player[] players;
    private Map<Player, Integer> score;
    int targetScore;
    int connectN;


    public Game(int rows, int cols, int connectN, int targetScore) {
        this.grid = new Grid(rows, cols);
        this.connectN = connectN;
        this.targetScore = targetScore;

        this.players = new Player[] {
                new Player("Player1", GridPosition.YELLOW),
                new Player("Player2", GridPosition.RED)
        };

        this.score = new HashMap<>();
        for (Player p : this.players) {
            this.score.put(p, 0);
        }
    }

    public void printBoard() {
        // print gameboard
        int[][] grid = this.grid.getGrid();
        for (int r = 0; r < grid.length; r++) {
            String row = "";
            for (int piece : grid[r]) {
                if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "O";
                } else if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "Y";
                } else if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "R";
                }
            }
            System.out.println(row);
        }
        System.out.println();
    }

    public int[] playMove(Player player) {
        // put a piece and update the score
        printBoard();
        int cols = grid.getColumnCount();
        System.out.print("Enter column number between 0 and " + (cols - 1) + " to add piece: ");
        int moveColumn = input.nextInt();
        int moveRow = this.grid.placePiece(moveColumn,player.getPiece());
        return new int[] {moveColumn,moveRow};
    }

    public boolean playRound() {
        // play game until someone win
        return true;
    }



    public void play(int rows, int cols, int connectN, int targetScore) {


    }
        // check score == target score

}




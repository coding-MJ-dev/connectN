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
                } else if (piece == GridPosition.YELLOW.ordinal()) {
                    row += "Y";
                } else if (piece == GridPosition.RED.ordinal()) {
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

    public Player playRound() {
        // play game until someone win
        while (true) {
            for (Player player : players) {
                int[] move = playMove(player);
                if (this.grid.checkWin(connectN,move[0],move[1],player.getPiece())) {
                    this.score.put(player, score.get(player)+1);
                    return player;
                }
            }
        }
    }



    public void play(int rows, int cols) {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.targetScore) {
            winner = playRound();
            System.out.println("Winner of the round is : " + winner.getName() + "!!!!!!!!!! ");
            maxScore = Math.max(maxScore, score.get(winner));
            this.grid.createGrid(rows, cols);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Winner of the game is : " + winner.getName() + "!!!!!!!!!! ");
        System.out.println("------------------------------------------------------------------");


    }
        // check score == target score

}




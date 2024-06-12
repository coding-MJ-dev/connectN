import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("----------------------------------");
        System.out.println("|   Welcome to ConnectN game!!!  |");
        System.out.println("----------------------------------");
        System.out.print("rows of the board: ");
        int rows = input.nextInt();
        System.out.print("colmns of the board: ");
        int cols = input.nextInt();
        System.out.print("aim to connect: ");
        int connectN = input.nextInt();
        System.out.print("How many rounds do you want to play: ");
        int targetScore = input.nextInt();

        System.out.println();
        System.out.println("Let's play game.");
        System.out.println();

        Game game = new Game(rows, cols, connectN, targetScore);
        game.printBoard();
    }
}
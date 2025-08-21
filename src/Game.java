import java.util.Scanner;

public class Game {
    private SudokuBoard board;
    private Scanner scanner;

    public Game() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Sudoku Terminal ===");

        while (true) {
            board.printBoard();

            System.out.print("Linha (0-8): ");
            int row = scanner.nextInt();

            System.out.print("Coluna (0-8): ");
            int col = scanner.nextInt();

            System.out.print("Valor (1-9): ");
            int value = scanner.nextInt();

            if (board.isValidMove(row, col, value)) {
                board.setCell(row, col, value);
            } else {
                System.out.println("Movimento inválido!");
            }
        }
    }
}

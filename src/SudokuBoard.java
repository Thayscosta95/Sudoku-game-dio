public class SudokuBoard {
    private Cell[][] board;

    public SudokuBoard() {
        board = new Cell[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = new Cell(0, false);
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {
        board[row][col].setValue(value);
    }

    public boolean isValidMove(int row, int col, int value) {
        // verifica linha
        for (int i = 0; i < 9; i++)
            if (board[row][i].getValue() == value) return false;

        // verifica coluna
        for (int i = 0; i < 9; i++)
            if (board[i][col].getValue() == value) return false;

        // verifica bloco 3x3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j].getValue() == value) return false;

        return true;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("-------------------------------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(board[i][j].getValue() == 0 ? "  " : board[i][j].getValue() + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------");
    }
}

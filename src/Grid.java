public class Grid {
    private int rows;
    private int cols;
    private int[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        createGrid();
    }

    private void createGrid() {
        this.grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }
    }

    public int placePiece(int col, GridPosition piece) {
        if (col < 0 || col > this.cols) {
            throw new Error("Invaild column");
        }

        for (int r = this.rows-1; r >= 0; r--) {
            if (grid[r][col] == GridPosition.EMPTY.ordinal()) {
                grid[r][col] = piece.ordinal();
                return r;
            }
        }
        return -1;
    }

    public boolean checkWin(int connectN, int row, int col, GridPosition piece) {
     //check column
        int count = 0;
        for (int r = this.rows-1; r >= 0; r--) {
            if (this.grid[r][col] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }

        }

        //check vertical
        count = 0;
        for (int c = 0; c < this.cols; c++) {
            if (grid[row][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        // diagonal check
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            int c = col + row - r;
            if (c >= 0 && c < cols-1 && grid[r][c] == piece.ordinal()) {
                count++;
            }
            if (count == connectN) {
                return true;
            }
            else {
                count = 0;
            }
        }
        // anti - diagonal check
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            int c = col - row + r;
            if (c >= 0 && c < cols-1 && grid[r][c] == piece.ordinal()) {
                count++;
            }
            if (count == connectN) {
                return true;
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public int getColumnCount() {
        return this.cols;
    }

}

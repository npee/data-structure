package _10_Maze;

public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;

    private int[][] grid = {
            {1,1,1,0,1,1,0,0,0,1,1,1,1},
            {1,0,1,1,1,0,1,1,1,1,0,0,1},
            {0,0,0,0,1,0,1,0,1,0,1,0,0},
            {1,1,1,0,1,1,1,0,1,0,1,1,1},
            {1,0,1,0,0,0,0,1,1,1,0,0,1},
            {1,0,1,1,1,1,1,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public boolean traverse(int row, int col) {
        boolean done = false;

        if (valid(row, col)) {
            grid[row][col] = TRIED;

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                done = true;
            } else {
                done = traverse(row + 1, col);
                if (!done) {
                    done = traverse(row, col + 1);
                }
                if (!done) {
                    done = traverse(row - 1, col);
                }
                if (!done) {
                    done = traverse(row, col - 1);
                }
            }

            if (done) {
                grid[row][col] = PATH;
            }
        }

        return done;
    }

    private boolean valid(int row, int col) {
        boolean result = false;

        if (row >= 0 && row < grid.length && col >= 0 && col < grid[col].length) {
            if (grid[row][col] == 1) {
                result = true;
            }
        }

        return result;
    }
}

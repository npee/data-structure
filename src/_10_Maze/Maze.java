package _10_Maze;

//********************************************************************
//  Maze.java       Author: Lewis/Chase
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

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

        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) {
            if (grid[row][col] == 1) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "\n";

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                result += grid[row][col] + " ";
            }
            result += "\n";
        }

        return result;
    }
}

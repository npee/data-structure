package _06_Maze;

//********************************************************************
//  Maze.java       Author: Lewis and Chase
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

import structures.LinkedStack;
import structures.StackADT;

public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;

    private int [][] grid = {
            {1,1,1,0,1,1,0,0,0,1,1,1,1},
            {1,0,0,1,1,0,1,1,1,1,0,0,1},
            {1,1,1,1,1,0,1,0,1,0,1,0,0},
            {0,0,0,0,1,1,1,0,1,0,1,1,1},
            {1,1,1,0,1,1,1,0,1,0,1,1,1},
            {1,0,1,0,0,0,0,1,1,1,0,0,1},
            {1,0,1,1,1,1,1,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    private StackADT<_06_Maze.Position> push_new_pos(int x, int y, StackADT<Position> stack) {
        Position nPos = new Position();
        nPos.setX(x);
        nPos.setY(y);
        if (valid(nPos.getX(), nPos.getY())) {
            stack.push(nPos);
        }
        return stack;
    }

    public boolean traverse() {
        boolean done = false;
        Position pos = new Position();
        Object dispose;
        StackADT<Position> stack = new LinkedStack<Position>();
        stack.push(pos);

        while(!done) {
            pos = stack.pop();
            grid[pos.getX()][pos.getY()] = TRIED;
            if (pos.getX() == grid.length - 1 && pos.getY() == grid[0].length - 1) {
                done = true;
            } else {
                stack = push_new_pos(pos.getX(), pos.getY() - 1, stack);
                stack = push_new_pos(pos.getX(), pos.getY() + 1, stack);
                stack = push_new_pos(pos.getX() - 1, pos.getY(), stack);
                stack = push_new_pos(pos.getX() + 1, pos.getY(), stack);
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

package _06_Maze;

//********************************************************************
//  MazeSearch.java       Author: Lewis and Chase
//
//  Demonstrates a simulation of recursion using a stack.
//********************************************************************

public class MazeSearch {
    public static void main(String[] args) {
        Maze labyrinth = new Maze();

        System.out.println(labyrinth);

        if (labyrinth.traverse()) {
            System.out.println("The maze was successfully traversed!");
        } else {
            System.out.println("There is no possible path.");
        }
        System.out.println(labyrinth);
    }
}

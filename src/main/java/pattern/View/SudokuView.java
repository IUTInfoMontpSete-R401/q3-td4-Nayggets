package pattern.View;

import pattern.Composite.Composite;
import pattern.Model.SudokuModel;

import java.util.ArrayList;

public class SudokuView {

    SudokuModel model;

    public SudokuView(SudokuModel sudo){
        model = sudo;
    }

    public void update(int row, int col, int value) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
    }


    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }

    public void display() {
        for(int row = 0; row < model.getBoardSize(); ++row) {
            if (row % model.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }

            for(int col = 0; col < model.getBoardSize(); ++col) {
                if (col % model.getBlockSize() == 0) {
                    System.out.print("| ");
                }

                int value = model.getValueAt(row,col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print("" + value + " ");
                }
            }

            System.out.println("|");
        }

        System.out.println(" -----------------------");
    }



    public int getBoardSize(int[][] board) {
        return board.length;
    }

    public int getBlockSize(int[][] board) {
        return (int)Math.sqrt((double)board[0].length);
    }


}

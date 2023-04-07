package pattern.Model;

import pattern.Composite.Case;
import pattern.Composite.Composite;
import pattern.Observer.SudokuObserver;

import java.util.ArrayList;

public class SudokuModel {


    private int[][] board;
    private ArrayList<SudokuObserver> observerList = new ArrayList<>();

    public SudokuModel(int boardSize) {
        board = new int[boardSize*boardSize][boardSize*boardSize];
    }


    public int getValueAt(int row, int col) {
        return board[row][col];
    }

    public boolean isValueValid(int row, int col, int value) {
        // Check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // Check region
        int regionSize = (int) Math.sqrt(board.length);
        int rowRegionStart = (row / regionSize) * regionSize;
        int colRegionStart = (col / regionSize) * regionSize;
        for (int i = rowRegionStart; i < rowRegionStart + regionSize; i++) {
            for (int j = colRegionStart; j < colRegionStart + regionSize; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setValueAt(int row, int col, int value) {
        board[row][col] = value;
        notifyAllObserver(row, col, value);
    }



    public int getBoardSize() {
        return board.length;
    }


    public int getBlockSize() {

        return (int) Math.sqrt(board[0].length);
    }



    public boolean isGameFinished() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                if (getValueAt(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void registerObserver(SudokuObserver sudokuObserver){
        observerList.add(sudokuObserver);
    }

    private void notifyAllObserver(int row, int col, int value){
        for(SudokuObserver o : observerList){
            o.update(row,col,value);
        }
    }
}

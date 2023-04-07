package pattern.Model;

import pattern.Composite.Cellule;
import pattern.Composite.Composite;
import pattern.Observer.SudokuObserver;

import java.util.ArrayList;

public class SudokuModel {

    private Composite composite;

    private ArrayList<SudokuObserver> observerList = new ArrayList<>();

    public SudokuModel(int[][] board)
    {
        Cellule[] cellules = new Cellule[board.length];
        for(int i = 0 ; i < board.length ; i++){
            cellules[i] = new Cellule(board[i]);
        }
        composite = new Cellule(cellules);
    }

    public int getValueAt(int row, int col) {
        return composite.getValue(row,col);
    }


    public int getBlockSize() {
        return (int)Math.sqrt((double)composite.length());
    }


    public boolean isValueValid(int row, int col, int value) {
        // Check row
        for (int i = 0; i < composite.length(); i++) {
            if (this.getValueAt(row,i) == value) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < composite.length(); i++) {
            if (this.getValueAt(i,col) == value) {
                return false;
            }
        }

        // Check region
        int regionSize = (int) Math.sqrt(this.composite.length());
        int rowRegionStart = (row / regionSize) * regionSize;
        int colRegionStart = (col / regionSize) * regionSize;
        for (int i = rowRegionStart; i < rowRegionStart + regionSize; i++) {
            for (int j = colRegionStart; j < colRegionStart + regionSize; j++) {
                if (this.getValueAt(i,j) == value) {
                    return false;
                }
            }
        }

        return true;
    }


    public void setValueAt(int row, int col, int value) {
        this.composite.setValue(row,col,value);
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

    void registerObserver(SudokuObserver sudokuObserver){
        observerList.add(sudokuObserver);
    }
    public int getBoardSize() {
        return this.composite.length();
    }

    private void notifyAllObserver(int[][] board,int row, int col, int value){
        for(SudokuObserver o : observerList){
            o.update(row,col,value);
        }
    }
}

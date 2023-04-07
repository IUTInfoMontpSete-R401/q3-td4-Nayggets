package Pattern.Observers;

import Pattern.Composite.Composite;
import Pattern.View.SudokuView;
import pattern.Observer.SudokuObserver;

public class SudokuCellView implements SudokuObserver {
    private Composite cell;
    private int row;
    private int col;

    public SudokuCellView(Composite cell, int row, int col) {
        this.cell = cell;
        this.row=row;
        this.col=col;
    }

    @Override
    public void update(int row, int col, int value) {
        if(row==this.row && col==this.col){
            System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
            cell.setValue(value);
        }
    }
}
package pattern.Observer;

import pattern.Composite.Cellule;
import pattern.Composite.Composite;
import pattern.Model.SudokuModel;
import pattern.Observer.SudokuObserver;

public class SudokuCellView implements SudokuObserver{
    private Composite cellule;
    private int row;
    private int col;

    public SudokuCellView(Composite cellule, int row, int col) {
        this.cellule = cellule;
        this.row=row;
        this.col=col;
    }

    @Override
    public void update(int row, int col, int value) {
        if(row==this.row && col==this.col){
            System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
            cellule.setValue(value);
        }
    }

}